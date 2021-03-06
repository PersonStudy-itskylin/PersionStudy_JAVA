/*
 * Copyright (c) 2005-2020 BeiJing Jidi Information Tech Co.,Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 北京极地信息安全安全有限公司.
 */
package com.ssi.depot.entity;

import java.io.Serializable;

/** 
 * CopyRright (c)2005-2014:   <极地信息Jidi Information> 
 * Project:  warehouse
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package cn.hglq4.ssi.warehouse.entity;
 * Author：      林为 
 * Create Date： 2014年9月26日 下午1:21:07
 * Modified By：  林为 
 * Modified Date: 2014年9月26日 下午1:21:07
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
/**
 * @author 林为
 *
 */

@SuppressWarnings("serial")
public class Account implements Serializable {
	
	private Integer id;//用户ID
	private String username;//用户名
	private String password;//密码
	private String realname;//姓名
	private String description;//描述
	private Integer role;//权限
	private String phone;//手机
	private String tel;//电话
	private String email;//邮箱
	private String qq;//QQ号
	private Integer state;//账号状态
	private String ip;//注册IP地址
	private String createtime;//创建时间
	private String updatetime;//修改时间
	private String remark;//备注
	
	
	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password="
				+ password + ", realname=" + realname + ", description="
				+ description + ", role=" + role + ", phone=" + phone
				+ ", tel=" + tel + ", email=" + email + ", qq=" + qq
				+ ", state=" + state + ", ip=" + ip + ", createtime="
				+ createtime + ", updatetime=" + updatetime + ", remark="
				+ remark + "]";
	}
	
	
	/**
	 * @param username
	 * @param password
	 */
	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param realname
	 * @param description
	 * @param role
	 * @param phone
	 * @param tel
	 * @param email
	 * @param qq
	 * @param state
	 * @param ip
	 * @param createtime
	 * @param updatetime
	 * @param remark
	 */
	public Account(Integer id, String username, String password,
			String realname, String description, Integer role, String phone,
			String tel, String email, String qq, Integer state, String ip,
			String createtime, String updatetime, String remark) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.description = description;
		this.role = role;
		this.phone = phone;
		this.tel = tel;
		this.email = email;
		this.qq = qq;
		this.state = state;
		this.ip = ip;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.remark = remark;
	}



	/**
	 * 
	 */
	public Account() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	
	
	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id 要设置的 id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username 要设置的 username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password 要设置的 password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return realname
	 */
	public String getRealname() {
		return realname;
	}
	/**
	 * @param realname 要设置的 realname
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}
	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description 要设置的 description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return role
	 */
	public Integer getRole() {
		return role;
	}
	/**
	 * @param role 要设置的 role
	 */
	public void setRole(Integer role) {
		this.role = role;
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
	 * @return tel
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * @param tel 要设置的 tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
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
	/**
	 * @return qq
	 */
	public String getQq() {
		return qq;
	}
	/**
	 * @param qq 要设置的 qq
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}
	/**
	 * @return state
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * @param state 要设置的 state
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * @return ip
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * @param ip 要设置的 ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * @return createtime
	 */
	public String getCreatetime() {
		return createtime;
	}
	/**
	 * @param createtime 要设置的 createtime
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	/**
	 * @return updatetime
	 */
	public String getUpdatetime() {
		return updatetime;
	}
	/**
	 * @param updatetime 要设置的 updatetime
	 */
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	/**
	 * @return remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark 要设置的 remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}