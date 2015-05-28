/*   
 * Copyright (c) 2010-2020 蓝桥软件 Ltd. All Rights Reserved.     
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with 蓝桥科技有限公司.   
 *   
 */

	
package cn.hglq4.eshop.service.catalog;

import cn.hglq4.eshop.service.ServiceException;
import cn.hglq4.eshop.vo.catalog.CatalogVO;

public interface ICatalogService {
	public void add(CatalogVO vo) throws ServiceException;
	public CatalogVO find(Integer CatalogId) throws ServiceException;
}
