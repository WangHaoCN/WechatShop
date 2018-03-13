package com.ssm.wechatshop.dao;

import com.ssm.wechatshop.entities.Manager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManagerMapper {
	/**
	 * @Description:按照id查找
	 * @param
	 * @return
	 */
	Manager findById(Integer managerid);

	/**
	 * @Description:按照其他条件查询
	 * @param
	 * @return
	 */
	List<Manager> findByType(Manager manager);

	/**
	 * @Description:查看全部
	 * @param
	 * @return
	 */
	List<Manager> findAll();

	/**
	 * @Description:分页查询 offset从第几条开始,开始(offset+1)，查询多少条limit
	 * @param
	 * @return
	 */
	List<Manager> findByPage(@Param("offset") int offset, @Param("limit") int limit);

	/**
	 * @Description:插入
	 * @param
	 * @return
	 */
	int insert(Manager manager);

	/**
	 * @Description:按照id修改
	 * @param
	 * @return
	 */
	int update(Manager manager);

	/**
	 * @Description:按照id删除
	 * @param
	 * @return
	 */
	int delete(Integer managerid);

	/**
	 * @Description:批量删除
	 * @param
	 * @return
	 */
	int deleteBatch(List<Integer> list);

}