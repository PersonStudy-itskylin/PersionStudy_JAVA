package com.hglq4.shopping.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hglq4.shopping.dao.CategoryDAO;
import com.hglq4.shopping.model.Category;
import com.hglq4.shopping.service.CategoryService;
import com.hglq4.shopping.util.BlueSkyException;

@Transactional
//@Resource(name ="categoryService")
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired(required=true)
	private CategoryDAO categoryDAO;
	

	public boolean addChildCategory(int parent, Category category) {
		// TODO Auto-generated method stub
		return categoryDAO.saveChildCategory(parent, category);
	}

	public boolean addTopCategory(String text,String description) {
		// TODO Auto-generated method stub
		Category category = new Category();
		category.setText(text);
		category.setDescription(description);
		category.setParent(0);//最根上，所以父节点的id为0
		category.setLeaf(true);//新添加的根节是叶子
		return categoryDAO.save(category);
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
        		 }catch(BlueSkyException qe){
        			 System.out.println(qe);
        		 }
        	 }
         }
		return categoryDAO.delete(id);
	}
	
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryDAO.findAll();
	}

	public List<Category> findTopAll() {
		// TODO Auto-generated method stub
		return categoryDAO.findTopCategory();
	}

	public boolean update(Category category) {
		// TODO Auto-generated method stub
		return categoryDAO.update(category);
	}
	
	
	/**修改为叶子，为deleteById作用的*/
	private boolean setCategoryToLeaf(int id) throws BlueSkyException{
		return categoryDAO.updateCategoryToLeaf(id);
	}
	private List<Category> findByParent(int pid) {
		// TODO Auto-generated method stub
		return categoryDAO.findByParent(pid);
	}
	public List<Category> getCategories(int id) {
		// TODO Auto-generated method stub
		//获得pid为0的所有记录
		List<Category> list = new ArrayList<Category>();
		categoryDAO.getCategories(list, id);
		return list;
	}
	

}
