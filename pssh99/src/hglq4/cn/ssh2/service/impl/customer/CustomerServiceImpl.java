/*
 * Copyright (c) 2010-2020 蓝桥软件 Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 蓝桥科技有限公司.
 */
package hglq4.cn.ssh2.service.impl.customer;

import hglq4.cn.ssh2.dao.customer.ICustomerDAO;
import hglq4.cn.ssh2.dao.customer.ICustomerLoginDAO;
import hglq4.cn.ssh2.entity.customer.Customer;
import hglq4.cn.ssh2.entity.customer.CustomerLogin;
import hglq4.cn.ssh2.service.customer.ICustomerService;
import hglq4.cn.ssh2.util.BlueSkyException;
import hglq4.cn.ssh2.vo.CustomerVO;
import hglq4.cn.ssh2.vo.LoginVO;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** 
 * CopyRright (c)2008-2014:   <蓝桥软件BlueSoft> 
 * Project:  pssh99
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package hglq4.cn.ssh2.service.impl.customer;
 * Author：      林为 
 * Create Date： 2014年8月16日 下午7:20:29
 * Modified By：  林为 
 * Modified Date: 2014年8月16日 下午7:20:29
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
/**
 * @author 林为
 *
 */
@Transactional
@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerLoginDAO customerLoginDAOImpl;
	@Autowired
	private ICustomerDAO customerDAOImpl;
	
	@Override
	public CustomerVO login(LoginVO login) throws BlueSkyException{
		//注入CustomerLoginDAOImpl，根据login表得到customer_id
		CustomerLogin  clogin = customerLoginDAOImpl.findByAccountAndPassword(login.getAccount(), login.getPwd(), login.getStatus());
		Integer cid = clogin.getCustomerId();
		
		//注入CustomerDAOImpl，根据customer_id，得到name和其他信息
		Customer customer = customerDAOImpl.get(cid);
		
		//返回控制层的VO
		CustomerVO cvo = new CustomerVO();
		//将实体转换为VO
		BeanUtils.copyProperties(customer, cvo);
		return cvo;
	}
}
