package com.ssm.wechatshop.entities;

import java.util.List;

/*
 * 购物车
 *
 */
public class ShoppingCart {

	// 购物车ID
	private int cartId;
	// 商品序列
	private List<Ware> warelists;
	// 购物车总价
	private float price;
	// 交易状态
	private int status;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public List<Ware> getWarelists() {
		return warelists;
	}

	public void setWarelists(List<Ware> warelists) {
		this.warelists = warelists;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ShoppingCart [cartId=" + cartId + ", warelists=" + warelists + ", price=" + price + ", status=" + status
				+ "]";
	}

}
