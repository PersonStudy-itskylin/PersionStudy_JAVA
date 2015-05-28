package com.softeem.jingdong.service;

import com.softeem.jingdong.entity.OrderBean;
import com.softeem.jingdong.entity.UsersBean;

/**
 * 订单的业务
 * @author Administrator
 *
 */
public interface OrderService {
	
	//添加订单 , 添加订单里面包含 添加订单 ， 简历 订单跟用户 跟商品之间的关系
	public void addOrder(OrderBean order,UsersBean users);
	
}
