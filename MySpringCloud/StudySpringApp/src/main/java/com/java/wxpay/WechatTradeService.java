//package com.java.wxpay;
//
//import java.util.HashMap;
//import java.util.Map;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @Title: WechatTradeService.java
// * @Package com.amt.wechat
// * @Description: TODO(微信支付服务类)
// * @author 江伟
// * @date 2018年12月7日 下午3:36:26 Copyright (c) ©1994-2018 Scjydz.com All Rights
// *       Reserved.
// */
//@Configuration
//public class WechatTradeService {
//
//	@Autowired
//	private WechatProperties wxProperties;
//
//	@Autowired
//	private MiniProgramProperties miniProgramProperties;
//
//	private WXPay wxpay;
//
//	// @Autowired
//	//private IWxPayConfig config;
//
//	@Bean
//	public WXPay getWXPay() throws Exception {
//		wxpay = new WXPay(new IWxPayConfig(wxProperties));
//		return wxpay;
//	}
//
//	// 普通商户版API：https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=7_1
//	// 服务商版API： https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_1
//
//	/**
//	 * @Title: doUnifiedOrder
//	 * @Description: TODO(扫码下单)
//	 * @param out_trade_no 商户订单号
//	 * @param total_fee    金额
//	 * @param productId    商品编号
//	 * @param body         商品描述
//	 * @param payType      支付类型： 1普通商户版 2服务商版
//	 * @return Map<String,String> 返回类型
//	 * @throws Exception
//	 */
//	public Map<String, String> doScanOrder(String out_trade_no, String total_fee, String productId, String body,
//			int payType) throws Exception {
//		// IWxPayConfig config = new IWxPayConfig(wxProperties);
//		// WXPay wxpay = new WXPay(config);
//		HashMap<String, String> data = new HashMap<>();
//		setPayValues(out_trade_no, total_fee, productId, body, payType, data);
//		data.put("trade_type", "NATIVE");// 交易类型 扫码支付
//		Map<String, String> result = wxpay.unifiedOrder(data);
//		return result;
//	}
//
//	/**
//	 * @Title: doPublicOrder
//	 * @Description: TODO(公众平台下单)
//	 * @param out_trade_no 商户订单号
//	 * @param total_fee    金额
//	 * @param productId    商品编号
//	 * @param body         商品描述
//	 * @param openid       用户openid
//	 * @param payType      支付类型： 1普通商户版 2服务商版
//	 * @return Map<String,String> 返回类型
//	 */
//	public Map<String, String> doPublicOrder(String out_trade_no, String total_fee, String productId, String body,
//			String openid, int payType) throws Exception {
//		// IWxPayConfig config = new IWxPayConfig(wxProperties);
//		// WXPay wxpay = new WXPay(config);
//		HashMap<String, String> data = new HashMap<>();
//		setPayValues(out_trade_no, total_fee, productId, body, payType, data);
//		data.put("openid", openid);// 公众号支付必须传入openid
//		data.put("trade_type", "JSAPI");// 交易类型
//		Map<String, String> result = wxpay.unifiedOrder(data);
//		return result;
//	}
//
//	/**
//	 * @description: 小程序下单
//	 * @param out_trade_no 商户订单号
//	 * @param total_fee    金额
//	 * @param productId    商品编号
//	 * @param body         商品描述
//	 * @param openid       用户openid
//	 * @param payType      支付类型： 1普通商户版 2服务商版
//	 * @return 返回类型
//	 * @throws Exception
//	 */
//	public Map<String, String> doMiniProgramOrder(String out_trade_no, String total_fee, String productId, String body,
//			String openid, int payType) throws Exception {
//		HashMap<String, String> data = new HashMap<>();
//		Map<String, String> result = null;
//		switch (payType) {
//		case 1:
//			wxProperties.setAppid(miniProgramProperties.getAppid());
//			// IWxPayConfig config = new IWxPayConfig(wxProperties);
//			// WXPay wxpay = new WXPay(config);
//			setRequestData(out_trade_no, total_fee, productId, body, openid, data);
//			result = wxpay.unifiedOrder(data);
//			break;
//		case 2: // 服务商版 需要再传入子商户信息
//			// IWxPayConfig config2 = new IWxPayConfig(wxProperties);
//			// WXPay wxpay2 = new WXPay(config);
//			setRequestData(out_trade_no, total_fee, productId, body, openid, data);
//			data.put("sub_appid", miniProgramProperties.getAppid());// 当前调起支付的小程序APPID
//			data.put("sub_mch_id", wxProperties.getSubMchId());// 子商户号
//			result = wxpay.unifiedOrder(data);
//			break;
//		default:
//			result = new HashMap<>();
//			result.put("return_code", "FAIL");
//			break;
//		}
//		return result;
//	}
//
//	/**
//	 * @description: 小程序支付请求参数赋值
//	 */
//	private void setRequestData(String out_trade_no, String total_fee, String productId, String body, String openid,
//			HashMap<String, String> data) {
//		toSetDataValues(out_trade_no, total_fee, productId, body, data);
//		data.put("trade_type", "JSAPI");// 交易类型
//		data.put("openid", openid);// 必须传入openid
//	}
//
//	/**
//	 * @description: 扫码和公众号支付请求参数赋值
//	 */
//	private void setPayValues(String out_trade_no, String total_fee, String productId, String body, int payType,
//			HashMap<String, String> data) {
//		toSetDataValues(out_trade_no, total_fee, productId, body, data);
//		switch (payType) {
//		case 1:
//			break;
//		case 2: // 服务商版 需要再传入子商户信息
//			data.put("sub_appid", wxProperties.getSubAppid());// 子商户公众账号
//			data.put("sub_mch_id", wxProperties.getSubMchId());// 子商户号
//			break;
//		default:
//			break;
//		}
//	}
//
//	/**
//	 * @description: 封装支付参数赋值
//	 */
//	private void toSetDataValues(String out_trade_no, String total_fee, String productId, String body,
//			HashMap<String, String> data) {
//		data.put("body", body);// 商品描述
//		data.put("out_trade_no", out_trade_no);// 商户订单号
//		data.put("fee_type", "CNY");// 标价币种 人民币
//		data.put("total_fee", total_fee);// 金额
//		data.put("notify_url", wxProperties.getNotifyUrl());// 回调地址
//		data.put("device_info", wxProperties.getDeviceInfo());// 设备号
//		data.put("product_id", productId);// 商品编号
//		data.put("spbill_create_ip", "123.12.12.123");// 终端ip 微信支付API的机器IP
//	}
//
//	/**
//	 * @description: 微信退款
//	 * @param orderNo     微信订单号
//	 * @param outRefundNo 商户退款单号
//	 * @param refundFee   退款金额
//	 * @param totalFee    订单金额
//	 * @param msg         退款原因
//	 * @param payType     支付类型： 1普通商户版 2服务商版
//	 * @return 退款结果
//	 * @throws Exception
//	 */
//	public Map<String, String> refundOrder(String orderNo, String outRefundNo, String refundFee, String totalFee,
//			String msg, int payType) throws Exception {
//		wxProperties.setAppid(miniProgramProperties.getAppid());
//		// IWxPayConfig config = new IWxPayConfig(wxProperties);
//		// WXPay wxpay = new WXPay(config);
//		HashMap<String, String> data = new HashMap<>();
//		setRefundData(orderNo, outRefundNo, refundFee, totalFee, msg, data);
//		switch (payType) {
//		case 1:
//			break;
//		case 2: // 服务商版 需要再传入子商户信息
//			data.put("sub_appid", wxProperties.getSubAppid());// 子商户公众账号
//			data.put("sub_mch_id", wxProperties.getSubMchId());// 子商户号
//			break;
//		default:
//			break;
//		}
//		Map<String, String> result = wxpay.refund(data);
//		return result;
//	}
//
//	/**
//	 * @description: 小程序退款
//	 * @param orderNo     微信订单号
//	 * @param outRefundNo 商户退款单号
//	 * @param refundFee   退款金额
//	 * @param totalFee    订单金额
//	 * @param msg         退款原因
//	 * @param payType     支付类型： 1普通商户版 2服务商版
//	 * @return 退款结果
//	 * @throws Exception
//	 */
//	public Map<String, String> refundMiniProgramOrder(String orderNo, String outRefundNo, String refundFee,
//			String totalFee, String msg, int payType) throws Exception {
//		HashMap<String, String> data = new HashMap<>();
//		Map<String, String> result = null;
//		switch (payType) {
//		case 1:
//			wxProperties.setAppid(miniProgramProperties.getAppid());
//			// IWxPayConfig config = new IWxPayConfig(wxProperties);
//			// WXPay wxpay = new WXPay(config);
//			setRefundData(orderNo, outRefundNo, refundFee, totalFee, msg, data);
//			result = wxpay.refund(data);
//			break;
//		case 2: // 服务商版 需要再传入子商户信息
//			// IWxPayConfig config2 = new IWxPayConfig(wxProperties);
//			// WXPay wxpay2 = new WXPay(config2);
//			setRefundData(orderNo, outRefundNo, refundFee, totalFee, msg, data);
//			data.put("sub_appid", miniProgramProperties.getAppid());// 当前调起支付的小程序APPID
//			data.put("sub_mch_id", wxProperties.getSubMchId());// 子商户号
//			result = wxpay.refund(data);
//			break;
//		default:
//			result = new HashMap<>();
//			result.put("return_code", "FAIL");
//			break;
//		}
//		return result;
//	}
//
//	/**
//	 * @description: 退款请求参数赋值
//	 */
//	private void setRefundData(String orderNo, String outRefundNo, String refundFee, String totalFee, String msg,
//			HashMap<String, String> data) {
//		data.put("transaction_id", orderNo);// 微信订单号
//		data.put("out_refund_no", outRefundNo);// 商户退款单号
//		data.put("refund_fee", refundFee);// 退款金额
//		data.put("total_fee", totalFee);// 订单金额
//		data.put("refund_fee_type", "CNY");// 退款货币种类
//		data.put("refund_desc", msg);// 退款原因
//	}
//}
