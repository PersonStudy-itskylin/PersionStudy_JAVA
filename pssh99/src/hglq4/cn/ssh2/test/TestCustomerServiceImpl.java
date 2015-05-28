/*
 * Copyright (c) 2010-2020 蓝桥软件 Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 蓝桥科技有限公司.
 */
package hglq4.cn.ssh2.test;

import hglq4.cn.ssh2.dao.customer.ICustomerLoginDAO;
import hglq4.cn.ssh2.service.customer.ICustomerService;
import hglq4.cn.ssh2.util.BlueSkyException;
import hglq4.cn.ssh2.vo.LoginVO;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.annotations.Test;

/** 
 * CopyRright (c)2008-2014:   <蓝桥软件BlueSoft> 
 * Project:  pssh99
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package hglq4.cn.ssh2.test;
 * Author：      林为 
 * Create Date： 2014年8月15日 下午8:22:34
 * Modified By：  林为 
 * Modified Date: 2014年8月15日 下午8:22:34
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
/**
 * @author 林为
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring.xml")
public class TestCustomerServiceImpl {
	@Autowired
	ICustomerService customerServiceImpl;
	@Autowired
	ICustomerLoginDAO customerlDaoImpl;
	private LoginVO login;
	/** 
	 * 方  法 名: setUp
	 * 功能描述： 
	 * 输入参数: TestCustomerLoginDAOImpl
	 * 返 回 值:  TestCustomerLoginDAOImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年8月15日 下午8:22:57
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年8月15日 下午8:22:57
	 */
	private void setUp() throws Exception{
		login = new LoginVO();
		login.setAccount("1943");
		login.setPwd("");
		login.setStatus("1");
	}
	
	/** 
	 * 方  法 名: tearDown
	 * 功能描述： 
	 * 输入参数: TestCustomerLoginDAOImpl
	 * 返 回 值:  TestCustomerLoginDAOImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年8月15日 下午8:24:28
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年8月15日 下午8:24:28
	 */
	private void tearDown() throws Exception {
	}
	/**
	 * {@link hglq4.cn.ssh2.dao.impl.customer.CustomerLoginDAOImpl#findByAccountAndPassword(java.lang.String, java.lang.String, java.lang.String)} 的测试方法。
	 */
	@Test
	public void testLogin(){
		try {
			customerServiceImpl.login(login);
		} catch (BlueSkyException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	/**
	 * {@link hglq4.cn.ssh2.dao.impl.GenericDaoImpl#list()} 的测试方法。
	 */
	@Test
	public void testList() {
		
	}

}
