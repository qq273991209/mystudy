
package com.java.entity;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReportProjectDetails implements Serializable {
	// @Fields serialVersionUID :
	private static final long serialVersionUID = 7994366532934418857L;

	// 体检报告编号
	@ApiModelProperty(value = "体检报告编号", example = "12")
	private Long id;

	// 体检用户就诊号
	@ApiModelProperty(value = "体检用户就诊号", example = "315687")
	private Long admId;

	// 体检用户编号
	@ApiModelProperty(value = "体检用户编号", example = "18")
	private Long userId;

	
	// 页数
	@ApiModelProperty(value = "页数", example = "1")
	private Integer total;

	
	// 项目名称
	@ApiModelProperty(value = "项目名称", example = "一般查体")
	private String itemDesc;

	
	// 项目ID
	@ApiModelProperty(value = "项目ID", example = "1828||P")
	private String itemId;

	
	// 报告格式
	@ApiModelProperty(value = "报告格式", example = "ufo")
	private String reportFormat;

	
	// 检查医生
	@ApiModelProperty(value = "检查医生", example = "凯莎")
	private String doctorName;


	// 检查日期
	@ApiModelProperty(value = "检查日期", example = "2019-1-20")
	private Date examDate;

	
	// 检查项结果描述
	@ApiModelProperty(value = "检查项结果描述", example = "体质指数||24.30||18.5-24||↑")
	private String examinationItemdetail;

}