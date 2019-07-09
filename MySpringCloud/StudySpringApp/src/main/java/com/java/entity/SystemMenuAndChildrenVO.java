package com.java.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Title: SystemMenuVO.java 
 * @Package com.amt.model 
 * @Description: TODO(系统菜单类) 
 * @author lys
 * @date 2019年05月15日 上午11:40:20 
 * Copyright (c) ©1994-2018 Scjydz.com All Rights Reserved.
 */
@Data
@Table(name = "system_menu")
public class SystemMenuAndChildrenVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4585856963713032353L;

	// 菜单编号
	@ApiModelProperty(value = "菜单编号(仅供编辑使用)", example = "1")
	private Long id;
	
	// 父级编号
	@ApiModelProperty(value = "父级编号", example = "1")
	private Long pid;
	
	// 菜单名称
	@ApiModelProperty(value = "菜单名称", example = "检查菜单")
	private String name;
	
	// 类型   0：目录   1：菜单   2：按钮
	@ApiModelProperty(value = "类型   0：目录   1：菜单   2：按钮", example = "0")
	private Short type;
	
	// 子菜单
    private List<SystemMenuAndChildrenVO> children;
    
    
	
}
