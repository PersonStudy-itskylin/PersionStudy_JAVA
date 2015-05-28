package com.qsh.shopping.dao.impl;

import java.util.List;

import org.junit.Test;

import com.qsh.shopping.dao.UserDAO;
import com.qsh.shopping.model.User;

public class TestUserDAOImpl {

	@Test
	public void testSave(){
		UserDAO dao = new UserDAOImpl();
		User u = new User();
		u.setName("邱盛华");
		u.setPassword("123");
		u.setIP("127.0.0.1");
		//u.setRegDate()
		System.out.println("a user have saved,this is id:"+dao.save(u).getId());
		
	}
	
	@Test
	public void testCheckUserName(){
		UserDAO dao = new UserDAOImpl();
		if(dao.checkUserName("邱盛华")){
			System.out.println("此用户名已存在！");
		}else{
			System.out.println("此用户名不存在！");
		}
	}
	
	@Test
	public void testDelete(){
		UserDAO dao = new UserDAOImpl();
		if(dao.delete(1)){
			System.out.println("删除成功！");
		}else{
			System.out.println("删除失败！");
		}
	}
	
	@Test
	public void testFindAll(){
		UserDAO dao = new UserDAOImpl();
		List list = dao.findAll();
		for(int i=0;i<list.size();i++){
			User u=(User)list.get(i);
			System.out.println("username:"+u.getName());
		}
	}
	
	@Test
	public void testLogin(){
		UserDAO dao = new UserDAOImpl();
		if(null!=dao.login("邱盛华", "1234")){
			System.out.println("登陆成功！");
		}else{
			System.out.println("登陆失败！");
		}
	}
	
	@Test
	public void testUpdate(){
		UserDAO dao = new UserDAOImpl();
		
		User user = new User();
		user.setId(3);
		//user.setName("邱盛华");
		if(dao.update(user)){
			System.out.println("修改成功！");
		}else{
			System.out.println("修改失败！");
		}
	}
}
