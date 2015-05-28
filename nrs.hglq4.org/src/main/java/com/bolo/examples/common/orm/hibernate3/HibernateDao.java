package com.bolo.examples.common.orm.hibernate3;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Criterion;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.bolo.examples.common.utils.ReflectUtils;
import com.bolo.examples.common.web.Page;

/**
 * 扩展HibernateDaoSupport的泛型基类
 * @author 菠萝大象
 * @param <T> 实体类型
 */
@Repository
public class HibernateDao<T> extends HibernateDaoSupport{

	protected Class<T> entityClass;

	/**
	 * 在构造函数中利用反射机制获得参数T的具体类
	 */
	public HibernateDao() {
		entityClass = ReflectUtils.getClassGenricType(getClass());
	}
	
	/**
	 * 根据实体类与ID获得对象
	 * @param clazz 实体类
	 * @param id 主键ID
	 */
    @SuppressWarnings("unchecked")
	public <X> X get(final Class<X> clazz, final Serializable id) {
		return (X) getSession().get(clazz, id);
	}
    
    /**
     * 根据id获得对象
     * @param id 主键ID
     */
    public T get(Serializable id){
        return get(entityClass, id);
    }
    
    /**
     * 删除对象
     * @param entity 实体类
     */
	public void delete(final Object entity) {
		getSession().delete(entity);
	}

	/**
	 * 根据ID删除对象
	 * @param id 主键ID
	 */
	public void delete(final Serializable id) {
		delete(get(id));
	}
	
	/**
	 * 根据实体类与ID删除对象
	 * @param clazz 实体类
	 * @param id 主键ID
	 */
	@SuppressWarnings("unchecked")
	public void delete(@SuppressWarnings("rawtypes") final Class clazz, final Serializable id){
		delete(get(clazz,id));
	}
    
    /**
	 * 保存对象
	 * @param entity 保存的实体对象
	 */
	public void save(final Object entity) {
		getSession().saveOrUpdate(entity);
	}

	/**
	 * 获取所有数据
	 * @param entityClass 参数T的反射类型
	 */
	@SuppressWarnings("unchecked")
	public <X> List<X> getAll(final Class<X> entityClass) {
		return createCriteria(entityClass).list();
	}
	
	/**
	 * 获取所有数据
	 */
	public List<T> getAll() {
		return query();
	}
	
	/**
	 * 根据条件获取数据
	 * @param criterions 数量可变的Criterion
	 */
	@SuppressWarnings("unchecked")
	public List<T> query(final Criterion... criterions) {
		return createCriteria(criterions).list();
	}
	
	/**
	 * HQL方式查询
	 * @param hql 符合HQL语法的查询语句
	 * @param values 数量可变的条件值,按顺序绑定
	 */
	public Query createQuery(final String hql, final Object... values){
        Query query = getSession().createQuery(hql);
        int j = values.length;
        for(int i = 0; i < j; i++)
            query.setParameter(i, values[i]);
        return query;
    }
    
	/**
	 * SQL方式查询
	 * @param sql 符合SQL语法的查询语句
	 * @param values 数量可变的条件值,按顺序绑定
	 */
    public SQLQuery createSQLQuery(final String sql,final Object... values){
        SQLQuery query = getSession().createSQLQuery(sql);
        if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
        return query;
    }
    
    /**
     * 根据类型创建查询对象
     * @param clazz 类型
     */
    public Criteria createCriteria(@SuppressWarnings("rawtypes") final Class clazz) {
		return getSession().createCriteria(clazz);
	}
    
    /**
     * 对象化查询
     * @param entityClass 参数T的反射类型
     * @param criterions 数量可变的Criterion
     */
    @SuppressWarnings("rawtypes")
	public Criteria createCriteria(final Class clazz, final Criterion... criterions){
        Criteria criteria = getSession().createCriteria(clazz);
        for (Criterion c : criterions) {
			criteria.add(c);
		}
        return criteria;
    }
    
    /**
     * 对象化查询
     * @param criterions 数量可变的Criterion
     */
    public Criteria createCriteria(final Criterion... criterions){
    	return createCriteria(entityClass, criterions);
    }
    
    /**
	 * @Description         分页加载对象
	 * @param currentPage   当前页
	 * @param pageSize      每页显示的记录数
	 * @param hql           查询语句
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Page<T> page(int currentPage, int pageSize) {
		
		int totalRows = getSession().createQuery("from "+entityClass.getSimpleName()).list().size();
		
		List<T> data = getSession().createQuery("from "+entityClass.getSimpleName()).setFirstResult((currentPage-1)*pageSize).setMaxResults(pageSize).list();
		
		return new Page<T>(totalRows, currentPage, pageSize, (currentPage-1)*pageSize+1, data);
	}
}