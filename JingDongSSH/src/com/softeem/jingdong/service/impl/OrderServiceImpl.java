package com.softeem.jingdong.service.impl;

import com.softeem.jingdong.dao.OrderDao;
import com.softeem.jingdong.entity.OrderBean;
import com.softeem.jingdong.entity.UsersBean;
import com.softeem.jingdong.service.OrderService;

public class OrderServiceImpl implements OrderService {
	
	//实例化 OrderDao 实例
	private OrderDao orderDao;
	
	//添加订单 , 添加订单里面包含 添加订单 ， 简历 订单跟用户 跟商品之间的关系
	public void addOrder(OrderBean order,UsersBean users){
		
		//建立关系
		order.setUsers(users);
		order.setGoodsList(users.getShoppingCar().getList());
		//先添加订单
		orderDao.addOrder(order);
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
}
