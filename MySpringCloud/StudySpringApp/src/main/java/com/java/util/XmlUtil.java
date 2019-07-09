/**
 * Project Name:StudySpringApp
 * File Name:XmlUtil.java
 * Package Name:com.java.util
 * Date:2019年6月17日下午10:30:26
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
*/
package com.java.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.java.entity.ReportProjectDetails;

/**
 * @Title: XmlUtil.java
 * @Package com.java.util
 * @Description: TODO(XML字符串解析工具)
 * @author 刘云升
 * @date 2019年6月17日 下午10:30:26 Copyright (c) ©1994-2019 Scjydz.com All Rights
 *       Reserved.
 */
public class XmlUtil {
	// Map集合用于保存解析后的数据，其内容值为Map[ResultCode=value,ResultList=节点元素]
	public static Map<String, Object> maps = new HashMap<>();

	/**
	 * 
	 * @description: XML字符串解析方法
	 * @param soap XML字符串
	 * @return Map集合
	 * @throws DocumentException
	 */
	public static Map<String, Object> parse(String soap) throws DocumentException {
		Document doc = DocumentHelper.parseText(soap);// 报文转成doc对象
		Element root = doc.getRootElement();
		Element PublicMethodResult = root.element("Body").element("PublicMethodResponse").element("PublicMethodResult");
		Element Response = DocumentHelper.parseText(PublicMethodResult.getTextTrim()).getRootElement();
		maps.put("ResultCode", Response.element("ResultCode").getText());
		maps.put("ResultList", Response.element("ResultList"));
		return maps;
	}

	/**
	 * 
	 * @description: 2.1.1.查询网上体检套餐类型（VIP等级）
	 * @throws DocumentException
	 */
	public static void one() throws DocumentException {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:s=\"http://www.w3.org/2001/XMLSchema\">\r\n"
				+ "  <SOAP-ENV:Body>\r\n" + "    <PublicMethodResponse xmlns=\"http://tempuri.org\">\r\n"
				+ "      <PublicMethodResult><![CDATA[<Response><ResultCode>0</ResultCode><ResultDesc>成功</ResultDesc><ResultList><ExamPackagesLevel><levelId>1</levelId><levelDesc>普通</levelDesc></ExamPackagesLevel><ExamPackagesLevel><levelId>2</levelId><levelDesc>V1</levelDesc></ExamPackagesLevel><ExamPackagesLevel><levelId>4</levelId><levelDesc>V8</levelDesc></ExamPackagesLevel><ExamPackagesLevel><levelId>5</levelId><levelDesc>入职体检</levelDesc></ExamPackagesLevel><ExamPackagesLevel><levelId>6</levelId><levelDesc>入学体检</levelDesc></ExamPackagesLevel><ExamPackagesLevel><levelId>7</levelId><levelDesc>门诊</levelDesc></ExamPackagesLevel><ExamPackagesLevel><levelId>8</levelId><levelDesc>院办</levelDesc></ExamPackagesLevel><ExamPackagesLevel><levelId>9</levelId><levelDesc>V5</levelDesc></ExamPackagesLevel></ResultList></Response>]]></PublicMethodResult>\r\n"
				+ "    </PublicMethodResponse>\r\n" + "  </SOAP-ENV:Body>\r\n" + "</SOAP-ENV:Envelope>";
		Element ResultList = (Element) XmlUtil.parse(xml).get("ResultList");
		List<Element> list = ResultList.elements();
		if (ResultList.elements().size() > 0) {
			for (Element element : list) {
				System.out.println(element.elementTextTrim("levelId"));
				System.out.println(element.elementTextTrim("levelDesc"));
			}
		} else {
			System.out.println("查无数据");
		}

	}

	/**
	 * 2.1.2.查询网上体检套餐
	 * 
	 * @throws DocumentException
	 * @description:
	 */
	public static void two() throws DocumentException {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:s=\"http://www.w3.org/2001/XMLSchema\">\r\n"
				+ "  <SOAP-ENV:Body>\r\n" + "    <PublicMethodResponse xmlns=\"http://tempuri.org\">\r\n"
				+ "      <PublicMethodResult><![CDATA[<Response><ResultCode>0</ResultCode><ResultDesc>成功</ResultDesc><ResultList>"
				+ "<ExaminationPackages>" + "<packageId>14</packageId>" + "<packageDesc>200134-女性基础套餐（已婚）</packageDesc>"
				+ "<packageAmt>1196</packageAmt>" + "<ordSetsId>14068</ordSetsId>" + "<levelDesc>普通</levelDesc>"
				+ "<levelId>1</levelId>" + "<giFlag>个人</giFlag>" + "<sexDesc>女</sexDesc>"
				+ "<ordSetsType>N</ordSetsType>" + "<locId>443</locId>" + "<locDesc>健康管理部忠山院区</locDesc>"
				+ "</ExaminationPackages>"
				+ "<ExaminationPackages><packageId>16</packageId><packageDesc>TJTC016-孕前检查套餐</packageDesc><packageAmt>1740.55</packageAmt><ordSetsId>35732</ordSetsId><levelDesc>普通</levelDesc><levelId>1</levelId><giFlag>个人</giFlag><sexDesc>女</sexDesc><ordSetsType>N</ordSetsType><locId>443</locId><locDesc>健康管理部忠山院区</locDesc></ExaminationPackages><ExaminationPackages><packageId>17</packageId><packageDesc>TJTC001-基础套餐（女）</packageDesc><packageAmt>1486.98</packageAmt><ordSetsId>35676</ordSetsId><levelDesc>普通</levelDesc><levelId>1</levelId><giFlag>个人</giFlag><sexDesc>女</sexDesc><ordSetsType>N</ordSetsType><locId>443</locId><locDesc>健康管理部忠山院区</locDesc></ExaminationPackages><ExaminationPackages><packageId>18</packageId><packageDesc>TJTC002-全面型套餐（女）</packageDesc><packageAmt>1926.98</packageAmt><ordSetsId>35680</ordSetsId><levelDesc>普通</levelDesc><levelId>1</levelId><giFlag>个人</giFlag><sexDesc>女</sexDesc><ordSetsType>N</ordSetsType><locId>443</locId><locDesc>健康管理部忠山院区</locDesc></ExaminationPackages><ExaminationPackages><packageId>19</packageId><packageDesc>TJTC002-全面型套餐（男）</packageDesc><packageAmt>1708.98</packageAmt><ordSetsId>35678</ordSetsId><levelDesc>普通</levelDesc><levelId>1</levelId><giFlag>个人</giFlag><sexDesc>男</sexDesc><ordSetsType>N</ordSetsType><locId>443</locId><locDesc>健康管理部忠山院区</locDesc></ExaminationPackages></ResultList></Response>]]></PublicMethodResult>\r\n"
				+ "    </PublicMethodResponse>\r\n" + "  </SOAP-ENV:Body>\r\n" + "</SOAP-ENV:Envelope>";
		Element ResultList = (Element) XmlUtil.parse(xml).get("ResultList");
		List<Element> list = ResultList.elements();
		if (ResultList.elements().size() > 0) {
			for (Element element : list) {
				System.out.println(element.elementTextTrim("packageId"));
				System.out.println(element.elementTextTrim("packageDesc"));
				System.out.println(element.elementTextTrim("packageAmt"));
				System.out.println(element.elementTextTrim("ordSetsId"));
				System.out.println(element.elementTextTrim("levelDesc"));
				System.out.println(element.elementTextTrim("levelId"));
				System.out.println(element.elementTextTrim("giFlag"));
				System.out.println(element.elementTextTrim("sexDesc"));
				System.out.println(element.elementTextTrim("ordSetsType"));
				System.out.println(element.elementTextTrim("locId"));
				System.out.println(element.elementTextTrim("locDesc"));
			}
		} else {
			System.out.println("查无数据");
		}
	}

	/**
	 * 2.1.3.查询网上套餐明细
	 * 
	 * @throws DocumentException
	 * @description:
	 */
	public static void three() throws DocumentException {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:s=\"http://www.w3.org/2001/XMLSchema\">\r\n"
				+ "  <SOAP-ENV:Body>\r\n" + "    <PublicMethodResponse xmlns=\"http://tempuri.org\">\r\n"
				+ "      <PublicMethodResult><![CDATA[<Response><ResultCode>0</ResultCode><ResultDesc>成功</ResultDesc><ResultList>"
				+ "<ExamPackageItem>" + "<detailId>18||15||25||31</detailId>" + "<detailDesc>一般查体</detailDesc>"
				+ "<detailSeqNo>1</detailSeqNo>" + "<detailIntent>血压、身高、体重、脉搏、体重指数、腰围等一般情况</detailIntent>"
				+ "<itemId>18||15||25</itemId>" + "<itemDesc>常规查体</itemDesc>" + "<typeId>18||15</typeId>"
				+ "<typeDesc>查体</typeDesc>" + "<ordSetsId>18</ordSetsId>"
				+ "<ordSetsDesc>TJTC002-全面型套餐（女）</ordSetsDesc>" + "<ordSetsPrice>1926.98</ordSetsPrice>"
				+ "</ExamPackageItem><ExamPackageItem><detailId>18||15||32||42</detailId><detailDesc>妇科查体</detailDesc><detailSeqNo>2</detailSeqNo><detailIntent>通过触诊检查了解宫颈、阴道的基本情况及子宫、附件有无压痛等</detailIntent><itemId>18||15||32</itemId><itemDesc>妇科查体</itemDesc><typeId>18||15</typeId><typeDesc>查体</typeDesc><ordSetsId>18</ordSetsId><ordSetsDesc>TJTC002-全面型套餐（女）</ordSetsDesc><ordSetsPrice>1926.98</ordSetsPrice></ExamPackageItem><ExamPackageItem><detailId>18||16||34||44</detailId><detailDesc>血常规23项</detailDesc><detailSeqNo>1</detailSeqNo><detailIntent>初步检测血液系统疾病及炎性感染</detailIntent><itemId>18||16||34</itemId><itemDesc>血常规</itemDesc><typeId>18||16</typeId><typeDesc>检验</typeDesc><ordSetsId>18</ordSetsId><ordSetsDesc>TJTC002-全面型套餐（女）</ordSetsDesc><ordSetsPrice>1926.98</ordSetsPrice></ExamPackageItem><ExamPackageItem><detailId>18||16||35||45</detailId><detailDesc>尿常规19项</detailDesc><detailSeqNo>2</detailSeqNo><detailIntent>对肾脏和尿路及全身性疾病提供信息</detailIntent><itemId>18||16||35</itemId><itemDesc>尿常规</itemDesc><typeId>18||16</typeId><typeDesc>检验</typeDesc><ordSetsId>18</ordSetsId><ordSetsDesc>TJTC002-全面型套餐（女）</ordSetsDesc><ordSetsPrice>1926.98</ordSetsPrice></ExamPackageItem><ExamPackageItem><detailId>18||16||36||46</detailId><detailDesc>肝功能十项</detailDesc><detailSeqNo>3</detailSeqNo><detailIntent>了解肝胆功能，有无肝炎、胆道阻塞等</detailIntent><itemId>18||16||36</itemId><itemDesc>肝功、肾功</itemDesc><typeId>18||16</typeId><typeDesc>检验</typeDesc><ordSetsId>18</ordSetsId><ordSetsDesc>TJTC002-全面型套餐（女）</ordSetsDesc><ordSetsPrice>1926.98</ordSetsPrice></ExamPackageItem><ExamPackageItem><detailId>18||16||36||47</detailId><detailDesc>肾功能三项</detailDesc><detailSeqNo>4</detailSeqNo><detailIntent>了解肾功能，有助于对痛风、肾炎的诊断</detailIntent><itemId>18||16||36</itemId><itemDesc>肝功、肾功</itemDesc><typeId>18||16</typeId><typeDesc>检验</typeDesc><ordSetsId>18</ordSetsId><ordSetsDesc>TJTC002-全面型套餐（女）</ordSetsDesc><ordSetsPrice>1926.98</ordSetsPrice></ExamPackageItem><ExamPackageItem><detailId>18||16||37||48</detailId><detailDesc>血脂四项</detailDesc><detailSeqNo>5</detailSeqNo><detailIntent> 有助于了解脂代谢、动脉硬化疾病</detailIntent><itemId>18||16||37</itemId><itemDesc>血脂血糖</itemDesc><typeId>18||16</typeId><typeDesc>检验</typeDesc><ordSetsId>18</ordSetsId><ordSetsDesc>TJTC002-全面型套餐（女）</ordSetsDesc><ordSetsPrice>1926.98</ordSetsPrice></ExamPackageItem><ExamPackageItem><detailId>18||16||37||49</detailId><detailDesc>血糖</detailDesc><detailSeqNo>6</detailSeqNo><detailIntent>检查有无糖尿病和血糖异常</detailIntent><itemId>18||16||37</itemId><itemDesc>血脂血糖</itemDesc><typeId>18||16</typeId><typeDesc>检验</typeDesc><ordSetsId>18</ordSetsId><ordSetsDesc>TJTC002-全面型套餐（女）</ordSetsDesc><ordSetsPrice>1926.98</ordSetsPrice></ExamPackageItem><ExamPackageItem><detailId>18||16||38||50</detailId><detailDesc>同型半胱氨酸</detailDesc><detailSeqNo>7</detailSeqNo><detailIntent>脑卒中风险筛查</detailIntent><itemId>18||16||38</itemId><itemDesc>同型半胱氨酸</itemDesc><typeId>18||16</typeId><typeDesc>检验</typeDesc><ordSetsId>18</ordSetsId><ordSetsDesc>TJTC002-全面型套餐（女）</ordSetsDesc><ordSetsPrice>1926.98</ordSetsPrice></ExamPackageItem><ExamPackageItem><detailId>18||16||39||51</detailId><detailDesc>C13呼气试验</detailDesc><detailSeqNo>8</detailSeqNo><detailIntent>胃部幽门螺旋杆菌定量检测，金标准（呼气试验，方便无创）</detailIntent><itemId>18||16||39</itemId><itemDesc>C13</itemDesc><typeId>18||16</typeId><typeDesc>检验</typeDesc><ordSetsId>18</ordSetsId><ordSetsDesc>TJTC002-全面型套餐（女）</ordSetsDesc><ordSetsPrice>1926.98</ordSetsPrice></ExamPackageItem><ExamPackageItem><detailId>18||16||40||52</detailId><detailDesc>胃功能三联检查</detailDesc><detailSeqNo>9</detailSeqNo><detailIntent>包括胃蛋白酶原、胃泌素17检测。评估胃癌、胃炎风险。</detailIntent><itemId>18||16||40</itemId><itemDesc>胃功能</itemDesc><typeId>18||16</typeId><typeDesc>检验</typeDesc><ordSetsId>18</ordSetsId><ordSetsDesc>TJTC002-全面型套餐（女）</ordSetsDesc><ordSetsPrice>1926.98</ordSetsPrice></ExamPackageItem><ExamPackageItem><detailId>18||16||41||53</detailId><detailDesc>HPV E6 E7基因检测</detailDesc><detailSeqNo>10</detailSeqNo><detailIntent>早期的检测高危乳头瘤病毒（16型.18型）的感染，宫颈癌的早期筛查。</detailIntent><itemId>18||16||41</itemId><itemDesc>基因检测</itemDesc><typeId>18||16</typeId><typeDesc>检验</typeDesc><ordSetsId>18</ordSetsId><ordSetsDesc>TJTC002-全面型套餐（女）</ordSetsDesc><ordSetsPrice>1926.98</ordSetsPrice></ExamPackageItem><ExamPackageItem><detailId>18||17||28||34</detailId><detailDesc>上腹彩超</detailDesc><detailSeqNo>1</detailSeqNo><detailIntent>了解肝、胆、胰、脾及双肾有无占位</detailIntent><itemId>18||17||28</itemId><itemDesc>超声</itemDesc><typeId>18||17</typeId><typeDesc>检查</typeDesc><ordSetsId>18</ordSetsId><ordSetsDesc>TJTC002-全面型套餐（女）</ordSetsDesc><ordSetsPrice>1926.98</ordSetsPrice></ExamPackageItem><ExamPackageItem><detailId>18||17||28||35</detailId><detailDesc>盆腔彩超</detailDesc><detailSeqNo>2</detailSeqNo><detailIntent>子宫 卵巢 输卵管</detailIntent><itemId>18||17||28</itemId><itemDesc>超声</itemDesc><typeId>18||17</typeId><typeDesc>检查</typeDesc><ordSetsId>18</ordSetsId><ordSetsDesc>TJTC002-全面型套餐（女）</ordSetsDesc><ordSetsPrice>1926.98</ordSetsPrice></ExamPackageItem><ExamPackageItem><detailId>18||17||28||36</detailId><detailDesc>甲状腺超声</detailDesc><detailSeqNo>3</detailSeqNo><detailIntent>有无甲状腺肿瘤及淋巴结肿大</detailIntent><itemId>18||17||28</itemId><itemDesc>超声</itemDesc><typeId>18||17</typeId><typeDesc>检查</typeDesc><ordSetsId>18</ordSetsId><ordSetsDesc>TJTC002-全面型套餐（女）</ordSetsDesc><ordSetsPrice>1926.98</ordSetsPrice></ExamPackageItem><ExamPackageItem><detailId>18||17||28||37</detailId><detailDesc>乳腺超声</detailDesc><detailSeqNo>4</detailSeqNo><detailIntent>检查双侧乳腺有无包块</detailIntent><itemId>18||17||28</itemId><itemDesc>超声</itemDesc><typeId>18||17</typeId><typeDesc>检查</typeDesc><ordSetsId>18</ordSetsId><ordSetsDesc>TJTC002-全面型套餐（女）</ordSetsDesc><ordSetsPrice>1926.98</ordSetsPrice></ExamPackageItem><ExamPackageItem><detailId>18||17||29||38</detailId><detailDesc>头颅CT</detailDesc><detailSeqNo>5</detailSeqNo><detailIntent>早期发现肿瘤、脑梗塞、脑出血、脑脓肿等。对脑血管评估不及磁共振</detailIntent><itemId>18||17||29</itemId><itemDesc>CT</itemDesc><typeId>18||17</typeId><typeDesc>检查</typeDesc><ordSetsId>18</ordSetsId><ordSetsDesc>TJTC002-全面型套餐（女）</ordSetsDesc><ordSetsPrice>1926.98</ordSetsPrice></ExamPackageItem><ExamPackageItem><detailId>18||17||29||39</detailId><detailDesc>胸部CT</detailDesc><detailSeqNo>6</detailSeqNo><detailIntent>了解胸腔脏器有无占位性病变（选择了此项可替代胸部正位片）</detailIntent><itemId>18||17||29</itemId><itemDesc>CT</itemDesc><typeId>18||17</typeId><typeDesc>检查</typeDesc><ordSetsId>18</ordSetsId><ordSetsDesc>TJTC002-全面型套餐（女）</ordSetsDesc><ordSetsPrice>1926.98</ordSetsPrice></ExamPackageItem><ExamPackageItem><detailId>18||17||30||40</detailId><detailDesc>12导联心电图+高频心电图</detailDesc><detailSeqNo>7</detailSeqNo><detailIntent>检测有无心梗、心律失常、心肌缺血、肥厚等</detailIntent><itemId>18||17||30</itemId><itemDesc>心电图</itemDesc><typeId>18||17</typeId><typeDesc>检查</typeDesc><ordSetsId>18</ordSetsId><ordSetsDesc>TJTC002-全面型套餐（女）</ordSetsDesc><ordSetsPrice>1926.98</ordSetsPrice></ExamPackageItem><ExamPackageItem><detailId>18||17||31||41</detailId><detailDesc>液基细胞学</detailDesc><detailSeqNo>8</detailSeqNo><detailIntent>初筛有无宫颈炎、宫颈癌前病变、宫颈癌等。</detailIntent><itemId>18||17||31</itemId><itemDesc>细胞学</itemDesc><typeId>18||17</typeId><typeDesc>检查</typeDesc><ordSetsId>18</ordSetsId><ordSetsDesc>TJTC002-全面型套餐（女）</ordSetsDesc><ordSetsPrice>1926.98</ordSetsPrice></ExamPackageItem><ExamPackageItem><detailId>18||18||26||32</detailId><detailDesc>建档</detailDesc><detailSeqNo>1</detailSeqNo><detailIntent>实名制建档、随时调取体检结果</detailIntent><itemId>18||18||26</itemId><itemDesc>建档</itemDesc><typeId>18||18</typeId><typeDesc>其他</typeDesc><ordSetsId>18</ordSetsId><ordSetsDesc>TJTC002-全面型套餐（女）</ordSetsDesc><ordSetsPrice>1926.98</ordSetsPrice></ExamPackageItem><ExamPackageItem><detailId>18||18||27||33</detailId><detailDesc>早餐</detailDesc><detailSeqNo>2</detailSeqNo><detailIntent>牛奶、面包</detailIntent><itemId>18||18||27</itemId><itemDesc>早餐</itemDesc><typeId>18||18</typeId><typeDesc>其他</typeDesc><ordSetsId>18</ordSetsId><ordSetsDesc>TJTC002-全面型套餐（女）</ordSetsDesc><ordSetsPrice>1926.98</ordSetsPrice></ExamPackageItem><ExamPackageItem><detailId>18||18||33||43</detailId><detailDesc>结论</detailDesc><detailSeqNo>3</detailSeqNo><detailIntent>医生汇总分析形成体检纸质报告，专家健康咨询，体检报告袋</detailIntent><itemId>18||18||33</itemId><itemDesc>结论</itemDesc><typeId>18||18</typeId><typeDesc>其他</typeDesc><ordSetsId>18</ordSetsId><ordSetsDesc>TJTC002-全面型套餐（女）</ordSetsDesc><ordSetsPrice>1926.98</ordSetsPrice></ExamPackageItem></ResultList></Response>]]></PublicMethodResult>\r\n"
				+ "    </PublicMethodResponse>\r\n" + "  </SOAP-ENV:Body>\r\n" + "</SOAP-ENV:Envelope>";
		Element ResultList = (Element) XmlUtil.parse(xml).get("ResultList");
		List<Element> list = ResultList.elements();
		if (ResultList.elements().size() > 0) {
			for (Element element : list) {
				System.out.println(element.elementTextTrim("detailId"));
				System.out.println(element.elementTextTrim("detailDesc"));
				System.out.println(element.elementTextTrim("detailSeqNo"));
				System.out.println(element.elementTextTrim("detailIntent"));
				System.out.println(element.elementTextTrim("itemId"));
				System.out.println(element.elementTextTrim("itemDesc"));
				System.out.println(element.elementTextTrim("typeId"));
				System.out.println(element.elementTextTrim("typeDesc"));
				System.out.println(element.elementTextTrim("ordSetsId"));
				System.out.println(element.elementTextTrim("ordSetsDesc"));
				System.out.println(element.elementTextTrim("ordSetsPrice"));
			}
		} else {
			System.out.println("查无数据");
		}
	}

	/**
	 * 2.1.4.查询HIS套餐明细
	 * 
	 * @throws DocumentException
	 * @description:
	 */
	public static void four() throws DocumentException {
//		List<PEItem> items = new ArrayList<PEItem>();
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:s=\"http://www.w3.org/2001/XMLSchema\">\r\n"
				+ "  <SOAP-ENV:Body>\r\n" + "    <PublicMethodResponse xmlns=\"http://tempuri.org\">\r\n"
				+ "      <PublicMethodResult><![CDATA[<Response><ResultCode>0</ResultCode><ResultDesc>成功</ResultDesc><ResultList><PEItem><itemId>16606||1</itemId><itemDesc>采血试管(BD)</itemDesc><itemPrice>1.57</itemPrice><stationId>18</stationId><stationDesc>其它项目</stationDesc></PEItem><PEItem><itemId>16606||1</itemId><itemDesc>采血试管(BD)</itemDesc><itemPrice>1.57</itemPrice><stationId>18</stationId><stationDesc>其它项目</stationDesc></PEItem><PEItem><itemId>16606||1</itemId><itemDesc>采血试管(BD)</itemDesc><itemPrice>1.57</itemPrice><stationId>18</stationId><stationDesc>其它项目</stationDesc></PEItem><PEItem><itemId>16606||1</itemId><itemDesc>采血试管(BD)</itemDesc><itemPrice>1.57</itemPrice><stationId>18</stationId><stationDesc>其它项目</stationDesc></PEItem><PEItem><itemId>2648||1</itemId><itemDesc>建立健康档案</itemDesc><itemPrice>4.5</itemPrice><stationId>38</stationId><stationDesc>指引单及早餐</stationDesc></PEItem><PEItem><itemId>17299||1</itemId><itemDesc>一般查体</itemDesc><itemPrice>0</itemPrice><stationId>1</stationId><stationDesc>一般检查+结论</stationDesc></PEItem><PEItem><itemId>6074||1</itemId><itemDesc>H308.体检B女性</itemDesc><itemPrice>108</itemPrice><stationId>7</stationId><stationDesc>检验科</stationDesc><sexId>2</sexId><sexDesc>女</sexDesc></PEItem><PEItem><itemId>5808||1</itemId><itemDesc>JY150.血细胞分析</itemDesc><itemPrice>24.5</itemPrice><stationId>7</stationId><stationDesc>检验科</stationDesc></PEItem><PEItem><itemId>5816||1</itemId><itemDesc>JY160.尿液一般检查</itemDesc><itemPrice>39.3</itemPrice><stationId>7</stationId><stationDesc>检验科</stationDesc></PEItem><PEItem><itemId>18879||1</itemId><itemDesc>TJJY001.体检生化</itemDesc><itemPrice>102.4</itemPrice><stationId>7</stationId><stationDesc>检验科</stationDesc></PEItem><PEItem><itemId>6115||1</itemId><itemDesc>H443.INS 空腹</itemDesc><itemPrice>35</itemPrice><stationId>7</stationId><stationDesc>检验科</stationDesc></PEItem><PEItem><itemId>2366||1</itemId><itemDesc>FBCC101.腹部（肝，胆，胰，脾，双肾）</itemDesc><itemPrice>150</itemPrice><stationId>9</stationId><stationDesc>超声室</stationDesc></PEItem><PEItem><itemId>2369||1</itemId><itemDesc>FBCC104.妇科（子宫、附件及周围组织）</itemDesc><itemPrice>150</itemPrice><stationId>9</stationId><stationDesc>超声室</stationDesc><sexId>2</sexId><sexDesc>女</sexDesc></PEItem><PEItem><itemId>2381||1</itemId><itemDesc>FBCC116.乳腺及引流区淋巴结</itemDesc><itemPrice>102</itemPrice><stationId>9</stationId><stationDesc>超声室</stationDesc></PEItem><PEItem><itemId>2220||1</itemId><itemDesc>CT.胸部平扫1</itemDesc><itemPrice>378</itemPrice><stationId>13</stationId><stationDesc>CT室</stationDesc></PEItem><PEItem><itemId>17284||1</itemId><itemDesc>人体成分分析</itemDesc><itemPrice>80</itemPrice><stationId>22</stationId><stationDesc>营养科</stationDesc></PEItem><PEItem><itemId>10841||1</itemId><itemDesc>XDT19.常规心电图+频谱</itemDesc><itemPrice>71</itemPrice><stationId>10</stationId><stationDesc>心电图</stationDesc></PEItem><PEItem><itemId>17302||1</itemId><itemDesc>妇科查体</itemDesc><itemPrice>0</itemPrice><stationId>4</stationId><stationDesc>妇科</stationDesc><sexId>2</sexId><sexDesc>女</sexDesc></PEItem><PEItem><itemId>7850||1</itemId><itemDesc>XB04.液基细胞学与显微摄影术</itemDesc><itemPrice>288</itemPrice><stationId>12</stationId><stationDesc>病理科</stationDesc><sexId>2</sexId><sexDesc>女</sexDesc></PEItem><PEItem><itemId>18775||1</itemId><itemDesc>体检费</itemDesc><itemPrice>23</itemPrice><stationId>38</stationId><stationDesc>指引单及早餐</stationDesc></PEItem><PEItem><itemId>7761||1</itemId><itemDesc>BL521.HPV检测（低危组+高危组，适用于组织和脱落细胞）</itemDesc><itemPrice>360</itemPrice><stationId>12</stationId><stationDesc>病理科</stationDesc></PEItem><PEItem><itemId>18535||1</itemId><itemDesc>健康管理服务费</itemDesc><itemPrice>0</itemPrice><stationId>18</stationId><stationDesc>其它项目</stationDesc></PEItem></ResultList></Response>]]></PublicMethodResult>\r\n"
				+ "    </PublicMethodResponse>\r\n" + "  </SOAP-ENV:Body>\r\n" + "</SOAP-ENV:Envelope>";
		Element ResultList = (Element) XmlUtil.parse(xml).get("ResultList");
		List<Element> list = ResultList.elements();
		if (ResultList.elements().size() > 0) {
			for (Element element : list) {
//				PEItem e = new PEItem();
//				PEItem pEItem = new PEItem();
//				pEItem.setItemid(element.elementTextTrim("itemId"));
//				pEItem.setItemdesc(element.elementTextTrim("itemDesc"));
//				pEItem.setStationid(element.elementTextTrim("stationId"));
//				pEItem.setStationdesc(element.elementTextTrim("stationDesc"));
//				pEItem.setSexid(element.elementTextTrim("sexId"));
//				pEItem.setSexdesc(element.elementTextTrim("sexDesc"));
//				pEItem.setItemprice(new BigDecimal(element.elementTextTrim("itemPrice")));
//				items.add(pEItem);
			}
		} else {
			System.out.println("查无数据");
		}
	}

	/**
	 * 2.1.5.查询所有体检项目
	 * 
	 * @throws DocumentException
	 * @description:
	 */
	public static void five() throws DocumentException {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:s=\"http://www.w3.org/2001/XMLSchema\">\r\n"
				+ "  <SOAP-ENV:Body>\r\n" + "    <PublicMethodResponse xmlns=\"http://tempuri.org\">\r\n"
				+ "      <PublicMethodResult><![CDATA[<Response><ResultCode>0</ResultCode><ResultDesc>成功</ResultDesc><ResultList><pageCount>99</pageCount><pageNo>1</pageNo><pageSize>10</pageSize><totalCount>984</totalCount><PeOrdItem><itemCategoryDesc>健康管理中心</itemCategoryDesc><hisItemId>17299||1</hisItemId><itemDesc>一般查体</itemDesc><price>0</price><alertMsg>身高:______cm；体重_____kg；血压：____/____ mmHg；</alertMsg></PeOrdItem><PeOrdItem><itemCategoryDesc>健康管理中心</itemCategoryDesc><hisItemId>17300||1</hisItemId><itemDesc>内科查体</itemDesc><price>0</price></PeOrdItem><PeOrdItem><itemCategoryDesc>治疗科室通用</itemCategoryDesc><hisItemId>17332||1</hisItemId><itemDesc>呼出气一氧化氮测定</itemDesc><price>240</price></PeOrdItem><PeOrdItem><itemCategoryDesc>健康管理中心</itemCategoryDesc><hisItemId>17301||1</hisItemId><itemDesc>外科查体</itemDesc><price>0</price></PeOrdItem><PeOrdItem><itemCategoryDesc>健康管理中心</itemCategoryDesc><hisItemId>17302||1</hisItemId><itemDesc>妇科查体</itemDesc><price>0</price><alertMsg>★提示：限于已婚或有性生活者，未婚者检查此项需签字</alertMsg></PeOrdItem><PeOrdItem><itemCategoryDesc>治疗妇科</itemCategoryDesc><hisItemId>17246||1</hisItemId><itemDesc>阴道镜检查</itemDesc><price>28</price><alertMsg>★提示：限于已婚或有性生活者，未婚者检查此项需签字</alertMsg></PeOrdItem><PeOrdItem><itemCategoryDesc>健康管理中心</itemCategoryDesc><hisItemId>17303||1</hisItemId><itemDesc>眼科查体</itemDesc><price>0</price><alertMsg>右: 　左: 　（裸视/矫正）配戴隐形眼镜（是/否）</alertMsg></PeOrdItem><PeOrdItem><itemCategoryDesc>治疗眼科</itemCategoryDesc><hisItemId>7312||1</hisItemId><itemDesc>眼底检查</itemDesc><price>11</price><alertMsg>右: 　左: 　（裸视/矫正）配戴隐形眼镜（是/否）</alertMsg></PeOrdItem><PeOrdItem><itemCategoryDesc>治疗眼科</itemCategoryDesc><hisItemId>7310||1</hisItemId><itemDesc>普通视力检查</itemDesc><price>4</price><alertMsg>右: 　左: 　（裸视/矫正）配戴隐形眼镜（是/否）</alertMsg></PeOrdItem><PeOrdItem><itemCategoryDesc>其他计费</itemCategoryDesc><hisItemId>2758||1</hisItemId><itemDesc>色觉检查</itemDesc><price>7</price><alertMsg>右: 　左: 　（裸视/矫正）配戴隐形眼镜（是/否）</alertMsg></PeOrdItem></ResultList></Response>]]></PublicMethodResult>\r\n"
				+ "    </PublicMethodResponse>\r\n" + "  </SOAP-ENV:Body>\r\n" + "</SOAP-ENV:Envelope>";
		Element ResultList = (Element) XmlUtil.parse(xml).get("ResultList");
		List<Element> list = ResultList.elements();
		if (ResultList.elements().size() > 0) {
			for (Element element : list) {
				if ("PeOrdItem".equals(element.getName())) {
					System.out.println(element.elementTextTrim("itemCategoryDesc"));
					System.out.println(element.elementTextTrim("hisItemId"));
					System.out.println(element.elementTextTrim("itemDesc"));
					System.out.println(element.elementTextTrim("price"));
					System.out.println(element.elementTextTrim("alertMsg"));
//				System.out.println(element.elementTextTrim("stationDesc"));
//				System.out.println(element.elementTextTrim("itemDesc"));
//				System.out.println(element.elementTextTrim("typeId"));
//				System.out.println(element.elementTextTrim("typeDesc"));
//				System.out.println(element.elementTextTrim("ordSetsId"));
//				System.out.println(element.elementTextTrim("ordSetsDesc"));
//				System.out.println(element.elementTextTrim("ordSetsPrice"));
				}
			}
		} else {
			System.out.println("查无数据");
		}
	}

	/**
	 * 2.1.7.查询网上预约记录
	 * 
	 * @throws DocumentException
	 * @description:
	 */
	public static void six() throws DocumentException {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:s=\"http://www.w3.org/2001/XMLSchema\">\r\n"
				+ "  <SOAP-ENV:Body>\r\n" + "    <PublicMethodResponse xmlns=\"http://tempuri.org\">\r\n"
				+ "      <PublicMethodResult><![CDATA[<Response><ResultCode>0</ResultCode><ResultDesc>成功</ResultDesc><ResultList>"
				+ "<ExamRegRecord>" + "<patientRegNo>0001109188</patientRegNo>" + "<patientName>李栋</patientName>"
				+ "<sexDesc>男</sexDesc>" + "<patientAge>39</patientAge>"
				+ "<patientIdNo>370101198004101637</patientIdNo>" + "<ordSetId>7804</ordSetId>"
				+ "<ordSetDesc>200134-男性体检基础套餐(40岁以下)</ordSetDesc>" + "<regExamDate>2019-06-20</regExamDate>"
				+ "<regId>28</regId>" + "<phoneNo>18689089008</phoneNo>" + "<levelDesc>普通</levelDesc>"
				+ "<status>6</status>" + "<payFlag>0</payFlag>" + "<admId>1743133</admId>" + "<preIADM>35147</preIADM>"
				+ "<locId>443</locId>" + "<locDesc>健康管理部忠山院区</locDesc>" + "<preDateFlag>0</preDateFlag>"
				+ "<peId>PT00008166</peId>" + "<canModifyFlag>Y</canModifyFlag>"
				+ "</ExamRegRecord></ResultList></Response>]]></PublicMethodResult>\r\n"
				+ "    </PublicMethodResponse>\r\n" + "  </SOAP-ENV:Body>\r\n" + "</SOAP-ENV:Envelope>";
		Element ResultList = (Element) XmlUtil.parse(xml).get("ResultList");
		List<Element> list = ResultList.elements();
		if (ResultList.elements().size() > 0) {
			for (Element element : list) {
				System.out.println(element.elementTextTrim("patientRegNo"));
				System.out.println(element.elementTextTrim("patientName"));
				System.out.println(element.elementTextTrim("sexDesc"));
				System.out.println(element.elementTextTrim("patientAge"));
				System.out.println(element.elementTextTrim("patientIdNo"));
				System.out.println(element.elementTextTrim("ordSetId"));
				System.out.println(element.elementTextTrim("ordSetDesc"));
				System.out.println(element.elementTextTrim("regExamDate"));
				System.out.println(element.elementTextTrim("regId"));
				System.out.println(element.elementTextTrim("phoneNo"));
				System.out.println(element.elementTextTrim("levelDesc"));
				System.out.println(element.elementTextTrim("status"));
				System.out.println(element.elementTextTrim("payFlag"));
				System.out.println(element.elementTextTrim("admId"));
				System.out.println(element.elementTextTrim("preIADM"));
				System.out.println(element.elementTextTrim("locId"));
				System.out.println(element.elementTextTrim("locDesc"));
				System.out.println(element.elementTextTrim("preDateFlag"));
				System.out.println(element.elementTextTrim("peId"));
				System.out.println(element.elementTextTrim("canModifyFlag"));
			}
		} else {
			System.out.println("查无数据");
		}
	}

	/**
	 * 2.2.1.查询历次体检记录
	 * 
	 * @throws DocumentException
	 * @description:
	 */
	public static void Seven() throws DocumentException {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:s=\"http://www.w3.org/2001/XMLSchema\">\r\n"
				+ "  <SOAP-ENV:Body>\r\n" + "    <PublicMethodResponse xmlns=\"http://tempuri.org\">\r\n"
				+ "      <PublicMethodResult><![CDATA[<Response><ResultCode>0</ResultCode><ResultDesc>成功</ResultDesc><ResultList>"
				+ "<PeRecord>" + "<name>蓝贵静</name>" + "<sex>女</sex>" + "<age>26</age>"
				+ "<examDate>2019-06-06</examDate>" + "<company>江阳区法院</company>" + "<admId>1352879</admId>"
				+ "<reportStatus>已完成</reportStatus>" + "<peStatus>到达</peStatus>" + "<preDate>2019-06-06</preDate>"
				+ "</PeRecord></ResultList></Response>]]></PublicMethodResult>\r\n" + "    </PublicMethodResponse>\r\n"
				+ "  </SOAP-ENV:Body>\r\n" + "</SOAP-ENV:Envelope>";
		Element ResultList = (Element) XmlUtil.parse(xml).get("ResultList");
		List<Element> list = ResultList.elements();
		if (ResultList.elements().size() > 0) {
			for (Element element : list) {
				System.out.println("name=" + element.elementTextTrim("name"));
				System.out.println("sex=" + element.elementTextTrim("sex"));
				System.out.println("age=" + element.elementTextTrim("age"));
				System.out.println("examDate=" + element.elementTextTrim("examDate"));
				System.out.println("company=" + element.elementTextTrim("company"));
				System.out.println("admId=" + element.elementTextTrim("admId"));
				System.out.println("reportStatus=" + element.elementTextTrim("reportStatus"));
				System.out.println("peStatus=" + element.elementTextTrim("peStatus"));
				System.out.println("preDate=" + element.elementTextTrim("preDate"));
//				System.out.println(element.elementTextTrim("phoneNo"));
//				System.out.println(element.elementTextTrim("levelDesc"));
//				System.out.println(element.elementTextTrim("status"));
//				System.out.println(element.elementTextTrim("payFlag"));
//				System.out.println(element.elementTextTrim("admId"));
//				System.out.println(element.elementTextTrim("preIADM"));
//				System.out.println(element.elementTextTrim("locId"));
//				System.out.println(element.elementTextTrim("locDesc"));
//				System.out.println(element.elementTextTrim("preDateFlag"));
//				System.out.println(element.elementTextTrim("peId"));
//				System.out.println(element.elementTextTrim("canModifyFlag"));
			}
		} else {
			System.out.println("查无数据");
		}
	}

	/**
	 * 2.2.2.查询总检建议
	 * 
	 * @throws DocumentException
	 * @description:
	 */
	public static void Eight() throws DocumentException {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:s=\"http://www.w3.org/2001/XMLSchema\">\r\n"
				+ "  <SOAP-ENV:Body>\r\n" + "    <PublicMethodResponse xmlns=\"http://tempuri.org\">\r\n"
				+ "      <PublicMethodResult><![CDATA[<Response><ResultCode>0</ResultCode><ResultDesc>成功</ResultDesc><ResultList><ExaminationSummary><examSummary><![CDATA[ 1、[宫颈轻度糜烂]<br>       宫颈糜烂多是宫颈柱状上皮外翻的生理现象（宫颈柱状上皮异位），当出现病理性改变如液基细胞有异常，必须作进一步检查，若有接触性出血、白带增多、异味、瘙痒等症状需进一步治疗。宫颈糜烂轻度者，可随访观察，中及重度者物理治疗，效果较好。建议妇科随访。<br> 2、[液基细胞学与显微摄影术：炎细胞—轻度]<br>       您此次宫颈液基细胞学检查提示：炎细胞—轻度，建议妇科随访，必要时抗炎治疗。<br> 3、[左附件囊性暗区]<br>       您此次彩超提示：左附件区减弱回声，建议下次月经干净后3-7天，复查彩超，妇科随访。<br> 4、[尿隐血阳性]<br>尿隐血：+1 cell/ul<br>       正常人尿沉渣镜检红细胞数0～3个/HP（即尿隐血为-）。尿路感染、肾细小结石、剧烈运动、寒冷以及药物等都可引起。如有尿急、尿频、尿痛等不适可到泌尿外科就诊。<br> 5、[双侧乳腺 US-BI-RADS 1类]<br>       系正常乳腺，建议每年常规随访。]]]]><![CDATA[></examSummary><summaryDoctor>李晓红/杨昌秀</summaryDoctor><summaryDate>2019-06-14</summaryDate><auditDoctor>李晓红</auditDoctor><auditDate>2019-06-14</auditDate><IllExplain><![CDATA[ 1、[肝血管瘤？]<br>       彩超提示：肝内异常回声：考虑血管瘤。肝血管瘤为肝脏的一种良性病变，往往无症状，且不影响肝功能，一般不需要特殊处理。若为体检首次发现，需进一步做肝脏CT或增强CT等检查，结合AFP综合分析，以除外肝内其他占位性病变。若非首次发现（既往检查已存在），建议定期（3-6个月）复查腹部彩超、血AFP 、肝功等动态观察，如果瘤体过大可到肝胆外科就诊治疗。<br> 2、[体重超重]<br>               体质指数：24.30 (18.5-24 ) ↑<br>       24≤BMI＜28为超重，建议您控制体重，注意低盐、低糖、低脂，多食高纤维素、高维生素饮食，增加新鲜蔬菜和水果在膳食中的比重，适量摄取谷类。养成良好进食行为，避免进食速度过快，不要一餐过饱，也不要漏餐。适当增加运动量，多进行有氧的中、低强度体力活动，如走路、慢跑等。控制膳食与增加运动相结合，长期坚持，不可急于求成。建议必要时可到营养科进行膳食指导。<br>]]]]><![CDATA[></IllExplain><IllExplainTitle><![CDATA[1、[肝血管瘤？]<br> 2、[体重超重]]]]]><![CDATA[></IllExplainTitle></ExaminationSummary></ResultList></Response>]]></PublicMethodResult>\r\n"
				+ "    </PublicMethodResponse>\r\n" + "  </SOAP-ENV:Body>\r\n" + "</SOAP-ENV:Envelope>";
//		System.out.println(xml);
		Element ResultList = (Element) XmlUtil.parse(xml).get("ResultList");
		List<Element> list = ResultList.elements();
		if (ResultList.elements().size() > 0) {
			for (Element element : list) {
				System.out.println("examSummary=" + element.elementTextTrim("examSummary"));
				System.out.println("summaryDoctor=" + element.elementTextTrim("summaryDoctor"));
				System.out.println("summaryDate=" + element.elementTextTrim("summaryDate"));
				System.out.println("auditDoctor=" + element.elementTextTrim("auditDoctor"));
				System.out.println("auditDate=" + element.elementTextTrim("auditDate"));
				System.out.println("IllExplain=" + element.elementTextTrim("IllExplain"));
				System.out.println("IllExplainTitle=" + element.elementTextTrim("IllExplainTitle"));
//				System.out.println(element.elementTextTrim("peStatus"));
//				System.out.println(element.elementTextTrim("preDate"));
//				System.out.println(element.elementTextTrim("phoneNo"));
//				System.out.println(element.elementTextTrim("levelDesc"));
//				System.out.println(element.elementTextTrim("status"));
//				System.out.println(element.elementTextTrim("payFlag"));
//				System.out.println(element.elementTextTrim("admId"));
//				System.out.println(element.elementTextTrim("preIADM"));
//				System.out.println(element.elementTextTrim("locId"));
//				System.out.println(element.elementTextTrim("locDesc"));
//				System.out.println(element.elementTextTrim("preDateFlag"));
//				System.out.println(element.elementTextTrim("peId"));
//				System.out.println(element.elementTextTrim("canModifyFlag"));
			}
		} else {
			System.out.println("查无数据");
		}
	}

	/**
	 * 2.2.3.查询报告项目细项结果
	 * 
	 * @throws DocumentException
	 * @description:
	 */
	public static void nine() throws DocumentException {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:s=\"http://www.w3.org/2001/XMLSchema\">\r\n"
				+ "  <SOAP-ENV:Body>\r\n" + "    <PublicMethodResponse xmlns=\"http://tempuri.org\">\r\n"
				+ "      <PublicMethodResult><![CDATA[<Response>\r\n" + "			<ResultCode>0</ResultCode>\r\n"
				+ "			<ResultDesc>成功</ResultDesc>\r\n" + "			<ResultList>\r\n"
				+ "				<total>1</total>\r\n" + "				<ExaminationItem>\r\n"
				+ "					<itemDesc>内科检查</itemDesc>\r\n" + "					<itemId>2132||1</itemId>\r\n"
				+ "					<reportFormat>RF_NOR</reportFormat>\r\n"
				+ "					<doctorName>Demo Group</doctorName>\r\n"
				+ "					<examDate>2017-08-25</examDate>\r\n"
				+ "					<isFirst>1</isFirst>\r\n" + "					<isLast>0</isLast>\r\n"
				+ "					<stationCode>2</stationCode>\r\n"
				+ "					<stationName>内科</stationName>\r\n" + "					<ItemDetailList>\r\n"
				+ "						<ExaminationItemDetail>\r\n"
				+ "							<itemDesc>心率</itemDesc>\r\n"
				+ "							<itemResult>89</itemResult>\r\n"
				+ "							<itemUom>次/分</itemUom>\r\n"
				+ "							<referenceRange>60-90</referenceRange>\r\n"
				+ "						</ExaminationItemDetail>\r\n"
				+ "						<ExaminationItemDetail>\r\n"
				+ "							<itemDesc>心脏节律</itemDesc>\r\n"
				+ "							<itemResult>整齐</itemResult>\r\n"
				+ "							<referenceRange>整齐</referenceRange>\r\n"
				+ "						</ExaminationItemDetail>\r\n" + "					</ItemDetailList>\r\n"
				+ "				</ExaminationItem>\r\n" + "				<ExaminationItem>\r\n"
				+ "					<itemDesc>常规心电图检查(12导联)</itemDesc>\r\n"
				+ "					<itemId>2132||5</itemId>\r\n"
				+ "					<reportFormat>RF_EKG</reportFormat>\r\n"
				+ "					<doctorName>Demo Group</doctorName>\r\n"
				+ "					<examDate>2017-08-25</examDate>\r\n" + "					<ItemDetailList>\r\n"
				+ "						<ExaminationItemDetail>\r\n"
				+ "							<itemDesc>常规心电图检查(12导联)</itemDesc>\r\n"
				+ "							<itemResult>临床诊断:;检查所见:正常;诊断意见:异常</itemResult>\r\n"
				+ "							<imgInfo>ftp://dhc:dhc@127.0.0.1:21/test/2233.pdf</imgInfo>\r\n"
				+ "						</ExaminationItemDetail>\r\n" + "					</ItemDetailList>\r\n"
				+ "					<isFirst>0</isFirst>\r\n" + "					<isLast>1</isLast>\r\n"
				+ "					<stationCode>10</stationCode>\r\n"
				+ "					<stationName>心电图</stationName>\r\n" + "				</ExaminationItem>\r\n"
				+ "			</ResultList>\r\n" + "		</Response>]]></PublicMethodResult>\r\n"
				+ "    </PublicMethodResponse>\r\n" + "  </SOAP-ENV:Body>\r\n" + "</SOAP-ENV:Envelope>";

		String xmlx = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:s=\"http://www.w3.org/2001/XMLSchema\">\r\n"
				+ "  <SOAP-ENV:Body>\r\n" + "    <PublicMethodResponse xmlns=\"http://tempuri.org\">\r\n"
				+ "      <PublicMethodResult><![CDATA[<Response><ResultCode>0</ResultCode><ResultDesc>成功</ResultDesc><ResultList><total>2</total><ExaminationItem><itemDesc>眼科查体</itemDesc><itemId>1320550||6</itemId><reportFormat>RF_NOR</reportFormat><doctorName>曹阳</doctorName><examDate>2019-06-06</examDate><ItemDetailList><ExaminationItemDetail><itemDesc>矫正视力右</itemDesc><itemResult>1.0</itemResult></ExaminationItemDetail><ExaminationItemDetail><itemDesc>矫正视力左</itemDesc><itemResult>1.0</itemResult></ExaminationItemDetail><ExaminationItemDetail><itemDesc>色觉</itemDesc><itemResult>（-）</itemResult></ExaminationItemDetail></ItemDetailList><isFirst>0</isFirst><isLast>0</isLast><stationCode>4</stationCode></ExaminationItem><ExaminationItem><itemDesc>耳鼻喉查体</itemDesc><itemId>1320550||7</itemId><reportFormat>RF_NOR</reportFormat><doctorName>杨昌秀</doctorName><examDate>2019-06-06</examDate><ItemDetailList><ExaminationItemDetail><itemDesc>既往史</itemDesc><itemResult>见问卷</itemResult><referenceRange>见问卷</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>现病史</itemDesc><itemResult>见问卷</itemResult><referenceRange>见问卷</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>耳</itemDesc><itemResult>未见明显异常</itemResult><referenceRange>未见明显异常</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>鼻</itemDesc><itemResult>未见明显异常</itemResult><referenceRange>未见明显异常</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>咽</itemDesc><itemResult>未见明显异常</itemResult><referenceRange>未见明显异常</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>喉</itemDesc><itemResult>未查</itemResult><referenceRange>未查</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>其它</itemDesc><itemResult>无</itemResult><referenceRange>无</referenceRange></ExaminationItemDetail></ItemDetailList><isFirst>0</isFirst><isLast>0</isLast><stationCode>5</stationCode></ExaminationItem><ExaminationItem><itemDesc>JY150.血细胞分析</itemDesc><itemId>1320550||8</itemId><reportFormat>RF_LIS</reportFormat><auditDoctorName>钟宇</auditDoctorName><doctorName>于卉</doctorName><examDate>2019-06-13</examDate><ItemDetailList><ExaminationItemDetail><itemDesc>白细胞数</itemDesc><itemAbbreviation>WBC</itemAbbreviation><itemResult>5.33</itemResult><itemUom>10`9/L</itemUom><referenceRange>3.5-9.5</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>中性粒细胞数</itemDesc><itemAbbreviation>NEU</itemAbbreviation><itemResult>2.16</itemResult><itemUom>10`9/L</itemUom><referenceRange>1.8-6.3</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>淋巴细胞数</itemDesc><itemAbbreviation>LYM</itemAbbreviation><itemResult>2.82</itemResult><itemUom>10`9/L</itemUom><referenceRange>1.1-3.2</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>单核细胞数</itemDesc><itemAbbreviation>MONO</itemAbbreviation><itemResult>0.26</itemResult><itemUom>10`9/L</itemUom><referenceRange>0.1-0.6</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>嗜酸性粒细胞数</itemDesc><itemAbbreviation>EOS</itemAbbreviation><itemResult>0.08</itemResult><itemUom>10`9/L</itemUom><referenceRange>0.02-0.52</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>嗜碱性粒细胞数</itemDesc><itemAbbreviation>BASO</itemAbbreviation><itemResult>0.01</itemResult><itemUom>10`9/L</itemUom><referenceRange>0-0.06</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>中性粒细胞率</itemDesc><itemAbbreviation>NEU-R</itemAbbreviation><itemResult>40.50</itemResult><itemUom>%</itemUom><referenceRange>40-75</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>淋巴细胞率</itemDesc><itemAbbreviation>LYM-R</itemAbbreviation><itemResult>53.00</itemResult><exceptionTip>↑</exceptionTip><itemUom>%</itemUom><referenceRange>20-50</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>单核细胞率</itemDesc><itemAbbreviation>MONO-R</itemAbbreviation><itemResult>4.80</itemResult><itemUom>%</itemUom><referenceRange>3-10</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>嗜酸性粒细胞率</itemDesc><itemAbbreviation>EOS-R</itemAbbreviation><itemResult>1.50</itemResult><itemUom>%</itemUom><referenceRange>0.4-8</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>嗜碱性粒细胞率</itemDesc><itemAbbreviation>BASO-R</itemAbbreviation><itemResult>0.20</itemResult><itemUom>%</itemUom><referenceRange>0-1</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>红细胞数</itemDesc><itemAbbreviation>RBC</itemAbbreviation><itemResult>4.21</itemResult><itemUom>10`12/L</itemUom><referenceRange>3.8-5.1</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>血红蛋白</itemDesc><itemAbbreviation>HGB</itemAbbreviation><itemResult>128</itemResult><itemUom>g/L</itemUom><referenceRange>115-150</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>红细胞压积</itemDesc><itemAbbreviation>HCT</itemAbbreviation><itemResult>0.40</itemResult><referenceRange>0.35-0.45</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>红细胞平均体积</itemDesc><itemAbbreviation>MCV</itemAbbreviation><itemResult>95.00</itemResult><itemUom>fl</itemUom><referenceRange>82-100</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>红细胞平均血红蛋白量</itemDesc><itemAbbreviation>MCH</itemAbbreviation><itemResult>30.30</itemResult><itemUom>pg</itemUom><referenceRange>27-34</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>红细胞平均血红蛋白浓度</itemDesc><itemAbbreviation>MCHC</itemAbbreviation><itemResult>319</itemResult><itemUom>g/L</itemUom><referenceRange>316-354</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>红细胞体积分布宽度标准差</itemDesc><itemAbbreviation>RDW-SD</itemAbbreviation><itemResult>40.20</itemResult><itemUom>fl</itemUom><referenceRange>35-56</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>红细胞体积分布宽度变异系数</itemDesc><itemAbbreviation>RDW-CV</itemAbbreviation><itemResult>12.00</itemResult><itemUom>%</itemUom><referenceRange>11-16</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>血小板数</itemDesc><itemAbbreviation>PLT</itemAbbreviation><itemResult>231</itemResult><itemUom>10`9/L</itemUom><referenceRange>125-350</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>血小板平均体积</itemDesc><itemAbbreviation>MPV</itemAbbreviation><itemResult>8.50</itemResult><exceptionTip>↓</exceptionTip><itemUom>fl</itemUom><referenceRange>9.4-12.5</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>血小板压积</itemDesc><itemAbbreviation>PCT</itemAbbreviation><itemResult>0.20</itemResult><referenceRange>0.10-0.28</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>血小板体积分布宽度</itemDesc><itemAbbreviation>PDW</itemAbbreviation><itemResult>15.70</itemResult><itemUom>%</itemUom><referenceRange>15.1-18.1</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>大血小板比例</itemDesc><itemAbbreviation>P-LCR</itemAbbreviation><itemResult>15.60</itemResult><itemUom>%</itemUom><referenceRange>13.0-43.0</referenceRange></ExaminationItemDetail></ItemDetailList><isFirst>0</isFirst><isLast>0</isLast><stationCode>7</stationCode></ExaminationItem></ResultList></Response>]]></PublicMethodResult>\r\n"
				+ "    </PublicMethodResponse>\r\n" + "  </SOAP-ENV:Body>\r\n" + "</SOAP-ENV:Envelope>";
		Element ResultList = (Element) XmlUtil.parse(xmlx).get("ResultList");
		List<Element> list = ResultList.elements();
		if (ResultList.elements().size() > 0) {
			for (Element element : list) {
				if ("total".equals(element.getName())) {
					System.out.println("total=" + element.getText());
				}
				if ("ExaminationItem".equals(element.getName())) {
					System.out.println("itemDesc=" + element.elementTextTrim("itemDesc"));
					System.out.println("itemId=" + element.elementTextTrim("itemId") + "itemId");
					System.out.println("reportFormat=" + element.elementTextTrim("reportFormat"));
					System.out.println("doctorName=" + element.elementTextTrim("doctorName"));
					System.out.println("examDate=" + element.elementTextTrim("examDate"));

					if ("ItemDetailList".equals(element.element("ItemDetailList").getName())) {
						List<Element> lists = element.element("ItemDetailList").elements();
						for (Element element2 : lists) {
							System.out.println("itemDesc=" + element2.elementTextTrim("itemDesc"));
							System.out.println("itemResult=" + element2.elementTextTrim("itemResult"));
							System.out.println("imgInfo=" + element2.elementTextTrim("imgInfo"));
							System.out.println("itemUom=" + element2.elementTextTrim("itemUom"));
							System.out.println("referenceRange=" + element2.elementTextTrim("referenceRange"));
							System.out.println("exceptionTip=" + element2.elementTextTrim("exceptionTip"));
						}
					}

				}

//				System.out.println(element.elementTextTrim("phoneNo"));
//				System.out.println(element.elementTextTrim("levelDesc"));
//				System.out.println(element.elementTextTrim("status"));
//				System.out.println(element.elementTextTrim("payFlag"));
//				System.out.println(element.elementTextTrim("admId"));
//				System.out.println(element.elementTextTrim("preIADM"));
//				System.out.println(element.elementTextTrim("locId"));
//				System.out.println(element.elementTextTrim("locDesc"));
//				System.out.println(element.elementTextTrim("preDateFlag"));
//				System.out.println(element.elementTextTrim("peId"));
//				System.out.println(element.elementTextTrim("canModifyFlag"));
			}
		} else {
			System.out.println("查无数据");
		}
	}

	public static void testone() throws DocumentException {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:s=\"http://www.w3.org/2001/XMLSchema\">\r\n"
				+ "  <SOAP-ENV:Body>\r\n" + "    <PublicMethodResponse xmlns=\"http://tempuri.org\">\r\n"
				+ "      <PublicMethodResult><![CDATA[<Response>\r\n" + "	<ResultCode>0</ResultCode>\r\n"
				+ "	<ResultDesc>成功</ResultDesc>\r\n" + "	<ResultList>\r\n" + "		<Response>\r\n"
				+ "			<Name>陈婉清</Name>\r\n" + "			<Sex>女</Sex>\r\n" + "			<PayRecords>\r\n"
				+ "				<PayRecord>\r\n" + "					<admId>1123||P</admId>\r\n"
				+ "					<CheckDate>2018-05-04</CheckDate>\r\n"
				+ "					<SetsDesc>入职体检</SetsDesc>\r\n" + "					<Amt>263.00</Amt>\r\n"
				+ "				</PayRecord>\r\n" + "				<PayRecord>\r\n"
				+ "					<admId>1124||P</admId>\r\n"
				+ "					<CheckDate>2018-04-17</CheckDate>\r\n" + "					<Amt>345.00</Amt>\r\n"
				+ "				</PayRecord>\r\n" + "			</PayRecords>\r\n" + "		</Response>\r\n"
				+ "	</ResultList>\r\n" + "</Response>]]></PublicMethodResult>\r\n" + "    </PublicMethodResponse>\r\n"
				+ "  </SOAP-ENV:Body>\r\n" + "</SOAP-ENV:Envelope>";
//		System.out.println(xml);
		Element ResultList = (Element) XmlUtil.parse(xml).get("ResultList");
		List<Element> list = ResultList.elements();
//		System.out.println(ResultList.element("Response").element("PayRecords").element("PayRecord").elementTextTrim("admId"));
		if (ResultList.elements().size() > 0) {
			for (Element element : list) {
//				System.out.println(element.element("PayRecords").getName());
				if ("PayRecords".equals(element.element("PayRecords").getName())) {
					List<Element> list2 = element.element("PayRecords").elements();
					for (Element element2 : list2) {
						System.out.println(element2.elementTextTrim("admId"));
					}
				}
				List<Element> list2 = element.element("PayRecords").elements();
				for (Element element2 : list2) {
					System.out.println(element2.elementTextTrim("admId"));
				}
//				System.out.println("summaryDoctor="+element.elementTextTrim("summaryDoctor"));
//				System.out.println("summaryDate="+element.elementTextTrim("summaryDate"));
//				System.out.println("auditDoctor="+element.elementTextTrim("auditDoctor"));
//				System.out.println("auditDate="+element.elementTextTrim("auditDate"));
//				System.out.println("IllExplain="+element.elementTextTrim("IllExplain"));
//				System.out.println("IllExplainTitle="+element.elementTextTrim("IllExplainTitle"));
//				System.out.println(element.elementTextTrim("peStatus"));
//				System.out.println(element.elementTextTrim("preDate"));
//				System.out.println(element.elementTextTrim("phoneNo"));
//				System.out.println(element.elementTextTrim("levelDesc"));
//				System.out.println(element.elementTextTrim("status"));
//				System.out.println(element.elementTextTrim("payFlag"));
//				System.out.println(element.elementTextTrim("admId"));
//				System.out.println(element.elementTextTrim("preIADM"));
//				System.out.println(element.elementTextTrim("locId"));
//				System.out.println(element.elementTextTrim("locDesc"));
//				System.out.println(element.elementTextTrim("preDateFlag"));
//				System.out.println(element.elementTextTrim("peId"));
//				System.out.println(element.elementTextTrim("canModifyFlag"));
			}
		} else {
			System.out.println("查无数据");
		}

	}

	public static String getReportProjectDetailsByPageNoAndAdmId(Integer PageNo, Long admId) {
		// 查询体检项目细项结果
		List<ReportProjectDetails> details = new ArrayList<ReportProjectDetails>();
		try {
//		String itemXml = hisServiceUtil.getReportProjectDetails(admId.toString(), PageNo.toString());
			String xmlx = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
					+ "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:s=\"http://www.w3.org/2001/XMLSchema\">\r\n"
					+ "  <SOAP-ENV:Body>\r\n" + "    <PublicMethodResponse xmlns=\"http://tempuri.org\">\r\n"
					+ "      <PublicMethodResult><![CDATA[<Response><ResultCode>0</ResultCode><ResultDesc>成功</ResultDesc><ResultList><total>2</total><ExaminationItem><itemDesc>眼科查体</itemDesc><itemId>1320550||6</itemId><reportFormat>RF_NOR</reportFormat><doctorName>曹阳</doctorName><examDate>2019-06-06</examDate><ItemDetailList><ExaminationItemDetail><itemDesc>矫正视力右</itemDesc><itemResult>1.0</itemResult></ExaminationItemDetail><ExaminationItemDetail><itemDesc>矫正视力左</itemDesc><itemResult>1.0</itemResult></ExaminationItemDetail><ExaminationItemDetail><itemDesc>色觉</itemDesc><itemResult>（-）</itemResult></ExaminationItemDetail></ItemDetailList><isFirst>0</isFirst><isLast>0</isLast><stationCode>4</stationCode></ExaminationItem><ExaminationItem><itemDesc>耳鼻喉查体</itemDesc><itemId>1320550||7</itemId><reportFormat>RF_NOR</reportFormat><doctorName>杨昌秀</doctorName><examDate>2019-06-06</examDate><ItemDetailList><ExaminationItemDetail><itemDesc>既往史</itemDesc><itemResult>见问卷</itemResult><referenceRange>见问卷</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>现病史</itemDesc><itemResult>见问卷</itemResult><referenceRange>见问卷</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>耳</itemDesc><itemResult>未见明显异常</itemResult><referenceRange>未见明显异常</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>鼻</itemDesc><itemResult>未见明显异常</itemResult><referenceRange>未见明显异常</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>咽</itemDesc><itemResult>未见明显异常</itemResult><referenceRange>未见明显异常</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>喉</itemDesc><itemResult>未查</itemResult><referenceRange>未查</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>其它</itemDesc><itemResult>无</itemResult><referenceRange>无</referenceRange></ExaminationItemDetail></ItemDetailList><isFirst>0</isFirst><isLast>0</isLast><stationCode>5</stationCode></ExaminationItem><ExaminationItem><itemDesc>JY150.血细胞分析</itemDesc><itemId>1320550||8</itemId><reportFormat>RF_LIS</reportFormat><auditDoctorName>钟宇</auditDoctorName><doctorName>于卉</doctorName><examDate>2019-06-13</examDate><ItemDetailList><ExaminationItemDetail><itemDesc>白细胞数</itemDesc><itemAbbreviation>WBC</itemAbbreviation><itemResult>5.33</itemResult><itemUom>10`9/L</itemUom><referenceRange>3.5-9.5</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>中性粒细胞数</itemDesc><itemAbbreviation>NEU</itemAbbreviation><itemResult>2.16</itemResult><itemUom>10`9/L</itemUom><referenceRange>1.8-6.3</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>淋巴细胞数</itemDesc><itemAbbreviation>LYM</itemAbbreviation><itemResult>2.82</itemResult><itemUom>10`9/L</itemUom><referenceRange>1.1-3.2</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>单核细胞数</itemDesc><itemAbbreviation>MONO</itemAbbreviation><itemResult>0.26</itemResult><itemUom>10`9/L</itemUom><referenceRange>0.1-0.6</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>嗜酸性粒细胞数</itemDesc><itemAbbreviation>EOS</itemAbbreviation><itemResult>0.08</itemResult><itemUom>10`9/L</itemUom><referenceRange>0.02-0.52</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>嗜碱性粒细胞数</itemDesc><itemAbbreviation>BASO</itemAbbreviation><itemResult>0.01</itemResult><itemUom>10`9/L</itemUom><referenceRange>0-0.06</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>中性粒细胞率</itemDesc><itemAbbreviation>NEU-R</itemAbbreviation><itemResult>40.50</itemResult><itemUom>%</itemUom><referenceRange>40-75</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>淋巴细胞率</itemDesc><itemAbbreviation>LYM-R</itemAbbreviation><itemResult>53.00</itemResult><exceptionTip>↑</exceptionTip><itemUom>%</itemUom><referenceRange>20-50</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>单核细胞率</itemDesc><itemAbbreviation>MONO-R</itemAbbreviation><itemResult>4.80</itemResult><itemUom>%</itemUom><referenceRange>3-10</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>嗜酸性粒细胞率</itemDesc><itemAbbreviation>EOS-R</itemAbbreviation><itemResult>1.50</itemResult><itemUom>%</itemUom><referenceRange>0.4-8</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>嗜碱性粒细胞率</itemDesc><itemAbbreviation>BASO-R</itemAbbreviation><itemResult>0.20</itemResult><itemUom>%</itemUom><referenceRange>0-1</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>红细胞数</itemDesc><itemAbbreviation>RBC</itemAbbreviation><itemResult>4.21</itemResult><itemUom>10`12/L</itemUom><referenceRange>3.8-5.1</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>血红蛋白</itemDesc><itemAbbreviation>HGB</itemAbbreviation><itemResult>128</itemResult><itemUom>g/L</itemUom><referenceRange>115-150</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>红细胞压积</itemDesc><itemAbbreviation>HCT</itemAbbreviation><itemResult>0.40</itemResult><referenceRange>0.35-0.45</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>红细胞平均体积</itemDesc><itemAbbreviation>MCV</itemAbbreviation><itemResult>95.00</itemResult><itemUom>fl</itemUom><referenceRange>82-100</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>红细胞平均血红蛋白量</itemDesc><itemAbbreviation>MCH</itemAbbreviation><itemResult>30.30</itemResult><itemUom>pg</itemUom><referenceRange>27-34</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>红细胞平均血红蛋白浓度</itemDesc><itemAbbreviation>MCHC</itemAbbreviation><itemResult>319</itemResult><itemUom>g/L</itemUom><referenceRange>316-354</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>红细胞体积分布宽度标准差</itemDesc><itemAbbreviation>RDW-SD</itemAbbreviation><itemResult>40.20</itemResult><itemUom>fl</itemUom><referenceRange>35-56</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>红细胞体积分布宽度变异系数</itemDesc><itemAbbreviation>RDW-CV</itemAbbreviation><itemResult>12.00</itemResult><itemUom>%</itemUom><referenceRange>11-16</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>血小板数</itemDesc><itemAbbreviation>PLT</itemAbbreviation><itemResult>231</itemResult><itemUom>10`9/L</itemUom><referenceRange>125-350</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>血小板平均体积</itemDesc><itemAbbreviation>MPV</itemAbbreviation><itemResult>8.50</itemResult><exceptionTip>↓</exceptionTip><itemUom>fl</itemUom><referenceRange>9.4-12.5</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>血小板压积</itemDesc><itemAbbreviation>PCT</itemAbbreviation><itemResult>0.20</itemResult><referenceRange>0.10-0.28</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>血小板体积分布宽度</itemDesc><itemAbbreviation>PDW</itemAbbreviation><itemResult>15.70</itemResult><itemUom>%</itemUom><referenceRange>15.1-18.1</referenceRange></ExaminationItemDetail><ExaminationItemDetail><itemDesc>大血小板比例</itemDesc><itemAbbreviation>P-LCR</itemAbbreviation><itemResult>15.60</itemResult><itemUom>%</itemUom><referenceRange>13.0-43.0</referenceRange></ExaminationItemDetail></ItemDetailList><isFirst>0</isFirst><isLast>0</isLast><stationCode>7</stationCode></ExaminationItem></ResultList></Response>]]></PublicMethodResult>\r\n"
					+ "    </PublicMethodResponse>\r\n" + "  </SOAP-ENV:Body>\r\n" + "</SOAP-ENV:Envelope>";
			Map<String, Object> itemMap = XmlUtil.parse(xmlx);
			if (Integer.valueOf(itemMap.get("ResultCode").toString()) != 0) {
				return "系统错误";
			}
			Element itemResultList = (Element) itemMap.get("ResultList");
			@SuppressWarnings("unchecked")
			List<Element> itemlist = itemResultList.elements();
			if (itemResultList.elements().size() > 0) {
				String total = "";
				for (Element element : itemlist) {
					if ("total".equals(element.getName())) {
						total = element.getText();
					}
					if ("ExaminationItem".equals(element.getName())) {
						ReportProjectDetails projectDetails = new ReportProjectDetails();
						projectDetails.setAdmId(admId);
						projectDetails.setTotal(Integer.valueOf(total));
						projectDetails.setItemDesc(element.elementTextTrim("itemDesc"));
						projectDetails.setItemId(element.elementTextTrim("itemId"));
						projectDetails.setReportFormat(element.elementTextTrim("reportFormat"));
						projectDetails.setDoctorName(element.elementTextTrim("doctorName"));
						projectDetails.setExamDate(DateUtil.parseDate(element.elementTextTrim("examDate")));
						StringBuffer buffer = new StringBuffer();
						if ("ItemDetailList".equals(element.element("ItemDetailList").getName())) {
							@SuppressWarnings("unchecked")
							List<Element> ItemDetails = element.element("ItemDetailList").elements();
							for (Element element2 : ItemDetails) {
								buffer.append("##");
								buffer.append(element2.elementTextTrim("itemDesc") + "||");
								buffer.append(element2.elementTextTrim("itemResult") + "||");
								if (!StringUtils.isEmpty(element2.elementTextTrim("imgInfo"))) {
									buffer.append(element2.elementTextTrim("imgInfo") + "||");
								}else {
									buffer.append("无" + "||");
								}
								if (!StringUtils.isEmpty(element2.elementTextTrim("itemUom"))) {
									buffer.append(element2.elementTextTrim("itemUom") + "||");
								}else {
									buffer.append("无" + "||");
								}
								if (!StringUtils.isEmpty(element2.elementTextTrim("referenceRange"))) {
									buffer.append(element2.elementTextTrim("referenceRange") + "||");
								}else {
									buffer.append("无" + "||");
								}
								if (!StringUtils.isEmpty(element2.elementTextTrim("exceptionTip"))) {
									buffer.append(element2.elementTextTrim("exceptionTip") + "||");
								}else {
									buffer.append("无" + "||");
								}
							}
						}
						projectDetails.setExaminationItemdetail(buffer.toString());
						details.add(projectDetails);
					}

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(details);
		return "成功";
	}

	public static void main(String[] args) throws DocumentException {
//		getReportProjectDetailsByPageNoAndAdmId(12, 1L);
		// one();
//		two();
		// three();
//		four();
//		Set<PEItem> items = new HashSet<PEItem>(four());
//		List<PEItem> a = new ArrayList<PEItem>(items);
//		
//		for (PEItem P : items) {
//			System.out.println(P);
//		}
////		for (PEItem peItem : items) {
////			System.err.println(peItem);
////		}
//		List<PEItem> items2 = four();
////		for (PEItem peItem : items2) {
////			System.out.println(peItem);
////		}
//		for (PEItem peItem : a) {
//			items2.remove(peItem);
//		}
//		
////		for (PEItem peItem : items2) {
////			System.out.println(peItem);
////		}
//	
//			System.out.println(items2);

//		five();
//		six();
//		System.out.println("2.2.1.查询历次体检记录=====================================");
//		Seven();
//		System.out.println("2.2.2.查询总检建议=====================================");
//		Eight();
//		System.out.println("2.2.3.查询报告项目细项结果=====================================");
//		nine();
//		Calendar now =Calendar.getInstance();  
//		now.setTime(new Date());
//		List<Object> list = new ArrayList<>();
//		for (int index = 0; index < 30; index++) {
//			now.setTime(new Date());
//			now.set(Calendar.DATE,now.get(Calendar.DATE)+index);
//			list.add(now.get(Calendar.YEAR)+"年");
//			list.add((now.get(Calendar.MONTH)+1)+"月");
//			list.add(now.get(Calendar.DATE)+"日");
//		}
//		now.set(Calendar.DATE,now.get(Calendar.DATE)+11);
//		System.out.println(now.get(Calendar.YEAR));
		// 默认从0-11
//		System.out.println(now.get(Calendar.MONTH)+1);
//		System.out.println(now.get(Calendar.DATE));
//		System.out.println(list);
//		testone();
//		String str = "##白细胞数||5.33||无||10`9/L||3.5-9.5||无||##中性粒细胞数||2.16||无||10`9/L||1.8-6.3||无||##淋巴细胞数||2.82||无||10`9/L||1.1-3.2||无||##单核细胞数||0.26||无||10`9/L||0.1-0.6||无||##嗜酸性粒细胞数||0.08||无||10`9/L||0.02-0.52||无||##嗜碱性粒细胞数||0.01||无||10`9/L||0-0.06||无||##中性粒细胞率||40.50||无||%||40-75||无||##淋巴细胞率||53.00||无||%||20-50||↑||##单核细胞率||4.80||无||%||3-10||无||##嗜酸性粒细胞率||1.50||无||%||0.4-8||无||##嗜碱性粒细胞率||0.20||无||%||0-1||无||##红细胞数||4.21||无||10`12/L||3.8-5.1||无||##血红蛋白||128||无||g/L||115-150||无||##红细胞压积||0.40||无||无||0.35-0.45||无||##红细胞平均体积||95.00||无||fl||82-100||无||##红细胞平均血红蛋白量||30.30||无||pg||27-34||无||##红细胞平均血红蛋白浓度||319||无||g/L||316-354||无||##红细胞体积分布宽度标准差||40.20||无||fl||35-56||无||##红细胞体积分布宽度变异系数||12.00||无||%||11-16||无||##血小板数||231||无||10`9/L||125-350||无||##血小板平均体积||8.50||无||fl||9.4-12.5||↓||##血小板压积||0.20||无||无||0.10-0.28||无||##血小板体积分布宽度||15.70||无||%||15.1-18.1||无||##大血小板比例||15.60||无||%||13.0-43.0||无||";
//		String[] strs = str.split("##");
////		String[] sb = strs[1].split("||");
//		for (String string : strs) {
//			System.out.println(string);
//			String[] sb = string.split("||");
//			
//			for (String string2 : sb) {
//				System.err.println(string2);
//			}
////			System.out.println(sb[0]);
//		}
		
	}

}
