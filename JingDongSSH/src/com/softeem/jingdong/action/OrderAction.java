package com.softeem.jingdong.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.softeem.jingdong.entity.OrderBean;
import com.softeem.jingdong.entity.UsersBean;
import com.softeem.jingdong.service.OrderService;
/**
 * 订单 Action
 * @author Administrator
 */
public class OrderAction extends ActionSupport {

	private static final long serialVersionUID = 8189598361091118151L;
	private OrderService orderService;
	private String name;
	private String address;
	private String phone;
	private String email;
	private String payWay;
	private OrderBean order = new OrderBean();
	
	/**
	 * 添加订单
	 */
	public String addOrder(){
		
		//添加订单号
		order.setNo(this.getID());
		order.setConsignee(name);
		order.setAddress(address);
		order.setPhone(phone);
		order.setEmail(email);
		order.setPayWay(payWay);
		order.setTime( new Timestamp( new Date().getTime() ));
		
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		
		//调用 下订单方法
		orderService.addOrder(order, (UsersBean)session.getAttribute("users"));
		
		//跳转到成功页面
		return SUCCESS;
	}
	
	/**
	 * 获取订单编号 13位
	 * yyyyMMdd + 5位随机数
	 */
	public long getID(){
		
		//yyyyMMdd
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String t = sdf.format(new Date());
		
		//5位随机数
		Random r = new Random();
		int m = 0;
		
		while( (m=r.nextInt(100000)) > 10000){
			break;
		}
		
		//拼接 返回 随机 订单号
		return Long.parseLong(t + m); 
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public OrderBean getOrder() {
		return order;
	}
	public void setOrder(OrderBean order) {
		this.order = order;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
}
