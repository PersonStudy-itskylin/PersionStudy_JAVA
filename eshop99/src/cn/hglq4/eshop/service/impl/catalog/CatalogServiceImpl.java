/*   
 * Copyright (c) 2010-2020 蓝桥软件 Ltd. All Rights Reserved.     
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with 蓝桥科技有限公司.   
 *   
 */

	
package cn.hglq4.eshop.service.impl.catalog;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hglq4.eshop.dao.catalog.ICatalogDAO;
import cn.hglq4.eshop.entity.catalog.Catalog;
import cn.hglq4.eshop.service.ServiceException;
import cn.hglq4.eshop.service.catalog.ICatalogService;
import cn.hglq4.eshop.vo.catalog.CatalogVO;

/** 
 * CopyRright (c)2008-2014: <蓝桥软件BlueSoft>                          
 * Project:  eshop99                                          
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>    
 * Comments:  <对此类的描述，可以引用系统设计中的描述>                                           
 * JDK version used: <JDK1.6>                              
 * Namespace: cn.hglq4.eshop                                        
 * Author：shenzhi                
 * Create Date： 2014年8月14日 
 * Modified By： shenzhi                                     
 * Modified Date: 2014年8月14日 下午2:51:49                                    
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0 
 */
@Service
@Transactional
public class CatalogServiceImpl implements ICatalogService {

	
	@Autowired
	private ICatalogDAO catalogDAOImpl;
	@Override
	public void add(CatalogVO vo) throws ServiceException {
		// TODO Auto-generated method stub
		Catalog entity=new Catalog();
		BeanUtils.copyProperties(vo, entity);
		catalogDAOImpl.save(entity);
	}

	@Override
	public CatalogVO find(Integer catalogId) throws ServiceException {
		Catalog u=catalogDAOImpl.find(catalogId);
		CatalogVO vo=new CatalogVO();
		BeanUtils.copyProperties(u, vo);
		
		return vo;
	}
	

}
