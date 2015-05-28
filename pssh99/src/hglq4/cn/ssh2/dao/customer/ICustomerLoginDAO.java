/*
 * Copyright (c) 2010-2020 蓝桥软件 Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 蓝桥科技有限公司.
 */
package hglq4.cn.ssh2.dao.customer;

import hglq4.cn.ssh2.dao.support.IGenericDao;
import hglq4.cn.ssh2.entity.customer.CustomerLogin;

/**
 * CopyRright (c)2008-2014: <蓝桥软件BlueSoft> 
 * Project: pssh99 
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号> 
 * Comments: <对此类的描述，可以引用系统设计中的描述> 
 * JDK version used: <JDK1.6> 
 * Namespace: package hglq4.cn.ssh2.dao.customer; 
 * Author： 林为 
 * Create Date： 2014年8月15日 下午5:03:51 
 * Modified By： 林为 
 * Modified Date: 2014年8月15日下午5:03:51 
 * Why & What is modified: <修改原因描述> 
 * Version: v1.0
 */
public interface ICustomerLoginDAO extends IGenericDao<CustomerLogin, Integer> {
	
	/**
	 * 
	 * 方  法 名: findByAccountAndPassword
	 * 功能描述： 查询用户账号，密码，状态，用于登陆验证
	 * 输入参数:  String account,
	 * 		    String pwd,
	 * 			String status
	 * 返 回 值:  CustomerLogin
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年8月15日 下午5:13:23
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年8月15日 下午5:13:23
	 */
	CustomerLogin findByAccountAndPassword(String account, String pwd,String status);
	
}