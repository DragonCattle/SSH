package com.itheima.domain;

import java.util.List;

public class PageBean<T> {
	
	//当前页
	private int currPage;
	//总页数
	private int countPage;
	//总记录数
	private int totalPage;
	//每页显示多少条记录 
	private int pageSize;
	//当前页的所有记录
	private List<T> list;
	
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getCountPage() {
		return countPage;
	}
	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageBean [currPage=" + currPage + ", countPage=" + countPage + ", totalPage=" + totalPage
				+ ", pageSize=" + pageSize + ", list=" + list + "]";
	}

	
	
}
