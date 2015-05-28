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

import com.ssi.depot.dao.ISystemLogDAO;
import com.ssi.depot.entity.Account;
import com.ssi.depot.entity.SystemLog;
import com.ssi.depot.service.ISystemLogService;
import com.ssi.depot.util.DateUtil;
import com.ssi.depot.util.PageUtil;

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
	private Map<String, Object> json;
	private SystemLog system;
	private String msg ="";
	private boolean flag;
	
	
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
	@SuppressWarnings("static-access")
	@Override
	public Map<String, Object> addSystemLog(SystemLog sys,ServletActionContext servletActionContext) {
		json = new HashMap<String, Object>();
		flag = false; 
		msg = "系统日志添加失败！";
		Account acc = (Account) servletActionContext.getRequest().getSession().getAttribute("account");
		sys.setAccid(acc.getId());//获得用户Id
		sys.setSystime(DateUtil.format(new Date()));//自动获取系统时间
		sys.setSysip(servletActionContext.getRequest().getRemoteAddr());//获得IP地址
		System.out.println(sys.toString());
		if(systemLogDao.insertSystemLog(sys) > 0){
			flag = true;
			msg = "添加成功！";
		}
		json.put("success", flag);
		json.put("msg", msg);

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
	public Map<String, Object> delSystemLog(String sysid,ServletActionContext servletActionContext) {
		json = new HashMap<String, Object>();
		flag = false; 
		String[] ids = sysid.split(",");
		String error = "";
		String ok = "";
		msg = "删除ID为   " + sysid + " 的记录失败，请重试...";
		for(int i = 0; i< ids.length; i++){
			if(systemLogDao.deleteSystemLog(ids[i])>0){
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
		msg = "系统记录ID: " + ok + "  删除成功。";
		if(error.length() != 0 ){
			msg +="系统记录ID:" + error + " 删除失败..";
		}
		json.put("success", flag);
		json.put("msg", msg);
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
	public Map<String, Object> findSystemLogById(String sysid,ServletActionContext servletActionContext) {
		json = new HashMap<String, Object>();
		flag = false; 
		msg = "未找到id为  " + sysid + " 的记录！";
		SystemLog rows = systemLogDao.selectSystemLogById(sysid);
		if(rows != null){
			flag = true;
			json.put("rows", rows);
		}else{
			json.put("msg", msg);
		}
		json.put("success", flag);
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
	public Map<String, Object> findSystemLogByAll(ServletActionContext servletActionContext) {
		json = new HashMap<String, Object>();
		flag = false; 
		List<SystemLog> rows = systemLogDao.selectSystemLogByAll();
		if (rows != null) {
			flag = true;
			json.put("total", rows.size());
			json.put("rows", rows);
		}
		json.put("success", flag);
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
	public Map<String, Object> findSystemLogByPage(String page, String start,String limit,ServletActionContext servletActionContext) {
		json = new HashMap<String, Object>();
		flag = false; 
		List<SystemLog> list = systemLogDao.selectSystemLogByPage(PageUtil.page(page, start, limit));
		if (list != null) {
			flag = true;
			json.put("total", systemLogDao.selectSystemLogByAll().size());
			json.put("rows", list);
		}
		json.put("success", flag);
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
