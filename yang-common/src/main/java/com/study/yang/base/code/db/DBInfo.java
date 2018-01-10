package com.study.yang.base.code.db;

import com.study.yang.base.code.config.Config;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Slf4j
public class DBInfo {

    private DBInfo() {}

    private String productName;

    private String productVersion;

    private String catalogSeparator;

    private String driverVersion;

    private List<TableInfo> tables;

    public static DBInfo getInstance(Config conf) {

        DBInfo info = new DBInfo();

        try {
            Class.forName(conf.getDriverClass());
            Connection con = DriverManager.getConnection(conf.getJdbcUrl(), conf.getUserName(), conf.getUserPwd());

            DatabaseMetaData dbmd = con.getMetaData();
            info.setProductName(dbmd.getDatabaseProductName());
            info.setProductVersion(dbmd.getDatabaseProductVersion());
            info.setCatalogSeparator(dbmd.getCatalogSeparator());
            info.setDriverVersion(dbmd.getDriverVersion());

            List<TableInfo> tables = new ArrayList<TableInfo>();
            info.setTables(tables);

            ResultSet rs = dbmd.getTables(conf.getDbName(), null, null, new String[]{"TABLE"});
            while(rs.next()) {

                String tableName = rs.getString("TABLE_NAME");

                if ((CollectionUtils.isNotEmpty(conf.getTableSet()) && !conf.getTableSet().contains(tableName)) ||
                        CollectionUtils.isEmpty(conf.getTableSet()) && !conf.getTables().equals("*") && !tableName.substring(0, 2).equals(conf.getTables().substring(0, 2))) {
                    continue;
                }



                String comment = getCommentByTableName(tableName, con);
                List<ColumnInfo> columns = new ArrayList<ColumnInfo>();

                TableInfo tableInfo = new TableInfo(tableName, comment);
                tableInfo.setColumns(columns);

                ResultSet columnRs = dbmd.getColumns(conf.getDbName(), null, tableName, null);
                while(columnRs.next()) {
                    if(null==tableInfo.getId()){
                        tableInfo.setId(columnRs.getString("COLUMN_NAME"));
                    }
                    columns.add(new ColumnInfo(columnRs.getString("COLUMN_NAME"), columnRs.getString("TYPE_NAME"), columnRs.getString("REMARKS")));
                }

                tables.add(tableInfo);
                log.info("read table : " + tableInfo.getName() + " from database success");
            }
        } catch (Exception e) {
            log.error("error exception : ", e);
        }

        return info;
    }

    /**
     * 获得某表的建表语句
     *
     * @param tableName
     * @return
     * @throws Exception
     */
    private static String getCommentByTableName(String tableName, Connection con) throws Exception {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SHOW CREATE TABLE " + tableName);
        if (rs != null && rs.next()) {
            String createDDL = rs.getString(2);
            rs.close();
            stmt.close();
            return parse(createDDL);
        }

        return StringUtils.EMPTY;
    }

    /**
     * 返回注释信息
     *
     * @param all
     * @return
     */
    private static String parse(String all) {
        String comment = null;
        int index = all.indexOf("COMMENT='");
        if (index < 0) {
            return "";
        }
        comment = all.substring(index + 9);
        comment = comment.substring(0, comment.length() - 1);
        return comment;
    }

}
