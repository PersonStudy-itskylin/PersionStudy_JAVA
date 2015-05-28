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
 * Create Date： 2014年10月9日 下午1:37:25
 * Modified By：  林为 
 * Modified Date: 2014年10月9日 下午1:37:25
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
/**
 * 商品出入库记录
 * @author 林为
 *
 */
@SuppressWarnings("serial")
public class ProductInOut implements Serializable{
	private Integer pioid;
	private Integer proid;
//	private Account account;
	private Integer pioquantity;
	private Integer piocount;
	private String piotype;
	private String piooperation;
	private Integer piooperationnum;
	private String pioagreementid;
	private String pioprojectid;
	private String pioprojectname;
	private String piouttime;
	private String piointime;
	private String piosign;
	private String pioapply;
	private String pioDelivery;
	private String pioremark;
	private String pioadminsign;
	
	/**
	 * 
	 */
	public ProductInOut() {
		super();
		// TODO 自动生成的构造函数存根
	}
	/**
	 * @param pioid
	 * @param proid
	 * @param pioquantity
	 * @param piocount
	 * @param piotype
	 * @param piooperation
	 * @param piooperationnum
	 * @param pioagreementid
	 * @param pioprojectid
	 * @param pioprojectname
	 * @param piouttime
	 * @param piointime
	 * @param piosign
	 * @param pioapply
	 * @param pioDelivery
	 * @param pioremark
	 * @param pioadminsign
	 */
	public ProductInOut(Integer pioid, Integer proid, Integer pioquantity,
			Integer piocount, String piotype, String piooperation,
			Integer piooperationnum, String pioagreementid,
			String pioprojectid, String pioprojectname, String piouttime,
			String piointime, String piosign, String pioapply,
			String pioDelivery, String pioremark, String pioadminsign) {
		super();
		this.pioid = pioid;
		this.proid = proid;
		this.pioquantity = pioquantity;
		this.piocount = piocount;
		this.piotype = piotype;
		this.piooperation = piooperation;
		this.piooperationnum = piooperationnum;
		this.pioagreementid = pioagreementid;
		this.pioprojectid = pioprojectid;
		this.pioprojectname = pioprojectname;
		this.piouttime = piouttime;
		this.piointime = piointime;
		this.piosign = piosign;
		this.pioapply = pioapply;
		this.pioDelivery = pioDelivery;
		this.pioremark = pioremark;
		this.pioadminsign = pioadminsign;
	}
	
	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProductInOut [pioid=" + pioid + ", proid=" + proid
				+ ", account=" +/* account +*/ ", pioquantity=" + pioquantity
				+ ", piocount=" + piocount + ", piotype=" + piotype
				+ ", piooperation=" + piooperation + ", piooperationnum="
				+ piooperationnum + ", pioagreementid=" + pioagreementid
				+ ", pioprojectid=" + pioprojectid + ", pioprojectname="
				+ pioprojectname + ", piouttime=" + piouttime + ", piointime="
				+ piointime + ", piosign=" + piosign + ", pioapply=" + pioapply
				+ ", pioDelivery=" + pioDelivery + ", pioremark=" + pioremark
				+ ", pioadminsign=" + pioadminsign + "]";
	}
	/**
	 * @return pioid
	 */
	public Integer getPioid() {
		return pioid;
	}
	/**
	 * @param pioid 要设置的 pioid
	 */
	public void setPioid(Integer pioid) {
		this.pioid = pioid;
	}
	/**
	 * @return proid
	 */
	public Integer getProid() {
		return proid;
	}
	/**
	 * @param proid 要设置的 proid
	 */
	public void setProid(Integer proid) {
		this.proid = proid;
	}
	/**
	 * @return account
	 */
/*	public Account getAccount() {
		return account;
	}
	*//**
	 * @param account 要设置的 account
	 *//*
	public void setAccount(Account account) {
		this.account = account;
	}*/
	/**
	 * @return pioquantity
	 */
	public Integer getPioquantity() {
		return pioquantity;
	}
	/**
	 * @param pioquantity 要设置的 pioquantity
	 */
	public void setPioquantity(Integer pioquantity) {
		this.pioquantity = pioquantity;
	}
	/**
	 * @return piocount
	 */
	public Integer getPiocount() {
		return piocount;
	}
	/**
	 * @param piocount 要设置的 piocount
	 */
	public void setPiocount(Integer piocount) {
		this.piocount = piocount;
	}
	/**
	 * @return piotype
	 */
	public String getPiotype() {
		return piotype;
	}
	/**
	 * @param piotype 要设置的 piotype
	 */
	public void setPiotype(String piotype) {
		this.piotype = piotype;
	}
	/**
	 * @return piooperation
	 */
	public String getPiooperation() {
		return piooperation;
	}
	/**
	 * @param piooperation 要设置的 piooperation
	 */
	public void setPiooperation(String piooperation) {
		this.piooperation = piooperation;
	}
	/**
	 * @return piooperationnum
	 */
	public Integer getPiooperationnum() {
		return piooperationnum;
	}
	/**
	 * @param piooperationnum 要设置的 piooperationnum
	 */
	public void setPiooperationnum(Integer piooperationnum) {
		this.piooperationnum = piooperationnum;
	}
	/**
	 * @return pioagreementid
	 */
	public String getPioagreementid() {
		return pioagreementid;
	}
	/**
	 * @param pioagreementid 要设置的 pioagreementid
	 */
	public void setPioagreementid(String pioagreementid) {
		this.pioagreementid = pioagreementid;
	}
	/**
	 * @return pioprojectid
	 */
	public String getPioprojectid() {
		return pioprojectid;
	}
	/**
	 * @param pioprojectid 要设置的 pioprojectid
	 */
	public void setPioprojectid(String pioprojectid) {
		this.pioprojectid = pioprojectid;
	}
	/**
	 * @return pioprojectname
	 */
	public String getPioprojectname() {
		return pioprojectname;
	}
	/**
	 * @param pioprojectname 要设置的 pioprojectname
	 */
	public void setPioprojectname(String pioprojectname) {
		this.pioprojectname = pioprojectname;
	}
	/**
	 * @return piouttime
	 */
	public String getPiouttime() {
		return piouttime;
	}
	/**
	 * @param piouttime 要设置的 piouttime
	 */
	public void setPiouttime(String piouttime) {
		this.piouttime = piouttime;
	}
	/**
	 * @return piointime
	 */
	public String getPiointime() {
		return piointime;
	}
	/**
	 * @param piointime 要设置的 piointime
	 */
	public void setPiointime(String piointime) {
		this.piointime = piointime;
	}
	/**
	 * @return piosign
	 */
	public String getPiosign() {
		return piosign;
	}
	/**
	 * @param piosign 要设置的 piosign
	 */
	public void setPiosign(String piosign) {
		this.piosign = piosign;
	}
	/**
	 * @return pioapply
	 */
	public String getPioapply() {
		return pioapply;
	}
	/**
	 * @param pioapply 要设置的 pioapply
	 */
	public void setPioapply(String pioapply) {
		this.pioapply = pioapply;
	}
	/**
	 * @return pioDelivery
	 */
	public String getPioDelivery() {
		return pioDelivery;
	}
	/**
	 * @param pioDelivery 要设置的 pioDelivery
	 */
	public void setPioDelivery(String pioDelivery) {
		this.pioDelivery = pioDelivery;
	}
	/**
	 * @return pioremark
	 */
	public String getPioremark() {
		return pioremark;
	}
	/**
	 * @param pioremark 要设置的 pioremark
	 */
	public void setPioremark(String pioremark) {
		this.pioremark = pioremark;
	}
	/**
	 * @return pioadminsign
	 */
	public String getPioadminsign() {
		return pioadminsign;
	}
	/**
	 * @param pioadminsign 要设置的 pioadminsign
	 */
	public void setPioadminsign(String pioadminsign) {
		this.pioadminsign = pioadminsign;
	}
}