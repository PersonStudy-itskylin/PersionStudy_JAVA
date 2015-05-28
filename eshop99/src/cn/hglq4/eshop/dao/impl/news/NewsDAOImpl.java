/*   
 * Copyright (c) 2010-2020 蓝桥软件 Ltd. All Rights Reserved.     
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with 蓝桥科技有限公司.   
 *   
 */

	
package cn.hglq4.eshop.dao.impl.news;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.hglq4.eshop.dao.impl.GenericDAOImpl;
import cn.hglq4.eshop.dao.news.INewsDAO;
import cn.hglq4.eshop.entity.news.News;

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
 * Modified Date: 2014年8月14日 上午10:15:56                                    
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0 
 */
@Repository
public class NewsDAOImpl extends GenericDAOImpl<News, Integer> implements INewsDAO {

	@Override
	public void save(News entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(News entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Class<News> entityClass, Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(News entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public News findById(Class<News> entityClass, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<News> findAll(Class<News> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> find(String hql, Object... values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalRows() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPageSize(int size) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<News> findByPage(int pageNo, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public News find(String title, String author) {
		List<News> list = getHibernateTemplate().find("from News where title=? and author=?", new Object[]{title,author});
		if(list != null&&list.size()==1){
			return list.get(0);
		}else{
		return null;
		}
	}

}
