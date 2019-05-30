package com.itheima.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.LinkManDao;
import com.itheima.domain.Customer;
import com.itheima.domain.LinkMan;
import com.itheima.domain.PageBean;
import com.itheima.service.LinkManService;
@Transactional
public class LinkManServiceImpl implements LinkManService{
	
	private LinkManDao linkManDao;

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}

	@Override
	public PageBean<LinkMan> findAll(DetachedCriteria detachedCriteria, Integer currPage) {
		PageBean<LinkMan> pageBean=new PageBean<LinkMan>();
		//���õ�ǰҳ����ʾ3����¼
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		//���õ�ǰҳ
		pageBean.setCurrPage(currPage);
		//��ѯ�ܼ�¼��
		int totalPage=linkManDao.countPage(detachedCriteria);
		//System.out.println("totalPage:"+totalPage);
		pageBean.setTotalPage(totalPage);
		//�����ҳ��
		int countPage=totalPage%3==0?totalPage/pageSize:totalPage/pageSize+1;
		System.out.println("countPage:"+countPage);
		pageBean.setCountPage(countPage);
		
		int begin=(currPage-1)*pageSize;
	
		List<LinkMan> list=linkManDao.findByPage(detachedCriteria,begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	
	

}
