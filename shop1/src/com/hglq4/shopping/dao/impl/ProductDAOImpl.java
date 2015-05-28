package com.hglq4.shopping.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resource.AuthenticationType;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.hglq4.shopping.dao.ProductDAO;
import com.hglq4.shopping.model.Product;
import com.hglq4.shopping.util.HibernateUtil;
@SuppressWarnings("all")
@Resource(name="productDAO",authenticationType=AuthenticationType.CONTAINER)
public class ProductDAOImpl implements ProductDAO {

	@Autowired(required=true)
	private HibernateUtil hibernateUtil;
	private Session sess = null;
	private Transaction tx = null;


	public boolean delete(int id) {
		// TODO Auto-generated method stub
		String hql = "delete from Product where id=" + id;

		return hibernateUtil.exeDel(hql);
	}

	@SuppressWarnings("unchecked")
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		String hql = "from Product";
		return hibernateUtil.getSession().createQuery(hql).list();
	}

	@SuppressWarnings("unchecked")
	public List<Product> findByKeyword(String keyword) {
		// TODO Auto-generated method stub
		String hql = "";
		if (null != keyword) {
			hql = "from Product where name like '%" + keyword
					+ "%' or descr like '%" + keyword + "%'";
		}
		return hibernateUtil.exeQuery(hql);
	}

	public Product save(Product product) {
		// TODO Auto-generated method stub
		Product p = null;
		try {
			sess = hibernateUtil.getSession();
			tx = sess.beginTransaction();

			p = (Product) sess.load(Product.class, sess.save(product));

			tx.commit();
			// hibernateUtil.closeSession(session);
		} catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
		return p;
	}

	public boolean update(Product product) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Transaction transaction = null;
		Session session = null;
		try {
			session = hibernateUtil.getSession();
			transaction = session.beginTransaction();

			Product p = (Product) session.load(Product.class, product.getId());
			if (null != product.getName()) {
				p.setName(product.getName());
			}
			if (null != product.getDescr()) {
				p.setDescr(product.getDescr());
			}
			if (product.getNormaPrice() != 0) {
				p.setNormaPrice(product.getNormaPrice());
			}
			if (product.getMemberPrice() != 0) {
				p.setMemberPrice(product.getMemberPrice());
			}
			if (product.getCategory() != null) {
				p.setCategory(product.getCategory());
			}
			if (product.getPhoto() != null) {
				p.setPhoto(product.getPhoto());
			}

			transaction.commit();
			flag = true;
		} catch (HibernateException he) {
			flag = false;
			he.printStackTrace();
			tx.rollback();
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
		return flag;
	}

	public List<Product> findAll(int start, int limit) {
		// TODO Auto-generated method stub
		String hql = "from Product";
		return hibernateUtil.exeQueryPage(hql, start, limit);
	}

}
