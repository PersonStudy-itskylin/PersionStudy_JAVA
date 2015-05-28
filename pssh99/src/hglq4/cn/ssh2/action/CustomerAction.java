/*
 * Copyright (c) 2010-2020 蓝桥软件 Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 蓝桥科技有限公司.
 */
package hglq4.cn.ssh2.action;

import hglq4.cn.ssh2.service.customer.ICustomerService;
import hglq4.cn.ssh2.util.BlueSkyException;
import hglq4.cn.ssh2.vo.CustomerVO;
import hglq4.cn.ssh2.vo.LoginVO;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/** 
 * CopyRright (c)2008-2014:   <蓝桥软件BlueSoft> 
 * Project:  pssh99
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package hglq4.cn.ssh2.action;
 * Author：      林为 
 * Create Date： 2014年8月16日 下午8:47:11
 * Modified By：  林为 
 * Modified Date: 2014年8月16日 下午8:47:11
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
/**
 * @author 林为
 * 
 */
@SuppressWarnings("serial")
@Resource
@ParentPackage("struts-default")
@Scope("prototype")
@Namespace("/customer")
public class CustomerAction extends BaseAction {

	@Autowired
	private ICustomerService customerServiceImpl;
	/**
	 * @return customerServiceImpl
	 */
	public ICustomerService getCustomerServiceImpl() {
		return customerServiceImpl;
	}

	private LoginVO lvo;

	@Action(value = "login", results = {
			@Result(name = "success", location = "/customer/ok.jsp"),
			@Result(name = "error", location = "/customer/error.jsp") })
	public String login() {
		try {
			CustomerVO cvo = customerServiceImpl.login(lvo);
			session.put("curentUser", cvo);
		} catch (BlueSkyException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			tip = e.getMessage() + "000000000000000000000000000000";
			return ERROR; 
		}

		return SUCCESS;
	}

	/**
	 * action 的属性值通过get返回给页面request范围
	 * 
	 * @return loginvo
	 */
	public LoginVO getLvo() {
		return lvo;
	}

	/**
	 * 页面的值传过来，Set注入
	 * 
	 * @param loginvo
	 *            要设置的 loginvo
	 */
	public void setLvo(LoginVO lvo) {
		this.lvo = lvo;
	}
}
