package com.qsh.shopping.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;

import com.qsh.shopping.dao.CategoryDAO;
import com.qsh.shopping.model.Category;
import com.qsh.shopping.service.CategoryService;
import com.qsh.shopping.util.QshException;

public class CategoryServiceImpl implements CategoryService {
	
	private CategoryDAO categoryDao;
	
	public CategoryDAO getCategoryDao() {
		return categoryDao;
	}
	@Resource
	public void setCategoryDao(CategoryDAO categoryDao) {
		this.categoryDao = categoryDao;
	}

	public boolean addChildCategory(int parent, Category category) {
		// TODO Auto-generated method stub
		return categoryDao.saveChildCategory(parent, category);
	}

	public boolean addTopCategory(String text,String description) {
		// TODO Auto-generated method stub
		Category category = new Category();
		category.setText(text);
		category.setDescription(description);
		category.setParent(0);//最根上，所以父节点的id为0
		category.setLeaf(true);//新添加的根节是叶子
		return categoryDao.save(category);
	}

	/**递归删除*/
	public boolean deleteById(int id,int pid){
		// TODO Auto-generated method stub
		List<Category> list = this.findByParent(id);
		 if(list.size()>0){
         	for(Category c:list){
         		deleteById(c.getId(),c.getParent());
         	}
         }else{//删除子节点完成，设置父节为叶子
        	 //如果还有兄弟就不改变
        	// System.out.println("num:"+this.findByParent(pid).size());
        	 if(this.findByParent(pid).size()<=1){
        		 try{
        			 this.setCategoryToLeaf(pid);
        		 }catch(QshException qe){
        			 System.out.println(qe);
        		 }
        	 }
         }
		return categoryDao.delete(id);
	}
	
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}

	public List<Category> findTopAll() {
		// TODO Auto-generated method stub
		return categoryDao.findTopCategory();
	}

	public boolean update(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.update(category);
	}
	
	
	/**修改为叶子，为deleteById作用的*/
	private boolean setCategoryToLeaf(int id) throws QshException{
		return categoryDao.updateCategoryToLeaf(id);
	}
	private List<Category> findByParent(int pid) {
		// TODO Auto-generated method stub
		return categoryDao.findByParent(pid);
	}
	public List<Category> getCategories(int id) {
		// TODO Auto-generated method stub
		//获得pid为0的所有记录
		List<Category> list = new ArrayList<Category>();
		categoryDao.getCategories(list, id);
		return list;
	}
	

}
