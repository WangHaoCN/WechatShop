package com.ssm.wechatshop.dao;

import java.util.List;

import com.ssm.wechatshop.entities.Indent;

public interface IndentMapper {

	//根据用户名查询订单
	public List<Indent> getIndentByUserId(String userid);
	
	
	
}