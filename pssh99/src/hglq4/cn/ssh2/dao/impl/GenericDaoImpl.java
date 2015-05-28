/*
 * Copyright (c) 2010-2020 蓝桥软件 Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 蓝桥科技有限公司.
 */
package hglq4.cn.ssh2.dao.impl;

import hglq4.cn.ssh2.dao.support.IGenericDao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/** 
 * CopyRright (c)2008-2014:   <蓝桥软件BlueSoft> 
 * Project:  pssh99
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package hglq4.cn.ssh2.dao.impl;
 * Author：      林为 
 * Create Date： 2014年8月15日 下午4:23:28
 * Modified By：  林为 
 * Modified Date: 2014年8月15日 下午4:23:28
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
/**
 * @author 林为
 * 
 */

@SuppressWarnings("unchecked")
public abstract class GenericDaoImpl<T, ID extends Serializable> 
	extends HibernateDaoSupport implements IGenericDao<T, ID> {

	private Class<T> clazz = null;

	/**
	 * 
	 */
	public GenericDaoImpl() {
		// TODO 自动生成的构造函数存根
		//得到当前类的子类
		Class<?> cz = getClass();
		//得到当前类的父类,e.g:GenericDAOImpl<T,ID extends Serializable>
		ParameterizedType ptype = (ParameterizedType)(cz.getGenericSuperclass());
		//得到泛型父类的第一个参数，T，强制转换成 class类型
		clazz = (Class<T>)(ptype.getActualTypeArguments()[0]);
	}

	@Override
	public void save(T entity) {
		getHibernateTemplate().save(entity);
	}

	@Override
	public void delete(T entity) {
		getHibernateTemplate().delete(entity);
	}

	@Override
	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}

	@Override
	public T get(ID id) {
		T t = (T) getHibernateTemplate().get(clazz, id);
		return t;
	}

	@Override
	public List<T> list() {
		List<T> list = getHibernateTemplate().loadAll(clazz);
		return list;
	}

}
