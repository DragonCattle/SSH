package com.itheima.dao.impl;


import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	/**
	 * 保存用户信息
	 */
	@Override
	public void regist(User user) {
		this.getHibernateTemplate().save(user);
	}
	/**
	 * 查询用户
	 */
	@Override
	public User login(User user) {
		List<User> list=(List<User>) this.getHibernateTemplate().find("from User where user_code=? and user_password=?", 
										user.getUser_code(),user.getUser_password());
		if(list.size()>0) {
			return list.get(0);
		}
		return null;	
	}

}
