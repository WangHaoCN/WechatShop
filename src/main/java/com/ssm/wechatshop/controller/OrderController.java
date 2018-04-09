package com.ssm.wechatshop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.wechatshop.entities.Address;
import com.ssm.wechatshop.entities.School;
import com.ssm.wechatshop.entities.User;
import com.ssm.wechatshop.entities.Ware;
import com.ssm.wechatshop.service.UserService;

@Controller
@RequestMapping("/user")
public class OrderController {

	@Autowired
	private UserService userService;

	@SuppressWarnings("unchecked")
	@RequestMapping("/zongjia.action")
	public void zongjia(@Param("wareId") Integer wareId, @Param("kind") Integer kind, HttpSession session,
			HttpServletResponse response, @Param("count") Integer count) throws IOException {
		PrintWriter out = response.getWriter();
		List<Ware> WareGwc = new ArrayList<Ware>();
		if (session.getAttribute("WareGwc") != null) {
			WareGwc = (List<Ware>) session.getAttribute("WareGwc");
		}
		Ware ware = new Ware();
		for (int i = 0; i < WareGwc.size(); i++) {
			if (WareGwc.get(i).getWareId() == wareId) {
				ware = WareGwc.get(i);
				WareGwc.remove(i);
				if (kind == 1 && count != -1) {
					ware.setCount(count);
				} else if (kind == 2 && count != -1) {
					if (ware.getCount() > 0)
						ware.setCount(count);
				}
				WareGwc.add(ware);
			}
		}

		for (int i = 0; i < WareGwc.size() - 2; i++)
			for (int j = i + 1; j < WareGwc.size(); j++)
				if (WareGwc.get(i).getWareId() == WareGwc.get(j).getWareId())
					WareGwc.remove(j);
		session.setAttribute("WareGwc", WareGwc);
		double price = 0;
		for (int i = 0; i < WareGwc.size(); i++) {
			price += ((float) WareGwc.get(i).getCount()) * WareGwc.get(i).getPrice();
		}
		out.print(price);
	}

	@RequestMapping("/morendizhi.action")
	public void morenshouhuo(HttpSession session, HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");

		User user = new User();
		if (session.getAttribute("user") != null)
			user = (User) session.getAttribute("user");
		Address address = new Address();
		address = userService.getMorenAddressByUserid(user.getOpenId());
		if (address != null)
			out.print(address.getMoren());

	}

	@RequestMapping("/xuanzhong.action")
	public void xuanzhong(@Param("id") String id, HttpSession session, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		Address address = new Address();

		if (session.getAttribute("user") != null) {
			userService.quxiaomoren(((User) (session.getAttribute("user"))).getOpenId());
			userService.shezhimoren(id);
		}

		address = userService.getAddressById(id);
		session.setAttribute("address", address);
		if (address != null)
			out.print(address.getId());
	}

	@RequestMapping("/school.action")
	public void schoolBuilding(HttpServletResponse response, HttpServletRequest request) throws IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");

		out.write("<option value=''>-- ��ѡ��ѧУ��Ϣ����� --</option>");

		List<School> schools = userService.getAllSchool();
		for (int i = 0; i < schools.size(); i++)
			out.write("<option value='" + schools.get(i).getSchool() + "'>" + schools.get(i).getSchool() + "</option>");
	}

	@RequestMapping("/schoolBuilding.action")
	public void getSchoolBuilding(@Param("build") String build, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		List<School> schools = userService.getBuildBySchool(build);
		for (int i = 0; i < schools.size(); i++)
			out.write("<option value='" + schools.get(i).getBuilding() + "'>" + schools.get(i).getBuilding()
					+ "</option>");
	}

}
