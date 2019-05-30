package com.itheima.dao.impl;



import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.dao.LinkManDao; 
import com.itheima.domain.LinkMan;

public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao{

	@Override
	public int countPage(DetachedCriteria detachedCriteria) {
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list=(List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if(list.size()>0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<LinkMan> findByPage(DetachedCriteria detachedCriteria, int begin, int pageSize) {
		detachedCriteria.setProjection(null);
		List<LinkMan> list=(List<LinkMan>) this.getHibernateTemplate().findByCriteria(detachedCriteria,begin,pageSize);
		
		return list;
	}
      
}
