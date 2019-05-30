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
		//����ҵ���
		User exitUser=userService.login(user);
		
		if(exitUser==null) {
			//��ҳ�����������Ϣ
			this.addActionError("����˻������������󣡣�");
			return LOGIN;
		}
		//���û���Ϣ�����session
		ServletActionContext.getRequest().getSession().setAttribute("existUser", exitUser);
		return SUCCESS;
	}
}
