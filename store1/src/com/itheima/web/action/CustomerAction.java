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
	//业务成注入
	private CustomerService customerService;
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	//使用属性注入：set方法的方式接收数据
	private Integer currPage=1;
	
	/**
	 * 提供文件上传的3个属性
	 * @param currPage
	 */
	private String uploadFileName;//文件名称
	private File upload;           //上传文件
	private String uploadContenType;//文件类型

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
		//上传图片
		if(upload!=null) {
			//文件上传
			//设置文件上传路径：
			String path="D:/upload";
			//获取将上传的文件，改为随机名称
			String uuidFileName=UploadUtils.getUuidFileName(uploadFileName);
			//创建目录结构
			String realPath=UploadUtils.getPath(uuidFileName);

			//生成文件夹路径
			String url=path+realPath;
			File file=new File(url);
			//判断目录是否存在
			if(!file.exists()) {
				//创建目录
				file.mkdirs();
			}
			//文件上传
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
		//调用业务查询
		PageBean<Customer> pageBane=customerService.findByPage(detachedCriteria,currPage);
		//放进值栈
		ActionContext.getContext().getValueStack().push(pageBane);
		return "findAll";
	}
	
	public String delete() {
		System.out.println("----"+customer.getCust_id());
		//查询该用户
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
		//将数据放进值栈
		//ActionContext.getContext().getValueStack().push(customer);
		return "editSuccess";
	}
	

}
