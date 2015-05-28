/*
 * Copyright (c) 2005-2020 BeiJing Jidi Information Tech Co.,Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 北京极地信息安全安全有限公司.
 */
package com.ssi.depot.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssi.depot.dao.IProductDAO;
import com.ssi.depot.entity.Product;
import com.ssi.depot.service.IProductService;
import com.ssi.depot.util.DateUtil;
import com.ssi.depot.util.PageUtil;

/** 
 * CopyRright (c)2005-2014:   <极地信息Jidi Information> 
 * Project:  depot
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package com.ssi.depot.service.impl;
 * Author：      林为 
 * Create Date： 2014年10月20日 下午2:28:56
 * Modified By：  林为 
 * Modified Date: 2014年10月20日 下午2:28:56
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
@Service("productService")
@Transactional
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductDAO productDao;
	private Product product;
	private String msg = "";

	/** 
	 * 方  法 名: findProductByid
	 * 功能描述： 
	 * 输入参数: ProductServiceImpl
	 * 返 回 值:  ProductServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月20日 下午2:28:56
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月20日 下午2:28:56
	 */
	@Override
	public Map<String, Object> findProductById(String id) {
		boolean flag = false;
		msg = "未找到id为  "+ id + " 的产品！";
		Map<String, Object> map = new HashMap<String, Object>();
		Product pro = productDao.selectProductById(id);
		if(pro != null){
			flag = true;
			map.put("rows", pro);
		}else{
			map.put("msg", msg);
		}
		map.put("success", flag);
		return map;
	}

	/** 
	 * 方  法 名: addProduct
	 * 功能描述： 
	 * 输入参数: ProductServiceImpl
	 * 返 回 值:  ProductServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月20日 下午2:28:56
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月20日 下午2:28:56
	 */
	@Override
	public Map<String, Object> addProduct(Product product) {
		boolean flag = false;
		msg  = "添加产品失败，请重试...";
		Map<String, Object> json = new HashMap<String, Object>();
		product.setProcreatetime(DateUtil.format(new Date()));//获得系统时间
		if (productDao.insertProduct(product) > 0) {
			flag = true;
			msg = "添加成功！";
		}
		json.put("success", flag);
		json.put("msg", msg);
		return json;
	}

	/** 
	 * 方  法 名: findProductAll
	 * 功能描述： 
	 * 输入参数: ProductServiceImpl
	 * 返 回 值:  ProductServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月20日 下午2:28:56
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月20日 下午2:28:56
	 */
	@Override
	public Map<String, Object> findProductAll() {
		boolean flag = false;
		Map<String, Object> json = new HashMap<String, Object>();
		List<Product> rows = productDao.selectProductAll();
		if (rows != null) {
			flag = true;
			json.put("total", rows.size());
			json.put("rows", rows);
		}
		json.put("success", flag);
		return json;
	}

	/** 
	 * 方  法 名: findProductPage
	 * 功能描述： 
	 * 输入参数: ProductServiceImpl
	 * 返 回 值:  ProductServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月20日 下午2:28:56
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月20日 下午2:28:56
	 */
	@Override
	public Map<String, Object> findProductPage(Integer page,Integer start, Integer pageSize) {
		boolean flag = false;
        Map<String, Object> parmas = new HashMap<String, Object>();
		List<Product> list = productDao.selectProductByPage(PageUtil.page(page,start, pageSize));
		if (list != null) {
			flag = true;
			parmas.put("total", productDao.selectProductAll().size());
			parmas.put("rows", list);
		}
		parmas.put("success", flag);
		return parmas;
	}

	/** 
	 * 方  法 名: updateProduct
	 * 功能描述： 
	 * 输入参数: ProductServiceImpl
	 * 返 回 值:  ProductServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月20日 下午2:28:56
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月20日 下午2:28:56
	 */
	@Override
	public Map<String, Object> updateProduct(Product product) {
		boolean flag = false;
		Map<String, Object> map = new HashMap<String, Object>();
		String msg = "修改失败，请重试...";

		if (productDao.updateProduct(product) > 0) {
			flag = true;
			msg = "修改成功！";
		}
		map.put("success", flag);
		map.put("msg", msg);
		return map;
	}

	/** 
	 * 方  法 名: deleteProductById
	 * 功能描述： 
	 * 输入参数: ProductServiceImpl
	 * 返 回 值:  ProductServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月20日 下午2:28:56
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月20日 下午2:28:56
	 */
	@Override
	public Map<String, Object> deleteProductById(String proid) {
		boolean flag = false;
		Map<String, Object> map = new HashMap<String, Object>();
		msg = "删除ID为   " + proid + " 的产品失败，请重试...";
		if(productDao.delProduct(proid) > 0){
			flag = true;
			msg = "删除成功！";
		}
		map.put("success", flag);
		map.put("msg", msg);
		return map;	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
/*******************   setter and getter   *********************************
 * 	
 * 方  法 名: getProductDao
 * 功能描述： 
 * 输入参数: ProductServiceImpl
 * 返 回 值:  ProductServiceImpl
 * 异    常：      <按照异常名字的字母顺序> 
 * 创 建 人:  林为
 * 创建日期: 2014年10月20日 下午2:32:59
 * 修 改 人:  Blue_Sky
 * 修改日期: 2014年10月20日 下午2:32:59
 */
	
	
	
	public IProductDAO getProductDao() {
		return productDao;
	}

	public void setProductDao(IProductDAO productDao) {
		this.productDao = productDao;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}