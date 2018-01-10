package com.study.yang.base.code.db;

import com.study.yang.base.code.util.StringExUtils;
import com.study.yang.base.code.util.TypeUtils;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/7 上午9:25
 * @Description
 */
@Data
public class ColumnInfo {
    public ColumnInfo(String name, String type, String comment) {
        this.name = name;
        this.type = type;
        this.comment = comment;
    }

    private String name;

    private String type;

    private String comment;

    public String getName() {
        return name;
    }

    public String getCamelName() {
        return StringExUtils.toCamelName(name);
    }

    public String getClassName() {
        return StringExUtils.toUpperCaseFirstOne(getCamelName());
    }

    public String getJavaType() {
        if (TypeUtils.JAVA_TYPE_MAP.containsKey(type)) {
            return TypeUtils.JAVA_TYPE_MAP.get(type);
        }

        return type;
    }

    public String getMyBastisType() {
        if (TypeUtils.MYBATIS_TYPE_MAP.containsKey(type)) {
            return TypeUtils.MYBATIS_TYPE_MAP.get(type);
        }

        return type;
    }

    public String getClassImport() {
        if (TypeUtils.CLASS_IMPORT_MAP.containsKey(type)) {
            return TypeUtils.CLASS_IMPORT_MAP.get(type);
        }
        return StringUtils.EMPTY;
    }
}
