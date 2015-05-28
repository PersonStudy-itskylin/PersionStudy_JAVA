/*   
 * Copyright (c) 2010-2020 蓝桥软件 Ltd. All Rights Reserved.     
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with 蓝桥科技有限公司.   
 *   
 */

package cn.hglq4.eshop.entity.order;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * CopyRright (c)2008-2014: <蓝桥软件BlueSoft> Project: eshop99 Module ID:
 * <(模块)类编号，可以引用系统设计中的类编号> Comments: <对此类的描述，可以引用系统设计中的描述> JDK version used:
 * <JDK1.6> Namespace: cn.hglq4.eshop Author：张总监 Create Date： 2014年8月13日
 * Modified By： 张总监 Modified Date: 2014年8月13日 下午8:23:27 Why & What is modified:
 * <修改原因描述> Version: v1.0
 */

@SuppressWarnings("all")
@Entity
@Table(name="ORDERS",schema="scott")
public class Order implements Serializable {
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

	@Column(name = "ORDER_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "a")
	@SequenceGenerator(name = "a", sequenceName = "SEQ_ORDERS")
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	@Column(name = "ORDER_NO")
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	@Column(name = "CUSTOMER_ID")
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	@Column(name = "EMPLOYEE_ID")
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	@Column(name = "ORDERDATE")
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	@Column(name = "ARRIVEDATE")
	public String getArriveddate() {
		return arriveddate;
	}
	public void setArriveddate(String arriveddate) {
		this.arriveddate = arriveddate;
	}
	@Column(name = "SENDDATE")
	public String getSenddate() {
		return senddate;
	}
	public void setSenddate(String senddate) {
		this.senddate = senddate;
	}
	@Column(name = "TRANSPOTRATION")
	public String getTransportcom() {
		return transportcom;
	}
	public void setTransportcom(String transportcom) {
		this.transportcom = transportcom;
	}
	@Column(name = "CUSTOMMERNAME")
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	@Column(name = "CUSROMERADDRESS")
	public String getCustomeraddress() {
		return customeraddress;
	}
	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}
	@Column(name = "CUSTOMERCITY")
	public String getCustomercity() {
		return customercity;
	}
	public void setCustomercity(String customercity) {
		this.customercity = customercity;
	}
	@Column(name = "CUSOMERHOMETOWN")
	public String getCustomerhometown() {
		return customerhometown;
	}
    public void setCustomerhometown(String customerhometown) {
		this.customerhometown = customerhometown;
	}
	@Column(name = "CUSTOMERPOSTCODE")
	public String getCustomerpostcode() {
		return customerpostcode;
	}
	public void setCustomerpostcode(String customerpostcode) {
		this.customerpostcode = customerpostcode;
	}
	@Column(name = "CUSTOMERCOUNTRY")
	public String getCustomercountry() {
		return customercountry;
	}
	public void setCustomercountry(String customercountry) {
		this.customercountry = customercountry;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((arriveddate == null) ? 0 : arriveddate.hashCode());
		result = prime * result
				+ ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result
				+ ((customeraddress == null) ? 0 : customeraddress.hashCode());
		result = prime * result
				+ ((customercity == null) ? 0 : customercity.hashCode());
		result = prime * result
				+ ((customercountry == null) ? 0 : customercountry.hashCode());
		result = prime
				* result
				+ ((customerhometown == null) ? 0 : customerhometown.hashCode());
		result = prime * result
				+ ((customername == null) ? 0 : customername.hashCode());
		result = prime
				* result
				+ ((customerpostcode == null) ? 0 : customerpostcode.hashCode());
		result = prime * result
				+ ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result
				+ ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderNo == null) ? 0 : orderNo.hashCode());
		result = prime * result
				+ ((senddate == null) ? 0 : senddate.hashCode());
		result = prime * result
				+ ((transportcom == null) ? 0 : transportcom.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (arriveddate == null) {
			if (other.arriveddate != null)
				return false;
		} else if (!arriveddate.equals(other.arriveddate))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (customeraddress == null) {
			if (other.customeraddress != null)
				return false;
		} else if (!customeraddress.equals(other.customeraddress))
			return false;
		if (customercity == null) {
			if (other.customercity != null)
				return false;
		} else if (!customercity.equals(other.customercity))
			return false;
		if (customercountry == null) {
			if (other.customercountry != null)
				return false;
		} else if (!customercountry.equals(other.customercountry))
			return false;
		if (customerhometown == null) {
			if (other.customerhometown != null)
				return false;
		} else if (!customerhometown.equals(other.customerhometown))
			return false;
		if (customername == null) {
			if (other.customername != null)
				return false;
		} else if (!customername.equals(other.customername))
			return false;
		if (customerpostcode == null) {
			if (other.customerpostcode != null)
				return false;
		} else if (!customerpostcode.equals(other.customerpostcode))
			return false;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderNo == null) {
			if (other.orderNo != null)
				return false;
		} else if (!orderNo.equals(other.orderNo))
			return false;
		if (senddate == null) {
			if (other.senddate != null)
				return false;
		} else if (!senddate.equals(other.senddate))
			return false;
		if (transportcom == null) {
			if (other.transportcom != null)
				return false;
		} else if (!transportcom.equals(other.transportcom))
			return false;
		return true;
	}



}
