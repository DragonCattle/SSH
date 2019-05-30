package com.itheima.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao{

	@Override
	public void save(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}

	@Override
	public int countPage(DetachedCriteria detachedCriteria) {
		//统计有多少记录数
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list=(List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if(list.size()>0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Customer> findByPage(DetachedCriteria detachedCriteria, int begin, int pageSize) {
		detachedCriteria.setProjection(null);
		List<Customer> list=(List<Customer>) this.getHibernateTemplate().findByCriteria(detachedCriteria,begin,pageSize);
		return list;
	}

	@Override
	public Customer findById(Long cust_id) {
		List<Customer> list=(List<Customer>) this.getHibernateTemplate().find("from Customer where cust_id=?", cust_id);
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void delete(Customer customer) {
		this.getHibernateTemplate().delete(customer);
		
	}
	
	

}
