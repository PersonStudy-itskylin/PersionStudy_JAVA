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

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssi.depot.dao.IAccountDAO;
import com.ssi.depot.entity.Account;
import com.ssi.depot.entity.SystemLog;
import com.ssi.depot.service.IAccountService;
import com.ssi.depot.service.ISystemLogService;
import com.ssi.depot.util.DateUtil;
import com.ssi.depot.util.MD5Util;
import com.ssi.depot.util.MenuUtil;
import com.ssi.depot.util.PageUtil;
import com.ssi.depot.util.SysLogUtil;

/**
 * CopyRright (c)2005-2014: <极地信息Jidi Information> Project: warehouse Module ID:
 * <(模块)类编号，可以引用系统设计中的类编号> Comments: <对此类的描述，可以引用系统设计中的描述> JDK version used:
 * <JDK1.6> Namespace: package cn.hglq4.ssi.warehouse.service.impl; Author： 林为
 * Create Date： 2014年9月26日 下午2:50:12 Modified By： 林为 Modified Date: 2014年9月26日
 * 下午2:50:12 Why & What is modified: <修改原因描述> Version: v1.0
 */
@SuppressWarnings("all")
@Service("AccountService")
@Transactional
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private IAccountDAO accountDao;
	@Autowired
	private ISystemLogService syslogService;
	private Map<String, Object> json;
	private Account account;
	private SystemLog systemLog;
	private SystemLog syslog;
	private String msg = "";
	private boolean flag;
	private HttpSession session;
	private String SystemRemark;// 系统操作记录
	private Integer userId;
	private String userName;

	/**
	 * 
	 * 方 法 名: findAccountById 功能描述：根据用户ID查询用户信息 输入参数: AccountServiceImpl 返 回 值:
	 * AccountServiceImpl 异 常： <按照异常名字的字母顺序> 创 建 人: 林为 创建日期: 2014年11月24日
	 * 下午4:27:18 修 改 人: Blue_Sky 修改日期: 2014年11月24日 下午4:27:18
	 */
	@Override
	public Map<String, Object> findAccountById(String id,
			ServletActionContext servletActionContext) {
		flag = false;
		msg = "未找到id为  " + id + " 的用户！";
		Map<String, Object> json = new HashMap<String, Object>();
		Account rows = accountDao.selectAccountById(id);
		if (rows != null) {
			flag = true;
			json.put("rows", rows);
			Account accSession = (Account) servletActionContext.getRequest()
					.getSession().getAttribute("account");

			/******** 添加 系统记录 **********/
			userId = rows.getId();
			userName = rows.getRealname();

			SystemRemark = "管理员:" + userName + "(ID:" + userId + ") 查询用户ID："
					+ rows.getId();
			SystemLog sys = new SystemLog();
			sys.setAccid(userId);
			sys.setSysname(SysLogUtil.SystemModule_ADDUser);
			sys.setSysremark(SystemRemark);
			syslogService.addSystemLog(sys, servletActionContext);

			/*****************************/
		} else {
			json.put("msg", msg);
		}
		json.put("success", flag);
		return json;
	}

	/**
	 * 
	 * 方 法 名: addAccount 功能描述： 输入参数: AccountServiceImpl 返 回 值:
	 * AccountServiceImpl 异 常： <按照异常名字的字母顺序> 创 建 人: 林为 创建日期: 2014年11月24日
	 * 下午4:27:10 修 改 人: Blue_Sky 修改日期: 2014年11月24日 下午4:27:10
	 */
	@Override
	public Map<String, Object> addAccount(Account account,
			ServletActionContext servletActionContext) {
		json = new HashMap<String, Object>();
		flag = false;
		msg = "注册失败，请重试...";

		account.setCreatetime(DateUtil.format(new Date()));// 获取当前时间
		account.setIp(servletActionContext.getRequest().getRemoteAddr());// 得到用户IP地址
		account.setPassword(MD5Util.md5to32bit(account.getPassword()));// password
																		// MD5加密
		if (accountDao.insertAccount(account) > 0) {
			flag = true;
			msg = "注册成功！";

			/******** 添加 系统记录 **********/

			SystemRemark = "管理员:" + account.getRealname() + "(ID:"
					+ account.getId() + ") 添加账户";
			SystemLog sys = new SystemLog();
			sys.setAccid(account.getId());
			sys.setSysname(SysLogUtil.SystemModule_ADDUser);
			sys.setSysremark(SystemRemark);
			syslogService.addSystemLog(sys, servletActionContext);

			/*****************************/
		}
		json.put("success", flag);
		json.put("msg", msg);
		return json;
	}

	/**
	 * @category 登陆查询
	 * @param username
	 * @param password
	 * @return Account
	 */
	@Override
	public Account loginAccount(String username, String password,
			ServletActionContext servletActionContext) {
		Map<String, String> userpwd = new HashMap<String, String>();
		json = new HashMap<String, Object>();
		userpwd.put("username", username);// 用户名
		userpwd.put("password", MD5Util.md5to32bit(password));// 加密密码
		Account acc = accountDao.loginAccountByUsernameAndPassword(userpwd);
		session = servletActionContext.getRequest().getSession();

		if (acc != null) {
			session.setAttribute("account", acc);
			/*
			 * //菜单树 String menu = ""; switch (acc.getRole()) { case 0: menu =
			 * "root:[" + MenuUtil.AccountMenu + "," + MenuUtil.DepotMenu + ","
			 * + MenuUtil.SystemLogMenu + "]"; break; case 1: menu = "root:[" +
			 * MenuUtil.AccountMenu + "," + MenuUtil.ProductMenu + "," +
			 * MenuUtil.SystemLogMenu + "]"; break; case 2: menu = "root:[" +
			 * MenuUtil.AccountMenu + "," + MenuUtil.ProductInOutMenu + "," +
			 * MenuUtil.SystemLogMenu + "]"; break;
			 * 
			 * default:
			 * 
			 * break; }
			 */
			/******** 添加 系统记录 **********/
			SystemRemark = "管理员:" + acc.getRealname() + "(ID:" + acc.getId()
					+ ") 登陆";
			SystemLog sys = new SystemLog();
			sys.setAccid(acc.getId());
			sys.setSysname(SysLogUtil.SystemModule_Login);
			sys.setSysremark(SystemRemark);
			syslogService.addSystemLog(sys, servletActionContext);

			/*****************************/
		}
		return acc;
	}

	/**
	 * 
	 * 方 法 名: findAllAccount 功能描述： 输入参数: AccountServiceImpl 返 回 值:
	 * AccountServiceImpl 异 常： <按照异常名字的字母顺序> 创 建 人: 林为 创建日期: 2014年11月24日
	 * 下午4:26:59 修 改 人: Blue_Sky 修改日期: 2014年11月24日 下午4:26:59
	 */
	@Override
	public Map<String, Object> findAllAccount(
			ServletActionContext servletActionContext) {
		json = new HashMap<String, Object>();
		flag = false;
		List<Account> rows = accountDao.findAllAccount();
		if (rows != null) {
			flag = true;
			json.put("total", rows.size());
			json.put("rows", rows);

			/******** 添加 系统记录 **********/
			Account accSession = (Account) servletActionContext.getRequest()
					.getSession().getAttribute("account");
			userId = accSession.getId();
			userName = accSession.getRealname();
			SystemRemark = "管理员:" + userName + "(ID:" + userId + ") 查询 所有用户";

			SystemLog sys = new SystemLog();
			sys.setAccid(userId);
			sys.setSysname(SysLogUtil.SystemModule_SELECTUser);
			sys.setSysremark(SystemRemark);
			syslogService.addSystemLog(sys, servletActionContext);

			/*****************************/
		}
		json.put("success", flag);
		return json;
	}

	/**
	 * 
	 * 方 法 名: findAccountPage 功能描述： 输入参数: AccountServiceImpl 返 回 值:
	 * AccountServiceImpl 异 常： <按照异常名字的字母顺序> 创 建 人: 林为 创建日期: 2014年11月24日
	 * 下午4:26:55 修 改 人: Blue_Sky 修改日期: 2014年11月24日 下午4:26:55
	 */
	public Map<String, Object> findAccountPage(String page, String start,
			String limit, ServletActionContext servletActionContext) {
		json = new HashMap<String, Object>();
		flag = false;
		List<Account> list = accountDao.selectAccountPage(PageUtil.page(page,
				start, limit));
		if (list != null) {
			flag = true;
			json.put("total", accountDao.findAllAccount().size());
			json.put("rows", list);

			/******** 添加 系统记录 **********/
			userId = ((Account) servletActionContext.getRequest().getSession()
					.getAttribute("account")).getId();
			userName = ((Account) servletActionContext.getRequest()
					.getSession().getAttribute("account")).getRealname();
			SystemRemark = null;
			SystemRemark = "管理员:" + userName + "(ID：" + userId + ") 查询 所有用户";

			SystemLog sys = new SystemLog();
			sys.setAccid(userId);
			sys.setSysname(SysLogUtil.SystemModule_SELECTUser);
			sys.setSysremark(SystemRemark);
			syslogService.addSystemLog(sys, servletActionContext);
			/*****************************/
		}
		json.put("success", flag);
		return json;
	}

	/**
	 * 
	 * 方 法 名: updateAccountById 功能描述： 输入参数: AccountServiceImpl 返 回 值:
	 * AccountServiceImpl 异 常： <按照异常名字的字母顺序> 创 建 人: 林为 创建日期: 2014年11月24日
	 * 下午4:26:49 修 改 人: Blue_Sky 修改日期: 2014年11月24日 下午4:26:49
	 */
	@Override
	public Map<String, Object> updateAccountById(Account account,
			ServletActionContext servletActionContext) {
		json = new HashMap<String, Object>();
		flag = false;
		String msg = "修改失败，请重试...";
		account.setPassword(MD5Util.md5to32bit(account.getPassword()));// 加密
		if (accountDao.updateAccountById(account) > 0) {
			flag = true;
			msg = "修改成功！";

			/******** 添加 系统记录 **********/
			Account accSession = (Account) servletActionContext.getRequest()
					.getSession().getAttribute("account");
			userId = accSession.getId();
			userName = accSession.getRealname();

			SystemRemark = "管理员:" + userName + "(ID:" + userId + ") 修改用户ID:"
					+ account.getId();

			SystemLog sys = new SystemLog();
			sys.setAccid(userId);
			sys.setSysname(SysLogUtil.SystemModule_UPDATEUser);
			sys.setSysremark(SystemRemark);
			syslogService.addSystemLog(sys, servletActionContext);

			/*****************************/
		}
		json.put("success", flag);
		json.put("msg", msg);
		return json;
	}

	@Override
	public Map<String, Object> deleteAccountById(String idStr,
			ServletActionContext servletActionContext) {
		json = new HashMap<String, Object>();
		flag = false;
		String[] ids = idStr.split(",");
		String error = "";
		String ok = "";
		msg = "删除ID为   " + idStr + " 的用户失败，请重试...";
		System.out.println(" idstr  = " + idStr);
		for (int i = 0; i < ids.length; i++) {
			Account accIfRoot = accountDao.selectAccountById(ids[i]);
			System.out.println();
			System.out.println("=======   " + i + "    --   " + ids[i]);
			System.out.println("-----");
			if (accountDao.deleteAccountById(ids[i]) > 0) {
				flag = true;
				ok += ids[i];
				if (i != (ids.length - 1)) {
					ok += ",";
				}
			} else {
				error += ids[i];
				if (i != (ids.length - 2)) {
					error += ",";
				}
			}
		}
		msg = "用户ID: " + ok + "  删除成功;";
		if (error.length() != 0) {
			msg += "用户ID:" + error + " 删除失败..";
			json.put("error", error);
		}
		if (ok.length() != 0) {
			/******** 添加 系统记录 **********/
			Account accSession = (Account) servletActionContext.getRequest()
					.getSession().getAttribute("account");
			userId = accSession.getId();
			userName = accSession.getRealname();

			SystemRemark = "管理员:" + userName + "(ID:" + userId + ") 删除 ID:"
					+ ok;

			SystemLog sys = new SystemLog();
			sys.setAccid(userId);
			sys.setSysname(SysLogUtil.SystemModule_DELUser);
			sys.setSysremark(SystemRemark);
			syslogService.addSystemLog(sys, servletActionContext);

			/*****************************/
		}
		json.put("ok", ok);
		json.put("success", flag);
		json.put("msg", msg);
		return json;
	}

	/**
	 * 方 法 名: selectAccountBySome 功能描述：
	 * 
	 * @param: Account account 需要选择条件查询的信息
	 * @param: ServletActionCOntext servletActionContext
	 * @return Map<String, Object> json 返回查询出来的所有信息 创 建 人: 林为 创建日期: 2014年10月23日
	 *         下午1:00:07 修 改 人: Blue_Sky 修改日期: 2014年10月23日 下午1:00:07
	 */
	@Override
	public Map<String, Object> findAccountBySome(Account account,
			ServletActionContext servletActionContext) {
		json = new HashMap<String, Object>();
		flag = false;
		List<Account> rows = accountDao.selectAccountBySome(account);
		if (rows != null) {
			flag = true;
			json.put("total", rows.size());
			json.put("rows", rows);

			/******** 添加 系统记录 **********/
			Account accSession = (Account) servletActionContext.getRequest().getSession().getAttribute("account");
			userId = accSession.getId();
			userName = accSession.getRealname();
			String AccountId = null;
			for (Account a : rows) {// 得到查询的用户ID
				AccountId += a.getId() + ",";
			}
			SystemRemark = "管理员:" + userName + "(ID:" + userId + ") 选择查询 ID: "
					+ AccountId.substring(0, AccountId.length() - 2);
			SystemLog sys = new SystemLog();
			sys.setAccid(userId);
			sys.setSysname(SysLogUtil.SystemModule_SELECTUser);
			sys.setSysremark(SystemRemark);
			syslogService.addSystemLog(sys, servletActionContext);

			/*****************************/
		} else {
			msg = "查询失败，请重试...";
		}
		json.put("success", flag);
		json.put("msg", msg);
		return json;
	}

	/**
	 * 方 法 名: loginOut 功能描述： 输入参数: IAccountService 返 回 值: IAccountService 异 常：
	 * <按照异常名字的字母顺序> 创 建 人: 林为 创建日期: 2014年11月6日 下午1:17:45 修 改 人: Blue_Sky 修改日期:
	 * 2014年11月6日 下午1:17:45
	 */
	@Override
	public Map<String, Object> loginOut(
			ServletActionContext servletActionContext) {
		json = new HashMap<String, Object>();
		Account acc = (Account) session.getAttribute("account");

		/******** 添加 系统记录 **********/

		SystemRemark = "管理员:" + acc.getRealname() + "(ID:" + acc.getId()
				+ ") 退出登录";
		SystemLog sys = new SystemLog();
		sys.setAccid(userId);
		sys.setSysname(SysLogUtil.SystemModule_LoginOut);
		sys.setSysremark(SystemRemark);
		syslogService.addSystemLog(sys, servletActionContext);

		/*****************************/
		session.removeAttribute("account");
		
		json.put("success", true);
		json.put("msg", "注销成功！");
		return json;
	}

	/******************************** setter and getter ******************************************/
	/**
	 * @param accountDao
	 *            要设置的 accountDao
	 */
	public void setAccountDao(IAccountDAO accountDao) {
		this.accountDao = accountDao;
	}

	public IAccountDAO getAccountDao() {
		return accountDao;
	}

	/**
	 * @return account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account
	 *            要设置的 account
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	public SystemLog getSystemLog() {
		return systemLog;
	}

	public void setSystemLog(SystemLog systemLog) {
		this.systemLog = systemLog;
	}

	public ISystemLogService getSyslogService() {
		return syslogService;
	}

	public void setSyslogService(ISystemLogService syslogService) {
		this.syslogService = syslogService;
	}

	public SystemLog getSyslog() {
		return syslog;
	}

	public void setSyslog(SystemLog syslog) {
		this.syslog = syslog;
	}

}
