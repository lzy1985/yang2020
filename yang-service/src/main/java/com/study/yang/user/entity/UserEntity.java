package com.study.yang.user.entity;

import java.util.Date;
import com.study.yang.base.dao.entity.BaseEntity;
import lombok.Data;

/**
* 用户表
* @author lzy
* @version 1.0.0
* @since 2018/01/11 04:56
*/
@Data
public class UserEntity extends BaseEntity {

    private static final long serialVersionUID = 5409185459234711691L;

    /**
    * 主键id
    */
    private Integer id;
    /**
    * 用户名称
    */
    private String name;
    /**
    * 密码(MD5(密码+盐))
    */
    private String password;
    /**
    * 盐
    */
    private String salt;
    /**
    * 真实姓名
    */
    private String realName;
    /**
    * 电话
    */
    private String phone;
    /**
    * 邮箱
    */
    private String email;
    /**
    * 是否被锁定,0锁定,1未锁定
    */
    private Integer locked;
    /**
    * 最后登录时间
    */
    private Date lastLoginTime;
    /**
    * 最后登录ip
    */
    private Integer lastLoginIp;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 创建人
    */
    private Integer ctreator;
    /**
    * 修改时间
    */
    private Date updateTime;
    /**
    * 修改人
    */
    private Integer udpator;
    /**
    * 状态(0.无效,1.有效)
    */
    private Integer status;
}
