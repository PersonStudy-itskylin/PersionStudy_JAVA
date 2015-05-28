package com.hglq4.shopping.dao;

import java.util.List;

import com.hglq4.shopping.model.Category;
import com.hglq4.shopping.util.BlueSkyException;
/**
 * 产品分类数据访问对象接口
 * @author 林为
 */
public interface CategoryDAO {
	/**保存分类
	 * @return */
	public boolean save(Category entity);
	/**保存子节点*/
	public boolean saveChildCategory(int parent,Category category);
	/**删除分类*/
	public boolean delete(Integer id);
	/**修改分类
	 * @return */
	public boolean update(Category entity);
	/**查询所有分类信息*/
	public List<Category> findAll();
	/**查询根分类信息*/
	public List<Category> findTopCategory();
	/***/
	public List<Category> findByParent(int pid);
	/**根据id来查询*/
	public void getCategories(List<Category> list,int id);
	/**根据id修改为叶子
	 * @throws QshException */
	public boolean updateCategoryToLeaf(int id) throws BlueSkyException;
	
}
