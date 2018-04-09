package com.ssm.wechatshop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.wechatshop.entities.Address;
import com.ssm.wechatshop.entities.Indent;
import com.ssm.wechatshop.entities.User;
import com.ssm.wechatshop.entities.Ware;
import com.ssm.wechatshop.service.UserService;

/*
 * @author 王浩
 * 用于用户权限的页面跳转
 * 简单逻辑处理
 */
@Controller
@RequestMapping("/user")
public class UserPagerController {

	@Autowired
	private UserService userService;

	// 用户
	@RequestMapping("/usermessage.action")
	public String userMessage() {

		return "/user/usermessage";
	}
	
	@RequestMapping("addressUpdate.action")
	public ModelAndView addressUpdate(Map<String, Object> map,@Param("id")String id){
		//通过id获取地址
		System.out.println("       "+id+"       ");
		Address address = new Address();
		if(userService.getAddressById(id)!=null)
			address = userService.getAddressById(id);
		map.put("address", address);
		return new ModelAndView("user/address",map);
	}

	// 用户收货信息管理
	@RequestMapping("/addressManager.action")
	public ModelAndView userAddress(Map<String, Object> map, HttpSession session) {
		List<Address> address = new ArrayList<Address>();
		if (session.getAttribute("user") != null) {
			User user = (User) session.getAttribute("user");
			address = userService.getAddress(user.getOpenId());
		}
		map.put("address", address);
		return new ModelAndView("/user/userAddress", map);
	}

	// 订单页面
	@RequestMapping("/userIndent.action")
	public ModelAndView userDingdan(Map<String, Object> map, HttpSession session) {
		// 获取所有订单信息
		User user = new User();
		List<Indent> indents = new ArrayList<Indent>();
		if (session.getAttribute("user") != null) {
			user = (User) session.getAttribute("user");
			indents = userService.getIndentByUser(user.getOpenId());
		}
		// 根据用户查询订单，存入map

		return new ModelAndView("/user/userdingdan", map);
	}

	// 收货地址页面
	@RequestMapping("/address.action")
	public String addressPage() {

		return "/user/address";
	}

	// 商城主页
	@RequestMapping("/index.action")
	public ModelAndView userindex(HttpSession session, HttpServletResponse response) {
		// 主页面主要显示20条商品信息，获取登陆信息存入数据库
		Map<String, List<Ware>> goods = new HashMap<String, List<Ware>>();
		List<Ware> wares = userService.getWare20();
		goods.put("wares", wares);
		/*
		 * 获取微信登陆的信息存入数据库,用户登录的session为user，进行权限控制
		 */
		User user = new User();
		session.setAttribute("user", user);
		// 模拟user信息
		user.setCity("泰安");
		user.setCountry("中国");
		user.setNickname("与我常在");
		user.setOpenId("a1053");
		user.setSex(1);

		/*
		 * 创建购物车session 键WareGwc，值List<Ware>
		 */
		List<Ware> WareGwc = new ArrayList<Ware>();
		if (session.getAttribute("WareGwc") == null)
			session.setAttribute("WareGwc", WareGwc);
		return new ModelAndView("/user/index", goods);
	}

	/*
	 * 微信支付接入
	 */

	// 提交订单页面
	@RequestMapping("/TijiaoDingdan.action")
	public String tijiaodingdan(@Param("price") float price, HttpSession session) {
		List<Ware> wares = (List<Ware>) session.getAttribute("WareGwc");
		float sessionPrice = 0;
		if (wares != null)
			for (Ware ware : wares) {
				sessionPrice += ((float) ware.getCount()) * ware.getPrice();
			}
		// 两次价格一致，进入付款页面
		if (price == sessionPrice)
			;
		return "";
	}

	// 确认订单页面
	@SuppressWarnings("unchecked")
	@RequestMapping("/confirmDingdan.action")
	public ModelAndView confirmDingdan(HttpSession session, Map<String, Object> map) {
		// 计算总价
		List<Ware> wares = (List<Ware>) session.getAttribute("WareGwc");
		float price = 0;
		if (wares != null)
			for (Ware ware : wares) {
				price += ((float) ware.getCount()) * ware.getPrice();
			}
		// 价格
		map.put("price", price);
		// 商品
		map.put("wares", (List<Ware>) session.getAttribute("WareGwc"));

		return new ModelAndView("user/confirmDingdan", map);
	}

	// 商品详情
	@RequestMapping("/xiangxixinxi.action")
	public ModelAndView userdetail(@Param("id") int id, Map<String, Object> map) {
		/*
		 * 通过id查询出商品 存入map中
		 */
		Ware ware = new Ware();
		ware = userService.findWareById(id);
		map.put("ware", ware);

		return new ModelAndView("/user/detail", map);
	}

	// 用户主页
	@RequestMapping("/userindex.action")
	public String bodyindex() {

		return "/user/userindex";
	}

	// 所有商品页面
	@RequestMapping("/usermoregoods.action")
	public ModelAndView moregoods(@Param("leixing") String leixing, Map<String, Object> map) {
		/*
		 * 查询所有商品，存入map
		 */
		List<Ware> allwares = userService.getWareAll();
		map.put("allwares", allwares);

		return new ModelAndView("/user/moregoods", map);
	}

	// 所有零食页面
	@RequestMapping("/userlingshi.action")
	public ModelAndView morelingshi(@Param("leixing") String leixing, Map<String, Object> map) {
		/*
		 * 查询所有商品，存入map
		 */
		leixing = "零食";

		List<Ware> allwares = new ArrayList<Ware>();
		if (userService.getWareLingshi(leixing) != null)
			allwares = userService.getWareLingshi(leixing);
		map.put("wares", allwares);

		return new ModelAndView("/user/userlingshi", map);
	}

	// 所有水果页面
	@RequestMapping("/usershuiguo.action")
	public ModelAndView moreShuiguo(@Param("leixing") String leixing, Map<String, Object> map) {
		/*
		 * 查询所有商品，存入map
		 */
		leixing = "水果";
		List<Ware> allwares = userService.getWareLingshi(leixing);
		map.put("allwares", allwares);

		return new ModelAndView("/user/usershuiguo", map);
	}

	// 商品查询
	@RequestMapping("/search.action")
	public ModelAndView searchware(@Param("val") String val, Map<String, Object> map) {
		List<Ware> wares = new ArrayList<Ware>();
		if (!(val == null || "".equals(val.toString()) || val.length() == 0))
			wares = userService.searchWare(val);
		map.put("allwares", wares);
		return new ModelAndView("/user/moregoods", map);
	}

	// 商品加入购物车 ajax
	@RequestMapping("/gwc.action")
	public void jiarugwc(@Param("wareId") int wareId, HttpServletResponse response, HttpSession session)
			throws IOException {
		PrintWriter out = response.getWriter();
		Ware ware = userService.findWareById(wareId);
		@SuppressWarnings("unchecked")
		List<Ware> wares = (List<Ware>) session.getAttribute("WareGwc");
		ware.setCount(1);
		if (wares.size() == 0) {
			wares.add(ware);
		} else
			for (int i = 0; i < wares.size(); i++) {
				if (ware.getWareId() == wares.get(i).getWareId()) {
					ware.setCount(wares.get(i).getCount());
					wares.remove(i);
					wares.add(ware);
				} else {
					wares.add(ware);
				}
			}
		session.setAttribute("WareGwc", wares);
		out.print("1");
	}

	// 购物车
	@SuppressWarnings("unchecked")
	@RequestMapping("/usergwc.action")
	public ModelAndView usergwc(HttpSession session, Map<String, Object> map) {
		List<Ware> wares = new ArrayList<Ware>();
		if (session.getAttribute("WareGwc") != null) {
			wares = (List<Ware>) session.getAttribute("WareGwc");
		}
		map.put("userGwc", wares);
		return new ModelAndView("/user/usergwc", map);
	}

	// 所有其他
	@RequestMapping("/userqita.action")
	public ModelAndView userqita(Map<String, Object> map) throws UnsupportedEncodingException {
		/*
		 * 获取所有其他商品信息，存入map
		 */
		List<Ware> wares = new ArrayList<Ware>();

		// String str1 = "零食";
		// String str2 = "水果";
		// str1 = new String(str1.getBytes("gbk"),"utf-8");
		// str2 = new String(str2.getBytes("gbk"),"utf-8");
		wares = userService.getWareAll();
		if (wares.size() > 0)
			for (int i = wares.size() - 1; i >= 0; i--)
				if (wares.get(i).getKind().equals("零食") || wares.get(i).getKind().equals("水果"))
					wares.remove(i);
		map.put("wares", wares);
		return new ModelAndView("/user/userqita", map);
	}

	// 个人主页
	@RequestMapping("/usermain.action")
	public String usermain() {

		return "/user/usermain";
	}

}
