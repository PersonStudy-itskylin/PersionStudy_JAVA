/*   
 * Copyright (c) 2010-2020 蓝桥软件 Ltd. All Rights Reserved.     
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with 蓝桥科技有限公司.   
 *   
 */

	
package cn.hglq4.eshop.dao.impl.order;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.hglq4.eshop.dao.impl.GenericDAOImpl;
import cn.hglq4.eshop.dao.order.IOrderDAO;
import cn.hglq4.eshop.entity.order.Order;

/** 
 * CopyRright (c)2008-2014: <蓝桥软件BlueSoft>                          
 * Project:  eshop99_14                                          
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>    
 * Comments:  <对此类的描述，可以引用系统设计中的描述>                                           
 * JDK version used: <JDK1.6>                              
 * Namespace: cn.hglq4.eshop                                        
 * Author：张总监                
 * Create Date： 2014-8-14 
 * Modified By：  张总监                                        
 * Modified Date: 2014-8-14 上午11:42:00                                    
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0 
 */
@Repository
public class OrderDAOImpl extends GenericDAOImpl<Order,Integer> implements IOrderDAO{

public Order findById(Class<Order> entityClass, Integer id) {
		
		return null;
	}

	@Override
	public List<Order> findAll(Class<Order> entityClass) {

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
	public List<Order> findByPage(int pageNo, int size) {

		return null;
	}
}
