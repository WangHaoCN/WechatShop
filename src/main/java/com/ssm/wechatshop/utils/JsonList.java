package com.ssm.wechatshop.utils;

import java.util.List;

import com.ssm.wechatshop.entities.Ware;

import net.sf.json.JSONArray;

public class JsonList {

	
	//List×ªjson
	public static String toJson(List<Ware> list) {
		JSONArray jsonArray = JSONArray.fromObject(list);
		String str = jsonArray.toString();
		return str;
	}

	//json×ª»»list
	public static List<Ware> toList(String jsonStr) {
		JSONArray jsonArray = JSONArray.fromObject(jsonStr);
		@SuppressWarnings("unchecked")
		List<Ware> list = (List<Ware>) JSONArray.toCollection(jsonArray, Ware.class);
		return list;
	}

}
