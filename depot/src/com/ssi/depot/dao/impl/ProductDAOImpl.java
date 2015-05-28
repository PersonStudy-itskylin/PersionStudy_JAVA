/*
 * Copyright (c) 2005-2020 BeiJing Jidi Information Tech Co.,Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 北京极地信息安全安全有限公司.
 */
package com.ssi.depot.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ssi.depot.dao.IProductDAO;
import com.ssi.depot.entity.Product;

/** 
 * CopyRright (c)2005-2014:   <极地信息Jidi Information> 
 * Project:  depot
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package com.ssi.depot.dao.impl;
 * Author：      林为 
 * Create Date： 2014年10月10日 下午1:26:16
 * Modified By：  林为 
 * Modified Date: 2014年10月10日 下午1:26:16
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
/**
 * @author 林为
 *
 */
@Repository("ProductDAO")
@Transactional
public class ProductDAOImpl extends SqlSessionDaoSupport implements IProductDAO {

	/** 
	 * 方  法 名: insertProduct
	 * 功能描述： 
	 * 输入参数: ProductDAOImpl
	 * 返 回 值:  ProductDAOImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月10日 下午1:26:16
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月10日 下午1:26:16
	 */
	@Override
	public int insertProduct(Product product) {
		return getSqlSession().insert("com.ssi.depot.dao.IProductDAO.insertProduct", product);
	}

	/* 
	 * 方  法 名: delProduct
	 * 功能描述： 
	 * 输入参数: ProductDAOImpl
	 * 返 回 值:  ProductDAOImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月10日 下午1:26:16
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月10日 下午1:26:16
	 */
	@Override
	public int delProduct(String proid) {
		return getSqlSession().delete("com.ssi.depot.dao.IProductDAO.delProduct", Integer.valueOf(proid));
	}

	/* 
	 * 方  法 名: updateProduct
	 * 功能描述： 
	 * 输入参数: ProductDAOImpl
	 * 返 回 值:  ProductDAOImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月10日 下午1:26:16
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月10日 下午1:26:16
	 */
	@Override
	public int updateProduct(Product product) {
		return getSqlSession().update("com.ssi.depot.dao.IProductDAO.updateProduct", product);
	}

	/* 
	 * 方  法 名: selectProductById
	 * 功能描述： 
	 * 输入参数: ProductDAOImpl
	 * 返 回 值:  ProductDAOImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月10日 下午1:26:16
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月10日 下午1:26:16
	 */
	@Override
	public Product selectProductById(String id) {
		return (Product) getSqlSession().selectOne("com.ssi.depot.dao.IProductDAO.selectProductById", Integer.valueOf(id));
	}

	/*
	 * 方  法 名: selectProductAll
	 * 功能描述： 
	 * 输入参数: ProductDAOImpl
	 * 返 回 值:  ProductDAOImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月10日 下午1:26:16
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月10日 下午1:26:16
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> selectProductAll() {
		return getSqlSession().selectList("com.ssi.depot.dao.IProductDAO.selectProductAll");
	}

	/*
	 * 方  法 名: selectProductByPage
	 * 功能描述： 
	 * 输入参数: ProductDAOImpl
	 * 返 回 值:  ProductDAOImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月10日 下午1:26:16
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月10日 下午1:26:16
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> selectProductByPage(Map<String, Integer> map) {
		 return getSqlSession().selectList("com.ssi.depot.dao.IProductDAO.selectProductByPage", map);
	}

}
