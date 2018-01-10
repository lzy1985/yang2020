package com.study.yang.base.code.db;

import com.study.yang.base.code.util.StringExUtils;
import com.study.yang.base.code.util.TypeUtils;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.List;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/7 上午9:25
 * @Description
 */
@Data
public class TableInfo {
    public TableInfo(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    private String id;
    private String name;

    private String comment;

    private List<ColumnInfo> columns;
    private HashSet<String> classImportSet;


    public String getName() {
        return name;
    }

    public String getCamelName() {
        return StringExUtils.toCamelName(name.substring(3));
    }

    public String getLowerCamelName() {
        return StringUtils.lowerCase(getCamelName());
    }

    public String getClassName() {
        return StringExUtils.toUpperCaseFirstOne(getCamelName());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInsertView() {
        StringBuilder sb = new StringBuilder();
        for (ColumnInfo column : columns) {
            if (column.getName().equalsIgnoreCase(getId())) {
                continue;
            }
            sb.append(column.getName()).append(",");
        }
        return sb.substring(0, sb.lastIndexOf(","));
    }

    public String getInsertValue() {
        StringBuilder sb = new StringBuilder();
        for (ColumnInfo column : columns) {
            if (column.getName().equalsIgnoreCase(getId())) {
                continue;
            }
            sb.append(":1.").append(column.getCamelName()).append(",");
        }
        return sb.substring(0, sb.lastIndexOf(","));
    }

    public String getInsertSelectiveView() {
        StringBuilder sb = new StringBuilder();
        for (ColumnInfo column : columns) {
            if (column.getName().equalsIgnoreCase(getId())) {
                continue;
            }
            sb.append(" #if(:1.").append(column.getCamelName()).append(" != null){")
                    .append(column.getName()).append(",")
                    .append("}");
        }
        return sb.toString();
    }

    public String getInsertSelectiveValue() {
        StringBuilder sb = new StringBuilder();
        for (ColumnInfo column : columns) {
            if (column.getName().equalsIgnoreCase(getId())) {
                continue;
            }
            sb.append(" #if(:1.").append(column.getCamelName()).append(" != null){")
                    .append(":1.").append(column.getCamelName()).append(",")
                    .append("}");
        }
        return sb.toString();
    }

    public String getUpdateValue() {
        StringBuilder sb = new StringBuilder();
        for (ColumnInfo column : columns) {
            if (column.getName().equalsIgnoreCase(getId())) {
                continue;
            }
            sb.append(column.getName()).append("=:1.").append(column.getCamelName()).append(",");
        }
        return sb.substring(0, sb.lastIndexOf(","));
    }

    public String getUpdateSelectiveValue() {
        StringBuilder sb = new StringBuilder();
        for (ColumnInfo column : columns) {
            if (column.getName().equalsIgnoreCase(getId())) {
                continue;
            }
            sb.append(" #if(:1.").append(column.getCamelName()).append(" != null){")
                    .append(column.getName()).append("=:1.").append(column.getCamelName()).append(",")
                    .append("}");
        }
        return sb.toString();
    }

    public String getSelectView() {
        StringBuilder sb = new StringBuilder();
        for (ColumnInfo column : columns) {
            sb.append(column.getName()).append(",");
        }
        return sb.substring(0, sb.lastIndexOf(","));
    }

    public String getQueryParams() {
        StringBuilder sb = new StringBuilder();
        for (ColumnInfo column : columns) {
            if (column.getJavaType().equalsIgnoreCase("BigDecimal") ||
                    column.getJavaType().equalsIgnoreCase("String") ||
                    column.getJavaType().equalsIgnoreCase("byte[]") ||
                    column.getJavaType().equalsIgnoreCase("Date")) {
                sb.append(" #if(:1.").append(column.getCamelName()).append(" != null){")
                        .append(" AND ").append(column.getName()).append("=:1.").append(column.getCamelName())
                        .append("}");
            } else {
                sb.append(" #if(:1.").append(column.getCamelName()).append(" > 0){")
                        .append(" AND ").append(column.getName()).append("=:1.").append(column.getCamelName())
                        .append("}");
            }
        }
        return sb.toString();
    }

    public HashSet<String> getClassImportSet(){
        classImportSet = new HashSet<String>();
        for (ColumnInfo column : columns) {
            if (TypeUtils.CLASS_IMPORT_MAP.containsKey(column.getType())) {
                classImportSet.add(TypeUtils.CLASS_IMPORT_MAP.get(column.getType()));
            }
        }
        return classImportSet;
    }
}
