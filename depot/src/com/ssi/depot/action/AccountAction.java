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
public class AccountAction extends ActionSupport {

	@Autowired
	private IAccountService accountService;
	private Account account;
	private Map<String, Object> result = new HashMap<String, Object>();

	/*
	 * 方 法 名: login 
	 * 功能描述： 
	 * 输入参数: AccountAction 
	 * 返 回 值: AccountAction 
	 * 异常：<按照异常名字的字母顺序> 
	 * 创 建 人: 林为 
	 * 创建日期: 2014年10月11日 下午11:18:02 
	 * 修 改 人: Blue_Sky
	 * 修改日期: 2014年10月11日 下午11:18:02
	 */
	@Action(value = "login", results = { @Result(name = SUCCESS, type = "json", params = {
			"root", "result" }) })
	public String loginAccount() {
		HttpServletRequest req = ServletActionContext.getRequest();
		boolean flag = false;
		Map<String, Object> map = new HashMap<String, Object>();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String msg = "账号或密码错误，请确定后重试！";
		Account acc = accountService.loginAccount(username, password);
		if (acc != null) {
			flag = true;
			msg = "欢迎您，" + acc.getRealname() + "！";
		}
		map.put("success", flag);
		map.put("msg", msg);
		result = map;
		return SUCCESS;
	}

	/*
	 * 方  法 名: regAccount
	 * 功能描述： 
	 * 输入参数: AccountAction
	 * 返 回 值:  AccountAction
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月14日 下午2:20:00
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月14日 下午2:20:00
	 */
	@Action(value = "reg", results = { @Result(name = "success", type = "json", params = {
			"root", "result" }) })
	public String addAccount() {// 添加用户
		HttpServletRequest req = ServletActionContext.getRequest();
		Account acc = new Account();
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		acc.setUsername(req.getParameter("username"));//获取  用户名
		acc.setPassword(req.getParameter("password"));//获得密码
		acc.setRealname(req.getParameter("realname"));//获得 用户姓名
		acc.setDescription(req.getParameter("description"));//获得描述
		acc.setRole(Integer.valueOf(req.getParameter("role")));//获得权限
		acc.setState(Integer.valueOf(req.getParameter("state")));//获得用户状态
		acc.setPhone(req.getParameter("phone"));//获得用户手机
		acc.setTel(req.getParameter("tel"));//获得电话
		acc.setEmail(req.getParameter("email"));//获得邮箱
		acc.setQq(req.getParameter("qq"));//获取 QQ
		acc.setRemark(req.getParameter("remark"));//获得备注
		acc.setIp(req.getLocalAddr());// 获取IP地址
		
		result = accountService.addAccount(acc);
		return SUCCESS;
	}

	/*
	 * 方  法 名: delAccount
	 * 功能描述： 
	 * 输入参数: AccountAction
	 * 返 回 值:  AccountAction
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月14日 下午2:19:55
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月14日 下午2:19:55
	 */
	@Action(value = "delAccount", results = { @Result(name = "success", type = "json", params = {
			"root", "result" }) })
	public String delAccount() {
		HttpServletRequest req = ServletActionContext.getRequest();
		result = accountService.deleteAccountById(req.getParameter("id"));
		return SUCCESS;
	}

	/*
	 * 方  法 名: getAccountAll
	 * 功能描述： 
	 * 输入参数: AccountAction
	 * 返 回 值:  AccountAction
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月14日 下午2:19:49
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月14日 下午2:19:49
	 */
	@Action(value = "getAccountAll", results = { 
			@Result(name = "success", type = "json", params = {"root", "result" }) })
	public String getAccountAll() {
		result = accountService.findAllAccount();
		return SUCCESS;
	}

	/*
	 * 方  法 名: getAccountPage
	 * 功能描述： 
	 * 输入参数: AccountAction
	 * 返 回 值:  AccountAction
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月14日 下午2:19:43
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月14日 下午2:19:43
	 */
	@Action(value = "getAccountPage", results = { @Result(name = "success", type = "json", params = {
			"root", "result" }) })
	public String getAccountPage() {
		HttpServletRequest req = ServletActionContext.getRequest();
		Integer start = Integer.valueOf(req.getParameter("start"));
		Integer page = Integer.valueOf(req.getParameter("page"));
		Integer limit = Integer.valueOf(req.getParameter("limit"));
		
		result = accountService.findAccountPage(page,start, limit);
		return SUCCESS;
	}

	/*
	 * 方  法 名: updateAccount
	 * 功能描述： 
	 * 输入参数: AccountAction
	 * 返 回 值:  AccountAction
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月14日 下午2:19:35
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月14日 下午2:19:35
	 */
	@Action(value = "updateAccount", results = { @Result(name = "success", type = "json", params = {
			"root", "result" }) })
	public String updateAccount() {
		HttpServletRequest req = ServletActionContext.getRequest();
		Account acc = new Account();
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		acc.setId(Integer.valueOf(req.getParameter("id")));//获得ID
		acc.setUsername(req.getParameter("username"));//获取  用户名
		acc.setPassword(req.getParameter("password"));//获得密码
		acc.setRealname(req.getParameter("realname"));//获得 用户姓名
		acc.setDescription(req.getParameter("description"));//获得描述
		acc.setRole(Integer.valueOf(req.getParameter("role")));//获得权限
		acc.setState(Integer.valueOf(req.getParameter("state")));//获得用户状态
		acc.setPhone(req.getParameter("phone"));//获得用户手机
		acc.setTel(req.getParameter("tel"));//获得电话
		acc.setEmail(req.getParameter("email"));//获得邮箱
		acc.setQq(req.getParameter("qq"));//获取 QQ
		acc.setRemark(req.getParameter("remark"));//获得备注
		
		result = accountService.updateAccountById(acc);
		return SUCCESS;
	}
	
	
	/**
	 * 
	 * 方  法 名: findAccountByOption
	 * 功能描述：  模糊查询
	 * 输入参数: AccountAction
	 * 返 回 值:  AccountAction
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月22日 下午3:20:58
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月22日 下午3:20:58
	 */
	@Action(value = "getAccountByOption", results = { @Result(name = "success", type = "json", params = {
			"root", "result" }) })
	public String findAccountByOption(){
		HttpServletRequest req = ServletActionContext.getRequest();
		Account acc = new Account();
//		acc.setId(Integer.valueOf(req.getParameter("id")));//获得ID
		acc.setUsername(req.getParameter("username"));//获取  用户名
		acc.setPassword(req.getParameter("password"));//获得密码
		acc.setRealname(req.getParameter("realname"));//获得 用户姓名
		acc.setDescription(req.getParameter("description"));//获得描述
//		acc.setRole(Integer.valueOf(req.getParameter("role")));//获得权限
//		acc.setState(Integer.valueOf(req.getParameter("state")));//获得用户状态
		acc.setPhone(req.getParameter("phone"));//获得用户手机
		acc.setTel(req.getParameter("tel"));//获得电话
		acc.setEmail(req.getParameter("email"));//获得邮箱
		acc.setQq(req.getParameter("qq"));//获取 QQ
		acc.setRemark(req.getParameter("remark"));//获得备注
		acc.setIp(req.getParameter("ip"));//获得查询IP
		result = accountService.findAccountByOption(acc);
		return SUCCESS;
	}
	
	

/*************************** setter and getter *********************************/
	
	
	/**
	 * @return accountService
	 */
	public IAccountService getAccountService() {
		return accountService;
	}

	/**
	 * @param accountService 要设置的 accountService
	 */
	public void setAccountService(IAccountService accountService) {
		this.accountService = accountService;
	}

	/**
	 * @return account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account 要设置的 account
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * @return result
	 */
	public Map<String, Object> getResult() {
		return result;
	}

	/**
	 * @param result 要设置的 result
	 */
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

}
