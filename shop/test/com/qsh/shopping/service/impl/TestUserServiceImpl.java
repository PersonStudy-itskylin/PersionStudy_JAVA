package com.qsh.shopping.service.impl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qsh.shopping.model.User;
import com.qsh.shopping.service.UserService;
import com.qsh.shopping.util.QshException;


public class TestUserServiceImpl {
	
	@Test
	public void testRegister(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_xml_config/beans.xml");
		UserService userService = (UserService)ctx.getBean("userService");
		
		
		User user = new User();
		user.setName("qsh");
		user.setPassword("123");
		try {
			System.out.println("id:"+userService.register(user).getId());
		}catch (QshException qe) {
			// TODO Auto-generated catch block
			System.out.println(qe);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
