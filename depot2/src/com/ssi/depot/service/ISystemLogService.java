/*
 * Copyright (c) 2005-2020 BeiJing Jidi Information Tech Co.,Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 北京极地信息安全安全有限公司.
 */
package com.ssi.depot.service;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.ssi.depot.entity.SystemLog;

/**
 * CopyRright (c)2005-2014: <极地信息Jidi Information> Project: depot Module ID:
 * <(模块)类编号，可以引用系统设计中的类编号> Comments: <对此类的描述，可以引用系统设计中的描述> JDK version used:
 * <JDK1.6> Namespace: package com.ssi.depot.service; Author： 林为 Create Date：
 * 2014年10月21日 下午4:47:56 Modified By： 林为 Modified Date: 2014年10月21日 下午4:47:56
 * Why & What is modified: <修改原因描述> Version: v1.0
 */
public interface ISystemLogService {

	Map<String, Object> delSystemLog(String sysid,ServletActionContext servletContext);

	Map<String, Object> addSystemLog(SystemLog sys,ServletActionContext servletContext);

	Map<String, Object> findSystemLogById(String sysid,ServletActionContext servletContext);

	Map<String, Object> findSystemLogByAll(ServletActionContext servletContext);

	Map<String, Object> findSystemLogByPage(String page, String start,String limit, ServletActionContext servletContext);
	
	
}
