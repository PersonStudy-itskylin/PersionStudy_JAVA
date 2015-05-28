package com.hglq4.shopping.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.QueryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hglq4.shopping.dao.UserDAO;
import com.hglq4.shopping.model.User;
import com.hglq4.shopping.service.UserService;

//@Service("userService")
@Transactional
@Resource(name ="userService")
@Service("userService")
public class UserServiceImpl implements UserService {


	@Autowired(required=true)
	private UserDAO userDao;
	
	public UserDAO getUserDao() {
		return userDao;
	}
	
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

	public User register(User user) throws QueryException{
		// TODO Auto-generated method stub
		User u = null;
		if(!checkUserName(user.getName())){
			u=userDao.save(user);
		}else{
			throw new QueryException("用户名已存在！");
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
