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
import com.ssi.depot.service.IAccountService;

/** 
 * CopyRright (c)2005-2014:   <极地信息Jidi Sec> 
 * Project:  warehouse
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package cn.hglq4.ssi.warehouse.controller;
 * Author：      林为 
 * Create Date： 2014年9月26日 下午2:54:06
 * Modified By：  林为 
 * Modified Date: 2014年9月26日 下午2:54:06
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
/**
 * @author 林为 778429240649
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("json-default")
@Namespace("/user")
public class AccountAction extends BaseAction<Account> {

	@Autowired
	private IAccountService accountService;

	/*
	 * 方 法 名: login 功能描述： 输入参数: AccountAction 返 回 值: AccountAction
	 * 异常：<按照异常名字的字母顺序> 创 建 人: 林为 创建日期: 2014年10月11日 下午11:18:02 修 改 人: Blue_Sky
	 * 修改日期: 2014年10月11日 下午11:18:02
	 */
	@Action(value = "login", results = { @Result(name = LOGIN, type = "json", params = {
			"root", "result" }) })
	public String loginAccount() {
		flag = false;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String msg = "账号或密码错误，请确定后重试！";
		Account acc = accountService.loginAccount(username, password,
				servletActionContext);
		if (acc != null) {
			flag = true;
			msg = "欢迎您，" + acc.getRealname() + "！";
		}
		json.put("success", flag);
		json.put("msg", msg);

		result = json;

		return LOGIN;
	}

	/*
	 * 方 法 名: regAccount 功能描述： 输入参数: AccountAction 返 回 值: AccountAction 异 常：
	 * <按照异常名字的字母顺序> 创 建 人: 林为 创建日期: 2014年10月14日 下午2:20:00 修 改 人: Blue_Sky 修改日期:
	 * 2014年10月14日 下午2:20:00
	 */
	@Action(value = "reg", results = { @Result(name = "success", type = "json", params = {
			"root", "result" }) })
	public String addAccount() {// 添加用户
		Account acc = new Account();
		String role = request.getParameter("role");
		String state = request.getParameter("state");

		acc.setUsername(request.getParameter("username"));// 获取 用户名
		acc.setPassword(request.getParameter("password"));// 获得密码
		acc.setRealname(request.getParameter("realname"));// 获得 用户姓名
		acc.setDescription(request.getParameter("description"));// 获得描述
		acc.setRole(Integer.valueOf(role));// 获得权限
		acc.setState(Integer.valueOf(state));// 获得用户状态
		acc.setPhone(request.getParameter("phone"));// 获得用户手机
		acc.setTel(request.getParameter("tel"));// 获得电话
		acc.setEmail(request.getParameter("email"));// 获得邮箱
		acc.setQq(request.getParameter("qq"));// 获取 QQ
		acc.setRemark(request.getParameter("remark"));// 获得备注
		result = accountService.addAccount(acc, servletActionContext);
		return SUCCESS;
	}

	/*
	 * 方 法 名: delAccount 功能描述： 输入参数: AccountAction 返 回 值: AccountAction 异 常：
	 * <按照异常名字的字母顺序> 创 建 人: 林为 创建日期: 2014年10月14日 下午2:19:55 修 改 人: Blue_Sky 修改日期:
	 * 2014年10月14日 下午2:19:55
	 */
	@Action(value = "delAccount", results = { @Result(name = SUCCESS, type = "json", params = {
			"root", "result" }) })
	public String delAccount() {
		String id = request.getParameter("id");
		result = accountService.deleteAccountById(id, servletActionContext);
		return SUCCESS;
	}

	/**
	 * 方 法 名: getAccountAll 功能描述： 输入参数: AccountAction 返 回 值: AccountAction 异 常：
	 * <按照异常名字的字母顺序> 创 建 人: 林为 创建日期: 2014年10月14日 下午2:19:49 修 改 人: Blue_Sky 修改日期:
	 * 2014年10月14日 下午2:19:49
	 */
	@Action(value = "getAccountAll", results = { @Result(name = SUCCESS, type = "json", params = {
			"root", "result" }) })
	public String getAccountAll() {
		result = accountService.findAllAccount(servletActionContext);
		return SUCCESS;
	}

	/**
	 * 方 法 名: getAccountPage 功能描述： 输入参数: AccountAction 返 回 值: AccountAction 异 常：
	 * <按照异常名字的字母顺序> 创 建 人: 林为 创建日期: 2014年10月14日 下午2:19:43 修 改 人: Blue_Sky 修改日期:
	 * 2014年10月14日 下午2:19:43
	 */
	@Action(value = "getAccountPage", results = { @Result(name = SUCCESS, type = "json", params = {
			"root", "result" }) })
	public String getAccountPage() {
		String limit = request.getParameter("limit");// +456
		String start = request.getParameter("start");
		String page = request.getParameter("page");
		result = accountService.findAccountPage(page, start, limit,
				servletActionContext);
		return SUCCESS;
	}

	/**
	 * 方 法 名: updateAccount 功能描述： 输入参数: AccountAction 返 回 值: AccountAction 异 常：
	 * <按照异常名字的字母顺序> 创 建 人: 林为 创建日期: 2014年10月14日 下午2:19:35 修 改 人: Blue_Sky 修改日期:
	 * 2014年10月14日 下午2:19:35
	 */
	@Action(value = "updateAccount", results = { @Result(name = "success", type = "json", params = {
			"root", "result" }) })
	public String updateAccount() {
		Account acc = new Account();
		String id = request.getParameter("id");
		String role = request.getParameter("role");
		String state = request.getParameter("state");

		acc.setId(Integer.valueOf(id));// 获得ID
		acc.setUsername(request.getParameter("username"));// 获取 用户名
		acc.setPassword(request.getParameter("password"));// 获得密码
		acc.setRealname(request.getParameter("realname"));// 获得 用户姓名
		acc.setDescription(request.getParameter("description"));// 获得描述
		acc.setRole(Integer.valueOf(role));// 获得权限
		acc.setState(Integer.valueOf(state));// 获得用户状态
		acc.setPhone(request.getParameter("phone"));// 获得用户手机
		acc.setTel(request.getParameter("tel"));// 获得电话
		acc.setEmail(request.getParameter("email"));// 获得邮箱
		acc.setQq(request.getParameter("qq"));// 获取 QQ
		acc.setRemark(request.getParameter("remark"));// 获得备注

		result = accountService.updateAccountById(acc, servletActionContext);
		return SUCCESS;
	}

	/**
	 * 
	 * 方 法 名: getfindAccountBySome 功能描述： 输入参数: AccountAction 返 回 值:
	 * AccountAction 异 常： <按照异常名字的字母顺序> 创 建 人: 林为 创建日期: 2014年11月6日 下午1:31:27 修 改
	 * 人: Blue_Sky 修改日期: 2014年11月6日 下午1:31:27
	 */
	@Action(value = "getAccountBySome", results = { @Result(name = SUCCESS, type = "json", params = {
			"root", "result" }) })
	public String getfindAccountBySome() {
		Account acc = new Account();
		String id = request.getParameter("id");// 获得ID
		String role = request.getParameter("role");// 获得权限
		String state = request.getParameter("state");// 获得用户状态
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if (id != null) {
			acc.setId(Integer.valueOf(id));
		}
		if (role != null) {
			acc.setRole(Integer.valueOf(role));
		}
		if (state != null) {
			acc.setState(Integer.valueOf(state));
		}

		acc.setUsername(request.getParameter("username"));// 获取 用户名
		acc.setPassword(request.getParameter("password"));// 获得密码
		acc.setRealname(request.getParameter("realname"));// 获得 用户姓名
		acc.setDescription(request.getParameter("description"));// 获得描述
		acc.setPhone(request.getParameter("phone"));// 获得用户手机
		acc.setTel(request.getParameter("tel"));// 获得电话
		acc.setEmail(request.getParameter("email"));// 获得邮箱
		acc.setQq(request.getParameter("qq"));// 获取 QQ
		acc.setRemark(request.getParameter("remark"));// 获得备注

		result = accountService.findAccountBySome(acc, servletActionContext);
		return SUCCESS;
	}

	/**
	 * 
	 * 方 法 名: getAccountSome 功能描述： 输入参数: AccountAction 返 回 值: AccountAction 异 常：
	 * <按照异常名字的字母顺序> 创 建 人: 林为 创建日期: 2014年11月24日 下午4:29:32 修 改 人: Blue_Sky 修改日期:
	 * 2014年11月24日 下午4:29:32
	 */
	@Action(value = "getAccountSome", results = { @Result(name = SUCCESS, type = "json", params = {
			"root", "result" }) })
	public String getAccountSome() {
		result = accountService.findAccountBySome(entity, servletActionContext);
		return SUCCESS;
	}

	@Action(value = "loginOut", results = { @Result(name = SUCCESS, type = "json", params = {
			"root", "result" }) })
	public String loginOut() {
		result = accountService.loginOut(servletActionContext);
		return SUCCESS;
	}

	/*************************** setter and getter *********************************/

	public IAccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(IAccountService accountService) {
		this.accountService = accountService;
	}

	/**
	 * 方 法 名: setServletResponse 功能描述： 输入参数: ServletResponseAware 返 回 值:
	 * ServletResponseAware 异 常： <按照异常名字的字母顺序> 创 建 人: 林为 创建日期: 2014年11月18日
	 * 上午10:37:50 修 改 人: Blue_Sky 修改日期: 2014年11月18日 上午10:37:50
	 */
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * 方 法 名: setServletResponse 功能描述： 输入参数: ServletResponseAware 返 回 值:
	 * ServletResponseAware 异 常： <按照异常名字的字母顺序> 创 建 人: 林为 创建日期: 2014年11月5日
	 * 上午9:51:46 修 改 人: Blue_Sky 修改日期: 2014年11月5日 上午9:51:46
	 */
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * 方 法 名: getModel 功能描述： 输入参数: ModelDriven<Account> 返 回 值:
	 * ModelDriven<Account> 异 常： <按照异常名字的字母顺序> 创 建 人: 林为 创建日期: 2014年11月5日
	 * 上午9:51:46 修 改 人: Blue_Sky 修改日期: 2014年11月5日 上午9:51:46
	 */
	@Override
	public Account getModel() {
		return entity;
	}

}
