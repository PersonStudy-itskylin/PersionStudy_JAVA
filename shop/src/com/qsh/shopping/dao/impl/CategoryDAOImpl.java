package com.qsh.shopping.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qsh.shopping.dao.CategoryDAO;
import com.qsh.shopping.model.Category;
import com.qsh.shopping.util.HibernateUtil;
import com.qsh.shopping.util.QshException;

public class CategoryDAOImpl implements CategoryDAO {
	HibernateUtil hibernateUtil;

	public HibernateUtil getHibernateUtil() {
		return hibernateUtil;
	}
	@Resource
	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		String hql = "delete from Category where id="+id;
		return hibernateUtil.exeDelete(hql);
	}

	public List<Category> findAll() {
		String hql = "from Category";
		return hibernateUtil.exeQuery(hql);
	}

	public boolean save(Category category) {
		boolean flag = false;
		Transaction transaction = null;
		Session session  = null;
		try{
			session = hibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			session.save(category);
			
			transaction.commit();
			flag = true;
		}catch(HibernateException he){
			he.printStackTrace();
			hibernateUtil.rollbackTransaction(transaction);
			flag = false;
		}catch(Exception e){
			e.printStackTrace();
			flag = false;
		}finally{
			hibernateUtil.closeSession(session);
		}
		return flag;
	}
	
	public boolean saveChildCategory(int parent,Category category) {
		boolean flag = false;
		Transaction transaction = null;
		Session session  = null;
		try{
			session = hibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			//更新爷节点，设置为非叶子
			Category pC = (Category)session.get(Category.class, parent);
	        pC.setLeaf(false);
			//存储新的category
			category.setParent(parent);
			
			flag=this.save(category);
			
			transaction.commit();
			flag = true;
		}catch(HibernateException he){
			he.printStackTrace();
			hibernateUtil.rollbackTransaction(transaction);
			flag = false;
		}catch(Exception e){
			e.printStackTrace();
			flag = false;
		}finally{
			hibernateUtil.closeSession(session);
		}
		return flag;
	}

	public boolean update(Category category) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Transaction transaction = null;
		Session session  = null;
		try{
			session = hibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			Category c=(Category)session.load(Category.class, category.getId());
			c.setText(category.getText());
			c.setDescription(category.getDescription());
			
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
	public List<Category> findByParent(int pid) {
		// TODO Auto-generated method stub
		String hql = "from Category where parent="+pid;
		return hibernateUtil.exeQuery(hql);
	}
	public List<Category> findTopCategory() {
		// TODO Auto-generated method stub
		String hql = "from Category where parent=0";
		return hibernateUtil.exeQuery(hql);
	}
	public boolean updateCategoryToLeaf(int id) throws QshException{
		// TODO Auto-generated method stub
		boolean flag = false;
		Transaction transaction = null;
		Session session  = null;
		try{
			session = hibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			Category category = (Category)session.load(Category.class, id);
			category.setLeaf(true);
			session.saveOrUpdate(category);
			
			transaction.commit();
			flag = true;
		}catch(ObjectNotFoundException o){
			throw new QshException("所有记录全部删除完毕");
		}catch(HibernateException he){
			he.printStackTrace();
			hibernateUtil.rollbackTransaction(transaction);
			flag = false;
		}catch(Exception e){
			e.printStackTrace();
			flag = false;
		}finally{
			hibernateUtil.closeSession(session);
		}
		return flag;
	}
	public void getCategories(List<Category> list,int id) {
		// TODO Auto-generated method stub
		
		Session session = hibernateUtil.getSession();
		session.beginTransaction();
		
            Query query = session.createQuery("from Category where parent='"+id+"'");
            
            List<Category> categories = query.list();
            for(Category category:categories){
            	list.add(category);
            	if(category.isLeaf()){
            		getCategories(list,category.getId());
            		//这样list就是一棵树,相当于深度查询
            	}
            }

		session.getTransaction().commit();
		hibernateUtil.closeSession(session);
	}
	

}
