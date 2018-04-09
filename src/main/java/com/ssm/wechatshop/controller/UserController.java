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
	
	public ModelAndView addressPage(Map<String, Object> map){
		
		return new ModelAndView("/user/",map);
	}
	
	@RequestMapping("/addressUpload.action")
	public ModelAndView addressUpload(Address address,HttpSession session){
		System.out.println(address);
		userService.addressInsert(address);
		session.setAttribute("address", address);
		System.out.println("����ɹ�");
		return new ModelAndView("redirect:/user/index.action");
	}
	
}
