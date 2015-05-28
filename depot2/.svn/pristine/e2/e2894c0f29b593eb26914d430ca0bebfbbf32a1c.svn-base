/*
 * Copyright (c) 2005-2020 BeiJing Jidi Information Tech Co.,Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 北京极地信息安全安全有限公司.
 */
package com.ssi.depot.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.ssi.depot.dao.ISystemLogDAO;
import com.ssi.depot.entity.SystemLog;

/** 
 * CopyRright (c)2005-2014:   <极地信息Jidi Information> 
 * Project:  depot
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package com.ssi.depot.dao.impl;
 * Author：      林为 
 * Create Date： 2014年10月21日 下午4:32:56
 * Modified By：  林为 
 * Modified Date: 2014年10月21日 下午4:32:56
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
@Repository("systemLogDao")
public class SystemLogDAOImpl extends SqlSessionDaoSupport implements ISystemLogDAO {

	private static final String NAMESPACE = "com.ssi.depot.dao.";
	
	/** 
	 * 方  法 名: insertSystemLog
	 * 功能描述： 
	 * 输入参数: SystemLogDAOImpl
	 * 返 回 值:  SystemLogDAOImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月21日 下午4:32:56
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月21日 下午4:32:56
	 */
	@Override
	public int insertSystemLog(SystemLog sys) {
		return getSqlSession().insert(NAMESPACE + "insertSystemLog", sys);
	}

	/** 
	 * 方  法 名: deleteSystemLog
	 * 功能描述： 
	 * 输入参数: SystemLogDAOImpl
	 * 返 回 值:  SystemLogDAOImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月21日 下午4:32:56
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月21日 下午4:32:56
	 */
	@Override
	public int deleteSystemLog(String sysid) {
		return getSqlSession().delete(NAMESPACE + "deleteSystemLog", Integer.valueOf(sysid));
	}
	
	/** 
	 * 方  法 名: updateSystemLog
	 * 功能描述： 
	 * 输入参数: SystemLogDAOImpl
	 * 返 回 值:  SystemLogDAOImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月21日 下午4:32:56
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月21日 下午4:32:56
	 */
	@Override
	public int updateSystemLog(SystemLog sys) {
		return getSqlSession().update(NAMESPACE + "updateSystemLog", sys);
	}

	/** 
	 * 方  法 名: selectSystemLogByAll
	 * 功能描述： 
	 * 输入参数: SystemLogDAOImpl
	 * 返 回 值:  SystemLogDAOImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月21日 下午4:32:56
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月21日 下午4:32:56
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SystemLog> selectSystemLogByAll() {
		return getSqlSession().selectList(NAMESPACE + "selectSystemLogByAll");
	}

	/** 
	 * 方  法 名: selectSystemLogByPage
	 * 功能描述： 
	 * 输入参数: SystemLogDAOImpl
	 * 返 回 值:  SystemLogDAOImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月21日 下午4:32:56
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月21日 下午4:32:56
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SystemLog> selectSystemLogByPage(Map<String,Integer> map) {
		return getSqlSession().selectList(NAMESPACE + "selectSystemLogByPage",map);
	}

	/** 
	 * 方  法 名: selectSystemLogById
	 * 功能描述： 
	 * 输入参数: ISystemLogDAO
	 * 返 回 值:  ISystemLogDAO
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月21日 下午4:38:45
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月21日 下午4:38:45
	 */
	@Override
	public SystemLog selectSystemLogById(String sysid) {
		return (SystemLog) getSqlSession().selectOne(NAMESPACE + "selectSystemLogById",Integer.valueOf(sysid));
	}

}
