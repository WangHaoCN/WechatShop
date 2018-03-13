package com.ssm.wechatshop.entities;

public class Manager {

	// 唯一标识 楼长编号
	private int managerId;
	// 楼长姓名
	private String name;
	// 密码
	private String password;
	// 楼号
	private String buildingNo;
	// 学校(精确到校区)
	private String school;
	// 电话
	private String phone;
	// 身份证号
	private String idNumber;

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBuildingNo() {
		return buildingNo;
	}

	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", name=" + name + ", password=" + password + ", buildingNo="
				+ buildingNo + ", school=" + school + ", phone=" + phone + ", idNumber=" + idNumber + "]";
	}

	public Manager(int managerId, String name, String password, String buildingNo, String school, String phone,
			String idNumber) {
		this.managerId = managerId;
		this.name = name;
		this.password = password;
		this.buildingNo = buildingNo;
		this.school = school;
		this.phone = phone;
		this.idNumber = idNumber;
	}

	public Manager() {
	}
}
