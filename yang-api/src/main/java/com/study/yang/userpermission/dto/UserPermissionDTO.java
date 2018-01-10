package com.study.yang.userpermission.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户权限表 DTO
 * @author lzy
 * @version 1.0.0
 * @since 2018/01/11 04:56
 */
@Data
public class UserPermissionDTO implements Serializable {

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
	 * 权限id
	 */
	private Integer permissionId;

	/**
	 * 权限类型(-1.减少权限,1.增加权限)
	 */
	private Integer type;

}
