//package com.java.quartz;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import org.dom4j.Element;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import com.java.entity.ExaminationPackages;
//import com.java.entity.PEItem;
//import com.java.entity.SubscribePackageInspectLinktwo;
//import com.java.mapper.ExaminationPackagesMapper;
//import com.java.mapper.PEItemMapper;
//import com.java.mapper.SubscribePackageInspectLinktwoMapper;
//import com.java.util.HisServiceUtil;
//import com.java.util.XmlUtil;
//
///**
// * 
// * @Title: UpDateHisMedicalExaminationPackage.java 
// * @Package com.java.quartz 
// * @Description: TODO(同步His体检套餐数据：包括检查项+套餐和检查项中间关联关系) 
// * @author 刘云升  
// * @date 2019年6月25日 上午8:58:43 
// * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
// */
//@Component
//public class UpDateHisMedicalExaminationPackage {
//	@Autowired
//	private HisServiceUtil hisServiceUtil;
//	@Autowired
//	private ExaminationPackagesMapper examinationPackagesMapper;
//	@Autowired
//	private PEItemMapper pEItemMapper;
//	@Autowired
//	private SubscribePackageInspectLinktwoMapper subscribePackageInspectLinktwoMapper;
//
//	@Scheduled(cron = "0 00 03 ? * MON")
//	public void execute() {
//		System.out.println("开始数据同步");
//		// 调用His接口查询所有网上体检套餐集合
//
//				// 假数据测试========================
//				String hisXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
//						"<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:s=\"http://www.w3.org/2001/XMLSchema\">\r\n" + 
//						"  <SOAP-ENV:Body>\r\n" + 
//						"    <PublicMethodResponse xmlns=\"http://tempuri.org\">\r\n" + 
//						"      <PublicMethodResult><![CDATA[<Response><ResultCode>0</ResultCode><ResultDesc>成功</ResultDesc><ResultList>"
//						+ "<ExaminationPackages>"
//						+ "<packageId>16</packageId><packageDesc>TJTC016-孕前检查套餐</packageDesc><packageAmt>1740.55</packageAmt><ordSetsId>35732</ordSetsId><levelDesc>普通</levelDesc><levelId>1</levelId><giFlag>个人</giFlag><sexDesc>女</sexDesc><ordSetsType>N</ordSetsType><locId>443</locId><locDesc>健康管理部忠山院区</locDesc>"
//						+ "</ExaminationPackages>"
//						+ "<ExaminationPackages><packageId>17</packageId><packageDesc>TJTC001-基础套餐（女）</packageDesc><packageAmt>1486.98</packageAmt><ordSetsId>35676</ordSetsId><levelDesc>普通</levelDesc><levelId>1</levelId><giFlag>个人</giFlag><sexDesc>女</sexDesc><ordSetsType>N</ordSetsType><locId>443</locId><locDesc>健康管理部忠山院区</locDesc></ExaminationPackages><ExaminationPackages><packageId>18</packageId><packageDesc>TJTC002-全面型套餐（女）</packageDesc><packageAmt>1926.98</packageAmt><ordSetsId>35680</ordSetsId><levelDesc>普通</levelDesc><levelId>1</levelId><giFlag>个人</giFlag><sexDesc>女</sexDesc><ordSetsType>N</ordSetsType><locId>443</locId><locDesc>健康管理部忠山院区</locDesc></ExaminationPackages><ExaminationPackages><packageId>19</packageId><packageDesc>TJTC002-全面型套餐（男）</packageDesc><packageAmt>1708.98</packageAmt><ordSetsId>35678</ordSetsId><levelDesc>普通</levelDesc><levelId>1</levelId><giFlag>个人</giFlag><sexDesc>男</sexDesc><ordSetsType>N</ordSetsType><locId>443</locId><locDesc>健康管理部忠山院区</locDesc></ExaminationPackages></ResultList></Response>]]></PublicMethodResult>\r\n" + 
//						"    </PublicMethodResponse>\r\n" + 
//						"  </SOAP-ENV:Body>\r\n" + 
//						"</SOAP-ENV:Envelope>";
//				try {
//					//调用his查询网上套餐集合接口
////					String hisXml = hisServiceUtil.getPhysicalExaminationXML("", "443", "");
//					//解析xml返回值
//					Map<String, Object> map = XmlUtil.parse(hisXml);
//					//如果返回成功则
//					if (Integer.parseInt(map.get("ResultCode").toString()) == 0) {
//						//查询本地数据库套餐数据
//						List<ExaminationPackages> listInfo = examinationPackagesMapper.selectAll();
//						//获取HIS接口返回节点
//						Element resultList = (Element) map.get("ResultList");
//						List<Element> list = resultList.elements();
//						//调用封装方法
//						List<ExaminationPackages> hisList = getAllExaminationPackages(list);
//						if (listInfo.size() == 0) {//如果数据库没有数据则直接添加
//							for (ExaminationPackages examinationPackages : hisList) {
//								examinationPackagesMapper.insert(examinationPackages);
//							}
//
//						}
//						else if(hisList.size()>listInfo.size()){//如果his的套餐数据新增了则
//							for (int index = 0; index < listInfo.size(); index++) {
//								for (int index2 = 0; index2 <hisList.size(); index2++) {
//									if(hisList.get(index2).getPackageid().equals(listInfo.get(index).getPackageid())) {//找到相同的元素
//										examinationPackagesMapper.updateByPrimaryKeySelective(hisList.get(index2));//更新套餐数据
//										hisList.remove(index2);//移除已更新的数据
//									}
//									
//								}
//							}
//							//添加新增的套餐
//							for (int index = 0; index < hisList.size(); index++) {
//								examinationPackagesMapper.insert(hisList.get(index));
//							}
//						}else if(hisList.size()<listInfo.size()){//如果his删除了套餐数据则
//							for (int index = 0; index < listInfo.size(); index++) {
//								for (int index2 = 0; index2 <hisList.size(); index2++) {
//									if(hisList.get(index2).getPackageid().equals(listInfo.get(index).getPackageid())) {//匹配相同元素
//										examinationPackagesMapper.updateByPrimaryKeySelective(hisList.get(index2));
//										listInfo.remove(index);//移除已经更新的元素
//									}	
//								}
//							}
//							//删除多余的套餐
//							for (int index = 0; index < listInfo.size(); index++) {
//								examinationPackagesMapper.deleteByPrimaryKey(listInfo.get(index).getPackageid());
//									subscribePackageInspectLinktwoMapper.deleteByPackageId(listInfo.get(index).getPackageid().toString());
//							}
//						}else {
//							//数据没有新增和删除则直接更新数据
//							for (ExaminationPackages examinationPackages : hisList) {
//								examinationPackagesMapper.updateByPrimaryKeySelective(examinationPackages);
//							}
//						}
//						Set<PEItem> setItems = new HashSet<PEItem>();
//						List<ExaminationPackages> updatePackages = new ArrayList<ExaminationPackages>();
//						for (ExaminationPackages examinationPackages : hisList) {
//							//调用his接口获取当前套餐的检查项
//							String pEItemXml ="";
//							if(examinationPackages.getOrdsetsid().equals("35680")) {
//								pEItemXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
//										"<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:s=\"http://www.w3.org/2001/XMLSchema\">\r\n" + 
//										"  <SOAP-ENV:Body>\r\n" + 
//										"    <PublicMethodResponse xmlns=\"http://tempuri.org\">\r\n" + 
//										"      <PublicMethodResult><![CDATA[<Response><ResultCode>0</ResultCode><ResultDesc>成功</ResultDesc><ResultList>"
//										+ "<PEItem>"
//										+ "<itemId>16606||1</itemId>"
//										+ "<itemDesc>采血试管(BD)</itemDesc>"
//										+ "<itemPrice>1.57</itemPrice>"
//										+ "<stationId>18</stationId>"
//										+ "<stationDesc>其它项目</stationDesc>"
//										+ "</PEItem>"
//										+ "<PEItem><itemId>16606||1</itemId>"
//										+ "<itemDesc>采血试管(BD)</itemDesc><itemPrice>1.57</itemPrice><stationId>18</stationId><stationDesc>其它项目</stationDesc></PEItem><PEItem><itemId>16606||1</itemId><itemDesc>采血试管(BD)</itemDesc><itemPrice>1.57</itemPrice><stationId>18</stationId><stationDesc>其它项目</stationDesc></PEItem><PEItem><itemId>16606||1</itemId><itemDesc>采血试管(BD)</itemDesc><itemPrice>1.57</itemPrice><stationId>18</stationId><stationDesc>其它项目</stationDesc></PEItem><PEItem><itemId>2648||1</itemId><itemDesc>建立健康档案</itemDesc><itemPrice>4.5</itemPrice><stationId>38</stationId><stationDesc>指引单及早餐</stationDesc></PEItem><PEItem><itemId>17299||1</itemId><itemDesc>一般查体</itemDesc><itemPrice>0</itemPrice><stationId>1</stationId><stationDesc>一般检查+结论</stationDesc></PEItem><PEItem><itemId>6074||1</itemId><itemDesc>H308.体检B女性</itemDesc><itemPrice>108</itemPrice><stationId>7</stationId><stationDesc>检验科</stationDesc><sexId>2</sexId><sexDesc>女</sexDesc></PEItem><PEItem><itemId>5808||1</itemId><itemDesc>JY150.血细胞分析</itemDesc><itemPrice>24.5</itemPrice><stationId>7</stationId><stationDesc>检验科</stationDesc></PEItem><PEItem><itemId>5816||1</itemId><itemDesc>JY160.尿液一般检查</itemDesc><itemPrice>39.3</itemPrice><stationId>7</stationId><stationDesc>检验科</stationDesc></PEItem><PEItem><itemId>18879||1</itemId><itemDesc>TJJY001.体检生化</itemDesc><itemPrice>102.4</itemPrice><stationId>7</stationId><stationDesc>检验科</stationDesc></PEItem><PEItem><itemId>6115||1</itemId><itemDesc>H443.INS 空腹</itemDesc><itemPrice>35</itemPrice><stationId>7</stationId><stationDesc>检验科</stationDesc></PEItem><PEItem><itemId>2366||1</itemId><itemDesc>FBCC101.腹部（肝，胆，胰，脾，双肾）</itemDesc><itemPrice>150</itemPrice><stationId>9</stationId><stationDesc>超声室</stationDesc></PEItem><PEItem><itemId>2369||1</itemId><itemDesc>FBCC104.妇科（子宫、附件及周围组织）</itemDesc><itemPrice>150</itemPrice><stationId>9</stationId><stationDesc>超声室</stationDesc><sexId>2</sexId><sexDesc>女</sexDesc></PEItem><PEItem><itemId>2381||1</itemId><itemDesc>FBCC116.乳腺及引流区淋巴结</itemDesc><itemPrice>102</itemPrice><stationId>9</stationId><stationDesc>超声室</stationDesc></PEItem><PEItem><itemId>2220||1</itemId><itemDesc>CT.胸部平扫1</itemDesc><itemPrice>378</itemPrice><stationId>13</stationId><stationDesc>CT室</stationDesc></PEItem><PEItem><itemId>17284||1</itemId><itemDesc>人体成分分析</itemDesc><itemPrice>80</itemPrice><stationId>22</stationId><stationDesc>营养科</stationDesc></PEItem><PEItem><itemId>10841||1</itemId><itemDesc>XDT19.常规心电图+频谱</itemDesc><itemPrice>71</itemPrice><stationId>10</stationId><stationDesc>心电图</stationDesc></PEItem><PEItem><itemId>17302||1</itemId><itemDesc>妇科查体</itemDesc><itemPrice>0</itemPrice><stationId>4</stationId><stationDesc>妇科</stationDesc><sexId>2</sexId><sexDesc>女</sexDesc></PEItem><PEItem><itemId>7850||1</itemId><itemDesc>XB04.液基细胞学与显微摄影术</itemDesc><itemPrice>288</itemPrice><stationId>12</stationId><stationDesc>病理科</stationDesc><sexId>2</sexId><sexDesc>女</sexDesc></PEItem><PEItem><itemId>18775||1</itemId><itemDesc>体检费</itemDesc><itemPrice>23</itemPrice><stationId>38</stationId><stationDesc>指引单及早餐</stationDesc></PEItem><PEItem><itemId>7761||1</itemId><itemDesc>BL521.HPV检测（低危组+高危组，适用于组织和脱落细胞）</itemDesc><itemPrice>360</itemPrice><stationId>12</stationId><stationDesc>病理科</stationDesc></PEItem><PEItem><itemId>18535||1</itemId><itemDesc>健康管理服务费</itemDesc><itemPrice>0</itemPrice><stationId>18</stationId><stationDesc>其它项目</stationDesc></PEItem></ResultList></Response>]]></PublicMethodResult>\r\n" + 
//										"    </PublicMethodResponse>\r\n" + 
//										"  </SOAP-ENV:Body>\r\n" + 
//										"</SOAP-ENV:Envelope>";
//							}
//							if(examinationPackages.getOrdsetsid().equals("35732")) {
//								pEItemXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
//										"<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:s=\"http://www.w3.org/2001/XMLSchema\">\r\n" + 
//										"  <SOAP-ENV:Body>\r\n" + 
//										"    <PublicMethodResponse xmlns=\"http://tempuri.org\">\r\n" + 
//										"      <PublicMethodResult><![CDATA[<Response><ResultCode>0</ResultCode><ResultDesc>成功</ResultDesc><ResultList><PEItem><itemId>16606||1</itemId><itemDesc>采血试管(BD)</itemDesc><itemPrice>1.57</itemPrice><stationId>18</stationId><stationDesc>其它项目</stationDesc></PEItem><PEItem><itemId>16606||1</itemId><itemDesc>采血试管(BD)</itemDesc><itemPrice>1.57</itemPrice><stationId>18</stationId><stationDesc>其它项目</stationDesc></PEItem><PEItem><itemId>16606||1</itemId><itemDesc>采血试管(BD)</itemDesc><itemPrice>1.57</itemPrice><stationId>18</stationId><stationDesc>其它项目</stationDesc></PEItem><PEItem><itemId>16606||1</itemId><itemDesc>采血试管(BD)</itemDesc><itemPrice>1.57</itemPrice><stationId>18</stationId><stationDesc>其它项目</stationDesc></PEItem><PEItem><itemId>16606||1</itemId><itemDesc>采血试管(BD)</itemDesc><itemPrice>1.57</itemPrice><stationId>18</stationId><stationDesc>其它项目</stationDesc></PEItem><PEItem><itemId>2648||1</itemId><itemDesc>建立健康档案</itemDesc><itemPrice>4.5</itemPrice><stationId>38</stationId><stationDesc>指引单及早餐</stationDesc></PEItem><PEItem><itemId>17299||1</itemId><itemDesc>一般查体</itemDesc><itemPrice>0</itemPrice><stationId>1</stationId><stationDesc>一般检查+结论</stationDesc></PEItem><PEItem><itemId>5808||1</itemId><itemDesc>JY150.血细胞分析</itemDesc><itemPrice>24.5</itemPrice><stationId>7</stationId><stationDesc>检验科</stationDesc></PEItem><PEItem><itemId>5816||1</itemId><itemDesc>JY160.尿液一般检查</itemDesc><itemPrice>39.3</itemPrice><stationId>7</stationId><stationDesc>检验科</stationDesc></PEItem><PEItem><itemId>18879||1</itemId><itemDesc>TJJY001.体检生化</itemDesc><itemPrice>102.4</itemPrice><stationId>7</stationId><stationDesc>检验科</stationDesc></PEItem><PEItem><itemId>6060||1</itemId><itemDesc>H107.甲功3项</itemDesc><itemPrice>84</itemPrice><stationId>7</stationId><stationDesc>检验科</stationDesc></PEItem><PEItem><itemId>6146||1</itemId><itemDesc>输血前检查(输血传播疾病+血型血清学)</itemDesc><itemPrice>366</itemPrice><stationId>7</stationId><stationDesc>检验科</stationDesc></PEItem><PEItem><itemId>2366||1</itemId><itemDesc>FBCC101.腹部（肝，胆，胰，脾，双肾）</itemDesc><itemPrice>150</itemPrice><stationId>9</stationId><stationDesc>超声室</stationDesc></PEItem><PEItem><itemId>2369||1</itemId><itemDesc>FBCC104.妇科（子宫、附件及周围组织）</itemDesc><itemPrice>150</itemPrice><stationId>9</stationId><stationDesc>超声室</stationDesc><sexId>2</sexId><sexDesc>女</sexDesc></PEItem><PEItem><itemId>10841||1</itemId><itemDesc>XDT19.常规心电图+频谱</itemDesc><itemPrice>71</itemPrice><stationId>10</stationId><stationDesc>心电图</stationDesc></PEItem><PEItem><itemId>17302||1</itemId><itemDesc>妇科查体</itemDesc><itemPrice>0</itemPrice><stationId>4</stationId><stationDesc>妇科</stationDesc><sexId>2</sexId><sexDesc>女</sexDesc></PEItem><PEItem><itemId>5822||1</itemId><itemDesc>JY166.阴道分泌物联合检查</itemDesc><itemPrice>66</itemPrice><stationId>7</stationId><stationDesc>检验科</stationDesc><sexId>2</sexId><sexDesc>女</sexDesc></PEItem><PEItem><itemId>7850||1</itemId><itemDesc>XB04.液基细胞学与显微摄影术</itemDesc><itemPrice>288</itemPrice><stationId>12</stationId><stationDesc>病理科</stationDesc><sexId>2</sexId><sexDesc>女</sexDesc></PEItem><PEItem><itemId>18775||1</itemId><itemDesc>体检费</itemDesc><itemPrice>23</itemPrice><stationId>38</stationId><stationDesc>指引单及早餐</stationDesc></PEItem><PEItem><itemId>5945||1</itemId><itemDesc>JY506.淋+支+衣PCR</itemDesc><itemPrice>174</itemPrice><stationId>7</stationId><stationDesc>检验科</stationDesc></PEItem><PEItem><itemId>19302||1</itemId><itemDesc>JY307.TORCH4项定量检测</itemDesc><itemPrice>185</itemPrice><stationId>7</stationId><stationDesc>检验科</stationDesc></PEItem><PEItem><itemId>18535||1</itemId><itemDesc>健康管理服务费</itemDesc><itemPrice>0</itemPrice><stationId>18</stationId><stationDesc>其它项目</stationDesc></PEItem></ResultList></Response>]]></PublicMethodResult>\r\n" + 
//										"    </PublicMethodResponse>\r\n" + 
//										"  </SOAP-ENV:Body>\r\n" + 
//										"</SOAP-ENV:Envelope>";
//							}
//							if(examinationPackages.getOrdsetsid().equals("35676")) {
//								pEItemXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
//										"<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:s=\"http://www.w3.org/2001/XMLSchema\">\r\n" + 
//										"  <SOAP-ENV:Body>\r\n" + 
//										"    <PublicMethodResponse xmlns=\"http://tempuri.org\">\r\n" + 
//										"      <PublicMethodResult><![CDATA[<Response><ResultCode>0</ResultCode><ResultDesc>成功</ResultDesc><ResultList><PEItem><itemId>16606||1</itemId><itemDesc>采血试管(BD)</itemDesc><itemPrice>1.57</itemPrice><stationId>18</stationId><stationDesc>其它项目</stationDesc></PEItem><PEItem><itemId>16606||1</itemId><itemDesc>采血试管(BD)</itemDesc><itemPrice>1.57</itemPrice><stationId>18</stationId><stationDesc>其它项目</stationDesc></PEItem><PEItem><itemId>16606||1</itemId><itemDesc>采血试管(BD)</itemDesc><itemPrice>1.57</itemPrice><stationId>18</stationId><stationDesc>其它项目</stationDesc></PEItem><PEItem><itemId>16606||1</itemId><itemDesc>采血试管(BD)</itemDesc><itemPrice>1.57</itemPrice><stationId>18</stationId><stationDesc>其它项目</stationDesc></PEItem><PEItem><itemId>2648||1</itemId><itemDesc>建立健康档案</itemDesc><itemPrice>4.5</itemPrice><stationId>38</stationId><stationDesc>指引单及早餐</stationDesc></PEItem><PEItem><itemId>17299||1</itemId><itemDesc>一般查体</itemDesc><itemPrice>0</itemPrice><stationId>1</stationId><stationDesc>一般检查+结论</stationDesc></PEItem><PEItem><itemId>6074||1</itemId><itemDesc>H308.体检B女性</itemDesc><itemPrice>108</itemPrice><stationId>7</stationId><stationDesc>检验科</stationDesc><sexId>2</sexId><sexDesc>女</sexDesc></PEItem><PEItem><itemId>5808||1</itemId><itemDesc>JY150.血细胞分析</itemDesc><itemPrice>24.5</itemPrice><stationId>7</stationId><stationDesc>检验科</stationDesc></PEItem><PEItem><itemId>5816||1</itemId><itemDesc>JY160.尿液一般检查</itemDesc><itemPrice>39.3</itemPrice><stationId>7</stationId><stationDesc>检验科</stationDesc></PEItem><PEItem><itemId>18879||1</itemId><itemDesc>TJJY001.体检生化</itemDesc><itemPrice>102.4</itemPrice><stationId>7</stationId><stationDesc>检验科</stationDesc></PEItem><PEItem><itemId>6115||1</itemId><itemDesc>H443.INS 空腹</itemDesc><itemPrice>35</itemPrice><stationId>7</stationId><stationDesc>检验科</stationDesc></PEItem><PEItem><itemId>2366||1</itemId><itemDesc>FBCC101.腹部（肝，胆，胰，脾，双肾）</itemDesc><itemPrice>150</itemPrice><stationId>9</stationId><stationDesc>超声室</stationDesc></PEItem><PEItem><itemId>2369||1</itemId><itemDesc>FBCC104.妇科（子宫、附件及周围组织）</itemDesc><itemPrice>150</itemPrice><stationId>9</stationId><stationDesc>超声室</stationDesc><sexId>2</sexId><sexDesc>女</sexDesc></PEItem><PEItem><itemId>2381||1</itemId><itemDesc>FBCC116.乳腺及引流区淋巴结</itemDesc><itemPrice>102</itemPrice><stationId>9</stationId><stationDesc>超声室</stationDesc></PEItem><PEItem><itemId>2220||1</itemId><itemDesc>CT.胸部平扫1</itemDesc><itemPrice>378</itemPrice><stationId>13</stationId><stationDesc>CT室</stationDesc></PEItem><PEItem><itemId>10841||1</itemId><itemDesc>XDT19.常规心电图+频谱</itemDesc><itemPrice>71</itemPrice><stationId>10</stationId><stationDesc>心电图</stationDesc></PEItem><PEItem><itemId>17302||1</itemId><itemDesc>妇科查体</itemDesc><itemPrice>0</itemPrice><stationId>4</stationId><stationDesc>妇科</stationDesc><sexId>2</sexId><sexDesc>女</sexDesc></PEItem><PEItem><itemId>7850||1</itemId><itemDesc>XB04.液基细胞学与显微摄影术</itemDesc><itemPrice>288</itemPrice><stationId>12</stationId><stationDesc>病理科</stationDesc><sexId>2</sexId><sexDesc>女</sexDesc></PEItem><PEItem><itemId>18775||1</itemId><itemDesc>体检费</itemDesc><itemPrice>23</itemPrice><stationId>38</stationId><stationDesc>指引单及早餐</stationDesc></PEItem><PEItem><itemId>18535||1</itemId><itemDesc>健康管理服务费</itemDesc><itemPrice>0</itemPrice><stationId>18</stationId><stationDesc>其它项目</stationDesc></PEItem></ResultList></Response>]]></PublicMethodResult>\r\n" + 
//										"    </PublicMethodResponse>\r\n" + 
//										"  </SOAP-ENV:Body>\r\n" + 
//										"</SOAP-ENV:Envelope>";
//							}
//							if(examinationPackages.getOrdsetsid().equals("35678")) {
//								pEItemXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
//										"<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:s=\"http://www.w3.org/2001/XMLSchema\">\r\n" + 
//										"  <SOAP-ENV:Body>\r\n" + 
//										"    <PublicMethodResponse xmlns=\"http://tempuri.org\">\r\n" + 
//										"      <PublicMethodResult><![CDATA[<Response><ResultCode>0</ResultCode><ResultDesc>成功</ResultDesc><ResultList><PEItem><itemId>16606||1</itemId><itemDesc>采血试管(BD)</itemDesc><itemPrice>1.57</itemPrice><stationId>18</stationId><stationDesc>其它项目</stationDesc></PEItem><PEItem><itemId>16606||1</itemId><itemDesc>采血试管(BD)</itemDesc><itemPrice>1.57</itemPrice><stationId>18</stationId><stationDesc>其它项目</stationDesc></PEItem><PEItem><itemId>16606||1</itemId><itemDesc>采血试管(BD)</itemDesc><itemPrice>1.57</itemPrice><stationId>18</stationId><stationDesc>其它项目</stationDesc></PEItem><PEItem><itemId>16606||1</itemId><itemDesc>采血试管(BD)</itemDesc><itemPrice>1.57</itemPrice><stationId>18</stationId><stationDesc>其它项目</stationDesc></PEItem><PEItem><itemId>2648||1</itemId><itemDesc>建立健康档案</itemDesc><itemPrice>4.5</itemPrice><stationId>38</stationId><stationDesc>指引单及早餐</stationDesc></PEItem><PEItem><itemId>17299||1</itemId><itemDesc>一般查体</itemDesc><itemPrice>0</itemPrice><stationId>1</stationId><stationDesc>一般检查+结论</stationDesc></PEItem><PEItem><itemId>6073||1</itemId><itemDesc>H307.体检A男性</itemDesc><itemPrice>119</itemPrice><stationId>7</stationId><stationDesc>检验科</stationDesc><sexId>1</sexId><sexDesc>男</sexDesc></PEItem><PEItem><itemId>5808||1</itemId><itemDesc>JY150.血细胞分析</itemDesc><itemPrice>24.5</itemPrice><stationId>7</stationId><stationDesc>检验科</stationDesc></PEItem><PEItem><itemId>5816||1</itemId><itemDesc>JY160.尿液一般检查</itemDesc><itemPrice>39.3</itemPrice><stationId>7</stationId><stationDesc>检验科</stationDesc></PEItem><PEItem><itemId>18879||1</itemId><itemDesc>TJJY001.体检生化</itemDesc><itemPrice>102.4</itemPrice><stationId>7</stationId><stationDesc>检验科</stationDesc></PEItem><PEItem><itemId>6115||1</itemId><itemDesc>H443.INS 空腹</itemDesc><itemPrice>35</itemPrice><stationId>7</stationId><stationDesc>检验科</stationDesc></PEItem><PEItem><itemId>17537||1</itemId><itemDesc>13碳尿素呼气试验</itemDesc><itemPrice>180</itemPrice><stationId>40</stationId><stationDesc>C13</stationDesc></PEItem><PEItem><itemId>2366||1</itemId><itemDesc>FBCC101.腹部（肝，胆，胰，脾，双肾）</itemDesc><itemPrice>150</itemPrice><stationId>9</stationId><stationDesc>超声室</stationDesc></PEItem><PEItem><itemId>2367||1</itemId><itemDesc>FBCC102.男性泌尿系（双肾、输尿管、膀胱、前列腺）</itemDesc><itemPrice>150</itemPrice><stationId>9</stationId><stationDesc>超声室</stationDesc><sexId>1</sexId><sexDesc>男</sexDesc></PEItem><PEItem><itemId>2380||1</itemId><itemDesc>FBCC115.甲状腺及颈部淋巴结</itemDesc><itemPrice>102</itemPrice><stationId>9</stationId><stationDesc>超声室</stationDesc></PEItem><PEItem><itemId>2189||1</itemId><itemDesc>CT.头颅横轴位平扫</itemDesc><itemPrice>225</itemPrice><stationId>13</stationId><stationDesc>CT室</stationDesc></PEItem><PEItem><itemId>2220||1</itemId><itemDesc>CT.胸部平扫1</itemDesc><itemPrice>378</itemPrice><stationId>13</stationId><stationDesc>CT室</stationDesc></PEItem><PEItem><itemId>17284||1</itemId><itemDesc>人体成分分析</itemDesc><itemPrice>80</itemPrice><stationId>22</stationId><stationDesc>营养科</stationDesc></PEItem><PEItem><itemId>10841||1</itemId><itemDesc>XDT19.常规心电图+频谱</itemDesc><itemPrice>71</itemPrice><stationId>10</stationId><stationDesc>心电图</stationDesc></PEItem><PEItem><itemId>18775||1</itemId><itemDesc>体检费</itemDesc><itemPrice>23</itemPrice><stationId>38</stationId><stationDesc>指引单及早餐</stationDesc></PEItem><PEItem><itemId>17539||1</itemId><itemDesc>裂隙灯检查</itemDesc><itemPrice>14</itemPrice><stationId>5</stationId><stationDesc>眼科</stationDesc></PEItem><PEItem><itemId>18535||1</itemId><itemDesc>健康管理服务费</itemDesc><itemPrice>0</itemPrice><stationId>18</stationId><stationDesc>其它项目</stationDesc></PEItem></ResultList></Response>]]></PublicMethodResult>\r\n" + 
//										"    </PublicMethodResponse>\r\n" + 
//										"  </SOAP-ENV:Body>\r\n" + 
//										"</SOAP-ENV:Envelope>";
//							}
////							pEItemXml = hisServiceUtil.getHisPackageDetailsXML(examinationPackages.getOrdsetsid());
//							//System.out.println(pEItemXml);
//							//这里解析数据同上
//							Map<String, Object> pEItemMap = XmlUtil.parse(pEItemXml);
//							if (Integer.parseInt(pEItemMap.get("ResultCode").toString()) == 0) {
//								Element resultPEList = (Element) pEItemMap.get("ResultList");
//								List<Element> PEListst = resultPEList.elements();
//								//获取当前套餐的检查项集合
//								List<PEItem> itemList = getAllpEItems(PEListst);
//								ExaminationPackages packageinfo = new ExaminationPackages();
//								packageinfo.setPeitems(itemList);
//								packageinfo.setPackageid(examinationPackages.getPackageid());
//								updatePackages.add(packageinfo);
//								for (PEItem pm : itemList) {
//									setItems.add(pm);
//								}
//							}
//						}
//						
//						List<PEItem> allItems =  pEItemMapper.selectAll();//查询所有检查项数据
//						if(allItems.size()==0) {
//							for (PEItem pm : setItems) {
//								pEItemMapper.insertSelective(pm);//新增检查项
//							}
//							for (int index = 0; index < updatePackages.size(); index++) {
//								for (PEItem pm : updatePackages.get(index).getPeitems()) {
//									SubscribePackageInspectLinktwo record = new SubscribePackageInspectLinktwo();
//									record.setInspectId(pm.getItemid());
//									record.setPackageId(updatePackages.get(index).getPackageid().toString());
//									subscribePackageInspectLinktwoMapper.insertSelective(record);//新增检查项和套餐中间关系
//								}
//							}
//						}else {//说明数据库有检查项数据
//							 if(allItems.size()<setItems.size()) {
//									for (PEItem peItem : allItems) {
//										setItems.remove(peItem);//移除重复检查项
//									}
//								
//								for (PEItem peItem : setItems) {
//									pEItemMapper.insertSelective(peItem);//新增检查项
//								}
//							}else {
//								for (PEItem peItem : setItems) {
//									pEItemMapper.updateByPrimaryKeySelective(peItem);//更新检查项
//								}
//							}
//							for (ExaminationPackages examinationPackages2 : updatePackages) {
//								List<PEItem> items = pEItemMapper.selectAllItemidBypackageId(examinationPackages2.getPackageid());
//								System.err.println(items.size());
//								if(items.size()>examinationPackages2.getPeitems().size()) {//说明his那边删除了某些检查项
//									for (PEItem peItem : examinationPackages2.getPeitems()) {
//										items.remove(peItem);
//									}
//									for (PEItem peItem : items) {
//										subscribePackageInspectLinktwoMapper.deleteByPrimaryKey(peItem.getInspectLink());//删除检查项和套餐中间关系
//									}
//								}else if(items.size()<examinationPackages2.getPeitems().size()) {//说明his那边增加了检查项
//									for (PEItem peItem : items) {
//										examinationPackages2.getPeitems().remove(peItem);
//									}
//									for (PEItem peItem : examinationPackages2.getPeitems()) {
//										SubscribePackageInspectLinktwo record = new SubscribePackageInspectLinktwo();
//										record.setInspectId(peItem.getItemid());
//										record.setPackageId(examinationPackages2.getPackageid().toString());
//										subscribePackageInspectLinktwoMapper.insertSelective(record);//添加检查项和套餐中间关系
//									}
//									
//								}else if(items.size()==0){//新增关联关系
//									for (PEItem peItem : examinationPackages2.getPeitems()) {
//										SubscribePackageInspectLinktwo record = new SubscribePackageInspectLinktwo();
//										record.setInspectId(peItem.getItemid());
//										record.setPackageId(examinationPackages2.getPackageid().toString());
//										subscribePackageInspectLinktwoMapper.insertSelective(record);//添加检查项和套餐中间关系
//									}
//								}
//							}
//						}
//					}
//
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				System.out.println("数据已同步");
//	}
//
//	/**
//	 * 
//	 * @description: 封装体检套餐集合
//	 * @param list 节点元素集合
//	 * @return 体检套餐集合
//	 */
//	private List<ExaminationPackages> getAllExaminationPackages(List<Element> list) {
//		List<ExaminationPackages> Packages = new ArrayList<ExaminationPackages>();
//		for (Element element : list) {
//			ExaminationPackages examinationPackages = new ExaminationPackages();
//			examinationPackages.setPackageid(Long.valueOf(element.elementTextTrim("packageId")));
//			examinationPackages.setPackagedesc(element.elementTextTrim("packageDesc"));
//			examinationPackages.setPackageamt(new BigDecimal(element.elementTextTrim("packageAmt")));
//			examinationPackages.setOrdsetsid(element.elementTextTrim("ordSetsId"));
//			examinationPackages.setLeveldesc(element.elementTextTrim("levelDesc"));
//			examinationPackages.setLevelid(element.elementTextTrim("levelId"));
//			examinationPackages.setGiflag(element.elementTextTrim("giFlag"));
//			examinationPackages.setSexdesc(element.elementTextTrim("sexDesc"));
//			examinationPackages.setOrdsetstype(element.elementTextTrim("ordSetsType"));
//			examinationPackages.setLocid(element.elementTextTrim("locId"));
//			examinationPackages.setLocdesc(element.elementTextTrim("locDesc"));
//			Packages.add(examinationPackages);
//		}
//		return Packages;
//	}
//
//	/**
//	 * 
//	 * @description: 封装检查项集合
//	 * @param list 节点元素集合
//	 * @return 检查项集合
//	 */
//	private List<PEItem> getAllpEItems(List<Element> list) {
//		List<PEItem> items = new ArrayList<PEItem>();
//		for (Element element : list) {
//			PEItem pEItem = new PEItem();
//			pEItem.setItemid(element.elementTextTrim("itemId"));
//			pEItem.setItemdesc(element.elementTextTrim("itemDesc"));
//			pEItem.setStationid(element.elementTextTrim("stationId"));
//			pEItem.setStationdesc(element.elementTextTrim("stationDesc"));
//			pEItem.setSexid(element.elementTextTrim("sexId"));
//			pEItem.setSexdesc(element.elementTextTrim("sexDesc"));
//			pEItem.setItemprice(new BigDecimal(element.elementTextTrim("itemPrice")));
//			items.add(pEItem);
//		}
//		return items;
//	}
//}
