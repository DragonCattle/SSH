package com.itheima.web.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.itheima.domain.Customer;
import com.itheima.domain.PageBean;
import com.itheima.service.CustomerService;
import com.itheima.utils.UploadUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	private Customer customer=new Customer();
	
	@Override
	public Customer getModel() {	
		return customer;
	}
	//ҵ���ע��
	private CustomerService customerService;
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	//ʹ������ע�룺set�����ķ�ʽ��������
	private Integer currPage=1;
	
	/**
	 * �ṩ�ļ��ϴ���3������
	 * @param currPage
	 */
	private String uploadFileName;//�ļ�����
	private File upload;           //�ϴ��ļ�
	private String uploadContenType;//�ļ�����

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadContenType(String uploadContenType) {
		this.uploadContenType = uploadContenType;
	}

	public void setCurrPage(Integer currPage) {
		if(currPage==null) {
			currPage=1;
		}
		this.currPage = currPage;
	}

	public String saveUI() {
		//customerService.save(customer);
	
		return "saveUI";
	}
	
	public String save() throws IOException {
		//�ϴ�ͼƬ
		if(upload!=null) {
			//�ļ��ϴ�
			//�����ļ��ϴ�·����
			String path="D:/upload";
			//��ȡ���ϴ����ļ�����Ϊ�������
			String uuidFileName=UploadUtils.getUuidFileName(uploadFileName);
			//����Ŀ¼�ṹ
			String realPath=UploadUtils.getPath(uuidFileName);

			//�����ļ���·��
			String url=path+realPath;
			File file=new File(url);
			//�ж�Ŀ¼�Ƿ����
			if(!file.exists()) {
				//����Ŀ¼
				file.mkdirs();
			}
			//�ļ��ϴ�
			File dictFile=new File(url+uuidFileName);
			FileUtils.copyFile(upload, dictFile);
			customer.setCust_image(url+uuidFileName);
		}
		customerService.save(customer);
		return "saveSuccess";
	}
	
	public String findAll() {
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Customer.class);
		
		if(customer.getCust_name()!=null) {
			detachedCriteria.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		if(customer.getBaseDictSource()!=null) {
			if(customer.getBaseDictSource().getDict_id()!=null&&!"".equals(customer.getBaseDictSource().getDict_id())) {
				detachedCriteria.add(Restrictions.eq("baseDictSource.dict_id", customer.getBaseDictSource().getDict_id()));
			}
		}
		if(customer.getBaseDictLevel()!=null) {
			if(customer.getBaseDictSource().getDict_id()!=null&&!"".equals(customer.getBaseDictLevel().getDict_id())) {
				detachedCriteria.add(Restrictions.eq("baseDictLevel.dict_id", customer.getBaseDictLevel().getDict_id()));
			}
		}
		if(customer.getBaseDictIndustry()!=null) {
			if(customer.getBaseDictSource().getDict_id()!=null&&!"".equals(customer.getBaseDictIndustry().getDict_id())) {
				detachedCriteria.add(Restrictions.eq("baseDictIndustry.dict_id", customer.getBaseDictIndustry().getDict_id()));
			}
		}
		//����ҵ���ѯ
		PageBean<Customer> pageBane=customerService.findByPage(detachedCriteria,currPage);
		//�Ž�ֵջ
		ActionContext.getContext().getValueStack().push(pageBane);
		return "findAll";
	}
	
	public String delete() {
		System.out.println("----"+customer.getCust_id());
		//��ѯ���û�
		customer=customerService.findById(customer.getCust_id());
		String url=customer.getCust_image();
		File file=new File(url);
		if(file.exists()) {
			file.delete();
		}
		customerService.delete(customer);
		return "deleteSuccess";
	}
	
	public String edit() {
		customer=customerService.findById(customer.getCust_id());
		//�����ݷŽ�ֵջ
		//ActionContext.getContext().getValueStack().push(customer);
		return "editSuccess";
	}
	

}
