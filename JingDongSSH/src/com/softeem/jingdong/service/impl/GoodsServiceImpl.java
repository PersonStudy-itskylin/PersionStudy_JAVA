package com.softeem.jingdong.service.impl;

import java.util.List;

import com.softeem.jingdong.dao.GoodsDao;
import com.softeem.jingdong.entity.GoodsBean;
import com.softeem.jingdong.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {
	
	//获取 GoodsDao 实例
	private GoodsDao goodsDao;
	
	//查询所由商品信息
	public List<GoodsBean> getAllGoods(){
		return goodsDao.getAllGoods();
	}
	
	//查询商品详细信息
	public GoodsBean getGoodsById(int id){
		return goodsDao.getGoodsById(id);
	}
	
	//模糊查询
	public List<GoodsBean> getSearchList(String key){
		return goodsDao.getSearchList(key);
	}

	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}
	
}
