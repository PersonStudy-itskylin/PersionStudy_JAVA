/*   
 * Copyright (c) 2010-2020 蓝桥软件 Ltd. All Rights Reserved.     
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with 蓝桥科技有限公司.   
 *   
 */

	
package cn.hglq4.eshop.dao.impl.menu;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import cn.hglq4.eshop.dao.impl.GenericDAOImpl;
import cn.hglq4.eshop.dao.menu.IMenuDAO;
import cn.hglq4.eshop.entity.menu.Menu;
import cn.hglq4.eshop.vo.menu.MenuVO;

/** 
 * CopyRright (c)2008-2014: <蓝桥软件BlueSoft>                          
 * Project:  eshop99                                          
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>    
 * Comments:  <对此类的描述，可以引用系统设计中的描述>                                           
 * JDK version used: <JDK1.6>                              
 * Namespace: cn.hglq4.eshop                                        
 * Author：张总监                
 * Create Date： 2014年8月14日 
 * Modified By：  张总监                                        
 * Modified Date: 2014年8月14日 上午10:44:25                                    
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0 
 */

public class MenuDAOImpl extends GenericDAOImpl<MenuVO, Integer> implements IMenuDAO{
	public List<Menu> find(String hql, Map<String, Object> params) {
		
		Query q=getSession(true).createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		List<Menu> list=q.list();
		return list;
	}
	
	public List<Menu> find(String hql) {
		
		Query q=getSession(true).createQuery(hql);
		
		List<Menu> list=q.list();
		return list;
	}
}
