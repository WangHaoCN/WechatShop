package com.ssm.wechatshop.dao;

import java.util.List;

//分页Bean
public class PageBean<T> {
	private int currPage;// 当前页数
	private int pageSize;// 每页显示多少条记录
	private int totle;// 总记录
	private int totlePage;// 总页数
	private List<T> list;// 显示数据的集合

	public int getCurrPage() {
		return currPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getTotle() {
		return totle;
	}

	public int getTotlePage() {
		return totlePage;
	}

	public List<T> getList() {
		return list;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotle(int totle) {
		this.totle = totle;
	}

	public void setTotlePage(int totlePage) {
		this.totlePage = totlePage;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "PageBean [currPage=" + currPage + ", pageSize=" + pageSize + ", totle=" + totle + ", totlePage="
				+ totlePage + ", list=" + list + "]";
	}

}
