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
 * Project:  depot
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package com.ssi.depot.entity;
 * Author：      林为 
 * Create Date： 2014年10月9日 下午2:58:00
 * Modified By：  林为 
 * Modified Date: 2014年10月9日 下午2:58:00
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
/**
 * 系统操作记录类
 * 
 * @author 林为
 *
 */
@SuppressWarnings("serial")
public class SystemLog implements Serializable {
	private Integer sysid;// 系统日志ID
	private Account account;// 操作用户
	private Integer accid;
	private String sysname;// 操作模块
	private String systime;// 操作时间
	private String sysip;// 操作者IP地址
	private String sysremark;// 操作说明

	/**
	 * 
	 */
	public SystemLog() {
		super();
		// TODO 自动生成的构造函数存根
	}

	/**
	 * @param sysid
	 * @param sysname
	 * @param systime
	 * @param sysip
	 * @param sysremark
	 */
	public SystemLog(Integer sysid, Integer accid, String sysname,
			String systime, String sysip, String sysremark) {
		super();
		this.sysid = sysid;
		this.accid = accid;
		this.sysname = sysname;
		this.systime = systime;
		this.sysip = sysip;
		this.sysremark = sysremark;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SystemLog [sysid=" + sysid + ", account=" + accid
				+ ", sysname=" + sysname + ", systime=" + systime + ", sysip="
				+ sysip + ", sysremark=" + sysremark + "]";
	}

	/**
	 * @return sysid
	 */
	public Integer getSysid() {
		return sysid;
	}

	/**
	 * @param sysid
	 *            要设置的 sysid
	 */
	public void setSysid(Integer sysid) {
		this.sysid = sysid;
	}

	/**
	 * @return sysname
	 */
	public String getSysname() {
		return sysname;
	}

	/**
	 * @param sysname
	 *            要设置的 sysname
	 */
	public void setSysname(String sysname) {
		this.sysname = sysname;
	}

	/**
	 * @return systime
	 */
	public String getSystime() {
		return systime;
	}

	/**
	 * @param systime
	 *            要设置的 systime
	 */
	public void setSystime(String systime) {
		this.systime = systime;
	}

	/**
	 * @return sysip
	 */
	public String getSysip() {
		return sysip;
	}

	/**
	 * @param sysip
	 *            要设置的 sysip
	 */
	public void setSysip(String sysip) {
		this.sysip = sysip;
	}

	/**
	 * @return sysremark
	 */
	public String getSysremark() {
		return sysremark;
	}

	/**
	 * @param sysremark
	 *            要设置的 sysremark
	 */
	public void setSysremark(String sysremark) {
		this.sysremark = sysremark;
	}

	public Integer getAccid() {
		return accid;
	}

	public void setAccid(Integer accid) {
		this.accid = accid;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
