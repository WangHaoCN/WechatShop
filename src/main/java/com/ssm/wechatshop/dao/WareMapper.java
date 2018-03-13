package com.ssm.wechatshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.wechatshop.entities.User;
import com.ssm.wechatshop.entities.Ware;

public interface WareMapper {

	/**
	 * @Description:按照id查找
	 * @param
	 * @return
	 */
	Ware findById(int openid);

	/**
	 * @Description:按照其他条件查询
	 * @param
	 * @return
	 */
	List<Ware> findByType(Ware ware);

	/**
	 * @Description:查看全部
	 * @param
	 * @return
	 */
	List<Ware> findAll();

	/**
	 * @Description:分页查询 offset从第几条开始,开始(offset+1)，查询多少条limit
	 * @param
	 * @return
	 */
	List<Ware> findByPage(@Param("offset") int offset, @Param("limit") int limit);

	/**
	 * @Description:条件查询
	 * @author 王浩
	 * @param String kind
	 * @return List<Ware>
	 */
	List<Ware> findByKind(@Param("kind") String kind);
	
	/**
	 * @Description:条件查询
	 * @author 王浩
	 * @param String kind
	 * @return List<Ware>
	 */
	List<Ware> findByName(@Param("val") String val);
	
	/**
	 * @Description:条件查询
	 * @author 王浩
	 * @param String kind
	 * @return List<Ware>
	 */
	List<Ware> findQita(String str1,String str2);

}