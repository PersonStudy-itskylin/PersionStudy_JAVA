package cn.hglq4.eshop.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<T, ID extends Serializable> {

	public void save(T entity);

	public void delete(T entity);

	public void deleteById(Class<T> entityClass, ID id);

	public void update(T entity);

	public T findById(Class<T> entityClass, ID id);

	public List<T> findAll(Class<T> entityClass);

	public List<Object> find(String hql, Object... values);
	
	public int getTotalRows();  

	public int getPageSize(int size);  
	
	public List<T> findByPage(final int pageNo, final int size);  

}
