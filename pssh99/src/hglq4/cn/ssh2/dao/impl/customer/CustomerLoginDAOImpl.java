/*
 * Copyright (c) 2010-2020 蓝桥软件 Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 蓝桥科技有限公司.
 */
package hglq4.cn.ssh2.dao.impl.customer;

import hglq4.cn.ssh2.dao.customer.ICustomerLoginDAO;
import hglq4.cn.ssh2.dao.impl.GenericDaoImpl;
import hglq4.cn.ssh2.entity.customer.CustomerLogin;

/** 
 * CopyRright (c)2008-2014:   <蓝桥软件BlueSoft> 
 * Project:  pssh99
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package hglq4.cn.ssh2.dao.impl.customer;
 * Author：      林为 
 * Create Date： 2014年8月15日 下午7:57:15
 * Modified By：  林为 
 * Modified Date: 2014年8月15日 下午7:57:15
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
//@Repository
public class CustomerLoginDAOImpl extends GenericDaoImpl<CustomerLogin,Integer> implements ICustomerLoginDAO{
	
	@Override
	public CustomerLogin findByAccountAndPassword(String account, String pwd,
			String status) {
		String hql = "from CustomerLogin c where account=? and pwd=?";
		CustomerLogin clogin = (CustomerLogin)getHibernateTemplate().find(hql,new String[]{account,pwd});
		
		return clogin;
	}


}