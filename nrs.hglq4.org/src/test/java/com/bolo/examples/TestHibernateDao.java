package com.bolo.examples;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bolo.examples.entity.base.Article;
import com.bolo.examples.entity.base.Role;
import com.bolo.examples.entity.base.User;
import com.bolo.examples.service.base.ArticleManager;
import com.bolo.examples.service.base.RoleManager;
import com.bolo.examples.service.base.UserManager;

public class TestHibernateDao {

	private static UserManager userManager;
	private static RoleManager roleManager;
	private static ArticleManager articleManager;
	
	@BeforeClass
	public static void init(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		userManager = (UserManager)context.getBean("userManager");
		roleManager = (RoleManager)context.getBean("roleManager");
		articleManager = (ArticleManager) context.getBean("articleManager");
	}
	
	@Test
	public void testUser(){
		User user = userManager.getUser(1);
		Assert.assertEquals("张三",user.getName());
		System.out.println("ID： "+user.getRole()+" 姓名： "+user.getName());
	}
	
	@Test
	public void testRole(){
		Role role = roleManager.getRole(1);
		Assert.assertEquals("超级管理员",role.getAccount());
		System.out.println("ID： "+role.getRolid()+" 角色名： "+role.getAccount());
	}
	
	@Test
	public void testArticle(){
		
		Article article = articleManager.getArticleById(1);
//		
//		System.out.println(article.getArtid()+" "+article.getArttitle());
		
		List<Article> articles = articleManager.getAllRelatedarticle(article);
		
		for(Article art : articles){
			
			System.out.println(art.getArtid()+" "+art.getArttitle());
		}
		
	}
	

	
	
	
	
}
