package com.itheima.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.dao.BaseDictDao;
import com.itheima.domain.BaseDict;

public class BaseDictDaoImpl extends HibernateDaoSupport implements BaseDictDao{

	@Override
	public List<BaseDict> findByTypeCode(BaseDict baseDict) {
		List<BaseDict> list=(List<BaseDict>) this.getHibernateTemplate().find("from BaseDict where dict_type_code=?", baseDict.getDict_type_code());
		
		return list;
	}
	
	
	
	
	

}
