package com.ssm.wechatshop.entities;

import javax.persistence.Entity;

/*
 * @author wanghao
 * @param
 *
 * 更改openid字段为String
 */
@Entity
public class Address {
    // 主键 唯一标识
    private int id;
    // 对应用户id
    private String openId;
    // 省份
    private String province;
    // 城市
    private String city;
    // 学校
    private String school;
    // 楼号
    private String buildingNo;
    // 房间号
    private String roomNo;
    // 收货人姓名
    private String name;
    // 收货人电话
    private String phone;
    //是否为默认收货地址  0为非默认，1为默认
    private int moren;

    public int getMoren() {
		return moren;
	}

	public void setMoren(int moren) {
		this.moren = moren;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Address [id=" + id + ", openId=" + openId + ", province=" + province + ", city=" + city + ", school="
                + school + ", buildingNo=" + buildingNo + ", roomNo=" + roomNo + ", name=" + name + ", phone=" + phone
                + "]";
    }

    public Address(int id, String openId, String province, String city, String school, String buildingNo, String roomNo, String name, String phone) {
        this.id = id;
        this.openId = openId;
        this.province = province;
        this.city = city;
        this.school = school;
        this.buildingNo = buildingNo;
        this.roomNo = roomNo;
        this.name = name;
        this.phone = phone;
    }
    public Address(){}

}
