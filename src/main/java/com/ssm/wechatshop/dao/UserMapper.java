package com.ssm.wechatshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.wechatshop.entities.User;

public interface UserMapper {
	/**
	 * @Description:按照id查找
	 * @param
	 * @return
	 */
	User findById(String openid);

	/**
	 * @Description:按照其他条件查询
	 * @param
	 * @return
	 */
	List<User> findByType(User user);

	/**
	 * @Description:查看全部
	 * @param
	 * @return
	 */
	List<User> findAll();

	/**
	 * @Description:分页查询 offset从第几条开始,开始(offset+1)，查询多少条limit
	 * @param
	 * @return
	 */
	List<User> findByPage(@Param("offset") int offset, @Param("limit") int limit);

	/**
	 * @Description:插入
	 * @param
	 * @return
	 */
	int insert(User user);

	/**
	 * @Description:按照id修改
	 * @param
	 * @return
	 */
	int update(User user);

	/**
	 * @Description:按照id删除
	 * @param
	 * @return
	 */
	int delete(String openid);

	/**
	 * @Description:批量删除
	 * @param
	 * @return
	 */
	int deleteBatch(List<String> list);

}