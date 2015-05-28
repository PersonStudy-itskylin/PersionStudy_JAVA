/*
 * Copyright (c) 2005-2020 BeiJing Jidi Information Tech Co.,Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 北京极地信息安全安全有限公司.
 */
package com.ssi.depot.dao;


import java.util.List;
import java.util.Map;

import com.ssi.depot.entity.Product;

/** 
 * CopyRright (c)2005-2014:   <极地信息Jidi Information> 
 * Project:  depot
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package com.ssi.depot.dao;
 * Author：      林为 
 * Create Date： 2014年10月10日 上午11:47:53
 * Modified By：  林为 
 * Modified Date: 2014年10月10日 上午11:47:53
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
/**
 * @author 林为
 *
 */
public interface IProductDAO {

	int insertProduct(Product product);
	
	int delProduct(String id);
	
	int updateProduct(Product product);
	
	Product selectProductById(String id);
	
	List<Product> selectProductAll();
	
	List<Product> selectProductByPage(Map<String,Integer> map);
}
