package com.softeem.jingdong.dao;

import com.softeem.jingdong.entity.OrderBean;

/**
 * 订单相关的数据访问操作
 * @author Administrator
 *
 */
public interface OrderDao {
	
	//添加订单信息,同时建立人跟订单 , 订单跟商品的关系
	public void addOrder(OrderBean order);
	
}
