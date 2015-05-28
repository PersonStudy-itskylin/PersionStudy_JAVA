package com.softeem.jingdong.dao;

import java.util.List;

import com.softeem.jingdong.entity.GoodsBean;

/**
 * 跟商品相关的 数据访问层
 * @author Administrator
 *
 */
public interface GoodsDao {
	
	//查找所有商品
	public List<GoodsBean> getAllGoods();
	
	//通过 id 查询该商品信息
	public GoodsBean getGoodsById(int id);
	
	//模糊查询
	public List<GoodsBean> getSearchList(String key);
	
}
