package com.qsh.shopping.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;

import com.qsh.shopping.dao.UserDAO;
import com.qsh.shopping.model.User;
import com.qsh.shopping.service.UserService;
import com.qsh.shopping.util.QshException;

public class UserServiceImpl implements UserService {
	
	UserDAO userDao;
	
	public UserDAO getUserDao() {
		return userDao;
	}
	@Resource
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public boolean checkUserName(String username) {
		// TODO Auto-generated method stub
		return userDao.checkUserName(username);
	}

	public List<User> getPersons() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	public User login(String name, String password) throws IndexOutOfBoundsException{
		// TODO Auto-generated method stub
		return userDao.login(name, password);
	}

	public boolean modify(User p) {
		// TODO Auto-generated method stub
		return userDao.update(p);
	}

	public User register(User user) throws QshException{
		// TODO Auto-generated method stub
		User u = null;
		if(!checkUserName(user.getName())){
			u=userDao.save(user);
		}else{
			throw new QshException("用户名已存在！");
		}
		return u;
	}

	public boolean remove(String[] ids) {
		// TODO Auto-generated method stub
		boolean flag = false;
		for(int i=0;i<ids.length;i++){
			
			flag = userDao.delete(Integer.parseInt(ids[i])); 
		}
		return flag;
			
	}
	public List<User> getPersons(int start, int end) {
		// TODO Auto-generated method stub
		return userDao.findAll(start, end);
	}
	public int getCount() {
		// TODO Auto-generated method stub
		return this.getPersons().size();
	}

}
