/*
 * Copyright (c) 2005-2020 BeiJing Jidi Information Tech Co.,Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 北京极地信息安全安全有限公司.
 */
package com.ssi.depot.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ssi.depot.action.common.BaseAction;
import com.ssi.depot.entity.Account;
import com.ssi.depot.entity.Product;
import com.ssi.depot.service.IProductService;

/**
 * CopyRright (c)2005-2014: <极地信息Jidi Information> Project: depot Module ID:
 * <(模块)类编号，可以引用系统设计中的类编号> Comments: <对此类的描述，可以引用系统设计中的描述> JDK version used:
 * <JDK1.6> Namespace: package com.ssi.depot.action; Author： 林为 Create Date：
 * 2014年10月20日 下午2:59:45 Modified By： 林为 Modified Date: 2014年10月20日 下午2:59:45
 * Why & What is modified: <修改原因描述> Version: v1.0
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("json-default")
@Namespace("/product")
public class ProductAction extends BaseAction<Product> {

	@Autowired
	private IProductService productService;
	private Account account;

	/**
	 * 
	 * 方 法 名: getProductAll 功能描述： 输入参数: ProductAction 返 回 值: ProductAction 异 常：
	 * <按照异常名字的字母顺序> 创 建 人: 林为 创建日期: 2014年10月20日 下午3:07:44 修 改 人: Blue_Sky 修改日期:
	 * 2014年10月20日 下午3:07:44
	 */
	@Action(value = "getProductAll", results = { @Result(name = SUCCESS, type = "json", params = {
			"root", "result" }) })
	public String getProductAll() {
		result = productService.findProductAll(servletActionContext);
		return SUCCESS;
	}

	/**
	 * 
	 * 方 法 名: getProductPage 功能描述： 输入参数: ProductAction 返 回 值: ProductAction 异 常：
	 * <按照异常名字的字母顺序> 创 建 人: 林为 创建日期: 2014年10月20日 下午3:10:21 修 改 人: Blue_Sky 修改日期:
	 * 2014年10月20日 下午3:10:21
	 */
	@Action(value = "getProductPage", results = { @Result(name = SUCCESS, type = "json", params = {
			"root", "result" }) })
	public String getProductPage() {

		String start = request.getParameter("start");
		String limit = request.getParameter("limit");
		String page = request.getParameter("page");

		result = productService.findProductPage(page, start, limit,
				servletActionContext);
		return SUCCESS;
	}

	/**
	 * 
	 * 方 法 名: addProduct 功能描述： 输入参数: ProductAction 返 回 值: ProductAction 异 常：
	 * <按照异常名字的字母顺序> 创 建 人: 林为 创建日期: 2014年10月20日 下午4:05:53 修 改 人: Blue_Sky 修改日期:
	 * 2014年10月20日 下午4:05:53
	 */
	@Action(value = "addProduct", results = { @Result(name = SUCCESS, type = "json", params = {
			"root", "result" }) })
	public String addProduct() {
		Product pro = new Product();

		pro.setProname(request.getParameter("proname"));// 获得产品名
		pro.setProsource(request.getParameter("prosource"));// 获得产品来源
		pro.setProtype(request.getParameter("protype"));// 获得产品类型
		pro.setProquantity(Integer.valueOf(request.getParameter("proquantity")));// 获得产品数量
		pro.setProprice(Float.valueOf(request.getParameter("proprice")));// 获得产品价格
		pro.setPromodel(request.getParameter("promodel"));// 获得产品型号
		pro.setProremark(request.getParameter("proremark"));// 获得产品备注信息

		result = productService.addProduct(pro, servletActionContext);
		return SUCCESS;
	}

	/**
	 * 
	 * 功能描述： 修改产品信息 输入参数: ProductAction 返 回 值: ProductAction 异 常： <按照异常名字的字母顺序>
	 * 创 建 人: 林为 创建日期: 2014年11月27日 下午1:29:29 修 改 人: Blue_Sky 修改日期: 2014年11月27日
	 * 下午1:29:29
	 */
	@Action(value = "updateProduct", results = { @Result(name = SUCCESS, type = "json", params = {
			"root", "result" }) })
	public String updateProduct() {
		Product pro = new Product();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		pro.setProid(Integer.valueOf(request.getParameter("proid")));// 获得产品ID
		pro.setProname(request.getParameter("proname"));// 获得产品名称
		pro.setProsource(request.getParameter("prosource"));// 获得产品来源
		pro.setProtype(request.getParameter("protype"));// 获得产品类型
		pro.setProquantity(Integer.valueOf(request.getParameter("proquantity")));// 获得产品数量
		pro.setProprice(Float.valueOf(request.getParameter("proprice")));// 获得产品价格
		pro.setPromodel(request.getParameter("promodel"));// 获得产品型号
		pro.setProremark(request.getParameter("proremark"));// 获得产品备注信息

		result = productService.updateProduct(pro, servletActionContext);
		return SUCCESS;
	}

	@Action(value = "getProduct", results = { @Result(name = SUCCESS, type = "json", params = {
			"root", "result" }) })
	public String getProductById() {
		result = productService.findProductById(request.getParameter("proid"),
				servletActionContext);
		return SUCCESS;
	}

	@Action(value = "delProduct", results = { @Result(name = SUCCESS, type = "json", params = {
			"root", "result" }) })
	public String delProduct() {
		result = productService.deleteProductById(
				request.getParameter("proid"), servletActionContext);
		return SUCCESS;
	}

	/********************** getter and setter *************************************/

	public IProductService getProductService() {
		return productService;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public Product getModel() {
		return entity;
	}

}
