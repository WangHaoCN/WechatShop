package com.ssm.wechatshop.entities;

/*
 * 商品类
 *修改图片地址合并成一个
 */
public class Ware implements java.io.Serializable {

	// 商品ID
	private int wareId;
	// 商品名
	private String name;
	// 商品描述
	private String describe;
	// 商品价格
	private float price;
	// 商品图集合（以|分割开）
	private String imageUrl;
	// 商品分类
	private String kind;
	// 录入时间
	private String date;
	// 楼长id
	private String managerid;

	// 原价
	private float yuanjia;

	private float count;

	public float getCount() {
		return count;
	}

	public void setCount(float count) {
		this.count = count;
	}

	public float getYuanjia() {
		return yuanjia;
	}

	public void setYuanjia(float yuanjia) {
		this.yuanjia = yuanjia;
	}

	public int getWareId() {
		return wareId;
	}

	public void setWareId(int wareId) {
		this.wareId = wareId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getManagerid() {
		return managerid;
	}

	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}

	@Override
	public String toString() {
		return "Ware [wareId=" + wareId + ", name=" + name + ", describe=" + describe + ", price=" + price
				+ ", imageUrl=" + imageUrl + ", kind=" + kind + ", date=" + date + ", managerid=" + managerid
				+ ", yuanjia=" + yuanjia + ", count=" + count + "]";
	}

}
