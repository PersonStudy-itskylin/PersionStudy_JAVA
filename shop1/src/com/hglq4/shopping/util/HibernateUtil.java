package com.hglq4.shopping.util;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

@SuppressWarnings("rawtypes")
public class HibernateUtil {
	private static SessionFactory sf = null;
	private static HibernateUtil instance = new HibernateUtil();
	private List list = null;
	private Transaction tx = null;
	private Session sess = null;

	private HibernateUtil() {
		// TODO Auto-generated constructor stub
		Configuration cfg = new Configuration().configure();
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(
				cfg.getProperties()).buildServiceRegistry();
		sf = cfg.buildSessionFactory(sr);
	}

	public static HibernateUtil getInstance() {
		return instance;
	}

	public static Session getSession() {
		// TODO Auto-generated method stub
		return sf.openSession();
	}

	/**
	 * 返回一个List集合
	 */
	public List exeQuery(String hql) {
		try {
			sess = getSession();
			tx = sess.beginTransaction();

			list = sess.createQuery(hql).list();

			tx.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	/**
	 * 分页查询
	 */
	public List exeQueryPage(String hql, int start, int end) {
		try {
			sess = getSession();
			tx = sess.beginTransaction();

			list = sess.createQuery(hql).setFirstResult(start)
					.setMaxResults(end).list();

			tx.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public boolean exeDel(String hql) {
		boolean flag = false;
		try {
			sess = getSession();
			tx = sess.beginTransaction();

			sess.createQuery(hql).executeUpdate();

			tx.commit();
			flag = true;
		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;

		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		} finally {
			close();
		}
		return flag;
	}

	public static void close() {
		// TODO Auto-generated method stub
		if (sf != null) {
			sf.close();
		}
	}

}
