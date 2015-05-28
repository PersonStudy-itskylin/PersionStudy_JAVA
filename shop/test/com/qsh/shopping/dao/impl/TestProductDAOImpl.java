package com.qsh.shopping.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qsh.shopping.dao.ProductDAO;
import com.qsh.shopping.model.Category;
import com.qsh.shopping.model.Product;

public class TestProductDAOImpl {
	
	@Test
	public void testSave(){
		ApplicationContext cfx = new ClassPathXmlApplicationContext("spring_xml_config/beans.xml");
		
		ProductDAO dao = (ProductDAO)cfx.getBean("productDao");
		
		for(int i=0;i<26;i++){
		Product product = new Product();
		product.setName("牛肉"+i);
		product.setDescr("好吃的牛肉");
		product.setNormaPrice(12.23);
		product.setMemberPrice(11.11);
		product.setPdate(new Timestamp(System.currentTimeMillis()));
		
		Category category = new Category();
		category.setId(1);
		product.setCategory(category);
		product.setPhoto("product1.jpg");
		
		
		System.out.println("productID:"+dao.save(product).getId());
		}
	}
	
	@Test
	public void testDelete(){
		ApplicationContext cfx = new ClassPathXmlApplicationContext("spring_xml_config/beans.xml");
		
		ProductDAO dao = (ProductDAO)cfx.getBean("productDao");
		
		if(dao.delete(3)){
			System.out.println("删除成功！");
		}else{
			System.out.println("删除不成功！");
		}
	}
	
	@Test
	public void testUpdate(){
		ApplicationContext cfx = new ClassPathXmlApplicationContext("spring_xml_config/beans.xml");
		
		ProductDAO dao = (ProductDAO)cfx.getBean("productDao");
		
		Product product = new Product();
		product.setId(4);
		product.setName("中国8");
		//product.setNormaPrice(888888888.5);
		if(dao.update(product)){
			System.out.println("修改成功！");
		}else{
			System.out.println("修改不成功！");
		}
	}
	
	@Test
	public void testFindAll(){
		ApplicationContext cfx = new ClassPathXmlApplicationContext("spring_xml_config/beans.xml");
		
		ProductDAO dao = (ProductDAO)cfx.getBean("productDao");
		
		List<Product> list = dao.findAll();
		
		for(Product p : list){
			System.out.println("商品名："+p.getName() +" ，市场价:"+p.getNormaPrice());
		}
	}
	
	@Test
	public void testFindByKeyword(){
		ApplicationContext cfx = new ClassPathXmlApplicationContext("spring_xml_config/beans.xml");
		
		ProductDAO dao = (ProductDAO)cfx.getBean("productDao");
		
		String keyword="y";
		List<Product> list = dao.findByKeyword(keyword);
		
		for(Product p : list){
			System.out.println("商品名："+p.getName() +" ，市场价:"+p.getNormaPrice());
		}
	}
	
	@Test
	public void testFindByCategory(){
		ApplicationContext cfx = new ClassPathXmlApplicationContext("spring_xml_config/beans.xml");
		
		ProductDAO dao = (ProductDAO)cfx.getBean("productDao");
		
		String categoryId="2";
		List<Product> list = dao.findByKeyword(categoryId);
		
		System.out.println(list.size());
		for(Product p : list){
			System.out.println("商品名："+p.getName() +" ，市场价:"+p.getNormaPrice());
		}
	}
}
