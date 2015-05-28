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
import org.springframework.stereotype.Controller;

import com.ssi.depot.action.common.BaseAction;
import com.ssi.depot.entity.SystemLog;
import com.ssi.depot.service.ISystemLogService;

/** 
 * CopyRright (c)2005-2014:   <极地信息Jidi Information> 
 * Project:  depot2
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package com.ssi.depot.action;
 * Author：      林为 
 * Create Date： 2014年10月24日 下午3:16:19
 * Modified By：  林为 
 * Modified Date: 2014年10月24日 下午3:16:19
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
@SuppressWarnings("serial")
@Controller
@Namespace("/syslog")
@ParentPackage("json-default")
public class SystemLogAction extends BaseAction<SystemLog>{

	@Autowired
	private ISystemLogService systemService;
	
	/**
	 * 
	 * 方  法 名: addSystemLog
	 * 功能描述： 
	 * 输入参数: SystemLogAction
	 * 返 回 值:  SystemLogAction
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月24日 下午4:53:12
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月24日 下午4:53:12
	 */
	@Action(value="addSyslog",results={@Result(name=SUCCESS,type="json",params={"root","result"})})
	public String addSystemLog(){
		entity.setSysname(request.getParameter("sysname"));//获得操作者的名字
		entity.setSysremark(request.getParameter("sysremark"));//获得备注
		result = systemService.addSystemLog(entity,servletActionContext);
		return SUCCESS;
	}
	
	
	/**
	 * 
	 * 方  法 名: delSystemLog
	 * 功能描述： 
	 * 输入参数: SystemLogAction
	 * 返 回 值:  SystemLogAction
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月24日 下午4:53:01
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月24日 下午4:53:01
	 */
	@Action(value="delSyslog",results={@Result(name=SUCCESS,type="json",params={"root","result"})})
	public String delSystemLog(){
		result = systemService.delSystemLog(request.getParameter("sysid"),servletActionContext);
		return SUCCESS;
	}
	
	
	/**
	 * 
	 * 方  法 名: getSystemLogById
	 * 功能描述： 
	 * 输入参数: SystemLogAction
	 * 返 回 值:  SystemLogAction
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月24日 下午4:52:57
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月24日 下午4:52:57
	 */
	@Action(value="getSysLogById",results={@Result(name=SUCCESS,type="json",params={"root","result"})})
	public String getSystemLogById(){
		result = systemService.findSystemLogById(request.getParameter("sysid"),servletActionContext);
		return SUCCESS;
	}
	
	
	/**
	 * 
	 * 方  法 名: getSystemLogByAll
	 * 功能描述： 
	 * 输入参数: SystemLogAction
	 * 返 回 值:  SystemLogAction
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月24日 下午4:52:53
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月24日 下午4:52:53
	 */
	@Action(value="getSysLogAll",results={@Result(name=SUCCESS,type="json",params={"root","result"})})
	public String getSystemLogByAll(){
		result = systemService.findSystemLogByAll(servletActionContext);
		return SUCCESS;
	}
	
	
	/**
	 * 
	 * 方  法 名: getSystemLogByPage
	 * 功能描述： 
	 * 输入参数: SystemLogAction
	 * 返 回 值:  SystemLogAction
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月24日 下午4:52:49
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月24日 下午4:52:49
	 */
	@Action(value="getSysLogPage",results={@Result(name=SUCCESS,type="json",params={"root","result"})})
	public String getSystemLogByPage(){
		String start = request.getParameter("start");
		String limit = request.getParameter("limit");
		String page = request.getParameter("page");
		result = systemService.findSystemLogByPage(page, start, limit,servletActionContext);
		return SUCCESS;
	}
	
	
	
	
	
	
	
/***************  getter and setter  *********************/	

	/** 
	 * 方  法 名: setServletResponse
	 * 功能描述： 
	 * 输入参数: ServletResponseAware
	 * 返 回 值:  ServletResponseAware
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年11月24日 上午10:48:30
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年11月24日 上午10:48:30
	 */
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	@Override
	public SystemLog getModel() {
		return entity;
	}


	/** 
	 * 方  法 名: setServletRequest
	 * 功能描述： 
	 * 输入参数: ServletRequestAware
	 * 返 回 值:  ServletRequestAware
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年11月24日 上午10:48:30
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年11月24日 上午10:48:30
	 */
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}


}
