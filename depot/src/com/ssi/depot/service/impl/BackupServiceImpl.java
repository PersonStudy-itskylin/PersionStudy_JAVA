/*
 * Copyright (c) 2005-2020 BeiJing Jidi Information Tech Co.,Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 北京极地信息安全安全有限公司.
 */
package com.ssi.depot.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssi.depot.dao.IBackupDAO;
import com.ssi.depot.entity.Backup;
import com.ssi.depot.service.IBackupService;
import com.ssi.depot.util.PageUtil;

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
/**
 * @author 林为
 *
 */
@Service("backupService")
@Transactional
public class BackupServiceImpl implements IBackupService {

	@Autowired
	private IBackupDAO backupDao;
	private Backup backup;
	private String msg ="";



	/* 
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
	public Map<String,Object> findBackupById(String id) {
		Map<String,Object> json = new HashMap<String,Object>();
		boolean flag = false;
		msg = "未找到id为  "+ id + " 的记录！";
		Backup columns = backupDao.selectBackupById(id);
		if(columns != null){
			flag = true;
			json.put("rows", columns);
		}else{
			json.put("msg", msg);
		}
		json.put("success", flag);
		return json;
	}

	/* 
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
	public Map<String, Object> addBackup(Backup backup) {
		boolean flag = false;
		msg = "备份失败，请重试...";
		Map<String, Object> json = new HashMap<String, Object>();

		if (backupDao.insertBackup(backup) > 0) {
			flag = true;
			msg = "备份成功！";
		}
		json.put("success", flag);
		json.put("msg", msg);
		return json;
	}

	/* 
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
	public Map<String, Object> findBackupAll() {
		boolean flag = false;
		Map<String, Object> json = new HashMap<String, Object>();
		List<Backup> backuplist = backupDao.selectBackupAll();
		if (backuplist != null) {
			flag = true;
		}
		json.put("success", flag);
		json.put("total", backuplist.size());
		json.put("rows", backuplist);
		return json;
	}

	/* 
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
	public Map<String, Object> findBackupByPage(Integer page,Integer start,Integer limit) {
		boolean flag = false;
		Map<String, Object> json = new HashMap<String, Object>();
		List<Backup> backupList = backupDao.selectBackupByPage(PageUtil.page(page ,start, limit));
		if (backupList != null) {
			flag = true;
		}
		json.put("success", flag);
		json.put("total", backupDao.selectBackupAll().size());
		json.put("rows", backupList);
		return json;
	}
	
	/* 
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
	public Map<String, Object> updateBackupById(Backup backup) {
		boolean flag = false;
		Map<String, Object> json = new HashMap<String, Object>();
		String msg = "修改失败，请重试...";
		if (backupDao.updateBackupById(backup) > 0) {
			flag = true;
			msg = "修改成功！";
		}
		json.put("success", flag);
		json.put("msg", msg);
		return json;
	}

	/* 
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
	public Map<String, Object> delBackupById(String id) {
		boolean flag = false;
		msg = "备份删除失败，请重试...";
		Map<String, Object> json = new HashMap<String, Object>();
		if(backupDao.deleteBackupById(id)>0){
			flag = true;
			msg = "备份删除成功！";
		}
		json.put("success", flag);
		json.put("msg", msg);
		return json;
	}

	
/*****************  setter and getter  ************************/	
	/**
	 * @return backupDao
	 */
	public IBackupDAO getBackupDao() {
		return backupDao;
	}

	/**
	 * @return backup
	 */
	public Backup getBackup() {
		return backup;
	}

	/**
	 * @param backup 要设置的 backup
	 */
	public void setBackup(Backup backup) {
		this.backup = backup;
	}

	/**
	 * @param backupDao 要设置的 backupDao
	 */
	public void setBackupDao(IBackupDAO backupDao) {
		this.backupDao = backupDao;
	}
}