package com.study.yang.userrole.entity;

import com.study.yang.base.dao.entity.BaseEntity;
import lombok.Data;

/**
* 用户角色中间表
* @author lzy
* @version 1.0.0
* @since 2018/01/11 04:56
*/
@Data
public class UserRoleEntity extends BaseEntity {

    private static final long serialVersionUID = 5409185459234711691L;

    /**
    * 
    */
    private Integer id;
    /**
    * 用户id
    */
    private Integer uId;
    /**
    * 角色id
    */
    private Integer rId;
}
