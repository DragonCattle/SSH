package com.itheima.web.action;

import org.apache.struts2.ServletActionContext;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	private User user=new User();

	public User getUser() {
		return user;
	}
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Override
	public User getModel() {
		
		return user;
	}
	public String regist() {
		System.out.println(user);
		userService.regist(user);
		return LOGIN;
	}
	
	public String login() {
		//调用业务层
		User exitUser=userService.login(user);
		
		if(exitUser==null) {
			//向页面输出错误信息
			this.addActionError("你的账户或者密码有误！！");
			return LOGIN;
		}
		//将用户信息存放在session
		ServletActionContext.getRequest().getSession().setAttribute("existUser", exitUser);
		return SUCCESS;
	}
}
