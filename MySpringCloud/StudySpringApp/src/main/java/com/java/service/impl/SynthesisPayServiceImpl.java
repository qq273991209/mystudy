//package com.java.service.impl;
//
//import java.math.BigDecimal;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.java.entity.WechatPublicPayParam;
//import com.java.entity.WechatPublicPayResult;
//import com.java.service.SynthesisPayService;
//import com.java.util.ResultMsg;
//import com.java.wxpay.WXPayConstants.SignType;
//import com.java.wxpay.WXPayUtil;
//import com.java.wxpay.WechatProperties;
//import com.java.wxpay.WechatTradeService;
//
//import lombok.extern.slf4j.Slf4j;
//import tk.mybatis.mapper.util.StringUtil;
//
//@Service
//@Slf4j
//public class SynthesisPayServiceImpl implements SynthesisPayService {
//	@Autowired
//	private WechatTradeService wechatTradeService;
//	
//	@Autowired
//	private WechatProperties wxProperties;
//	
//	@Override
//	public ResultMsg getWechatPublicPayResult(WechatPublicPayParam params) throws Exception {
//		
//		WechatPublicPayResult result = new WechatPublicPayResult();
//
//		/*result.setOrderNumber("prepay_id=ffffffffff");
//		result.setAppId("dasdasd23123");
//		result.setNonceStr("sdfgdgdgfgdf");
//		result.setPaySign("dfsgdsfgdsfgdsfgdfs");
//		result.setSignType("MD5");
//		result.setTimeStamp(Long.toString(System.currentTimeMillis()));*/
////		log.info("本地签名："+wxOrderParem.getPaySign()+"="+nonce_str+"="+time);
////		return new ResultMsg(200, "微信公众平台预支付成功", result);
//
//		// 微信金额单位分 所以要乘以100
//		BigDecimal money =  params.getMoney().multiply(new BigDecimal(100));
//		Map<String, String> map = wechatTradeService.doPublicOrder(params.getOrderType() + params.getOrderId(),
//				String.valueOf(money.longValue()), params.getOrderId().toString(), 
//				params.getUsername() + params.getDealType(), params.getOpenid(), params.getPayType());
//		log.info("微信公众平台预支付返回参数：" + map);
//		if ("SUCCESS".equals(map.get("return_code")) && (StringUtil.isNotEmpty(map.get("result_code")) && "SUCCESS".equals(map.get("result_code"))) ) { // 二次签名 HashMap<String, String>
//			HashMap<String, String> back = new HashMap<String, String>();
//			String time = Long.toString(System.currentTimeMillis());
//			String nonce_str = UUID.randomUUID().toString().replaceAll("-", "");
//			setWxPayMap(nonce_str, map, back, time); // 组装微信下单参数
//			result.setOrderNumber("prepay_id=" + map.get("prepay_id"));
//			result.setAppId(map.get("appid"));
//			result.setNonceStr(nonce_str);
//			result.setPaySign(WXPayUtil.generateSignature(back, wxProperties.getKey(), SignType.MD5));
//			result.setSignType("MD5");
//			result.setTimeStamp(time); //
////			log.info("本地签名：" + result.getPaySign() + "=" + nonce_str + "=" + time);
//			return new ResultMsg(200, "微信公众平台预支付成功", result);
//		}
//
//		return new ResultMsg(201, "微信公众平台预支付失败");
//	}
//
//	@Override
//	public void getWechatPublicBack(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		
//		
//	}
//	
//	/**
//	 * @description: 微信预下单参数赋值
//	 * @param nonceStr 随机数
//	 * @param orderMap 微信预下单返回map
//	 * @param back     二次下单map
//	 * @param time     时间戳
//	 */
//	private void setWxPayMap(String nonceStr, Map<String, String> orderMap, HashMap<String, String> back, String time) {
//		back.put("appId", orderMap.get("appid"));
//		back.put("timeStamp", time);
//		back.put("nonceStr", nonceStr);
//		back.put("package", "prepay_id=" + orderMap.get("prepay_id"));
//		back.put("signType", "MD5");
//	}
//
//}
