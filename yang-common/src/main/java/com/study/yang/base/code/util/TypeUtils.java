package com.study.yang.base.code.util;

import java.util.HashMap;
import java.util.Map;

public final class TypeUtils {

    public final static Map<String, String> JAVA_TYPE_MAP = new HashMap<String, String>();

    static {
        JAVA_TYPE_MAP.put("INT", "Integer");
        JAVA_TYPE_MAP.put("BIGINT", "Long");
        JAVA_TYPE_MAP.put("INTEGER", "Integer");
        JAVA_TYPE_MAP.put("TINYINT", "Integer");
        JAVA_TYPE_MAP.put("SMALLINT", "Integer");
        JAVA_TYPE_MAP.put("MEDIUMINT", "Integer");
        JAVA_TYPE_MAP.put("FLOAT", "Float");
        JAVA_TYPE_MAP.put("DOUBLE", "Double");
        JAVA_TYPE_MAP.put("DECIMAL", "BigDecimal");

        JAVA_TYPE_MAP.put("INT UNSIGNED", "Integer");
        JAVA_TYPE_MAP.put("BIGINT UNSIGNED", "Long");
        JAVA_TYPE_MAP.put("INTEGER UNSIGNED", "Integer");
        JAVA_TYPE_MAP.put("TINYINT UNSIGNED", "Integer");
        JAVA_TYPE_MAP.put("SMALLINT UNSIGNED", "Integer");
        JAVA_TYPE_MAP.put("MEDIUMINT UNSIGNED", "Integer");
        JAVA_TYPE_MAP.put("FLOAT UNSIGNED", "Float");
        JAVA_TYPE_MAP.put("DOUBLE UNSIGNED", "Double");
        JAVA_TYPE_MAP.put("DECIMAL UNSIGNED", "BigDecimal");

        JAVA_TYPE_MAP.put("BIT", "Integer");
        JAVA_TYPE_MAP.put("BOOLEAN", "Integer");
        JAVA_TYPE_MAP.put("BOOL", "Integer");

        JAVA_TYPE_MAP.put("VARCHAR", "String");
        JAVA_TYPE_MAP.put("CHAR", "String");
        JAVA_TYPE_MAP.put("TEXT", "String");
        JAVA_TYPE_MAP.put("MEDIUMTEXT", "String");
        JAVA_TYPE_MAP.put("LONGTEXT", "String");

        JAVA_TYPE_MAP.put("BLOB", "Byte[]");
        JAVA_TYPE_MAP.put("MEDIUMBLOB", "Byte[]");
        JAVA_TYPE_MAP.put("LONGBLOB", "Byte[]");
        JAVA_TYPE_MAP.put("TINYBLOB", "Byte[]");

        JAVA_TYPE_MAP.put("BINARY", "Byte[]");
        JAVA_TYPE_MAP.put("VARBINARY", "Byte[]");

        JAVA_TYPE_MAP.put("DATE", "Date");
        JAVA_TYPE_MAP.put("TIME", "Date");
        JAVA_TYPE_MAP.put("DATETIME", "Date");
        JAVA_TYPE_MAP.put("TIMESTAMP", "Date");
        JAVA_TYPE_MAP.put("YEAR", "Date");
    }


    public final static Map<String, String> CLASS_IMPORT_MAP = new HashMap<String, String>();

    static {
        CLASS_IMPORT_MAP.put("DATE", "java.util.Date");
        CLASS_IMPORT_MAP.put("TIME", "java.util.Date");
        CLASS_IMPORT_MAP.put("DATETIME", "java.util.Date");
        CLASS_IMPORT_MAP.put("TIMESTAMP", "java.util.Date");
        CLASS_IMPORT_MAP.put("YEAR", "java.util.Date");
        CLASS_IMPORT_MAP.put("DECIMAL", "java.math.BigDecimal");
    }

    public final static Map<String, String> MYBATIS_TYPE_MAP = new HashMap<String, String>();

    static {
        MYBATIS_TYPE_MAP.put("INT", "INTEGER");
        MYBATIS_TYPE_MAP.put("BIGINT", "BIGINT");
        MYBATIS_TYPE_MAP.put("INTEGER", "INTEGER");
        MYBATIS_TYPE_MAP.put("TINYINT", "TINYINT");
        MYBATIS_TYPE_MAP.put("SMALLINT", "SMALLINT");
        MYBATIS_TYPE_MAP.put("MEDIUMINT", "INTEGER");
        MYBATIS_TYPE_MAP.put("FLOAT", "FLOAT");
        MYBATIS_TYPE_MAP.put("DOUBLE", "DOUBLE");
        MYBATIS_TYPE_MAP.put("DECIMAL", "DECIMAL");

        MYBATIS_TYPE_MAP.put("INT UNSIGNED", "INTEGER");
        MYBATIS_TYPE_MAP.put("BIGINT UNSIGNED", "BIGINT");
        MYBATIS_TYPE_MAP.put("INTEGER UNSIGNED", "INTEGER");
        MYBATIS_TYPE_MAP.put("TINYINT UNSIGNED", "TINYINT");
        MYBATIS_TYPE_MAP.put("SMALLINT UNSIGNED", "SMALLINT");
        MYBATIS_TYPE_MAP.put("MEDIUMINT UNSIGNED", "INTEGER");
        MYBATIS_TYPE_MAP.put("FLOAT UNSIGNED", "FLOAT");
        MYBATIS_TYPE_MAP.put("DOUBLE UNSIGNED", "DOUBLE");
        MYBATIS_TYPE_MAP.put("DECIMAL UNSIGNED", "DECIMAL");

        MYBATIS_TYPE_MAP.put("BIT", "TINYINT");
        MYBATIS_TYPE_MAP.put("BOOLEAN", "BOOLEAN");
        MYBATIS_TYPE_MAP.put("BOOL", "BOOLEAN");

        MYBATIS_TYPE_MAP.put("VARCHAR", "VARCHAR");
        MYBATIS_TYPE_MAP.put("CHAR", "CHAR");
        MYBATIS_TYPE_MAP.put("TEXT", "LONGVARCHAR");
        MYBATIS_TYPE_MAP.put("MEDIUMTEXT", "LONGVARCHAR");
        MYBATIS_TYPE_MAP.put("LONGTEXT", "LONGVARCHAR");

        MYBATIS_TYPE_MAP.put("BLOB", "BLOB");
        MYBATIS_TYPE_MAP.put("MEDIUMBLOB", "BLOB");
        MYBATIS_TYPE_MAP.put("LONGBLOB", "BLOB");
        MYBATIS_TYPE_MAP.put("TINYBLOB", "BLOB");

        MYBATIS_TYPE_MAP.put("BINARY", "BINARY");
        MYBATIS_TYPE_MAP.put("VARBINARY", "VARBINARY");

        MYBATIS_TYPE_MAP.put("DATE", "DATE");
        MYBATIS_TYPE_MAP.put("TIME", "TIME");
        MYBATIS_TYPE_MAP.put("DATETIME", "TIMESTAMP");
        MYBATIS_TYPE_MAP.put("TIMESTAMP", "TIMESTAMP");
        MYBATIS_TYPE_MAP.put("YEAR", "DATE");
    }
}
