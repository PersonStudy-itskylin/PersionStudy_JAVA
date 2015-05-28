/*
 * Copyright (c) 2005-2020 BeiJing Jidi Information Tech Co.,Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 北京极地信息安全安全有限公司.
 */
package com.ssi.depot.action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.ssi.depot.entity.Account;
import com.ssi.depot.entity.Product;
import com.ssi.depot.service.IProductService;

/** 
 * CopyRright (c)2005-2014:   <极地信息Jidi Information> 
 * Project:  depot
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package com.ssi.depot.action;
 * Author：      林为 
 * Create Date： 2014年10月20日 下午2:59:45
 * Modified By：  林为 
 * Modified Date: 2014年10月20日 下午2:59:45
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("json-default")
@Namespace("/product")
public class ProductAction extends ActionSupport{

	@Autowired
	private IProductService productService;
	private Product product;
	private Account account;
	private Map<String, Object> result = new HashMap<String, Object>();
	
	
	/**
	 * 
	 * 方  法 名: getProductAll
	 * 功能描述： 
	 * 输入参数: ProductAction
	 * 返 回 值:  ProductAction
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月20日 下午3:07:44
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月20日 下午3:07:44
	 */
	@Action(value="getProductAll",results={@Result(name= SUCCESS , type = "json",params={"root","result"})})
	public String getProductAll(){
		result = productService.findProductAll();
		return SUCCESS;
	}
	
	/**
	 * 
	 * 方  法 名: getProductPage
	 * 功能描述： 
	 * 输入参数: ProductAction
	 * 返 回 值:  ProductAction
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月20日 下午3:10:21
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月20日 下午3:10:21
	 */
	@Action(value="getProductPage",results={@Result(name= SUCCESS , type = "json",params={"root","result"})})
	public String getProductPage(){
		HttpServletRequest req = ServletActionContext.getRequest();
		Integer start = Integer.valueOf(req.getParameter("start"));
		Integer page = Integer.valueOf(req.getParameter("page"));
		Integer limit = Integer.valueOf(req.getParameter("limit"));
		
		result = productService.findProductPage(page,start, limit);
		return SUCCESS;
	}

	
	/**
	 * 
	 * 方  法 名: addProduct
	 * 功能描述： 
	 * 输入参数: ProductAction
	 * 返 回 值:  ProductAction
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月20日 下午4:05:53
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月20日 下午4:05:53
	 */
	@Action(value="addProduct",results={@Result(name= SUCCESS , type = "json",params={"root","result"})})
	public String addProduct(){
		HttpServletRequest req = ServletActionContext.getRequest();
		Product pro = new Product();
		
		pro.setAccid(Integer.valueOf(req.getParameter("accid")));//获得用户ID
		pro.setProname(req.getParameter("proname"));//获得产品名
		pro.setProsource(req.getParameter("prosource"));//获得产品来源
		pro.setProtype(req.getParameter("protype"));//获得产品类型
		pro.setProquantity(Integer.valueOf(req.getParameter("proquantity")));//获得产品数量
		pro.setProprice(Float.valueOf(req.getParameter("proprice")));//获得产品价格
		pro.setPromodel(req.getParameter("promodel"));//获得产品型号
		pro.setProeditor(req.getParameter("proeditor"));//获得修改者
		pro.setProremark(req.getParameter("proremark"));//获得产品备注信息
		
		result = productService.addProduct(pro);
		return SUCCESS;
	}


	@Action(value="updateProduct",results={@Result(name= SUCCESS , type = "json",params={"root","result"})})
	public String updateProduct(){
		HttpServletRequest req = ServletActionContext.getRequest();
		Product pro = new Product();
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		pro.setProid(Integer.valueOf(req.getParameter("proid")));//获得产品ID
		pro.setAccid(Integer.valueOf(req.getParameter("accid")));//获得用户ID
		pro.setProname(req.getParameter("proname"));//获得产品名称
		pro.setProsource(req.getParameter("prosource"));//获得产品来源
		pro.setProtype(req.getParameter("protype"));//获得产品类型
		pro.setProquantity(Integer.valueOf(req.getParameter("proquantity")));//获得产品数量
		pro.setProprice(Float.valueOf(req.getParameter("proprice")));//获得产品价格
		pro.setPromodel(req.getParameter("promodel"));//获得产品型号
		pro.setProeditor(req.getParameter("proeditor"));//获得修改者
		pro.setProremark(req.getParameter("proremark"));//获得产品备注信息
		
		result = productService.updateProduct(pro);
		return SUCCESS;
	}
	
	@Action(value="getProduct",results={@Result(name= SUCCESS , type = "json",params={"root","result"})})
	public String getProductById(){
		HttpServletRequest req = ServletActionContext.getRequest();
		result = productService.findProductById(req.getParameter("proid"));
		return SUCCESS;
	}
	
	

	@Action(value="delProduct",results={@Result(name= SUCCESS , type = "json",params={"root","result"})})
	public String delProduct(){
		HttpServletRequest req = ServletActionContext.getRequest();
		result = productService.deleteProductById(req.getParameter("proid"));
		return SUCCESS;
	}
	
/**********************  getter and setter  *************************************/	
	
	public IProductService getProductService() {
		return productService;
	}
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
