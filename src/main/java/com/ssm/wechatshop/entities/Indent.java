package com.ssm.wechatshop.entities;

import java.util.List;

/*
 * 订单类
 *
 */
public class Indent {
    //订单编号
    private int id;
    //商品序列
    private String warelist;
    //订单总价
    private float price;
    //楼长编号
    private int buildingNo;
	//订单发起人
    private int userId;
    //交易状态(待支付   已完成)
    private String status;
    //录入时间
    private String time;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getWarelist() {
		return warelist;
	}
	public void setWarelist(String warelist) {
		this.warelist = warelist;
	}
	public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public int getBuildingNo() {
    	return buildingNo;
    }
    public void setBuildingNo(int buildingNo) {
    	this.buildingNo = buildingNo;
    }

}
