/*
 * Copyright (c) 2005-2020 BeiJing Jidi Information Tech Co.,Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 北京极地信息安全安全有限公司.
 */
package com.ssi.depot.action;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.ssi.depot.entity.Backup;
import com.ssi.depot.service.IBackupService;
import com.ssi.depot.util.DateUtil;

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
public class BackupAction extends ActionSupport {

	@Autowired
	private IBackupService backupService;
	private Backup backup;
	private Map<String,Object> result = new HashMap<String, Object>();

	
	
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
	public String getBackupAll() {
		result = backupService.findBackupAll();
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
	public String getBackupPage() {
		HttpServletRequest req = ServletActionContext.getRequest();
		int start = Integer.valueOf(req.getParameter("start"));
		int page = Integer.valueOf(req.getParameter("page"));
		int limit = Integer.valueOf(req.getParameter("limit"));
		result = backupService.findBackupByPage(page,start,limit);
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
		HttpServletRequest req = ServletActionContext.getRequest();
		Backup bac = new Backup();
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		bac.setAccid(Integer.valueOf(req.getParameter("accid")));//获得备份用户
		bac.setBacdescription(req.getParameter("description"));//获得备份描述
		bac.setBacname(req.getParameter("bacname"));//获得备份名称
		bac.setBacpath(req.getParameter("bacpath"));//获得备份路径
		bac.setBacremark(req.getParameter("bacremark"));//获得备份备注
		bac.setBacip(req.getLocalAddr());//获得用户操作IP地址
		bac.setBactime(DateUtil.format(new Date()));//获得系统时间
		
		result = backupService.addBackup(backup);
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
		HttpServletRequest req = ServletActionContext.getRequest();
		Backup bac = new Backup();
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		bac.setAccid(Integer.valueOf(req.getParameter("accid")));//获得备份用户
		bac.setBacdescription(req.getParameter("description"));//获得备份描述
		bac.setBacname(req.getParameter("bacname"));//获得备份名称
		bac.setBacpath(req.getParameter("bacpath"));//获得备份路径
		bac.setBacremark(req.getParameter("bacremark"));//获得备份备注
		
		result = backupService.updateBackupById(bac);
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
		HttpServletRequest req = ServletActionContext.getRequest();
		result = backupService.delBackupById(req.getParameter("bacid"));
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
/*********************  setter and getter  *************************/	
	/**
	 * @return backupService
	 */
	public IBackupService getBackupService() {
		return backupService;
	}

	/**
	 * @param backupService
	 *            要设置的 backupService
	 */
	public void setBackupService(IBackupService backupService) {
		this.backupService = backupService;
	}

	/**
	 * @return backup
	 */
	public Backup getBackup() {
		return backup;
	}

	/**
	 * @param backup
	 *            要设置的 backup
	 */
	public void setBackup(Backup backup) {
		this.backup = backup;
	}

	@JSON
	public Map<String,Object> getResult() {
		return result;
	}

	public void setResult(Map<String,Object> result) {
		this.result = result;
	}
}