package com.softeem.jingdong.dao.impl;

import java.sql.SQLException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.softeem.jingdong.dao.UsersDao;
import com.softeem.jingdong.entity.UsersBean;

/**
 * 实现父接口
 * @author Administrator
 *
 */
public class UsersDaoImpl implements UsersDao {
	
	//HibernateTeamplate 模板类
	private HibernateTemplate template;
	
	/**
	 * 通过 账号 和 密码 查询该用户信息
	 * 如果该用户信息存在 则返回 对象 . 否则 返回 null
	 * @throws SQLException 
	 */
	public UsersBean getUsersByUsers(UsersBean users){
		//返回结果对象
		String hql = "FROM UsersBean u WHERE u.name = ? AND u.password = ?";
		return (UsersBean)template.find(hql,new Object[]{users.getName(),users.getPassword()}).get(0);
	}
	
	/**
	 * 添加用户信息
	 */
	public void addUsers(UsersBean users){
		template.save(users);
	}

	public HibernateTemplate getTemplate() {
		return template;
	}
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	
}
