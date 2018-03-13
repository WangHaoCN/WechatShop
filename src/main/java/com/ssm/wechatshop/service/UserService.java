package com.ssm.wechatshop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.wechatshop.dao.AddressMapper;
import com.ssm.wechatshop.dao.IndentMapper;
import com.ssm.wechatshop.dao.SchoolMapper;
import com.ssm.wechatshop.dao.UserMapper;
import com.ssm.wechatshop.dao.WareMapper;
import com.ssm.wechatshop.entities.Address;
import com.ssm.wechatshop.entities.Indent;
import com.ssm.wechatshop.entities.School;
import com.ssm.wechatshop.entities.User;
import com.ssm.wechatshop.entities.Ware;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private WareMapper wareMapper;

	@Autowired
	private SchoolMapper schoolMapper;

	@Autowired
	private AddressMapper addressMapper;

	@Autowired
	private IndentMapper indentMapper;
	
	//获取用户的默认收货地址
	public Address getMorenAddressByUserid(String userId){
		Address address = new Address();
		address = addressMapper.getMorenAddressByUserId(userId);
		
		return address;
	}
	
	//通过用户id取消所有默认收货地址
	public void quxiaomoren(String userid){
		addressMapper.quxiaomoren(userid);
	}
	//通过AddressId设置默认地址
	public void shezhimoren(String addressid){
		addressMapper.shezhimoren(addressid);
	}
	
	//通过id获取收货地址
	public Address getAddressById(String id){
		Address address = new Address();
		address = addressMapper.findAddressById(id);
		System.out.println(address);
		return address;
	}
	
	
	//所有其他商品
	public List<Ware> getWareqita(String str1,String str2){
		List<Ware> wares = new ArrayList<Ware>();
		wares = wareMapper.findQita(str1,str2);
		return wares;
	}
	
	//查询收货地址
	public List<Address> getAddress(String userId){
		List<Address> address = new ArrayList<>();
		if(addressMapper.findById(userId)!=null)
			address = (List<Address>) addressMapper.findById(userId);
		return address;
	}
	
	// 通过id查询用户
	public User findUserById(String id) {
		User user = new User();
		user = userMapper.findById(id);
		return user;
	}

	// 查询用户的订单信息
	public List<Indent> getIndentByUser(String userid) {
		List<Indent> indents = new ArrayList<>();
		if (indentMapper.getIndentByUserId(userid) != null)
			indents = indentMapper.getIndentByUserId(userid);

		return indents;
	}

	// 查询学校信息
	public List<School> getAllSchool() {
		List<School> schools = new ArrayList<School>();
		schools = schoolMapper.getAllSchool();
		return schools;
	}

	// 根据学校名查询楼号
	public List<School> getBuildBySchool(String school) {
		List<School> schools = new ArrayList<School>();
		schools = schoolMapper.findBuildBySchool(school);
		return schools;
	}

	// 通过id查询商品
	public Ware findWareById(int id) {
		Ware ware = new Ware();
		ware = wareMapper.findById(id);
		return ware;
	}

	// 获取商品的前20条记录
	public List<Ware> getWare20() {
		List<Ware> wares = new ArrayList<>();
		// 获取总的记录条数
		int count = 0;

		wares = wareMapper.findByPage(0, 20);
		System.out.println(wares.size());
		Ware ware = wares.get(0);
		System.out.println(wares);

		return wares;

	}

	// 获取商品的前所有记录
	public List<Ware> getWareAll() {
		List<Ware> wares = new ArrayList<>();
		// 获取总的记录条数
		wares = wareMapper.findAll();
		System.out.println("商品总数  ：  " + wares.size());
		return wares;
	}

	// 获取所有零食
	public List<Ware> getWareLingshi(String lingshi) {
		List<Ware> waresLingshi = new ArrayList<>();
		// 获取总的记录条数
		waresLingshi = wareMapper.findByKind(lingshi);
		return waresLingshi;
	}

	// 获取所有水果
	public List<Ware> getWareShuiguo(String shuiguo) {
		List<Ware> waresLingshi = new ArrayList<>();
		// 获取总的记录条数
		waresLingshi = wareMapper.findByKind(shuiguo);
		return waresLingshi;
	}

	// 查询商品
	public List<Ware> searchWare(String val) {
		List<Ware> waresLingshi = new ArrayList<>();
		// 获取总的记录条数
		waresLingshi = wareMapper.findByName(val);
		return waresLingshi;
	}
	
	public List<Ware> searchQita(){
		List<Ware> waresLingshi = new ArrayList<>();
		// 获取总的记录条数
		waresLingshi = wareMapper.findByName("");
		return waresLingshi;
	}
 
	// 收货地址插入
	public void addressInsert(Address address) {
		addressMapper.insert(address);
	}

}
