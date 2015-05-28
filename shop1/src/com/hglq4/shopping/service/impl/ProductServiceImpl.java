package com.hglq4.shopping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hglq4.shopping.dao.ProductDAO;
import com.hglq4.shopping.model.Product;
import com.hglq4.shopping.service.ProductService;

@Transactional
//@Resource(name ="productService")
@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired(required=true)
	private ProductDAO productDao;
	

	public Product add(Product product) {
		// TODO Auto-generated method stub
		return productDao.save(product);
	}

	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	public List<Product> findByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return productDao.findByKeyword(keyword);
	}

	public boolean modify(Product product) {
		// TODO Auto-generated method stub
		return productDao.update(product);
	}

	public boolean remove(String[] ids) {
		// TODO Auto-generated method stub
		boolean flag = false;
		for(int i=0;i<ids.length;i++){
			flag = productDao.delete(Integer.parseInt(ids[i]));
		}
		return flag;
	}
	public List<Product> findAll(int start, int limit) {
		// TODO Auto-generated method stub
		return productDao.findAll(start, limit);
	}
	public long count() {
		// TODO Auto-generated method stub
		return findAll().size();
	}
}
