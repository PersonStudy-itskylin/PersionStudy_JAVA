package cn.hglq4.eshop.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.hglq4.eshop.dao.IGenericDAO;


public class GenericDAOImpl<T, ID extends Serializable> extends HibernateDaoSupport implements
		IGenericDAO<T, ID> {
	private Class<T> clazz;
	 
	
	public GenericDAOImpl(){
		  clazz=(Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	  
	}

	@Override
	public void save(T entity) {
		getHibernateTemplate().save(entity);

	}

	@Override
	public void delete(T entity) {


	}

	@Override
	public void deleteById(Class<T> entityClass, ID id) {


	}

	@Override
	public void update(T entity) {


	}

	@Override
	public T findById(Class<T> entityClass, ID id) {
		
		return null;
	}

	@Override
	public List<T> findAll(Class<T> entityClass) {

		return null;
	}

	@Override
	public List<Object> find(String hql, Object... values) {

		return null;
	}

	@Override
	public int getTotalRows() {

		return 0;
	}

	@Override
	public int getPageSize(int size) {

		return 0;
	}

	@Override
	public List<T> findByPage(int pageNo, int size) {

		return null;
	}

}
