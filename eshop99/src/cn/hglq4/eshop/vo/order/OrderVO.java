/*   
 * Copyright (c) 2010-2020 蓝桥软件 Ltd. All Rights Reserved.     
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with 蓝桥科技有限公司.   
 *   
 */

package cn.hglq4.eshop.vo.order;

/**
 * CopyRright (c)2008-2014: <蓝桥软件BlueSoft> Project: eshop99 Module ID:
 * <(模块)类编号，可以引用系统设计中的类编号> Comments: <对此类的描述，可以引用系统设计中的描述> JDK version used:
 * <JDK1.6> Namespace: cn.hglq4.eshop Author：张总监 Create Date： 2014年8月13日
 * Modified By： 张总监 Modified Date: 2014年8月13日 下午7:46:50 Why & What is modified:
 * <修改原因描述> Version: v1.0
 */

public class OrderVO {
	private Integer orderId;
	private String orderNo;
	private Integer customerId;
	private Integer employeeId;
	private String orderDate;
	private String arriveddate;
	private String senddate;
	private String transportcom;
	private String customername;
	private String customeraddress;
	private String customercity;
	private String customerhometown;
	private String customerpostcode;
	private String customercountry;
	private Integer productId; 
	 private Integer num;
	 private Integer discount;
	 public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getArriveddate() {
		return arriveddate;
	}
	public void setArriveddate(String arriveddate) {
		this.arriveddate = arriveddate;
	}
	public String getSenddate() {
		return senddate;
	}
	public void setSenddate(String senddate) {
		this.senddate = senddate;
	}
	public String getTransportcom() {
		return transportcom;
	}
	public void setTransportcom(String transportcom) {
		this.transportcom = transportcom;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomeraddress() {
		return customeraddress;
	}
	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}
	public String getCustomercity() {
		return customercity;
	}
	public void setCustomercity(String customercity) {
		this.customercity = customercity;
	}
	public String getCustomerhometown() {
		return customerhometown;
	}
	public void setCustomerhometown(String customerhometown) {
		this.customerhometown = customerhometown;
	}
	public String getCustomerpostcode() {
		return customerpostcode;
	}
	public void setCustomerpostcode(String customerpostcode) {
		this.customerpostcode = customerpostcode;
	}
	public String getCustomercountry() {
		return customercountry;
	}
	public void setCustomercountry(String customercountry) {
		this.customercountry = customercountry;
	}

	
	}