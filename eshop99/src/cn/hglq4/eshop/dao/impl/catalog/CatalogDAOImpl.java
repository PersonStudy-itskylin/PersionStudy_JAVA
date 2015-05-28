/*   
 * Copyright (c) 2010-2020 蓝桥软件 Ltd. All Rights Reserved.     
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with 蓝桥科技有限公司.   
 *   
 */

package cn.hglq4.eshop.dao.impl.catalog;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.hglq4.eshop.dao.catalog.ICatalogDAO;
import cn.hglq4.eshop.dao.impl.GenericDAOImpl;
import cn.hglq4.eshop.entity.catalog.Catalog;

/**
 * CopyRright (c)2008-2014: <蓝桥软件BlueSoft> Project: eshop99 Module ID:
 * <(模块)类编号，可以引用系统设计中的类编号> Comments: <对此类的描述，可以引用系统设计中的描述> JDK version used:
 * <JDK1.6> Namespace: cn.hglq4.eshop Author：shenzhi Create Date： 2014年8月14日
 * Modified By： shenzhi Modified Date: 2014年8月14日 上午10:06:55 Why & What is
 * modified: <修改原因描述> Version: v1.0
 */
@Repository
public class CatalogDAOImpl extends GenericDAOImpl<Catalog, Integer> implements ICatalogDAO {

	

		@Override
		public Catalog find(Integer catalogId) {
			List<Catalog> list=getHibernateTemplate().find("from Catalog where catalogId=?", new Object[]{catalogId});
			if(list!=null&&list.size()==1){
				return list.get(0);
			}else{
			    return null;
			}
		}

}
