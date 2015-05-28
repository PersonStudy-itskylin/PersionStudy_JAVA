package com.softeem.jingdong.dao;

import com.softeem.jingdong.entity.UsersBean;

/**
 * 用户相关的 数据访问层接口
 * @author Administrator
 *
 */
public interface UsersDao {
	
	//通过 账号 和 密码 查询该用户是否存在
	public UsersBean getUsersByUsers(UsersBean users);
	
	//添加用户
	public void addUsers(UsersBean users);
}
