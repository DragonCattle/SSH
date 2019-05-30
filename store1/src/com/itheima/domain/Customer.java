package com.itheima.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * CREATE TABLE `cst_customer` (
  `cust_id` BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT '�ͻ����(����)',
  `cust_name` VARCHAR(32) NOT NULL COMMENT '�ͻ�����(��˾����)',
  `cust_source` VARCHAR(32) DEFAULT NULL COMMENT '�ͻ���Ϣ��Դ',
  `cust_industry` VARCHAR(32) DEFAULT NULL COMMENT '�ͻ�������ҵ',
  `cust_level` VARCHAR(32) DEFAULT NULL COMMENT '�ͻ�����',
  `cust_phone` VARCHAR(64) DEFAULT NULL COMMENT '�̶��绰',
  `cust_mobile` VARCHAR(16) DEFAULT NULL COMMENT '�ƶ��绰',
  PRIMARY KEY (`cust_id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
 * @author ASUS
 *
 */

public class Customer {
	private Long cust_id;
	private String cust_name;
	/*private String cust_source;
	private String cust_industry;
	private String cust_level;*/
	private String cust_phone;
	private String cust_mobile;
	private String cust_image;
	/*
	 * �ͻ����ֵ��ʾһ�Զࣺ��Ҫ�ڶ��һ���ŵ���һ��һ���Ķ���
	 */
	private BaseDict baseDictSource;
	private BaseDict baseDictIndustry;
	private BaseDict baseDictLevel;
	//һ���ͻ��ж����ϵ��
	private Set<LinkMan> linkMan=new HashSet<LinkMan>();
	public Long getCust_id() {
		return cust_id;
	}
	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	public String getCust_mobile() {
		return cust_mobile;
	}
	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}
	public String getCust_image() {
		return cust_image;
	}
	public void setCust_image(String cust_image) {
		this.cust_image = cust_image;
	}
	public BaseDict getBaseDictSource() {
		return baseDictSource;
	}
	public void setBaseDictSource(BaseDict baseDictSource) {
		this.baseDictSource = baseDictSource;
	}
	public BaseDict getBaseDictIndustry() {
		return baseDictIndustry;
	}
	public void setBaseDictIndustry(BaseDict baseDictIndustry) {
		this.baseDictIndustry = baseDictIndustry;
	}
	public BaseDict getBaseDictLevel() {
		return baseDictLevel;
	}
	public void setBaseDictLevel(BaseDict baseDictLevel) {
		this.baseDictLevel = baseDictLevel;
	}
	public Set<LinkMan> getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(Set<LinkMan> linkMan) {
		this.linkMan = linkMan;
	}
	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name + ", cust_phone=" + cust_phone
				+ ", cust_mobile=" + cust_mobile + ", cust_image=" + cust_image + ", baseDictSource=" + baseDictSource
				+ ", baseDictIndustry=" + baseDictIndustry + ", baseDictLevel=" + baseDictLevel + ", linkMan=" + linkMan
				+ "]";
	}
	
	
	
	
}
