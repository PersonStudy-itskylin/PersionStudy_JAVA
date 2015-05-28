package com.hglq4.shopping.dao.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.annotation.Resource.AuthenticationType;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.hglq4.shopping.dao.SalesOrderDAO;
import com.hglq4.shopping.model.SaleItem;
import com.hglq4.shopping.model.SalesOrder;
import com.hglq4.shopping.util.HibernateUtil;

@SuppressWarnings("all")
@Resource(name="salesOrderDAO")
public class SalesOrderDAOImpl extends HibernateDaoSupport implements SalesOrderDAO {

	@Autowired(required=true)
	private HibernateUtil hibernateUtil;
	private Transaction tx = null;
	private Session sess  = null;


	public boolean delete(SalesOrder order) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			sess = hibernateUtil.getSession();
			tx = sess.beginTransaction();
			
			SalesOrder o=(SalesOrder)sess.load(SalesOrder.class, order.getId());
			//false表示作废
			o.setNullify(false);
			
			tx.commit();
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

	public List<SalesOrder> findALL() {
		// TODO Auto-generated method stub
		String hql = "from SalesOrder";
		return hibernateUtil.exeQuery(hql);
	}
	
	public List<SalesOrder> findALL(int start, int end){
		String hql = "from SalesOrder";
		return hibernateUtil.exeQueryPage(hql, start, end);
	}
	
	public List<SalesOrder> findByOderCode(String orderCode){
		String hql = "from SalesOrder where orderCode='"+orderCode+"'";
		return hibernateUtil.exeQuery(hql);
	}

	public boolean save(SalesOrder order) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			sess = hibernateUtil.getSession();
			tx = sess.beginTransaction();
			
			sess.save(order);
			
			Set<SaleItem> sis = order.getSaleItems();
			for(SaleItem si:sis){
				sess.save(si);
			}
			
			tx.commit();
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

	public boolean verify(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			sess = hibernateUtil.getSession();
			tx = sess.beginTransaction();
			
			SalesOrder o=(SalesOrder)sess.load(SalesOrder.class, id);
			//true表示已审核
			o.setStatus(true);
			
			tx.commit();
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
	public List<SalesOrder> findByOderUser(String username) throws IndexOutOfBoundsException{
		// TODO Auto-generated method stub
		String hql = "from SalesOrder where user='"+username+"'";
		return hibernateUtil.exeQuery(hql);
	}
	public List<SalesOrder> findALL(String id) {
		// TODO Auto-generated method stub
		String hql = "from SalesOrder where id="+id;
		return hibernateUtil.exeQuery(hql);
	}

}
