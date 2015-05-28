package com.softeem.jingdong.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


/**
 * 订单表
 * @author Administrator
 *
 */
public class OrderBean implements Serializable {
	
	private static final long serialVersionUID = -8198642297328838564L;
	
	private int id;
	//订单编号 长度 13位
	private long no;
	//收货人
	private String consignee;
	//收货地址
	private String address;
	//联系方式
	private String phone;
	//邮件
	private String email;
	//支付方式
	private String payWay;
	//订单时间
	private Timestamp time;
	//商品集合
	private List<GoodsBean> goodsList;
	//用户对象
	private UsersBean users;
	
	public OrderBean() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public List<GoodsBean> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<GoodsBean> goodsList) {
		this.goodsList = goodsList;
	}

	public UsersBean getUsers() {
		return users;
	}

	public void setUsers(UsersBean users) {
		this.users = users;
	}
	
}
