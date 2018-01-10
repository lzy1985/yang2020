package com.study.yang.base.code.config;

import com.google.common.collect.Sets;
import com.study.yang.base.code.util.DateExUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.util.Set;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/7 上午9:25
 * @Description
 */
@Data
@Slf4j
public class Config {
    private static final String CONF_PATH = "file/code-gen.properties";

    public Config() {
        initConf(CONF_PATH);
    }

    private String backendTemplatePath;

    private String backendTargetPath;

    private String driverClass;

    private String jdbcUrl;

    private String userName;

    private String userPwd;

    private String dbName;

    private String tables;

    private String basePackage;

    private String author;

    private String version;

    private String webModuleName;

    private String apiModuleName;

    private String serviceModuleName;

    private String daoModuleName;

    private String parentArtifactId;

    private String parentGroupId;

    private String coreArtifactId;

    private Set<String> tableSet = Sets.newHashSet();

    private void initConf(String confPath) {
        try {
            Configuration conf = new PropertiesConfiguration(confPath);
            this.backendTemplatePath = conf.getString("backend.template.path") == null ? StringUtils.EMPTY : conf.getString("backend.template.path").trim();
            this.backendTargetPath = conf.getString("backend.target.path") == null ? StringUtils.EMPTY : conf.getString("backend.target.path").trim();
            this.driverClass = conf.getString("driver.class") == null ? StringUtils.EMPTY : conf.getString("driver.class").trim();
            this.userName = conf.getString("userName") == null ? StringUtils.EMPTY : conf.getString("userName").trim();
            this.userPwd = conf.getString("userPwd") == null ? StringUtils.EMPTY : conf.getString("userPwd").trim();
            this.dbName = conf.getString("dbName") == null ? StringUtils.EMPTY : conf.getString("dbName").trim();
            this.jdbcUrl = conf.getString("jdbc.url") == null ? StringUtils.EMPTY : conf.getString("jdbc.url").trim().replaceAll("\\{dbName}", this.dbName);
            this.tables = conf.getString("tables") == null ? StringUtils.EMPTY : conf.getString("tables").trim();

            if (!tables.contains("*")) {
                for (String table : tables.split("@")) {
                    tableSet.add(table.trim());
                }
            }

            this.basePackage = conf.getString("base.package") == null ? StringUtils.EMPTY : conf.getString("base.package").trim();
            this.author = conf.getString("author") == null ? StringUtils.EMPTY : conf.getString("author").trim();
            this.version = conf.getString("version") == null ? StringUtils.EMPTY : conf.getString("version").trim();

            this.webModuleName = conf.getString("webModuleName") == null ? StringUtils.EMPTY : conf.getString("webModuleName").trim();
            this.apiModuleName = conf.getString("apiModuleName") == null ? StringUtils.EMPTY : conf.getString("apiModuleName").trim();
            this.serviceModuleName = conf.getString("serviceModuleName") == null ? StringUtils.EMPTY : conf.getString("serviceModuleName").trim();
            this.daoModuleName = conf.getString("daoModuleName") == null ? StringUtils.EMPTY : conf.getString("daoModuleName").trim();
            this.parentArtifactId = conf.getString("parentArtifactId") == null ? StringUtils.EMPTY : conf.getString("parentArtifactId").trim();
            this.parentGroupId = conf.getString("parentGroupId") == null ? StringUtils.EMPTY : conf.getString("parentGroupId").trim();
            this.coreArtifactId = conf.getString("coreArtifactId") == null ? StringUtils.EMPTY : conf.getString("coreArtifactId").trim();
        } catch (ConfigurationException e) {
            e.printStackTrace();
            log.error("error exception : ", e);
        }
    }

    public String getCreateDate() {
        try {
            return DateExUtils.currDate("yyyy/MM/dd HH:mm");
        } catch (ParseException e) {
            log.error("error exception : ", e);
        }
        return StringUtils.EMPTY;
    }
}
