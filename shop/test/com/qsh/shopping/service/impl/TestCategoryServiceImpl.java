package com.qsh.shopping.service.impl;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qsh.shopping.model.Category;
import com.qsh.shopping.model.Product;
import com.qsh.shopping.service.CategoryService;
import com.qsh.shopping.util.QshException;


public class TestCategoryServiceImpl {
	
	@Test
	public void testAddTopCategory(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_xml_config/beans.xml");
		
		CategoryService categoryService =(CategoryService) ctx.getBean("categoryService");
		
		String text="瓜子类";
		String description="所有分类的描述";
		categoryService.addTopCategory(text, description);
	}
	
	@Test
	public void testAddChildCategory(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_xml_config/beans.xml");
		
		CategoryService categoryService =(CategoryService) ctx.getBean("categoryService");
		
		
		Category category = new Category();
		category.setText("喔喔类");
		category.setDescription("很好吃");
		
		categoryService.addChildCategory(7, category);
	
	}
	
	@Test
	public void testDeleteById(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_xml_config/beans.xml");
		CategoryService categoryService =(CategoryService) ctx.getBean("categoryService");
		
		try{
			categoryService.deleteById(7,6);
		}catch(QshException e){
			System.out.println(e);
		}
	
	}
	
	@Test
	public void testFindAll(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_xml_config/beans.xml");
		CategoryService categoryService =(CategoryService) ctx.getBean("categoryService");
		
		List<Category> list = categoryService.findAll();
		
		for(Category category:list){
			System.out.println("name:"+category.getText());
		}
	}
	
	
	
	@Test
	public void testUpdate(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_xml_config/beans.xml");
		CategoryService categoryService =(CategoryService) ctx.getBean("categoryService");
		
		Category category = new Category();
		category.setId(6);
		category.setText("商品分类");
		category.setDescription("管理商品用的");
		if(categoryService.update(category)){
			System.out.println("修改成功");
		}else{
			System.out.println("修改不成功");
		}
		
	}
}
