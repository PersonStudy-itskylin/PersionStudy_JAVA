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

import com.ssi.depot.dao.IAccountDAO;
import com.ssi.depot.entity.Account;

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
@Repository("AccountDao")
public class AccountDAOImpl extends SqlSessionDaoSupport implements IAccountDAO {

	
	@Override
	public Account selectAccountById(String id) {
		return (Account) getSqlSession().selectOne("com.ssi.depot.dao.IAccountDAO.selectAccountById", Integer.valueOf(id));
	}

	/* （非 Javadoc）
	 * @see com.ssi.depot.dao.IAccountDAO#insertAccount(com.ssi.depot.entity.Account)
	 */
	@Override
	public int insertAccount(Account account) {
		return getSqlSession().insert("com.ssi.depot.dao.IAccountDAO.insertAccount", account);
	}

	/* （非 Javadoc）
	 * @see com.ssi.depot.dao.IAccountDAO#loginAccountByUsernameAndPassword(com.ssi.depot.entity.Account)
	 */
	@Override
	public Account loginAccountByUsernameAndPassword(Map<String, String> map) {
		return (Account)getSqlSession().selectOne("com.ssi.depot.dao.IAccountDAO.loginAccountByUsernameAndPassword", map);
	}

	/* （非 Javadoc）
	 * @see com.ssi.depot.dao.IAccountDAO#findAllAccount()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Account> findAllAccount() {
		return getSqlSession().selectList("com.ssi.depot.dao.IAccountDAO.selectAccountAll");
	}

	/* （非 Javadoc）
	 * @see com.ssi.depot.dao.IAccountDAO#updateAccountById(com.ssi.depot.entity.Account)
	 */
	@Override
	public int updateAccountById(Account account) {
		return getSqlSession().update("com.ssi.depot.dao.IAccountDAO.updateAccountById", account);
	}

	/* （非 Javadoc）
	 * @see com.ssi.depot.dao.IAccountDAO#deleteAccountById(java.lang.Integer)
	 */
	@Override
	public int deleteAccountById(String id) {
		return getSqlSession().delete("com.ssi.depot.dao.IAccountDAO.deleteAccountById",Integer.valueOf(id));
	}
	/* 
	 * 方  法 名: selectAccountCount
	 * 功能描述： 
	 * 输入参数: IAccountDAO
	 * 返 回 值:  IAccountDAO
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月13日 上午11:24:17
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月13日 上午11:24:17
	 */
	@Override
	public Integer selectAccountCount() {
		return getSqlSession().delete("com.ssi.depot.dao.IAccountDAO.selectAccountCount");
	}

	/* 
	 * 方  法 名: selectAccountPage
	 * 功能描述： 
	 * 输入参数: IAccountDAO
	 * 返 回 值:  IAccountDAO
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月13日 下午12:29:13
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月13日 下午12:29:13
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Account> selectAccountPage(Map<String, Integer> map) {
		return getSqlSession().selectList("com.ssi.depot.dao.IAccountDAO.selectAccountPage",map);
	}

	/** 
	 * 方  法 名: selectAccountByOption
	 * 功能描述： 
	 * 输入参数: IAccountDAO
	 * 返 回 值:  IAccountDAO
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月22日 下午1:47:43
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月22日 下午1:47:43
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Account> selectAccountByOption(Account account) {
		return getSqlSession().selectList("com.ssi.depot.dao.IAccountDAO.selectAccountByOption", account);
	}
}
