package com.softeem.jingdong.entity;

import java.io.Serializable;

/**
 * 用户实体类 跟 用户表一一对应
 * 一个用户对应一个购物车
 * @author Administrator
 *
 */
public class UsersBean implements Serializable {
	
	private static final long serialVersionUID = 5438890340998694650L;
	
	//属性
	private int id;
	private String name;
	private String password;
	
	//购物车信息
	private ShoppingCarBean shoppingCar;
	
	/**
	 * 构造器
	 */
	public UsersBean(){}
	
	public UsersBean(String name,String password){
		this.name = name;
		this.password = password;
	}
	
	//getter  setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public ShoppingCarBean getShoppingCar() {
		return shoppingCar;
	}

	public void setShoppingCar(ShoppingCarBean shoppingCar) {
		this.shoppingCar = shoppingCar;
	}
	
}
