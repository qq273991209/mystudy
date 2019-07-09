package com.java.util;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSONObject;

/**
 * @Title: JosnMenuTreeUtil.java
 * @Package com.amt.util
 * @Description: 递归获取Josn数据ID和Name
 * @author lys
 * @date 2019年5月15日 上午11:30:12 Copyright (c) ©1994-2019 Scjydz.com All Rights
 *       Reserved.
 */
public class JosnMenuTreeUtil {
	// 用于保存id和name拼接值
	public Map<String, StringBuffer> mapArr = new LinkedHashMap<String, StringBuffer>();
	// 用于拼接id格式为（id,id2,id3,id4,）
	public StringBuffer id = new StringBuffer();
	// 用于拼接name格式为（name1,name2,name3,name4,）
	public StringBuffer name = new StringBuffer();

	/**
	 * @description: 解析json树数据将所有的id和name已Map格式返回
	 * @param menu     Json List集合
	 * @param jsonId       json的Id字段
	 * @param jsonName     json的name字段
	 * @param jsonChildren json的children字段
	 * @return Map<id,name> 已id和name打包返回
	 */
	@SuppressWarnings("rawtypes")
	public Map<String, StringBuffer> menuList(List menu, String jsonId, String jsonName, String jsonChildren) {
		for (int index = 0; index < menu.size(); index++) {
			id.append(JSONObject.parseObject(menu.get(index).toString()).getString(jsonId) + ",");
			name.append(JSONObject.parseObject(menu.get(index).toString()).getString(jsonName) + ",");
			List myListTwo = JSONObject.parseObject(menu.get(index).toString()).getObject(jsonChildren, List.class);
			menuChild(myListTwo, jsonId, jsonName, jsonChildren);
		}
		mapArr.put("id", id);
		mapArr.put("name", name);
		return mapArr;
	}

	/**
	 * 
	 * @description: 解析json树数据将所有的id和name递归拼接直到List为null
	 * @param List     Json List集合
	 * @param jsonId       json的Id字段
	 * @param jsonName     json的name字段
	 * @param jsonChildren json的children字段
	 */
	@SuppressWarnings("rawtypes")
	public void menuChild(List list, String jsonId, String jsonName, String jsonChildren) {
		List myListTwo = null;
		for (int index = 0; index < list.size(); index++) {
			id.append(JSONObject.parseObject(list.get(index).toString()).getString(jsonId) + ",");
			name.append(JSONObject.parseObject(list.get(index).toString()).getString(jsonName) + ",");
			myListTwo = JSONObject.parseObject(list.get(index).toString()).getObject(jsonChildren, List.class);
			if (myListTwo != null) {
				menuChild(myListTwo, jsonId, jsonName, jsonChildren);
			}
		}
	}

	/**
	 * 
	 * @description: main方法测试
	 * @param args
	 */
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		JosnMenuTreeUtil util = new JosnMenuTreeUtil();
		String json = "{\"roleName\":\"\",\"roleSign\":[{\"id\":38,\"name\":\"体检用户\",\"pid\":0,\"children\":[{\"id\":46,\"name\":\"体检账号\",\"pid\":38,\"children\":[{\"id\":81,\"name\":\"体检详情\",\"pid\":46,\"children\":[]}]},{\"id\":82,\"name\":\"体检预约人\",\"pid\":38,\"children\":[]}]},{\"id\":39,\"name\":\"体检套餐\",\"pid\":0,\"children\":[{\"id\":78,\"name\":\"套餐管理\",\"pid\":39,\"children\":[]},{\"id\":86,\"name\":\"体检项管理\",\"pid\":39,\"children\":[]}]}],\"remark\":\"\"}";
		JSONObject pa = JSONObject.parseObject(json);
		List myList = pa.getObject("roleSign", List.class);
		Map<String, StringBuffer> map = util.menuList(myList, "id", "name", "children");
		System.out.println(map.get("id"));
		System.out.println(map.get("name"));
	}

}
