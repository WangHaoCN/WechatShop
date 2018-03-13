package com.ssm.wechatshop.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.wechatshop.entities.Address;
import com.ssm.wechatshop.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	//收货地址管理页面
	public ModelAndView addressPage(Map<String, Object> map){
		//根据用户的id查询收货地址
		
		return new ModelAndView("/user/",map);
	}
	//收货地址提交
	
	@RequestMapping("/addressUpload.action")
	public ModelAndView addressUpload(Address address,HttpSession session){
		System.out.println(address);
		userService.addressInsert(address);
		session.setAttribute("address", address);
		System.out.println("插入成功");
		return new ModelAndView("redirect:/user/index.action");
	}
	
}
