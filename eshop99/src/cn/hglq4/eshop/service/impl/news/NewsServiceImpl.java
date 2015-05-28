/*   
 * Copyright (c) 2010-2020 蓝桥软件 Ltd. All Rights Reserved.     
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with 蓝桥科技有限公司.   
 *   
 */

	
package cn.hglq4.eshop.service.impl.news;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hglq4.eshop.dao.news.INewsDAO;
import cn.hglq4.eshop.entity.news.News;
import cn.hglq4.eshop.service.ServiceException;
import cn.hglq4.eshop.service.news.INewsService;
import cn.hglq4.eshop.vo.news.NewsVO;

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
 * Modified Date: 2014年8月14日 上午10:21:34                                    
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0 
 */
@Service
@Transactional
public class NewsServiceImpl implements INewsService {
	
	@Autowired
	private INewsDAO newsDAOImpl;

	@Override
	public NewsVO find(String title, String author) throws ServiceException {
		News n = newsDAOImpl.find(title, author);
		NewsVO vo = new NewsVO();
		BeanUtils.copyProperties(n, vo);
		return vo;
	}
	
	

}
