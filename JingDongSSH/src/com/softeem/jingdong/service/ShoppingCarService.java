package com.softeem.jingdong.service;

import com.softeem.jingdong.entity.GoodsBean;

public interface ShoppingCarService {
	
	//添加添加到购物车中
	public GoodsBean addGoodsToShoppingCar(int id);
	
}
