package com.itheima.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.itheima.domain.BaseDict;
import com.itheima.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict>{

	private BaseDict baseDict=new BaseDict();
	
	public BaseDict getBaseDict() {
		return baseDict;
	}
	private BaseDictService baseDictService;
	

	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}

	@Override
	public BaseDict getModel() {
		return baseDict;
	}
	
	public String findByTypeCode() throws IOException {
		
		List<BaseDict> list=baseDictService.findByTypeCode(baseDict);
		
		//创建过滤对象
		JsonConfig jsonConfig=new JsonConfig();
		//设置过滤掉字段
		jsonConfig.setExcludes(new String[]{"dict_sort","dict_enable","dict_memo"});
		//转为json
		JSONArray jsonArray=JSONArray.fromObject(list,jsonConfig);
		
		//将json打印到页面
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().println(jsonArray.toString());
		return NONE;
	}

}
