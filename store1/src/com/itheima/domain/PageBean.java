package com.itheima.domain;

import java.util.List;

public class PageBean<T> {
	
	//��ǰҳ
	private int currPage;
	//��ҳ��
	private int countPage;
	//�ܼ�¼��
	private int totalPage;
	//ÿҳ��ʾ��������¼ 
	private int pageSize;
	//��ǰҳ�����м�¼
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
