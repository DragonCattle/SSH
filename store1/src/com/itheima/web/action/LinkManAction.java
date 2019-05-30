package com.itheima.web.action;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import com.itheima.domain.Customer;
import com.itheima.domain.LinkMan;
import com.itheima.domain.PageBean;
import com.itheima.service.LinkManService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{

	private LinkMan linkMan=new LinkMan();
	@Override
	public LinkMan getModel() {
		
		return linkMan;
	}
	
	private LinkManService linkManService;

	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}

	//ʹ������ע�룺set�����ķ�ʽ��������
	private Integer currPage=1;

	public void setCurrPage(Integer currPage) {
		if(currPage==null) {
			currPage=1;
		}
		this.currPage = currPage;
	}

	public String findAll() {
		System.out.println("��������");
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(LinkMan.class);
		//����ҵ���ѯ
		PageBean<LinkMan> pageBane=linkManService.findAll(detachedCriteria,currPage);
	    
		//�Ž�ֵջ
		ActionContext.getContext().getValueStack().push(pageBane);
		return "findAll";
	}
}
