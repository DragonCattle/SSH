package com.itheima.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.OpenSessionInViewFilter;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
import com.itheima.domain.PageBean;
import com.itheima.service.CustomerService;
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void save(Customer customer) {
		customerDao.save(customer);
		
	}

	@Override
	public PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer currPage) {
		PageBean<Customer> pageBean=new PageBean<>();
		//���õ�ǰҳ����ʾ3����¼
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		//���õ�ǰҳ
		pageBean.setCurrPage(currPage);
		//��ѯ�ܼ�¼��
		int totalPage=customerDao.countPage(detachedCriteria);
		System.out.println("totalPage:"+totalPage);
		pageBean.setTotalPage(totalPage);
		//�����ҳ��
		int countPage=totalPage%3==0?totalPage/pageSize:totalPage/pageSize+1;
		System.out.println("countPage:"+countPage);
		pageBean.setCountPage(countPage);
		
		int begin=(currPage-1)*pageSize;
	
		List<Customer> list=customerDao.findByPage(detachedCriteria,begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public Customer findById(Long cust_id) {
		Customer customer=customerDao.findById(cust_id);
		return customer;
	}

	@Override
	public void delete(Customer customer) {
		customerDao.delete(customer);
		
	}
	

}
