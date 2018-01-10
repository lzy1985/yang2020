package ${conf.basePackage}.${table.lowerCamelName}.entity;

<#list table.classImportSet as key>
import ${key};
</#list>
import ${conf.basePackage}.base.dao.entity.BaseEntity;
import lombok.Data;

/**
* ${table.comment}
* @author ${conf.author}
* @version ${conf.version}
* @since ${conf.createDate}
*/
@Data
public class ${table.className}Entity extends BaseEntity {

    private static final long serialVersionUID = 5409185459234711691L;

<#list table.columns as col>
    /**
    * ${col.comment}
    */
    private ${col.javaType} ${col.camelName};
</#list>
}
