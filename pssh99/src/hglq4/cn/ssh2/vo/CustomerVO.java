/*
 * Copyright (c) 2010-2020 蓝桥软件 Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 蓝桥科技有限公司.
 */
package hglq4.cn.ssh2.vo;

/** 
 * CopyRright (c)2008-2014:   <蓝桥软件BlueSoft> 
 * Project:  pssh99
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package hglq4.cn.ssh2.vo;
 * Author：      林为 
 * Create Date： 2014年8月16日 下午7:21:33
 * Modified By：  林为 
 * Modified Date: 2014年8月16日 下午7:21:33
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
/**
 * @author 林为
 *
 */
public class CustomerVO {
	/**
	 * "CUSTOMER_ID" NUMBER NOT NULL ENABLE, 
	"CUSTOMER_NAME" VARCHAR2(127), 
	"SEX" VARCHAR2(2) DEFAULT '男', 
	"COUNTRY" VARCHAR2(35), 
	"PROVINCE" VARCHAR2(35), 
	"city" VARCHAR2(35), 
	"ADDRESS" VARCHAR2(127), 
	"POSTCODE" VARCHAR2(6), 
	"PHONE" VARCHAR2(18), 
	"EMAIL" VARCHAR2(35), 
	 */
	private Integer customerId;
	private String customerName;
	private String sex;
	private String country;
	private String province;
	private String city;
	private String postcode;
	private String phone;
	private String email;
	/**
	 * @return customerId
	 */
	public Integer getCustomerId() {
		return customerId;
	}
	/**
	 * 
	 */
	public CustomerVO() {
		super();
		// TODO 自动生成的构造函数存根
	}
	/**
	 * @param customerId
	 * @param customerName
	 * @param sex
	 * @param country
	 * @param province
	 * @param city
	 * @param postcode
	 * @param phone
	 * @param email
	 */
	public CustomerVO(Integer customerId, String customerName, String sex,
			String country, String province, String city, String postcode,
			String phone, String email) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.sex = sex;
		this.country = country;
		this.province = province;
		this.city = city;
		this.postcode = postcode;
		this.phone = phone;
		this.email = email;
	}
	/* （非 Javadoc）
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result
				+ ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result
				+ ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result
				+ ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result
				+ ((province == null) ? 0 : province.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		return result;
	}
	/* （非 Javadoc）
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerVO other = (CustomerVO) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (postcode == null) {
			if (other.postcode != null)
				return false;
		} else if (!postcode.equals(other.postcode))
			return false;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		return true;
	}
	/**
	 * @param customerId 要设置的 customerId
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName 要设置的 customerName
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex 要设置的 sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country 要设置的 country
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return province
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * @param province 要设置的 province
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * @return city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city 要设置的 city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return postcode
	 */
	public String getPostcode() {
		return postcode;
	}
	/**
	 * @param postcode 要设置的 postcode
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	/**
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone 要设置的 phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email 要设置的 email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
