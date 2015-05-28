package com.softeem.jingdong.service;

import java.util.List;

import com.softeem.jingdong.entity.GoodsBean;

public interface GoodsService {
	
	//查询所由商品信息
	public List<GoodsBean> getAllGoods();
	
	//查询商品详细信息
	public GoodsBean getGoodsById(int id);
	
	//模糊查询
	public List<GoodsBean> getSearchList(String key);

}
