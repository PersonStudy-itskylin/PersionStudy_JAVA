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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssi.depot.dao.IAccountDAO;
import com.ssi.depot.entity.Account;
import com.ssi.depot.service.IAccountService;
import com.ssi.depot.util.DateUtil;
import com.ssi.depot.util.MD5Util;
import com.ssi.depot.util.PageUtil;

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
@Service("AccountService")
@Transactional
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private IAccountDAO accountDao;
	private Account account;
	private String msg= "";
	/*
	 * 根据Id查询用户信息 参数：int 返回值：Account
	 */
	@Override
	public Map<String, Object>  findAccountById(String id) {
		boolean flag = false;
		msg = "未找到id为  "+ id + " 的用户！";
		Map<String, Object> map = new HashMap<String, Object>();
		Account columns = accountDao.selectAccountById(id);
		if(columns != null){
			flag = true;
			map.put("rows", columns);
		}else{
			map.put("msg", msg);
		}
		map.put("success", flag);
		return map;
	}

	/**
	 * 
	 */
	@Override
	public Map<String, Object> addAccount(Account account) {
		boolean flag = false;
		msg = "注册失败，请重试...";
		Map<String, Object> json = new HashMap<String, Object>();

		account.setCreatetime(DateUtil.format(new Date()));//获取当前时间
		account.setPassword(MD5Util.md5(account.getPassword()));//password   MD5加密
		if (accountDao.insertAccount(account) > 0) {
			flag = true;
			msg = "注册成功！";
		}
		json.put("success", flag);
		json.put("msg", msg);
		return json;
	}

	/**
	 * 
	 */
	@Override
	public Account loginAccount(String username, String password) {
		Map<String, String> userpwd = new HashMap<String, String>();
		userpwd.put("username", username);
		userpwd.put("password", MD5Util.md5(password));
		return accountDao.loginAccountByUsernameAndPassword(userpwd);
	}

	/**
	 * 
	 */
	@Override
	public Map<String, Object> findAllAccount() {
		boolean flag = false;
		Map<String, Object> json = new HashMap<String, Object>();
		List<Account> rows = accountDao.findAllAccount();
		if (rows != null) {
			flag = true;
			json.put("total", rows.size());
			json.put("rows", rows);
		}
		json.put("success", flag);
		return json;
	}

	public Map<String, Object> findAccountPage(Integer page,Integer start,Integer limit){
		boolean flag = false;
        Map<String, Object> parmas = new HashMap<String, Object>();
		List<Account> list = accountDao.selectAccountPage(PageUtil.page(page,start, limit));
		if (list != null) {
			flag = true;
			parmas.put("total", accountDao.findAllAccount().size());
			parmas.put("rows", list);
		}
		parmas.put("success", flag);
		return parmas;
	}
	
	
	/**
	 * 
	 */
	@Override
	public Map<String, Object> updateAccountById(Account account) {
		boolean flag = false;
		Map<String, Object> map = new HashMap<String, Object>();
		String msg = "修改失败，请重试...";
		if (accountDao.updateAccountById(account) > 0) {
			flag = true;
			msg = "修改成功！";
		}
		map.put("success", flag);
		map.put("msg", msg);
		return map;
	}
	
	 
	
	
	@Override
	public Map<String, Object> deleteAccountById(String id) {
		boolean flag = false;
		Map<String, Object> map = new HashMap<String, Object>();
		msg = "删除ID为   " + id + " 的用户失败，请重试...";
		if(accountDao.deleteAccountById(id)>0){
			flag = true;
			msg = "删除成功！";
		}
		map.put("success", flag);
		map.put("msg", msg);
		return map;
	}

	/** 
	 * 方  法 名: findAccountByOption
	 * 功能描述： 
	 * 输入参数: IAccountService
	 * 返 回 值:  IAccountService
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月22日 下午3:12:37
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月22日 下午3:12:37
	 */
	@Override
	public Map<String, Object> findAccountByOption(Account account) {
		boolean flag = false;
		Map<String, Object> json = new HashMap<String, Object>();
		List<Account> accountlist = accountDao.selectAccountByOption(account);
		msg = "未找到的用户，请重试...";
		if(accountlist != null){
			flag = true;
			json.put("rows", accountlist);
			json.put("total", accountlist.size());
		}
		json.put("success", flag);
		json.put("msg", msg);
		return json;
	}

	
/********************************   setter and  getter   ******************************************/
	/**
	 * @param accountDao
	 *            要设置的 accountDao
	 */
	public void setAccountDao(IAccountDAO accountDao) {
		this.accountDao = accountDao;
	}

	/**
	 * @return account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account 要设置的 account
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

}
