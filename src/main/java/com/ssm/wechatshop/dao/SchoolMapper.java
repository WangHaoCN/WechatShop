package com.ssm.wechatshop.dao;

import java.util.List;

import com.ssm.wechatshop.entities.School;

public interface SchoolMapper {

	//��ȡ����ѧУ��Ϣ
	public List<School> getAllSchool();
	
	//����ѧУ��ȡ¥����Ϣ
	public List<School> findBuildBySchool(String school);
	
}
