/*   
 * Copyright (c) 2010-2020 蓝桥软件 Ltd. All Rights Reserved.     
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with 蓝桥科技有限公司.   
 *   
 */

	
package cn.hglq4.eshop.service.order;

import java.util.List;

import cn.hglq4.eshop.service.ServiceException;
import cn.hglq4.eshop.vo.Page;
import cn.hglq4.eshop.vo.order.OrderVO;

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
 * Modified Date: 2014年8月14日 下午4:26:32                                    
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0 
 */

public interface IOrderService {
	public void addOrder(OrderVO order)throws ServiceException;
	public  List<OrderVO> find(OrderVO order)throws ServiceException;
	public  Page<OrderVO> page(OrderVO order,int currpage,int pageSize)throws ServiceException;
}
