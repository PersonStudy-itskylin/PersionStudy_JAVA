package com.softeem.jingdong.service.impl;

import com.softeem.jingdong.dao.UsersDao;
import com.softeem.jingdong.entity.UsersBean;
import com.softeem.jingdong.service.UsersService;

/**
 * 用户 业务逻辑
 * 该层可以写任何逻辑 .
 * @author Administrator
 *
 */
public class UsersServiceImpl implements UsersService {
	
	//创建 Dao 对象
	private UsersDao usersDao;
	
	//用户登录
	public UsersBean login(UsersBean users){
		return usersDao.getUsersByUsers(users);
	}
	
	//用户注册
	public void register(UsersBean users){
		usersDao.addUsers(users);
	}

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}
}
