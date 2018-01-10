package com.study.yang.userrole.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户角色中间表 DTO
 * @author lzy
 * @version 1.0.0
 * @since 2018/01/11 04:56
 */
@Data
public class UserRoleDTO implements Serializable {

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
