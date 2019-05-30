package com.itheima.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.domain.Customer;

public interface CustomerDao {

	void save(Customer customer);

	int countPage(DetachedCriteria detachedCriteria);

	List<Customer> findByPage(DetachedCriteria detachedCriteria, int begin, int pageSize);

	Customer findById(Long cust_id);

	void delete(Customer customer);


}
