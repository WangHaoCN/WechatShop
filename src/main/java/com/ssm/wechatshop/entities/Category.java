package com.ssm.wechatshop.entities;

/**
 * Created by 谢庆贺 on 2017/6/27. 商品分类表
 */
public class Category {
	
	private int cgId;// id自增
	private String cgName;// 分类名称
	private String cgImg;// 分类图片集合（以|分割开）
	private String cgDescribe;// 分类描述
	private Integer sort;// 排序或者权重

	public Integer getCgId() {
		return cgId;
	}

	public void setCgId(Integer cgId) {
		this.cgId = cgId;
	}

	public String getCgName() {
		return cgName;
	}

	public void setCgName(String cgName) {
		this.cgName = cgName;
	}

	public String getCgImg() {
		return cgImg;
	}

	public void setCgImg(String cgImg) {
		this.cgImg = cgImg;
	}

	public String getCgDescribe() {
		return cgDescribe;
	}

	public void setCgDescribe(String cgDescribe) {
		this.cgDescribe = cgDescribe;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Category(Integer cgId, String cgName, String cgImg, String cgDescribe, Integer sort) {
		this.cgId = cgId;
		this.cgName = cgName;
		this.cgImg = cgImg;
		this.cgDescribe = cgDescribe;
		this.sort = sort;
	}

	public Category() {
	}

	@Override
	public String toString() {
		return "Category{" + "cgId=" + cgId + ", cgName='" + cgName + '\'' + ", cgImg='" + cgImg + '\''
				+ ", cgDescribe='" + cgDescribe + '\'' + ", sort=" + sort + '}';
	}
}
