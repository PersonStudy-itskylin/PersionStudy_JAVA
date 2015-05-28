/*
 * Copyright (c) 2010-2020 蓝桥软件 Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 蓝桥科技有限公司.
 */
package com.bolo.examples;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bolo.examples.entity.base.Comments;
import com.bolo.examples.service.base.ArticleManager;
import com.bolo.examples.service.base.CommentsManager;

/** 
 * CopyRright (c)2008-2014:   <蓝桥软件BlueSoft> 
 * Project:  nrs.hglq4.org
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  测试
 * JDK version used: <JDK1.6>                              
 * Namespace: package com.bolo.examples;
 * Author：      林为 
 * Create Date： 2014年8月14日 下午5:58:50
 * Modified By：  林为 
 * Modified Date: 2014年8月14日 下午5:58:50
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
/**
 * @author Blue_Sky
 *
 */
public class TestCommentsDao {

	private static ArticleManager articleManager;
	private static CommentsManager commentsManager;
	
	@BeforeClass
	public static void init(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		articleManager = (ArticleManager) context.getBean("articleManager");
		commentsManager = (CommentsManager) context.getBean("commentsManager");
	}
	
	@Test
	public void testComments(){
		List<Comments> l = commentsManager.getComments(1);	
		Iterator<Comments> ie =l.iterator();
		if(ie.hasNext()){
			Comments a = ie.next();
				System.out.println( a.getArticle().getArtid() + "-------" + a.getComid()+" "+a.getComcontent());
				System.out.println("-----------------------");
		}
	}
	
}
