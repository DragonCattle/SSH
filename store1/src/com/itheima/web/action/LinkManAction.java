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

	//使用属性注入：set方法的方式接收数据
	private Integer currPage=1;

	public void setCurrPage(Integer currPage) {
		if(currPage==null) {
			currPage=1;
		}
		this.currPage = currPage;
	}

	public String findAll() {
		System.out.println("请求来了");
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(LinkMan.class);
		//调用业务查询
		PageBean<LinkMan> pageBane=linkManService.findAll(detachedCriteria,currPage);
	    
		//放进值栈
		ActionContext.getContext().getValueStack().push(pageBane);
		return "findAll";
	}
}
