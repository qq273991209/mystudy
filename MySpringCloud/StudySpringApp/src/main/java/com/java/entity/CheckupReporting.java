/*
*
* CheckupReporting.java
* Copyright(C) 2017-2020 fendo��˾
* @date 2019-07-03
*/
package com.java.entity;

import java.util.Date;

import lombok.Data;
@Data
public class CheckupReporting {
    /**
     * 
     */
    private Long id;

    /**
     * 体检用户就诊号
     */
    private Long admId;

    /**
     * 体检用户编号
     */
    private Long userId;

    /**
     * 用户名
     */
    private String name;

    /**
     * 性别
     */
    private Short sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 体检日期
     */
    private Date examDate;

    /**
     * 单位
     */
    private String company;

    /**
     * 报告状态
     */
    private String reportStatus;

    /**
     * 体检状态
     */
    private String peStatus;

    /**
     * 预约日期
     */
    private Date preDate;

    /**
     * 建议内容
     */
    private String examSummary;

    /**
     * 总检医生
     */
    private String summaryDoctor;

    /**
     * 总检日期
     */
    private Date summaryDate;

    /**
     * 审核医生
     */
    private String auditDoctor;

    /**
     * 审核日期
     */
    private Date auditDate;

    /**
     * 建议描述
     */
    private String illExplain;

    /**
     * 标题说明
     */
    private String illExplaintitle;

    /**
     * 
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 体检用户就诊号
     * @return adm_id 体检用户就诊号
     */
    public Long getAdmId() {
        return admId;
    }

    /**
     * 体检用户就诊号
     * @param admId 体检用户就诊号
     */
    public void setAdmId(Long admId) {
        this.admId = admId;
    }

    /**
     * 体检用户编号
     * @return user_id 体检用户编号
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 体检用户编号
     * @param userId 体检用户编号
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 用户名
     * @return name 用户名
     */
    public String getName() {
        return name;
    }

    /**
     * 用户名
     * @param name 用户名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 性别
     * @return sex 性别
     */
    public Short getSex() {
        return sex;
    }

    /**
     * 性别
     * @param sex 性别
     */
    public void setSex(Short sex) {
        this.sex = sex;
    }

    /**
     * 年龄
     * @return age 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 年龄
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 体检日期
     * @return exam_date 体检日期
     */
    public Date getExamDate() {
        return examDate;
    }

    /**
     * 体检日期
     * @param examDate 体检日期
     */
    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    /**
     * 单位
     * @return company 单位
     */
    public String getCompany() {
        return company;
    }

    /**
     * 单位
     * @param company 单位
     */
    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    /**
     * 报告状态
     * @return report_status 报告状态
     */
    public String getReportStatus() {
        return reportStatus;
    }

    /**
     * 报告状态
     * @param reportStatus 报告状态
     */
    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus == null ? null : reportStatus.trim();
    }

    /**
     * 体检状态
     * @return pe_status 体检状态
     */
    public String getPeStatus() {
        return peStatus;
    }

    /**
     * 体检状态
     * @param peStatus 体检状态
     */
    public void setPeStatus(String peStatus) {
        this.peStatus = peStatus == null ? null : peStatus.trim();
    }

    /**
     * 预约日期
     * @return pre_date 预约日期
     */
    public Date getPreDate() {
        return preDate;
    }

    /**
     * 预约日期
     * @param preDate 预约日期
     */
    public void setPreDate(Date preDate) {
        this.preDate = preDate;
    }

    /**
     * 建议内容
     * @return exam_summary 建议内容
     */
    public String getExamSummary() {
        return examSummary;
    }

    /**
     * 建议内容
     * @param examSummary 建议内容
     */
    public void setExamSummary(String examSummary) {
        this.examSummary = examSummary == null ? null : examSummary.trim();
    }

    /**
     * 总检医生
     * @return summary_doctor 总检医生
     */
    public String getSummaryDoctor() {
        return summaryDoctor;
    }

    /**
     * 总检医生
     * @param summaryDoctor 总检医生
     */
    public void setSummaryDoctor(String summaryDoctor) {
        this.summaryDoctor = summaryDoctor == null ? null : summaryDoctor.trim();
    }

    /**
     * 总检日期
     * @return summary_date 总检日期
     */
    public Date getSummaryDate() {
        return summaryDate;
    }

    /**
     * 总检日期
     * @param summaryDate 总检日期
     */
    public void setSummaryDate(Date summaryDate) {
        this.summaryDate = summaryDate;
    }

    /**
     * 审核医生
     * @return audit_doctor 审核医生
     */
    public String getAuditDoctor() {
        return auditDoctor;
    }

    /**
     * 审核医生
     * @param auditDoctor 审核医生
     */
    public void setAuditDoctor(String auditDoctor) {
        this.auditDoctor = auditDoctor == null ? null : auditDoctor.trim();
    }

    /**
     * 审核日期
     * @return audit_date 审核日期
     */
    public Date getAuditDate() {
        return auditDate;
    }

    /**
     * 审核日期
     * @param auditDate 审核日期
     */
    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    /**
     * 建议描述
     * @return ill_explain 建议描述
     */
    public String getIllExplain() {
        return illExplain;
    }

    /**
     * 建议描述
     * @param illExplain 建议描述
     */
    public void setIllExplain(String illExplain) {
        this.illExplain = illExplain == null ? null : illExplain.trim();
    }

    /**
     * 标题说明
     * @return ill_explainTitle 标题说明
     */
    public String getIllExplaintitle() {
        return illExplaintitle;
    }

    /**
     * 标题说明
     * @param illExplaintitle 标题说明
     */
    public void setIllExplaintitle(String illExplaintitle) {
        this.illExplaintitle = illExplaintitle == null ? null : illExplaintitle.trim();
    }
}