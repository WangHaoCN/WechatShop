package com.ssm.wechatshop.dao;

import java.util.List;

import com.ssm.wechatshop.entities.Indent;

public interface IndentMapper {

	//�����û�����ѯ����
	public List<Indent> getIndentByUserId(String userid);
	
	
	
}