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
import com.ssi.depot.entity.Backup;
import com.ssi.depot.service.IBackupService;

/** 
 * CopyRright (c)2005-2014:   <极地信息Jidi Information> 
 * Project:  depot
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package com.ssi.depot.action;
 * Author：      林为 
 * Create Date： 2014年10月10日 上午9:53:05
 * Modified By：  林为 
 * Modified Date: 2014年10月10日 上午9:53:05
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
/**
 * @author 林为
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("json-default")
@Namespace("/backup")
public class BackupAction extends BaseAction<Backup> {

	@Autowired
	private IBackupService entityService;
	
	/**
	 * 
	 * 方  法 名: getBackupAllJSON
	 * 功能描述： 
	 * 输入参数: BackupAction
	 * 返 回 值:  BackupAction
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月11日 下午2:01:20
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月11日 下午2:01:20
	 */
	@Action(value = "getBackupAll", results = { 
			@Result(name = "success", type = "json", params = {"root", "result" })
		})
	public String getBackupAllJSON() {
		result = entityService.findBackupAll(servletActionContext);
		return SUCCESS;
	}
	
	/**
	 * 
	 * 方  法 名: selectBackupPage
	 * 功能描述： 得到备份记录分页的json串
	 * 输入参数: int start ,int pageSize
	 * 返 回 值:  json list<Backup>
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月11日 下午1:56:52
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月11日 下午1:56:52
	 */
	@Action(value = "getBackupPage", results = {
				@Result(name = "success", type = "json", params = {"root", "result" }) })
	public String selectBackupPage() {
		
		String start = request.getParameter("start");
		String limit = request.getParameter("limit");
		String page = request.getParameter("page");
		
		result = entityService.findBackupByPage(page,start,limit,servletActionContext);
		return SUCCESS;
	}
	
	/**
	 * 
	 * 方  法 名: addBackup
	 * 功能描述： 
	 * 输入参数: BackupAction
	 * 返 回 值:  JSON MSG
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月11日 下午2:28:19
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月11日 下午2:28:19
	 */
	@Action(value = "addBackup", results = {
			@Result(name = "success", type="json",params={"root","result"})})
	public String addBackup() {
		
		entity.setBacname(request.getParameter("bacname"));//获得备份名称
		entity.setAccid(Integer.valueOf(request.getParameter("accid")));//获得备份ID
		entity.setBacdescription(request.getParameter("bakdescription"));//获得备份描述信息
		entity.setBacremark(request.getParameter("bacremark"));//获得备份备注
		entity.setBacip(request.getLocalAddr());//获得用户操作IP地址
		/**
		 * 预留位置
		 * 备份数据库还没有写
		 */
		entity.setBacpath(request.getParameter("bacpath"));//获得备份路径
		
		result = entityService.addBackup(entity,servletActionContext);
		return SUCCESS;
	}

	
	/** 
	 * 方  法 名: updateBackup
	 * 功能描述： 
	 * 输入参数: BackupAction
	 * 返 回 值:  BackupAction
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月11日 下午2:30:04
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月11日 下午2:30:04
	 */
	@Action(value = "updateBackup", results = {
			@Result(name = "success", type="json",params={"root","result"})})
	public String updateBackup() {
		entity.setBacip(request.getParameter("bacid"));//获得要修改的备份ID
		entity.setBacname(request.getParameter("bacname"));//获得备份名称
		/**
		 * 预留位置
		 * 备份数据库还没有写
		 */
		entity.setBacpath(request.getParameter("bacpath"));//获得备份路径
		
		entity.setAccid(Integer.valueOf(request.getParameter("accid")));//获得备份ID
		entity.setBacdescription(request.getParameter("bakdescription"));//获得备份描述信息
		entity.setBacremark(request.getParameter("bacremark"));//获得备份备注
		result = entityService.updateBackupById(entity,servletActionContext);
		return SUCCESS;
	}
	
	
	/** 
	 * 方  法 名: delBackup
	 * 功能描述： 
	 * 输入参数: BackupAction
	 * 返 回 值:  BackupAction
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月11日 下午3:27:26
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月11日 下午3:27:26
	 */
	@Action(value = "delBackup", results = {
				@Result(name = "success", type="json",params={"root","result"})})
	public String delBackup() {
		result = entityService.delBackupById(request.getParameter("bacid"),servletActionContext);
		return SUCCESS;
	}
	
	
/****************** getter and setter *********************************/	

	public IBackupService getEntityService() {
		return entityService;
	}

	public void setEntityService(IBackupService entityService) {
		this.entityService = entityService;
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
	public Backup getModel() {
		return entity;
	}
}