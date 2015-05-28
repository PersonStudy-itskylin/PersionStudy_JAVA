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

import com.ssi.depot.dao.IProductInOutDAO;
import com.ssi.depot.entity.ProductInOut;

/**
 * CopyRright (c)2005-2014: <极地信息Jidi Information> Project: depot2 Module ID:
 * <(模块)类编号，可以引用系统设计中的类编号> Comments: <对此类的描述，可以引用系统设计中的描述> JDK version used:
 * <JDK1.6> Namespace: package com.ssi.depot.dao.impl; Author： 林为 Create Date：
 * 2014年10月28日 上午9:56:57 Modified By： 林为 Modified Date: 2014年10月28日 上午9:56:57
 * Why & What is modified: <修改原因描述> Version: v1.0
 */
@Repository("productInOutDAO")
@Transactional
public class ProductInOutDAOImpl extends SqlSessionDaoSupport implements IProductInOutDAO {

	private static final String NAMESPACE = "com.ssi.depot.dao.";
	
	/**
	 * 方 法 名: insertProductInOut 
	 * 功能描述： 
	 * 输入参数: ProductInOutDAOImpl 
	 * 返 回 值:ProductInOutDAOImpl 
	 * 异 常： <按照异常名字的字母顺序> 
	 * 创 建 人: 林为
	 *  创建日期: 2014年10月28日  上午9:56:57 
	 * 修 改 人: Blue_Sky 
	 * 修改日期: 2014年10月28日 上午9:56:57
	 */
	@Override
	public int insertProductInOut(ProductInOut productInOut) {
		return getSqlSession().insert(NAMESPACE + "insertProductInOut", productInOut);
	}

	/**
	 * 方 法 名: delProductInOut 
	 * 功能描述： 
	 * 输入参数: ProductInOutDAOImpl 
	 * 返 回 值:  ProductInOutDAOImpl 
	 * 异 常： <按照异常名字的字母顺序> 
	 * 创 建 人: 林为 
	 * 创建日期: 2014年10月28日 上午9:56:57 
	 * 修 改 人: Blue_Sky 
	 * 修改日期: 2014年10月28日 上午9:56:57
	 */
	@Override
	public int delProductInOut(String pioid) {
		return getSqlSession().delete(NAMESPACE + "deleteProductInOutById",Integer.valueOf(pioid));
	}

	@Override
	public int updateProductInOut(ProductInOut productInOut) {
		return getSqlSession().update(NAMESPACE + "updateProductInOutById",productInOut);
	}

	/**
	 * 方 法 名: selectProductInOutById 
	 * 功能描述：
	 *  输入参数: ProductInOutDAOImpl 
	 *  返 回 值: ProductInOutDAOImpl 
	 * 异 常： <按照异常名字的字母顺序> 
	 * 创 建 人: 林为 
	 * 创建日期: 2014年10月28日  上午9:56:57 
	 * 修 改 人: Blue_Sky 
	 * 修改日期: 2014年10月28日 上午9:56:57
	 */
	@Override
	public ProductInOut selectProductInOutById(String pioid) {
		return (ProductInOut) getSqlSession().selectOne(NAMESPACE + "selectProductInOutById",Integer.valueOf(pioid));
	}

	/**
	 * 方 法 名: selectProductInOutAll 
	 * 功能描述： 
	 * 输入参数: ProductInOutDAOImpl 
	 * 返 回 值:  ProductInOutDAOImpl 
	 * 异 常： <按照异常名字的字母顺序> 
	 * 创 建 人: 林为 创建日期: 2014年10月28日  上午9:56:57 
	 * 修 改 人: Blue_Sky 
	 * 修改日期: 2014年10月28日 上午9:56:57
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductInOut> selectProductInOutAll() {
		return getSqlSession().selectList(NAMESPACE + "selectProductInOutAll");
	}

	/**
	 * 方 法 名: selectProductInOutByPage 
	 * 功能描述： 
	 * 输入参数: ProductInOutDAOImpl 
	 * 返 回 值:  ProductInOutDAOImpl 
	 * 异 常： <按照异常名字的字母顺序> 
	 * 创 建 人: 林为 
	 * 创建日期: 2014年10月28日  上午9:56:57 
	 * 修 改 人: Blue_Sky 
	 * 修改日期: 2014年10月28日 上午9:56:57
	 */
	@SuppressWarnings("unchecked")
	public List<ProductInOut> selectProductInOutByPage(Map<String, Integer> map) {
		return getSqlSession().selectList(NAMESPACE + "selectProductInOutPage",map);
	}

	/** 
	 * 方  法 名: selectProductInOutByProductInOut
	 * 功能描述： 检查产品是否重复
	 * 输入参数: IProductInOutDAO
	 * 返 回 值:  IProductInOutDAO
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年11月27日 下午3:33:22
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年11月27日 下午3:33:22
	 */
	@Override
	public ProductInOut selectProductInOutByProductInOut(
			ProductInOut productInOut) {
		return (ProductInOut) getSqlSession().selectOne(NAMESPACE + "selectProductInOutByProductInOut",productInOut);
	}

}
