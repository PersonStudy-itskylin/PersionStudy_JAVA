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
import org.springframework.transaction.annotation.Transactional;

import com.ssi.depot.dao.IBackupDAO;
import com.ssi.depot.entity.Backup;

/** 
 * CopyRright (c)2005-2014:   <极地信息Jidi Information> 
 * Project:  warehouse
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package cn.hglq4.ssi.warehouse.service.impl;
 * Author：      林为 
 * Create Date： 2014年9月26日 下午2:50:12
 * Modified By：  林为 
 * Modified Date: 2014年9月26日 下午2:50:12
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
/**
 * @author 林为
 *
 */
@Transactional
@Repository("BackupDao")
public class BackupDAOImpl extends SqlSessionDaoSupport implements IBackupDAO{

	/* （非 Javadoc）
	 * @see com.ssi.depot.dao.IBackupDAO#selectBackupById(java.lang.Integer)
	 */
	@Override
	public Backup selectBackupById(String id) {
		return (Backup) getSqlSession().selectOne("com.ssi.depot.dao.IBackupDAO.selectBackupById", id);
	}

	/* （非 Javadoc）
	 * @see com.ssi.depot.dao.IBackupDAO#insertBackup(com.ssi.depot.entity.Backup)
	 */
	@Override
	public int insertBackup(Backup backup) {
		System.out.println(backup.getBactime()+"\t+++++++++++++++++++++++++--------------");
		return getSqlSession().insert("com.ssi.depot.dao.IBackupDAO.insertBackup", backup);
	}

	/* （非 Javadoc）
	 * @see com.ssi.depot.dao.IBackupDAO#selectBackupAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Backup> selectBackupAll() {
		return getSqlSession().selectList("com.ssi.depot.dao.IBackupDAO.selectBackupAll");
	}

	/* （非 Javadoc）
	 * @see com.ssi.depot.dao.IBackupDAO#pageBackup(java.lang.Integer, java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Backup> selectBackupByPage(Map<String ,Integer> map) {
		return getSqlSession().selectList("com.ssi.depot.dao.IBackupDAO.selectBackupByPage",map);
	}

	/* （非 Javadoc）
	 * @see com.ssi.depot.dao.IBackupDAO#updateAccountById(com.ssi.depot.entity.Backup)
	 */
	@Override
	public int updateBackupById(Backup backup) {
		return getSqlSession().update("com.ssi.depot.dao.IBackupDAO.updateBackupById",backup);
	}

	/* （非 Javadoc）
	 * @see com.ssi.depot.dao.IBackupDAO#deleteBackupById(java.lang.Integer)
	 */
	@Override
	public int deleteBackupById(String id) {
		return getSqlSession().delete("com.ssi.depot.dao.IBackupDAO.deleteBackupById", id);
	}
}