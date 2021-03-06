/*
 * Copyright (c) 2005-2020 BeiJing Jidi Information Tech Co.,Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 北京极地信息安全安全有限公司.
 */
package com.ssi.depot.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssi.depot.dao.IBackupDAO;
import com.ssi.depot.entity.Account;
import com.ssi.depot.entity.Backup;
import com.ssi.depot.entity.SystemLog;
import com.ssi.depot.service.IBackupService;
import com.ssi.depot.service.ISystemLogService;
import com.ssi.depot.util.DateUtil;
import com.ssi.depot.util.PageUtil;
import com.ssi.depot.util.SysLogUtil;

/** 
 * CopyRright (c)2005-2014:   <极地信息Jidi Information> 
 * Project:  depot
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package com.ssi.depot.service;
 * Author：      林为 
 * Create Date： 2014年10月9日 下午4:48:28
 * Modified By：  林为 
 * Modified Date: 2014年10月9日 下午4:48:28
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
@SuppressWarnings("all")
@Service("backupService")
@Transactional
public class BackupServiceImpl implements IBackupService {

	@Autowired
	private IBackupDAO backupDao;
	@Autowired
	private ISystemLogService syslogService;
	private Map<String, Object> json;
	private Backup backup;
	private String msg = "";
	private boolean flag;
	private Integer userId;
	private String userName;
	private String SystemRemark;


	/** 
	 * 方  法 名: findBackupById
	 * 功能描述： 
	 * 输入参数: BackupServiceImpl
	 * 返 回 值:  BackupServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月9日 下午4:48:28
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月9日 下午4:48:28
	 */
	@Override
	public Map<String, Object> findBackupById(String id,ServletActionContext servletActionContext) {
		json = new HashMap<String, Object>();
		flag = false;
		msg = "未找到id为  "+ id + " 的备份信息！";
		Backup rows = backupDao.selectBackupById(id);
		if(rows != null){
			flag = true;
			json.put("rows", rows);
			
			/********添加 系统记录**********/
			Account accSession = (Account) servletActionContext.getRequest().getSession().getAttribute("account");
			userId = accSession.getId();
			userName = accSession.getRealname();
			
			SystemRemark = "管理员:" + userName + "(ID:" + userId + ") 查询 所有备份信息";

			SystemLog sys = new SystemLog();
			sys.setAccid(userId);
			sys.setSysname(SysLogUtil.SystemModule_SELECTBackup);
			sys.setSysremark(SystemRemark);
			syslogService.addSystemLog(sys, servletActionContext);
			
			/*****************************/
			
		}else{
			json.put("msg", msg);
		}
		json.put("success", flag);
		return json;
	}

	/** 
	 * 方  法 名: addBackup
	 * 功能描述： 
	 * 输入参数: BackupServiceImpl
	 * 返 回 值:  BackupServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月9日 下午4:48:28
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月9日 下午4:48:28
	 */
	@Override
	public Map<String, Object> addBackup(Backup backup,ServletActionContext servletActionContext) {
		flag = false;
		json = new HashMap<String, Object>();

		backup.setBactime(DateUtil.format(new Date()));//获得系统时间
		if (backupDao.insertBackup(backup)>0) {
			flag = true;
			msg = "备份成功！";
			
			/********添加 系统记录**********/
			Account accSession = (Account) servletActionContext.getRequest().getSession().getAttribute("account");
			userId = accSession.getId();
			userName = accSession.getRealname();
			
			SystemRemark = "管理员:" + userName + "(ID:" + userId + ") 添加备份";

			SystemLog sys = new SystemLog();
			sys.setAccid(userId);
			sys.setSysname(SysLogUtil.SystemModule_ADDBackup);
			sys.setSysremark(SystemRemark);
			syslogService.addSystemLog(sys, servletActionContext);
			
			/*****************************/
		}
		json.put("success", flag);
		json.put("msg", msg);
		return json;
	}

	/** 
	 * 方  法 名: findBackupAll
	 * 功能描述： 
	 * 输入参数: BackupServiceImpl
	 * 返 回 值:  BackupServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月9日 下午4:48:28
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月9日 下午4:48:28
	 */
	@Override
	public Map<String, Object> findBackupAll(ServletActionContext servletActionContext) {
		flag = false;
		json = new HashMap<String, Object>();
		List<Backup> rows = backupDao.selectBackupAll();
		if (rows != null) {
			flag = true;
			json.put("total", rows.size());
			json.put("rows", rows);
			
			/********添加 系统记录**********/
			Account accSession = (Account) servletActionContext.getRequest().getSession().getAttribute("account");
			userId = accSession.getId();
			userName = accSession.getRealname();
			SystemRemark = "管理员:" + userName + "(ID：" + userId + ") 查询所有备份信息";
			
			SystemLog sys = new SystemLog();
			sys.setAccid(userId);
			sys.setSysname(SysLogUtil.SystemModule_SELECTBackup);
			sys.setSysremark(SystemRemark);
			syslogService.addSystemLog(sys, servletActionContext);
			/*****************************/
		}
		json.put("success", flag);
		return json;
	}

	/** 
	 * 方  法 名: findBackupByPage
	 * 功能描述： 
	 * 输入参数: BackupServiceImpl
	 * 返 回 值:  BackupServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月9日 下午4:48:28
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月9日 下午4:48:28
	 */
	@Override
	public Map<String, Object> findBackupByPage(String page,String start,String limit,ServletActionContext servletActionContext) {
		flag = false;
		json = new HashMap<String, Object>();
		List<Backup> list = backupDao.selectBackupByPage(PageUtil.page(page, start, limit));
		if (list != null) {
			flag = true;
			json.put("total", backupDao.selectBackupAll().size());
			json.put("rows", list);
			
			/********添加 系统记录**********/
			Account accSession = (Account) servletActionContext.getRequest().getSession().getAttribute("account");
			userId = accSession.getId();
			userName = accSession.getRealname();
			SystemRemark = "管理员:" + userName + "(ID：" + userId + ") 查询所有备份信息";
			
			SystemLog sys = new SystemLog();
			sys.setAccid(userId);
			sys.setSysname(SysLogUtil.SystemModule_SELECTBackup);
			sys.setSysremark(SystemRemark);
			syslogService.addSystemLog(sys, servletActionContext);
			/*****************************/
		}
		json.put("success", flag);
		return json;
	}
	
	/** 
	 * 方  法 名: updateBackupById
	 * 功能描述： 
	 * 输入参数: BackupServiceImpl
	 * 返 回 值:  BackupServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月9日 下午4:48:28
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月9日 下午4:48:28
	 */
	@Override
	public Map<String, Object> updateBackupById(Backup backup,ServletActionContext servletActionContext) {
		flag = false;
		json = new HashMap<String, Object>();
		msg = "修改失败，请重试...";
		if (backupDao.updateBackupById(backup) > 0) {
			flag = true;
			msg = "修改成功！";
			
			/********添加 系统记录**********/
			Account accSession = (Account) servletActionContext.getRequest().getSession().getAttribute("account");
			userId = accSession.getId();
			userName = accSession.getRealname();
			SystemRemark = "管理员:" + userName + "(ID：" + userId + ") 修改备份ID：" + backup.getBacid() + " 信息";
			
			SystemLog sys = new SystemLog();
			sys.setAccid(userId);
			sys.setSysname(SysLogUtil.SystemModule_UPDATEBackup);
			sys.setSysremark(SystemRemark);
			syslogService.addSystemLog(sys, servletActionContext);
			/*****************************/
		}
		json.put("success", flag);
		json.put("msg", msg);
		return json;
	}

	/** 
	 * 方  法 名: delBackupById
	 * 功能描述： 
	 * 输入参数: BackupServiceImpl
	 * 返 回 值:  BackupServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月9日 下午4:48:28
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月9日 下午4:48:28
	 */
	@Override
	public Map<String, Object> delBackupById(String idStr,ServletActionContext servletActionContext) {
		System.out.println("---backupserviceImpl        delBackupById------------------------------");
		json = new HashMap<String, Object>();
		flag = false;
		String[] ids = idStr.split(",");
		String error = "";
		String ok = "";
		msg = "删除ID为   " + idStr + " 的备份信息失败，请重试...";
		System.out.println(" idstr  = " + idStr);
		for(int i = 0; i< ids.length; i++){
			System.out.println();
			System.out.println("=======   " + i + "    --   " + ids[i]);
			System.out.println("-----");
			if(backupDao.deleteBackupById(ids[i])>0){
				flag = true;
				ok += ids[i];
				if(i != (ids.length-1)){
					ok +=",";
				}
			}else{
				error += ids[i];
				if(i != (ids.length-2)){
					error +=",";
				}
			}
		}
		msg = "备份ID: " + ok + "  删除成功；";
		if(error.length() != 0 ){
			msg +="备份ID:" + error + " 删除失败..";
			json.put("error", error);
		}
		if(ok.length() != 0){
			
			/********添加 系统记录**********/
			Account accSession = (Account) servletActionContext.getRequest().getSession().getAttribute("account");
			userId = accSession.getId();
			userName = accSession.getRealname();

			SystemRemark = "管理员:" + userName + "(ID：" + userId + ") 删除备份ID：" + backup.getBacid() + " 信息";
			
			SystemLog sys = new SystemLog();
			sys.setAccid(userId);
			sys.setSysname(SysLogUtil.SystemModule_DELBackup);
			sys.setSysremark(SystemRemark);
			syslogService.addSystemLog(sys, servletActionContext);
			/*****************************/
		}
		json.put("ok", ok);
		json.put("success", flag);
		json.put("msg", msg);
		return json;
	}

	
	
/***********************  getter and setter  ******************************/
	/*
	 * 
	 */
	public IBackupDAO getBackupDao() {
		return backupDao;
	}

	/*
	 * 
	 */
	public Backup getBackup() {
		return backup;
	}

	/*
	 * 
	 */
	public void setBackup(Backup backup) {
		this.backup = backup;
	}

	/*
	 * 
	 */
	public void setBackupDao(IBackupDAO backupDao) {
		this.backupDao = backupDao;
	}

	/*
	 * 
	 */
	public ISystemLogService getSyslogService() {
		return syslogService;
	}

	/*
	 * 
	 */
	public void setSyslogService(ISystemLogService syslogService) {
		this.syslogService = syslogService;
	}
}
