package com.qsh.shopping.service;

import java.util.List;

import com.qsh.shopping.model.Category;
import com.qsh.shopping.util.QshException;

public interface CategoryService {
	/**添加子分类*/
	public boolean addChildCategory(int parent, Category category);
	/**添加根分类*/
	public boolean addTopCategory(String text,String description);
	/**删除分类*/
	public boolean deleteById(int id,int pid) throws QshException;
	/**修改分类*/
	public boolean update(Category category);
	/**查询所有分类信息*/
	public List<Category> findAll();
	/**查询根分类信息*/
	public List<Category> findTopAll();
	/**根据id来查询*/
	public List<Category> getCategories(int id);
	
}
