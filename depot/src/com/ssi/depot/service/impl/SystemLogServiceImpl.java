/*
 * Copyright (c) 2005-2020 BeiJing Jidi Information Tech Co.,Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 北京极地信息安全安全有限公司.
 */
package com.ssi.depot.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssi.depot.dao.ISystemLogDAO;
import com.ssi.depot.entity.SystemLog;
import com.ssi.depot.service.ISystemLogService;

/** 
 * CopyRright (c)2005-2014:   <极地信息Jidi Information> 
 * Project:  depot
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package com.ssi.depot.service.impl;
 * Author：      林为 
 * Create Date： 2014年10月21日 下午4:51:26
 * Modified By：  林为 
 * Modified Date: 2014年10月21日 下午4:51:26
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
@Service("systemLogService")
@Transactional
public class SystemLogServiceImpl implements ISystemLogService {

	@Autowired
	private ISystemLogDAO systemLogDao;
	private SystemLog system;
	private String msg ="";
	/** 
	 * 方  法 名: addSystemLog
	 * 功能描述： 
	 * 输入参数: SystemLogServiceImpl
	 * 返 回 值:  SystemLogServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月21日 下午4:51:26
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月21日 下午4:51:26
	 */
	@Override
	public Map<String, Object> addSystemLog(SystemLog sys) {
		Map<String,Object> json = new HashMap<String, Object>();
		boolean falg = false; 
		
		
		
		return json;
	}

	/** 
	 * 方  法 名: delSystemLog
	 * 功能描述： 
	 * 输入参数: SystemLogServiceImpl
	 * 返 回 值:  SystemLogServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月21日 下午4:51:26
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月21日 下午4:51:26
	 */
	@Override
	public Map<String, Object> delSystemLog(String sysid) {
		Map<String,Object> json = new HashMap<String, Object>();
		boolean falg = false; 
		
		
		
		return json;
	}

	/** 
	 * 方  法 名: updateSystemLog
	 * 功能描述： 
	 * 输入参数: SystemLogServiceImpl
	 * 返 回 值:  SystemLogServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月21日 下午4:51:26
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月21日 下午4:51:26
	 */
	@Override
	public Map<String, Object> updateSystemLog(SystemLog sys) {
		Map<String,Object> json = new HashMap<String, Object>();
		boolean falg = false; 
		
		
		
		return json;
	}

	/** 
	 * 方  法 名: findSystemLogById
	 * 功能描述： 
	 * 输入参数: SystemLogServiceImpl
	 * 返 回 值:  SystemLogServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月21日 下午4:51:26
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月21日 下午4:51:26
	 */
	@Override
	public Map<String, Object> findSystemLogById(String sysid) {
		Map<String,Object> json = new HashMap<String, Object>();
		boolean falg = false; 
		
		
		
		return json;
	}

	/** 
	 * 方  法 名: findSystemLogByAll
	 * 功能描述： 
	 * 输入参数: SystemLogServiceImpl
	 * 返 回 值:  SystemLogServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月21日 下午4:51:26
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月21日 下午4:51:26
	 */
	@Override
	public Map<String, Object> findSystemLogByAll() {
		Map<String,Object> json = new HashMap<String, Object>();
		boolean falg = false; 
		
		
		
		return json;
	}

	/** 
	 * 方  法 名: findSystemLogByPage
	 * 功能描述： 
	 * 输入参数: SystemLogServiceImpl
	 * 返 回 值:  SystemLogServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月21日 下午4:51:26
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月21日 下午4:51:26
	 */
	@Override
	public Map<String, Object> findSystemLogByPage(Integer page, Integer start,Integer limit) {
		Map<String,Object> json = new HashMap<String, Object>();
		boolean falg = false; 
		
		
		
		return json;
	}

	
	
	
/********************* setter and getter **************************************************/	
	public ISystemLogDAO getSystemLogDao() {
		return systemLogDao;
	}

	public void setSystemLogDao(ISystemLogDAO systemLogDao) {
		this.systemLogDao = systemLogDao;
	}

	
	public SystemLog getSystem() {
		return system;
	}
	

	public void setSystem(SystemLog system) {
		this.system = system;
	}

}
