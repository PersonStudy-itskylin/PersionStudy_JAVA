package com.qsh.shopping.dao;

import java.util.List;

import com.qsh.shopping.model.Product;
import com.qsh.shopping.model.User;

public interface ProductDAO {
	/**新增商品*/
	public Product save(Product product);
	/**删除商品*/
	public boolean delete(int id);
	/**修改商品*/
	public boolean update(Product product);
	/**查询所有商品*/
	public List<Product> findAll();
	/**查询所有商品*/
	public List<Product> findAll(int start, int limit);
	/**查询关键字*/
	public List<Product> findByKeyword(String keyword);
}
