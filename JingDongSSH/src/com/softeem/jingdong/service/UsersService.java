package com.softeem.jingdong.service;

import com.softeem.jingdong.entity.UsersBean;

/**
 * 用户相关 的 业务逻辑层
 * 该层把控着所有的 用户 功能
 * @author Administrator
 *
 */
public interface UsersService {
	
	//用户登录
	public UsersBean login(UsersBean users);
	
	//用户注册
	public void register(UsersBean users);
	
}
