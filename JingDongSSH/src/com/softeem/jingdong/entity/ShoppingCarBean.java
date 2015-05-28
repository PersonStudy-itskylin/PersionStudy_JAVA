package com.softeem.jingdong.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 购物车
 * @author Administrator
 *
 */
public class ShoppingCarBean implements Serializable {
	
	private static final long serialVersionUID = 8638668600513222006L;
	
	//购物车 容器 , 可以存储购买的商品信息
	private List<GoodsBean> list = new ArrayList<GoodsBean>();
	//购物车商品总价
	private double sumPrice;
	//购物车商品总数量
	private int number;
	
	public ShoppingCarBean(){}
	
	public ShoppingCarBean(List<GoodsBean> list,double sumPrice,int number){
		this.list = list;
		this.sumPrice = sumPrice;
		this.number = number;
	}
	
	public List<GoodsBean> getList() {
		return list;
	}
	public void setList(List<GoodsBean> list) {
		this.list = list;
	}
	public double getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(double sumPrice) {
		this.sumPrice = sumPrice;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
}
