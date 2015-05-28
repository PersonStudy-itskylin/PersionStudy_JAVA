/*
 * Copyright (c) 2005-2020 BeiJing Jidi Information Tech Co.,Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 北京极地信息安全安全有限公司.
 */
package com.ssi.depot.service;

import java.util.Map;

import com.ssi.depot.entity.Account;

/** 
 * CopyRright (c)2005-2014:   <极地信息Jidi Information> 
 * Project:  warehouse
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package cn.ssi.depot.service;
 * Author：      林为 
 * Create Date： 2014年9月26日 下午2:49:12
 * Modified By：  林为 
 * Modified Date: 2014年9月26日 下午2:49:12
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
/**
 * @author 林为
 *
 */
public interface IAccountService {

	Map<String, Object> findAccountById(String id);
	
	Map<String, Object> addAccount(Account account);
	
	Account loginAccount(String username,String password);

	Map<String, Object> findAllAccount();
	
	Map<String, Object> findAccountPage(Integer page,Integer start,Integer pageSize);
	
	Map<String, Object> updateAccountById(Account account);
	
	Map<String, Object> deleteAccountById(String id);
	
	Map<String, Object> findAccountByOption(Account account);
}
