package com.ssm.wechatshop.dao;

import java.util.List;

import com.ssm.wechatshop.entities.School;

public interface SchoolMapper {

	//获取所有学校信息
	public List<School> getAllSchool();
	
	//根据学校获取楼号信息
	public List<School> findBuildBySchool(String school);
	
}
