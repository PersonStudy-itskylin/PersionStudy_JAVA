package com.softeem.jingdong.service.impl;

import com.softeem.jingdong.dao.GoodsDao;
import com.softeem.jingdong.entity.GoodsBean;
import com.softeem.jingdong.service.ShoppingCarService;

public class ShoppingCarServiceImpl implements ShoppingCarService {
	
	private GoodsDao goodsDao;
	
	//添加添加到购物车中
	public GoodsBean addGoodsToShoppingCar(int id){
		return goodsDao.getGoodsById(id);
	}

	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}
}
