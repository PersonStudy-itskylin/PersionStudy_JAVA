package com.hglq4.shopping.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resource.AuthenticationType;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.hglq4.shopping.dao.UserDAO;
import com.hglq4.shopping.model.User;
import com.hglq4.shopping.util.HibernateUtil;
@SuppressWarnings("all")
@Resource(name="userDAO",authenticationType=AuthenticationType.CONTAINER)
public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	@Autowired(required=true)
	private HibernateUtil hibernateUtil;
	private Transaction tx = null;
	private Session sess  = null;



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
		return hibernateUtil.exeDel(hql);
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
		
		user=(User)hibernateUtil.exeQuery(hql).get(1);
		
		return user;
	}

	public User save(User user) {
		// TODO Auto-generated method stub
		User u = null;
		try{
			sess = hibernateUtil.getSession();
			tx = sess.beginTransaction();
			
			u=(User)sess.load(User.class, sess.save(user));
			
			tx.commit();
			//hibernateUtil.close();
		}catch(HibernateException he){
			he.printStackTrace();
			tx.rollback();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			hibernateUtil.close();
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
			tx.rollback();
		}catch(Exception e){
			flag = false;
			e.printStackTrace();
		}finally{
			hibernateUtil.close();
		}
		return flag;
	}
	public List<User> findAll(int start, int end) {
		// TODO Auto-generated method stub
		String hql = "from User";
		return hibernateUtil.exeQueryPage(hql, start, end);
	}

}
