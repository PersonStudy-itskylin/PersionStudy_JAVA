/*
 * Copyright (c) 2005-2020 BeiJing Jidi Information Tech Co.,Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 北京极地信息安全安全有限公司.
 */
package com.ssi.depot.util;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssi.depot.dao.ISystemLogDAO;
import com.ssi.depot.entity.SystemLog;

/** 
 * CopyRright (c)2005-2014:   <极地信息Jidi Information> 
 * Project:  depot2
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package com.ssi.depot.util;
 * Author：      林为 
 * Create Date： 2014年11月6日 下午2:12:09
 * Modified By：  林为 
 * Modified Date: 2014年11月6日 下午2:12:09
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
public class SysLogUtil {
	
	/*****  用户模块   ******/
	public static final String SystemModule_Login = "用户登陆";
	public static final String SystemModule_LoginOut = "用户注销";
	public static final String SystemModule_ADDUser = "注册用户";
	public static final String SystemModule_DELUser = "删除用户";
	public static final String SystemModule_UPDATEUser = "修改用户";
	public static final String SystemModule_SELECTUser = "用户查询";

	/*****  产品模块   ******/
	public static final String SystemModule_ADDProduct = "产品入库";
	public static final String SystemModule_DELProduct = "删除产品";
	public static final String SystemModule_UPDATEProduct = "修改产品";
	public static final String SystemModule_SELECTProduct = "查询产品";

	/*****  出库模块   ******/
	public static final String SystemModule_ADDProductInOut = "产品出库";
	public static final String SystemModule_DELProductInOut = "删除产品出库";
	public static final String SystemModule_UPDATEProductInOut = "修改产品出库";
	public static final String SystemModule_SELECTProductInOut = "查询产品出库";

	/*****  备份模块   ******/
	public static final String SystemModule_ADDBackup = "添加备份";
	public static final String SystemModule_DELBackup = "删除备份";
	public static final String SystemModule_UPDATEBackup = "修改备份";
	public static final String SystemModule_SELECTBackup = "查询备份";
	
	private static SysLogUtil syslogUtil;
	@Autowired
	private ISystemLogDAO syslogDao;
	private SystemLog sys = new SystemLog();
	
	private SysLogUtil() {
		// TODO 自动生成的构造函数存根
	}
	
	/**
	 * 
	 * 方  法 名: getInstance
	 * 功能描述： 实例化SysLogUtil
	 * 输入参数: SysLogUtil
	 * 返 回 值:  SysLogUtil
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年11月25日 上午10:47:53
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年11月25日 上午10:47:53
	 */
	public static SysLogUtil getInstance(){
		if(syslogUtil == null){
			syslogUtil = new SysLogUtil();
		}
		return syslogUtil;
	}
	
	
	/** 
	 * 方  法 名: addSysLog
	 * 功能描述： 
	 * 输入参数: SystemLogUtil
	 * 返 回 值:  SystemLogUtil
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年11月6日 下午2:12:49
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年11月6日 下午2:12:49
	 */
	@SuppressWarnings("static-access")
	public boolean addSysLog(Integer userId,String SystemModule,String SystemRemark,ServletActionContext servletActionContext) {
		HttpServletRequest request = servletActionContext.getRequest();
		sys.setAccid(userId);
		sys.setSysname(SystemModule);
		sys.setSysremark(SystemRemark);
		sys.setSystime(DateUtil.format(new Date()));//获取系统时间
		sys.setSysip(request.getRemoteAddr());//添加IP地址
		int code = syslogDao.insertSystemLog(sys);
		System.out.println(code);
		return code > 0?true:false;
	}
	
/*********************  getter and setter  *********************/

	public ISystemLogDAO getSyslogDao() {
		return syslogDao;
	}

	public void setSyslogDao(ISystemLogDAO syslogDao) {
		this.syslogDao = syslogDao;
	}


}
