package com.softeem.jingdong.dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.softeem.jingdong.dao.OrderDao;
import com.softeem.jingdong.entity.OrderBean;

public class OrderDaoImpl implements OrderDao {
	
	private HibernateTemplate template;
	
	//添加订单
	public void addOrder(OrderBean order) {
		template.save(order);
	}

	public HibernateTemplate getTemplate() {
		return template;
	}
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

}
