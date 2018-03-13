package com.ssm.wechatshop.dao;

import java.util.List;

import com.ssm.wechatshop.entities.Address;
import com.ssm.wechatshop.entities.Manager;
import com.ssm.wechatshop.entities.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AddressMapper {

    /**
     * @Description:按照用户id查找
     * @param
     * @return
     */
    List<Address> findById(String id);
    
    /**
     * @Description:按照地址id查找
     * @param
     * @return
     */
    Address findAddressById(String id);

    /*
     * 通过用户id获取用户的默认地址
     */
    Address getMorenAddressByUserId(String userId);
    
    //通过用户id取消所有moren收货地址
    void quxiaomoren(String userId);
    
    //通过用户id取消所有moren收货地址
    void shezhimoren(String addressid);
    

    /**
     * @Description:按照其他条件查询:比如：用户名，省份，城市，学校，楼号，房间号，收货人姓名（使用and连接）
     * @param
     * @return
     */
    List<Address> findByType(Address address);


    /**
     * @Description:查看全部，按照用户id排列
     * @param
     * @return
     */
    List<Address> findAll();


    /**
     * @Description:分页查询  offset从第几条开始,开始(offset+1)，查询多少条limit  按照用户id排列
     * @param
     * @return
     */
    List<Address> findByPage(@Param("offset") int offset,@Param("limit") int limit);


    /**
     * @Description:插入
     * @param
     * @return
     */
    int insert(Address address);


    /**
     * @Description:按照id修改
     * @param
     * @return
     */
    int update(Address address);


    /**
     * @Description:按照id删除
     * @param
     * @return
     */
    int delete(Integer id);

    /**
     * @Description:按照用户名删除
     * @param
     * @return
     */
    int deleteByOpenId(@Param("openId") String openId);


    /**
     * @Description:批量删除
     * @param
     * @return
     */
    int deleteBatch(List<Integer> list);

}