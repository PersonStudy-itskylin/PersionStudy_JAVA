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
 * Create Date： 2014年10月9日 下午2:22:44
 * Modified By：  林为 
 * Modified Date: 2014年10月9日 下午2:22:44
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
/**
 * @author 林为
 *
 */
@SuppressWarnings("serial")
public class Backup implements Serializable{
	
	private Integer bacid;//备份ID
	private Account account;//备份用户
	private Integer accid;
	private String bacname;//备份名称
	private String bacdescription;//备份描述
	private String bacpath;//备份路径
	private String bacip;//操作IP
	private String bactime;//备份时间
	private String bacremark;//备份备注
	
	/**
	 * 
	 */
	public Backup() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	/**
	 * @param bacid
	 * @param accid
	 * @param bacname
	 * @param bacdescription
	 * @param bacpath
	 * @param bacip
	 * @param bactime
	 * @param bacremark
	 */
	public Backup(Integer bacid, Integer accid, String bacname,
			String bacdescription, String bacpath, String bacip,
			String bactime, String bacremark) {
		super();
		this.bacid = bacid;
		this.accid = accid;
		this.bacname = bacname;
		this.bacdescription = bacdescription;
		this.bacpath = bacpath;
		this.bacip = bacip;
		this.bactime = bactime;
		this.bacremark = bacremark;
	}
	@Override
	public String toString() {
		return "Backup [bacid=" + bacid + ", accid=" + accid + ", bacname="
				+ bacname + ", bacdescription=" + bacdescription + ", bacpath="
				+ bacpath + ", bacip=" + bacip + ", bactime=" + bactime
				+ ", bacremark=" + bacremark + "]";
	}
	/**
	 * @return bacid
	 */
	public Integer getBacid() {
		return bacid;
	}
	/**
	 * @param bacid 要设置的 bacid
	 */
	public void setBacid(Integer bacid) {
		this.bacid = bacid;
	}
	
	/**
	 * @return bacname
	 */
	public String getBacname() {
		return bacname;
	}
	/**
	 * @param bacname 要设置的 bacname
	 */
	public void setBacname(String bacname) {
		this.bacname = bacname;
	}
	/**
	 * @return bacdescription
	 */
	public String getBacdescription() {
		return bacdescription;
	}
	/**
	 * @param bacdescription 要设置的 bacdescription
	 */
	public void setBacdescription(String bacdescription) {
		this.bacdescription = bacdescription;
	}
	/**
	 * @return bacpath
	 */
	public String getBacpath() {
		return bacpath;
	}
	/**
	 * @param bacpath 要设置的 bacpath
	 */
	public void setBacpath(String bacpath) {
		this.bacpath = bacpath;
	}
	/**
	 * @return bacip
	 */
	public String getBacip() {
		return bacip;
	}
	/**
	 * @param bacip 要设置的 bacip
	 */
	public void setBacip(String bacip) {
		this.bacip = bacip;
	}
	/**
	 * @return bactime
	 */
	public String getBactime() {
		return bactime;
	}
	/**
	 * @param bactime 要设置的 bactime
	 */
	public void setBactime(String bactime) {
		this.bactime = bactime;
	}
	/**
	 * @return bacremark
	 */
	public String getBacremark() {
		return bacremark;
	}
	/**
	 * @param bacremark 要设置的 bacremark
	 */
	public void setBacremark(String bacremark) {
		this.bacremark = bacremark;
	}
	/**
	 * @return accid
	 */
	public Integer getAccid() {
		return accid;
	}
	/**
	 * @param accid 要设置的 accid
	 */
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
