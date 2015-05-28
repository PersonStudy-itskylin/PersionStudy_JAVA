package com.bolo.examples;


import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bolo.examples.entity.base.Article;
import com.bolo.examples.entity.base.Comments;
import com.bolo.examples.service.base.ArticleManager;
import com.bolo.examples.service.base.CommentsManager;

/**
 * 测试
 * @author 菠萝大象
 * @version 1.0
 */
public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		UserManager userManager = (UserManager)context.getBean("userManager");
//		RoleManager roleManager = (RoleManager)context.getBean("roleManager");
//		User user = userManager.getUser(1);
//		System.out.println("ID： "+user.getId()+" 姓名： "+user.getName());
//		Role role = roleManager.getRole(101);
//		System.out.println("ID： "+role.getId()+" 角色名： "+role.getName());
		//Page<User> page = userManager.getUsersByPage(2, 1);
//		System.out.println("------------"+page.getData().size()+"----------");
//		ArticleManager articleManager = (ArticleManager) context.getBean("articleManager");
//		testArticle(articleManager);
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CommentsManager commentsManager = (CommentsManager) context.getBean("commentsManager");
		testComments(commentsManager);
	}
	
	public static void testArticle(ArticleManager articleManager){
		
		Article article = articleManager.getArticleById(1);
		
		System.out.println(article.getArtid()+" "+article.getArttitle());
		
		List<Article> articleList = articleManager.getAllRelatedarticle(article);
		
		if(articleList!=null){
			for(Article a : articleList){
				
				System.out.println(a.getArtid()+" "+a.getArttitle());
			}
		}
	}
	public static void testComments(CommentsManager commentsManager){
		List<Comments> ls = commentsManager .getComments(1);	
		Iterator<Comments> ie =ls.iterator();
		if(ie.hasNext()){
			Comments a = ie.next();
			System.out.println(a.getComid()+" "+a.getComcontent());
			System.out.println("-----------------------");
		}
	}
}
