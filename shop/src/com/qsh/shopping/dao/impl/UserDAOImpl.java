package com.qsh.shopping.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qsh.shopping.dao.UserDAO;
import com.qsh.shopping.model.User;
import com.qsh.shopping.util.HibernateUtil;

public class UserDAOImpl implements UserDAO {

	private HibernateUtil hibernateUtil;

	public HibernateUtil getHibernateUtil() {
		return hibernateUtil;
	}
	@Resource
	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	public boolean checkUserName(String username) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.name='"+username+"'";
		if(hibernateUtil.exeQuery(hql).size() > 0){
			return true;
		}
		return false;
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		String hql = "delete from User where id="+id;
		return hibernateUtil.exeDelete(hql);
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		String hql = "from User";
		return hibernateUtil.exeQuery(hql);
	}

	public User login(String name, String password) throws IndexOutOfBoundsException{
		// TODO Auto-generated method stub
		User user = null;
		String hql = "from User where name='"+name+"' and password='"+password+"'";
		
		user=(User)hibernateUtil.exeQuery(hql).get(0);
		
		return user;
	}

	public User save(User user) {
		// TODO Auto-generated method stub
		User u = null;
		Transaction transaction = null;
		Session session  = null;
		try{
			session = hibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			u=(User)session.load(User.class, session.save(user));
			
			transaction.commit();
			//hibernateUtil.closeSession(session);
		}catch(HibernateException he){
			he.printStackTrace();
			hibernateUtil.rollbackTransaction(transaction);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			hibernateUtil.closeSession(session);
		}
		return u;
	}

	public boolean update(User user) {
		boolean flag = false;
		Transaction transaction = null;
		Session session  = null;
		try{
			session = hibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			User u=(User)session.load(User.class, user.getId());
			u.setName(user.getName());
			u.setPassword(user.getPassword());
			u.setAddr(user.getAddr());
			u.setEmail(user.getEmail());
			u.setPhone(user.getPhone());
			u.setQQ(user.getQQ());
			
			transaction.commit();
			flag = true;
		}catch(HibernateException he){
			flag = false;
			he.printStackTrace();
			hibernateUtil.rollbackTransaction(transaction);
		}catch(Exception e){
			flag = false;
			e.printStackTrace();
		}finally{
			hibernateUtil.closeSession(session);
		}
		return flag;
	}
	public List<User> findAll(int start, int end) {
		// TODO Auto-generated method stub
		String hql = "from User";
		return hibernateUtil.exeQueryPage(hql, start, end);
	}

}
