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
	
	public Address getMorenAddressByUserid(String userId){
		Address address = new Address();
		address = addressMapper.getMorenAddressByUserId(userId);
		
		return address;
	}
	
	public void quxiaomoren(String userid){
		addressMapper.quxiaomoren(userid);
	}

	public void shezhimoren(String addressid){
		addressMapper.shezhimoren(addressid);
	}
	
	public Address getAddressById(String id){
		return addressMapper.findAddressById(id);
	}
	
	
	public List<Ware> getWareqita(String str1,String str2){
		List<Ware> wares = new ArrayList<Ware>();
		wares = wareMapper.findQita(str1,str2);
		return wares;
	}

	public List<Address> getAddress(String userId){
		List<Address> address = new ArrayList<Address>();
		if(addressMapper.findById(userId)!=null)
			address = (List<Address>) addressMapper.findById(userId);
		return address;
	}
	
	public User findUserById(String id) {
		User user = new User();
		user = userMapper.findById(id);
		return user;
	}

	public List<Indent> getIndentByUser(String userid) {
		List<Indent> indents = new ArrayList<Indent>();
		if (indentMapper.getIndentByUserId(userid) != null)
			indents = indentMapper.getIndentByUserId(userid);

		return indents;
	}

	public List<School> getAllSchool() {
		List<School> schools = new ArrayList<School>();
		schools = schoolMapper.getAllSchool();
		return schools;
	}

	public List<School> getBuildBySchool(String school) {
		List<School> schools = new ArrayList<School>();
		schools = schoolMapper.findBuildBySchool(school);
		return schools;
	}

	public Ware findWareById(int id) {
		Ware ware = new Ware();
		ware = wareMapper.findById(id);
		return ware;
	}

	public List<Ware> getWare20() {
		List<Ware> wares = new ArrayList<Ware>();
		int count = 0;

		wares = wareMapper.findByPage(0, 20);
		System.out.println(wares.size());
		Ware ware = wares.get(0);
		System.out.println(wares);

		return wares;

	}

	public List<Ware> getWareAll() {
		List<Ware> wares = new ArrayList<Ware>();
		wares = wareMapper.findAll();
		System.out.println("��Ʒ����  ��  " + wares.size());
		return wares;
	}

	public List<Ware> getWareLingshi(String lingshi) {
		List<Ware> waresLingshi = new ArrayList<Ware>();
		waresLingshi = wareMapper.findByKind(lingshi);
		return waresLingshi;
	}

	public List<Ware> getWareShuiguo(String shuiguo) {
		List<Ware> waresLingshi = new ArrayList<Ware>();
		waresLingshi = wareMapper.findByKind(shuiguo);
		return waresLingshi;
	}

	public List<Ware> searchWare(String val) {
		List<Ware> waresLingshi = new ArrayList<Ware>();
		waresLingshi = wareMapper.findByName(val);
		return waresLingshi;
	}
	
	public List<Ware> searchQita(){
		List<Ware> waresLingshi = new ArrayList<Ware>();
		// ��ȡ�ܵļ�¼����
		waresLingshi = wareMapper.findByName("");
		return waresLingshi;
	}
 
	// �ջ���ַ����
	public void addressInsert(Address address) {
		addressMapper.insert(address);
	}

}
