package com.hglq4.shopping.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resource.AuthenticationType;

import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.hglq4.shopping.dao.CategoryDAO;
import com.hglq4.shopping.model.Category;
import com.hglq4.shopping.util.BlueSkyException;
import com.hglq4.shopping.util.HibernateUtil;

@SuppressWarnings("all")
@Resource(name="categoryDAO",authenticationType=AuthenticationType.CONTAINER)
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired(required=true)
	HibernateUtil hibernateUtil;
	private Transaction tx = null;
	private Session sess = null;

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		HibernateUtil.getInstance();
		sess = HibernateUtil.getSession();
		tx = sess.beginTransaction();
		String hql = "delete from Category where id=" + id;
		sess.createQuery(hql);
		try {
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			System.out.println("产品分类删除失败....");
		}
		return true;
	}

	public List<Category> findAll() {
		String hql = "from Category";
		return hibernateUtil.getSession().createQuery(hql).list();
	}

	public boolean save(Category category) {
		boolean flag = false;
		try {
			sess = hibernateUtil.getSession();
			tx = sess.beginTransaction();

			sess.save(category);

			tx.commit();
			flag = true;
		} catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
			flag = false;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			hibernateUtil.close();
		}
		return flag;
	}

	public boolean saveChildCategory(int parent, Category category) {
		boolean flag = false;
		try {
			sess = hibernateUtil.getSession();
			tx = sess.beginTransaction();

			// 更新父节点，设置为非叶子
			Category pC = (Category) sess.get(Category.class, parent);
			pC.setLeaf(false);
			// 存储新的category
			category.setParent(parent);

			flag = this.save(category);

			tx.commit();
			flag = true;
		} catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
			flag = false;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			hibernateUtil.close();
		}
		return flag;
	}

	public boolean update(Category category) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			sess = hibernateUtil.getSession();
			tx = sess.beginTransaction();

			Category c = (Category) sess.load(Category.class, category.getId());
			c.setText(category.getText());
			c.setDescription(category.getDescription());

			tx.commit();
			flag = true;
		} catch (HibernateException he) {
			flag = false;
			he.printStackTrace();
			tx.rollback();
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		} finally {
			hibernateUtil.close();
		}
		return flag;
	}

	public List<Category> findByParent(int pid) {
		// TODO Auto-generated method stub
		sess = hibernateUtil.getSession();

		String hql = "from Category where parent=" + pid;

		return sess.createQuery(hql).list();
	}

	public List<Category> findTopCategory() {
		// TODO Auto-generated method stub
		sess = hibernateUtil.getSession();
		String hql = "from Category where parent=0";

		return sess.createQuery(hql).list();
	}

	public boolean updateCategoryToLeaf(int id) throws BlueSkyException {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			sess = hibernateUtil.getSession();
			tx = sess.beginTransaction();

			Category category = (Category) sess.load(Category.class, id);
			category.setLeaf(true);
			sess.saveOrUpdate(category);

			tx.commit();
			flag = true;
		} catch (ObjectNotFoundException o) {
			throw new BlueSkyException("所有记录全部删除完毕");
		} catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
			flag = false;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			hibernateUtil.close();
		}
		return flag;
	}

	public void getCategories(List<Category> list, int id) {
		// TODO Auto-generated method stub

		sess = hibernateUtil.getSession();
		sess.beginTransaction();

		Query query = sess.createQuery("from Category where parent='" + id
				+ "'");

		List<Category> categories = query.list();
		for (Category category : categories) {
			list.add(category);
			if (category.isLeaf()) {
				getCategories(list, category.getId());
				// 这样list就是一棵树,相当于深度查询
			}
		}
		sess.getTransaction().commit();
		hibernateUtil.close();
	}

}
