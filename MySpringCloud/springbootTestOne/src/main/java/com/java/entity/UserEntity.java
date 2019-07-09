/*
*
* UserEntity.java
* Copyright(C) 2017-2020 fendo��˾
* @date 2019-05-20
*/
package com.java.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;

@Table(name = "subscribe_health_user")
public class UserEntity  implements Serializable{
    //@Fields serialVersionUID :  
	private static final long serialVersionUID = 5815308047446153241L;

	/**
     * 编号
     */
	@ApiModelProperty(value="卡编号", example="1")
    private Long id;

    /**
     * 体检预约帐号编号
     */
	@ApiModelProperty(value="体检预约帐号编号", example="1")
    private Long accountId;

    /**
     * 真实姓名
     */
	@ApiModelProperty(value="真实姓名", example="张三")
    private String realName;

    /**
     * 身份证号码
     */
	@ApiModelProperty(value="身份证号码", example="50002251993072419156")
    private String idCard;

    /**
     * 昵称
     */
	@ApiModelProperty(value="昵称", example="账上")
    private String nick;

    /**
     * 头像
     */
	@ApiModelProperty(value="头像", example="123.png")
    private String head;

    /**
     * 性别
     */
	@ApiModelProperty(value="性别", example="1")
    private Short sex;

    /**
     * 出生日期
     */
	@ApiModelProperty(value="出生日期", example="1993-07-24")
    private Date birthday;

    /**
     * 民族
     */
	@ApiModelProperty(value="民族", example="汉")
    private String nation;

    /**
     * 婚姻
     */
	@ApiModelProperty(value="婚姻", example="已婚")
    private String marriage;

    /**
     * 手机号
     */
	@ApiModelProperty(value="手机号", example="12346679521")
    private String phone;

    /**
     * 备用电话
     */
	@ApiModelProperty(value="备用电话", example="146862145")
    private String bakPhone;

    /**
     * 病情
     */
	@ApiModelProperty(value="病情", example="是个大范甘迪")
    private String illness;

    /**
     * 诊断内容
     */
	@ApiModelProperty(value="诊断内容", example="阿斯顿发生的鬼地方")
    private String diagnosticContent;

    /**
     * qq号
     */
	@ApiModelProperty(value="qq号", example="24535464567")
    private String qqNumber;

    /**
     * 邮箱
     */
	@ApiModelProperty(value="邮箱", example="123@qq.com")
    private String email;

    /**
     * 创建时间
     */
	@ApiModelProperty(value="创建时间", example="2019-5-20")
    private Date createTime;

    /**
     * 最后登陆时间
     */
	@ApiModelProperty(value="最后登陆时间", example="2019-5-20")
    private Date loginEndDate;

    /**
     * 省份编号
     */
	@ApiModelProperty(value="省份编号", example="12314")
    private String provinceCode;

    /**
     * 省份名称
     */
	@ApiModelProperty(value="省份名称", example="的恢复规划")
    private String provinceName;

    /**
     * 市编码
     */
	@ApiModelProperty(value="市编码", example="123123")
    private String cityCode;

    /**
     * 市名称
     */
	@ApiModelProperty(value="市名称", example="电饭锅电饭锅")
    private String cityName;

    /**
     * 区编码
     */
	@ApiModelProperty(value="区编码", example="24534")
    private String districtCode;

    /**
     * 区名称
     */
	@ApiModelProperty(value="区名称", example="是大法官")
    private String districtName;

    /**
     * 详细地址
     */
	@ApiModelProperty(value="详细地址", example="成都")
    private String address;

    /**
     * 状态 0无效 1有效
     */
	@ApiModelProperty(value="状态 0无效 1有效", example="1")
    private Short status;

    /**
     * 二维码
     */
	@ApiModelProperty(value="二维码", example="1")
    private String qrcode;

    /**
     * 编号
     * @return id 编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 编号
     * @param id 编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 体检预约帐号编号
     * @return account_id 体检预约帐号编号
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * 体检预约帐号编号
     * @param accountId 体检预约帐号编号
     */
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    /**
     * 真实姓名
     * @return real_name 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 真实姓名
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 身份证号码
     * @return id_card 身份证号码
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 身份证号码
     * @param idCard 身份证号码
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * 昵称
     * @return nick 昵称
     */
    public String getNick() {
        return nick;
    }

    /**
     * 昵称
     * @param nick 昵称
     */
    public void setNick(String nick) {
        this.nick = nick == null ? null : nick.trim();
    }

    /**
     * 头像
     * @return head 头像
     */
    public String getHead() {
        return head;
    }

    /**
     * 头像
     * @param head 头像
     */
    public void setHead(String head) {
        this.head = head == null ? null : head.trim();
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
     * 出生日期
     * @return birthday 出生日期
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 出生日期
     * @param birthday 出生日期
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 民族
     * @return nation 民族
     */
    public String getNation() {
        return nation;
    }

    /**
     * 民族
     * @param nation 民族
     */
    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    /**
     * 婚姻
     * @return marriage 婚姻
     */
    public String getMarriage() {
        return marriage;
    }

    /**
     * 婚姻
     * @param marriage 婚姻
     */
    public void setMarriage(String marriage) {
        this.marriage = marriage == null ? null : marriage.trim();
    }

    /**
     * 手机号
     * @return phone 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 手机号
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 备用电话
     * @return bak_phone 备用电话
     */
    public String getBakPhone() {
        return bakPhone;
    }

    /**
     * 备用电话
     * @param bakPhone 备用电话
     */
    public void setBakPhone(String bakPhone) {
        this.bakPhone = bakPhone == null ? null : bakPhone.trim();
    }

    /**
     * 病情
     * @return illness 病情
     */
    public String getIllness() {
        return illness;
    }

    /**
     * 病情
     * @param illness 病情
     */
    public void setIllness(String illness) {
        this.illness = illness == null ? null : illness.trim();
    }

    /**
     * 诊断内容
     * @return diagnostic_content 诊断内容
     */
    public String getDiagnosticContent() {
        return diagnosticContent;
    }

    /**
     * 诊断内容
     * @param diagnosticContent 诊断内容
     */
    public void setDiagnosticContent(String diagnosticContent) {
        this.diagnosticContent = diagnosticContent == null ? null : diagnosticContent.trim();
    }

    /**
     * qq号
     * @return qq_number qq号
     */
    public String getQqNumber() {
        return qqNumber;
    }

    /**
     * qq号
     * @param qqNumber qq号
     */
    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber == null ? null : qqNumber.trim();
    }

    /**
     * 邮箱
     * @return email 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 最后登陆时间
     * @return login_end_date 最后登陆时间
     */
    public Date getLoginEndDate() {
        return loginEndDate;
    }

    /**
     * 最后登陆时间
     * @param loginEndDate 最后登陆时间
     */
    public void setLoginEndDate(Date loginEndDate) {
        this.loginEndDate = loginEndDate;
    }

    /**
     * 省份编号
     * @return province_code 省份编号
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * 省份编号
     * @param provinceCode 省份编号
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    /**
     * 省份名称
     * @return province_name 省份名称
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * 省份名称
     * @param provinceName 省份名称
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    /**
     * 市编码
     * @return city_code 市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 市编码
     * @param cityCode 市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 市名称
     * @return city_name 市名称
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 市名称
     * @param cityName 市名称
     */
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    /**
     * 区编码
     * @return district_code 区编码
     */
    public String getDistrictCode() {
        return districtCode;
    }

    /**
     * 区编码
     * @param districtCode 区编码
     */
    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode == null ? null : districtCode.trim();
    }

    /**
     * 区名称
     * @return district_name 区名称
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * 区名称
     * @param districtName 区名称
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName == null ? null : districtName.trim();
    }

    /**
     * 详细地址
     * @return address 详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 详细地址
     * @param address 详细地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 状态 0无效 1有效
     * @return status 状态 0无效 1有效
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 状态 0无效 1有效
     * @param status 状态 0无效 1有效
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 二维码
     * @return qrcode 二维码
     */
    public String getQrcode() {
        return qrcode;
    }

    /**
     * 二维码
     * @param qrcode 二维码
     */
    public void setQrcode(String qrcode) {
        this.qrcode = qrcode == null ? null : qrcode.trim();
    }
}