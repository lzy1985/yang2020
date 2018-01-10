package com.study.yang.permission.dto;

import java.util.Date;
import lombok.Data;

import java.io.Serializable;

/**
 * 权限表 DTO
 * @author lzy
 * @version 1.0.0
 * @since 2018/01/11 04:56
 */
@Data
public class PermissionDTO implements Serializable {

	private static final long serialVersionUID = 5409185459234711691L;

	/**
	 * 
	 */
	private Integer id;

	/**
	 * 所属上级
	 */
	private Integer pId;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 权限码
	 */
	private String code;

	/**
	 * 类型(1.目录,2.菜单,3.按钮）
	 */
	private Integer type;

	/**
	 * 图标
	 */
	private String icon;

	/**
	 * 访问路径
	 */
	private String url;

	/**
	 * 状态(0. 无效,1.有效)
	 */
	private Integer status;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 
	 */
	private Date updateTime;

	/**
	 * 修改人
	 */
	private Integer updator;

}
