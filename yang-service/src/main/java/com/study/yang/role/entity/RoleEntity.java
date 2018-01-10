package com.study.yang.role.entity;

import java.util.Date;
import com.study.yang.base.dao.entity.BaseEntity;
import lombok.Data;

/**
* 
* @author lzy
* @version 1.0.0
* @since 2018/01/11 04:56
*/
@Data
public class RoleEntity extends BaseEntity {

    private static final long serialVersionUID = 5409185459234711691L;

    /**
    * 
    */
    private Integer id;
    /**
    * 角色名称
    */
    private String roleName;
    /**
    * 角色描述
    */
    private String description;
    /**
    * 角色类型(1.审核型,2.管理型)
    */
    private Integer type;
    /**
    * 排序
    */
    private Integer sort;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 创建人
    */
    private Integer creator;
    /**
    * 修改时间
    */
    private Date updateTime;
    /**
    * 修改人
    */
    private Integer updator;
}
