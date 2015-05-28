package com.softeem.jingdong.factory;

import com.softeem.jingdong.dao.GoodsDao;
import com.softeem.jingdong.dao.OrderDao;
import com.softeem.jingdong.dao.UsersDao;
import com.softeem.jingdong.dao.impl.GoodsDaoImpl;
import com.softeem.jingdong.dao.impl.OrderDaoImpl;
import com.softeem.jingdong.dao.impl.UsersDaoImpl;

/**
 * 静态工厂 ， 生产对象
 * @author Administrator
 *
 */
public class DaoFactory {
	
	//获取 UsersDao 实例
	public static UsersDao getUsersDaoInstance(){
		return new UsersDaoImpl();
	}
	
	//获取 GoodsDao 实例
	public static GoodsDao getGoodsDaoInstance(){
		return new GoodsDaoImpl();
	}
	
	//获取 OrderDao 实例
	public static OrderDao getOrderDaoInstance(){
		return new OrderDaoImpl();
	}
	
}
