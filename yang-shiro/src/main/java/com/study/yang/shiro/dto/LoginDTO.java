package com.study.yang.shiro.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/10/7 下午2:24
 * @Description
 */
@Data
public class LoginDTO implements Serializable {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 是否记住我
     */
    private Integer rememberMe;
}
