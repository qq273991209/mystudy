/**
 * Project Name:StudySpringApp
 * File Name:WebSeriveUtil.java
 * Package Name:com.java.util
 * Date:2019年6月17日下午5:20:33
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
*/
package com.java.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Title: HisServiceUtil.java
 * @Package com.amt.util
 * @Description: TODO(远程调用HisService)
 * @author 刘云升
 * @date 2019年6月17日 下午5:20:33 Copyright (c) ©1994-2019 Scjydz.com All Rights
 *       Reserved.
 */
@Component
@ConfigurationProperties(prefix = "hisProperties")
public class HisServiceUtil {

	// 查询网上体检套餐类型（VIP等级）业务代码
	private String requestCodeOne;

	// 查询网上体检套餐业务代码
	private String requestCodeTwo;

	// 根据套餐ID查询明细业务代码
	private String requestCodeThree;

	// 根据HIS套餐ID查询套餐项目业务代码
	private String requestCodeFour;

	// 查询所有体检业务代码
	private String requestCodeFive;

	// 保存个人预约记录（自选项目）业务代码
	@SuppressWarnings("unused")
	private String requestCodeSix;

	// 查询网上预约记录业务代码
	private String requestCodeSeven;

	// 取消网上预约记录业务代码
	private String requestCodeEight;

	// 根据登记号查询历次体检记录业务代码
	private String requestCodeNine;

	// 根据就诊ID查询总检建议业务代码
	private String requestCodeTen;

	// 根据就诊ID查询体检项目细项结果业务代码
	private String requestCodeEleven;

	// 根据病人ID查询体检待缴费记录业务代码
	private String requestCodeTwelve;

	// 根据admId（PE3001接口返回）查询体检待缴费项目业务代码
	private String requestCodeThirteen;

	// 支付接口业务代码
	private String requestCodeFourteen;

	// 远程调用接口方法
	private String METHOD;

	// 远程调用url地址
	private String ADDRESS;

	/**
	 * @description: HttpURLConnection远程执行POST方法调用外部接口
	 * @param address     外部url地址
	 * @param RequestCode 业务代码
	 * @param xml         传参格式为<id>1</id><name>张三</name>
	 * @return 接口调用XML字符串
	 * @throws Exception io异常
	 */
	public String requestWSDL(String RequestCode, String xml) throws Exception {
		// 创建服务地址
		URL url = new URL(this.ADDRESS);
		// 打开一个通向服务地址的连接
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		// 设置参数
		// 发送方式设置：POST必须大写
		connection.setRequestMethod("POST");
		// 设置数据格式：content-type
		connection.setRequestProperty("content-type", "text/xml;charset=utf-8");
		// 设置输入输出，因为默认新创建的connection没有读写权限，
		connection.setDoInput(true);
		connection.setDoOutput(true);
		// 设置SOAP数据，发送请求
		String soapXML = getXML(RequestCode, xml, this.METHOD);
		// 将信息以流的方式发送出去
		OutputStream os = connection.getOutputStream();
		os.write(soapXML.getBytes());
		// 接收服务端响应
//		int responseCode = connection.getResponseCode();
		StringBuilder sb = new StringBuilder();
//		if (200 == responseCode) {// 服务端响应成功
		// 获取当前连接请求返回的数据流
		InputStream is = connection.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String temp = null;
		while (null != (temp = br.readLine())) {
			sb.append(temp);
		}
		is.close();
		isr.close();
		br.close();
//		}
		os.close();

		return sb.toString();
	}

	/**
	 * 
	 * @description: 组装格式xml
	 * @param RequestCode 业务代码
	 * @param xml         传参格式为<id>1</id><name>张三</name>
	 * @param method      接口方法
	 * @return 完整soapXML传参信息
	 */
	private static String getXML(String RequestCode, String xml, String method) {

		StringBuffer requestXML = new StringBuffer();
		requestXML.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		requestXML.append(
				"<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">");
		requestXML.append("<soap:Body>");
		requestXML.append("<" + method + " xmlns=\"http://tempuri.org\">");
		if (!StringUtils.isEmpty(RequestCode)) {
			requestXML.append("<MethodName>" + RequestCode + "</MethodName>");
		}
		requestXML.append("<Input><![CDATA[<Request>");
		if (!StringUtils.isEmpty(xml)) {
			requestXML.append(xml);
		}
		requestXML.append("</Request>]]></Input>");

		requestXML.append("</" + method + ">");
		requestXML.append("</soap:Body>");
		requestXML.append("</soap:Envelope>");

		return requestXML.toString();
	}

	/**
	 * @description: 2.1.1.查询网上体检套餐类型（VIP等级）XML传参
	 * @param locId 科室id
	 * @return xml数据
	 * @throws Exception
	 */
	public String getPhysicalExaminationTypeXML(String locId) throws Exception {

		String xml = "<locId>" + locId + "</locId>";
		return requestWSDL(this.requestCodeOne, xml);
	}

	/**
	 * 
	 * @description: 2.1.2.查询网上体检套餐XML传参
	 * @param levelId 类型ID 可空
	 * @param locId   体检科室ID 可空
	 * @param sex     性别描述 可空；男、女
	 * @return xml数据
	 * @throws Exception
	 */
	public String getPhysicalExaminationXML(String levelId, String locId, String sex) throws Exception {
		String xml = "<levelId>" + levelId + "</levelId><locId>" + locId + "</locId><sex>" + sex + "</sex>";

		return requestWSDL(this.requestCodeTwo, xml);
	}

	/**
	 * @description: 2.1.3.查询网上套餐明细XML传参
	 * @param packageId 网上套餐ID
	 * @return XML传参
	 * @throws Exception
	 */
	public String getOnlineMealXML(String packageId) throws Exception {
		String xml = "<packageId>" + packageId + "</packageId>";
		return requestWSDL(this.requestCodeThree, xml);
	}

	/**
	 * @description: 2.1.4.查询His套餐明细XML传参
	 * @param ordSetsId 网上套餐ID
	 * @return XML传参
	 * @throws Exception
	 * 
	 */
	public String getHisPackageDetailsXML(String ordSetsId) throws Exception {
		String xml = "<ordSetsId>" + ordSetsId + "</ordSetsId>";
		return requestWSDL(this.requestCodeFour, xml);
	}

	/**
	 * @description: 2.1.5.查询所有体检项目XML传参
	 * @param hisItemId 医嘱项ID 传空返回所有
	 * @param locId     体检科室ID
	 * @param pageNo    页码
	 * @param pageSize  每页大小
	 * @return
	 * @throws Exception
	 */
	public String getAllMedicalTermXML(String hisItemId, String locId, String pageNo, String pageSize)
			throws Exception {
		String xml = "<hisItemId>" + hisItemId + "</hisItemId><locId>" + locId + "</locId><pageNo>" + pageNo
				+ "</pageNo><pageSize>" + pageSize + "</pageSize>";
		return requestWSDL(this.requestCodeFive, xml);
	}
	
	/**
	 * 
	 * @description: 2.1.6.保存个人预约记录(自选项目)
	 * @param Map  参数Map集合
	 * @return 接口调用XML数据
	 * @throws Exception
	 */
	public String getSaveTheReservationXML(Map<String,Object> map)
			throws Exception {
		String xml = "<PatientRegNo/>" + 
				"	<CertificateNo>"+map.get("CertificateNo")+"</CertificateNo>" + 
				"	<CertificateType>"+map.get("CertificateType")+"</CertificateType>" + 
				"	<SexCode>"+map.get("SexCode")+"</SexCode>" + 
				"	<LocID>"+map.get("LocID")+"</LocID>" + 
				"	<PatientDob>"+map.get("PatientDob")+"</PatientDob>" + 
				"	<PmType>"+map.get("PmType")+"</PmType>" + 
				"	<LevelDesc>"+map.get("LevelDesc")+"</LevelDesc>" + 
				"	<PatientName>"+map.get("PatientName")+"</PatientName>" + 
				"	<OrdSetsId>"+map.get("OrdSetsId")+"</OrdSetsId>" + 
				"	<TelephoneNo>"+map.get("TelephoneNo")+"</TelephoneNo>" + 
				"	<PreWay>"+map.get("PreWay")+"</PreWay>" + 
				"	<ExamDate>"+map.get("ExamDate")+"</ExamDate>" + 
				"	<DetailID></DetailID>" + 
				"	<OEvaluationID/>" + 
				"	<PreIADM/>" + 
				"	<Status/>" + 
				"	<PayFlag/>" + 
				"	<OPUserCode>"+map.get("OPUserCode")+"</OPUserCode>" + 
				"	<SelfItemList>" + 
				"		<SelfItem>" + 
				"			<ItemID>"+map.get("ItemID")+"</ItemID>" + 
				"		</SelfItem>" + 
				"	</SelfItemList>";
		return requestWSDL(this.requestCodeSix, xml);
	}

	/**
	 * 
	 * @description: 2.1.7.查询网上预约记录
	 * @param patientIdNo 身份证号
	 * @param payFlag     缴费标志 1：缴费 0：未缴费
	 * @param regId       网上预约ID
	 * @param status      预约状态 0：已预约 1：医院已处理 2：取消预约 4：已缴费 5：已体检 6：取消体检
	 * @param preWay      预约途径 PC/APP/WeChat/Self-help
	 * @return XML
	 * @throws Exception
	 */
	public String getOnlineBookingXML(String patientIdNo, String payFlag, String regId, String status, String preWay)
			throws Exception {
		String xml = "<patientIdNo>" + patientIdNo + "</patientIdNo><payFlag>" + payFlag + "</payFlag><regId>" + regId
				+ "</regId><status>" + status + "</status><preWay>" + preWay + "</preWay>";
		return requestWSDL(this.requestCodeSeven, xml);
	}

	/**
	 * 
	 * @description: 2.1.8.取消网上预约记录XML
	 * @param regId        网上预约记录ID
	 * @param idCard       身份证号
	 * @param patientRegNo 登记号
	 * @param userCode     操作员代码
	 * @return XML
	 * @throws Exception
	 */
	public String getNoReservationXML(String regId, String idCard, String patientRegNo, String userCode)
			throws Exception {
		String xml = "<regId>" + regId + "</regId><patientRegNo>" + patientRegNo + "</patientRegNo><idCard>" + idCard
				+ "</idCard><userCode>" + userCode + "</userCode>";
		return requestWSDL(this.requestCodeEight, xml);
	}

	/**
	 * @description: 2.2.1.查询历次体检记录XML
	 * @param patientNo 登记号
	 * @return XML
	 * @throws Exception
	 */
	public String getAllPreviousMedicalXML(String patientNo) throws Exception {
		String xml = "<patientNo>" + patientNo + "</patientNo>";

		return requestWSDL(this.requestCodeNine, xml);
	}

	/**
	 * 
	 * @description: 2.2.2.查询总检建议xml
	 * @param admId 就诊ID
	 * @return XML
	 * @throws Exception
	 */
	public String getTotalInspectionAdvice(String admId) throws Exception {
		String xml = "<admId>" + admId + "</admId>";
		return requestWSDL(this.requestCodeTen, xml);
	}

	/**
	 * 
	 * @description: 2.2.3.查询报告项目细项结果XML
	 * @param admId  就诊ID
	 * @param pageNo 页码
	 * @return XML字符串
	 * @throws Exception
	 */
	public String getReportProjectDetails(String admId, String pageNo) throws Exception {
		String xml = "<admId>" + admId + "</admId><pageNo>" + pageNo + "</pageNo>";
		return requestWSDL(this.requestCodeEleven, xml);
	}

	/**
	 * 
	 * @description: 2.3.1.查找待缴费记录XML
	 * @param regNo 登记号
	 * @return xml数据
	 * @throws Exception
	 */
	public String getToPayCostInfo(String regNo) throws Exception {
		String xml = "<regNo>" + regNo + "</regNo>";
		return requestWSDL(this.requestCodeTwelve, xml);
	}

	/**
	 * 
	 * @description: 根据admId（PE3001接口返回）查询体检待缴费项目
	 * @param admId 就诊ID||预约类型 由PE3001接口返回
	 * @return xml字符串
	 * @throws Exception
	 */
	public String getItemsToBePaidInfo(String admId) throws Exception {
		String xml = "<admId>" + admId + "</admId>";
		return requestWSDL(this.requestCodeThirteen, xml);
	}

	/**
	 * 
	 * @description: 2.3.3.支付接口XML
	 * @param admId       就诊ID||预约类型 由PE3001接口返回
	 * @param regNo       登记号 非必须
	 * @param payAmount   金额
	 * @param orderNo     订单号
	 * @param terminalId  终端ID
	 * @param UserCode    收费员代码
	 * @param PayModeCode 支付方式代码
	 * @param PayDetails  支付信息对象 HIS交易需要 <PayModeCode></PayModeCode>
	 *                    <PayAccountNo>001</PayAccountNo> <PayAmt></PayAmt>
	 *                    <PlatformNo></PlatformNo> <OutPayNo></OutPayNo>
	 *                    <PayChannel></PayChannel> <POSPayStr></POSPayStr>
	 *                    <PayDate></PayDate> <PayTime></PayTime>
	 * @return xml字符串
	 * @throws Exception
	 */
	public String getPay(String admId, String regNo, String payAmount, String orderNo, String terminalId,
			String UserCode, String PayModeCode, String PayDetails) throws Exception {
		String xml = "<admId>" + admId + "</admId><regNo>" + regNo + "</regNo><payAmount>" + payAmount
				+ "</payAmount><UserCode>" + UserCode + "</UserCode><PayModeCode>" + PayModeCode
				+ "</PayModeCode><orderNo>" + orderNo + "</orderNo><PayDetails>" + PayDetails + "</PayDetails>";
		return requestWSDL(this.requestCodeFourteen, xml);
	}

	public static void main(String[] args) throws Exception {
		// 测试方法，测试接口为例，url地址
//		String address = " http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl";
		// 设置传参
//		String xml = "<locId>443</locId>";
		// 查看xml传参拼接结果
//		String repString = HisServiceUtil.getXML("HS10201", xml, METHOD);
		// 调用工具方法并填入调用接口名称
//		String repString = WebServiceUtil.requestWSDL("HS10201", xml);
//		System.out.println(repString);

		HisServiceUtil s = new HisServiceUtil();

		s.getOnlineMealXML("1");

	}

}
