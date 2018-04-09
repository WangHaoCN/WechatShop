package com.ssm.wechatshop.dao;

import java.util.List;

import com.ssm.wechatshop.entities.School;

public interface SchoolMapper {

	public List<School> getAllSchool();
	
	public List<School> findBuildBySchool(String school);
	
}
