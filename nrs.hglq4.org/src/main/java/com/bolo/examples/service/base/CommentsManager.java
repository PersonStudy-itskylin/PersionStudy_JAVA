/*
 * Copyright (c) 2010-2020 蓝桥软件 Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 蓝桥科技有限公司.
 */
package com.bolo.examples.service.base;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.bolo.examples.common.orm.hibernate3.HibernateDao;
import com.bolo.examples.common.web.Page;
import com.bolo.examples.dao.base.CommentsDao;
import com.bolo.examples.entity.base.Article;
import com.bolo.examples.entity.base.Comments;

/** 
 * CopyRright (c)2008-2014:   <蓝桥软件BlueSoft> 
 * Project:  nrs.hglq4.org
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package com.bolo.examples.service.base;
 * Author：      林为 
 * Create Date： 2014年8月14日 下午4:49:47
 * Modified By：  林为 
 * Modified Date: 2014年8月14日 下午4:49:47
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
/**
 * @author Blue_Sky
 * 
 */
@Service
public class CommentsManager extends HibernateDao<Comments> {

	@Autowired
	public CommentsDao commentsDao;

	/**
	 * 
	 * 方  法 名: getComment
	 * 功能描述： 
	 * 输入参数: 文章实体类Article
	 * 返 回 值:  List<Comments>所有与文章ID相匹配的评论
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年8月14日 下午5:18:04
	 * 修 改 人:  林为
	 * 修改日期: 2014年8月14日 下午5:18:04
	 */
	@SuppressWarnings("unchecked")
	public List<Comments> getComments(Integer id) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ArticleManager articleManager = (ArticleManager) context.getBean("articleManager");
		Article a = articleManager.getArticleById(id);
		Criteria cr = commentsDao.createCriteria(Comments.class);
		
		return 	cr.add(Restrictions.eq("article", a)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Comments> queryResult(HttpServletRequest request){
		Integer id = Integer.getInteger(request.getParameter("id"));
		if(id == null){
			id = 1;
		}
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ArticleManager articleManager = (ArticleManager) context.getBean("articleManager");
		Article a = articleManager.getArticleById(id);
		Criteria cr = commentsDao.createCriteria(Comments.class);
		
		return 	cr.add(Restrictions.eq("article", a)).list();
	}
	
	
	
	/*
	 * 分页
	 */
	public Page<Comments> getCommentsByPage(int currentPage, int pageSize) {
		return commentsDao.page(currentPage, pageSize);
	}
}
