package com.ssm.wechatshop.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.wechatshop.dao.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-dao.xml" })

public class UserMapperTest {

	@Resource
	private UserMapper userMapper;

	@Test
	public void findById() throws Exception {

		System.out.println("           :::::::::" + userMapper);

		System.out.println(userMapper.findById("”√ªß1").toString());

		System.out.println(userMapper.findById("2"));// null

	}

}