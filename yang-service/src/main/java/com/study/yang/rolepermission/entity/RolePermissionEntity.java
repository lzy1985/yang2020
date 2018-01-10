package com.study.yang.rolepermission.entity;

import com.study.yang.base.dao.entity.BaseEntity;
import lombok.Data;

/**
* 角色权限表
* @author lzy
* @version 1.0.0
* @since 2018/01/11 04:56
*/
@Data
public class RolePermissionEntity extends BaseEntity {

    private static final long serialVersionUID = 5409185459234711691L;

    /**
    * 
    */
    private Integer id;
    /**
    * 角色id
    */
    private Integer rId;
    /**
    * 权限id
    */
    private Integer permissionId;
}
