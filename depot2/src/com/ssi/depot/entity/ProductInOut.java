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
 * 
 * @author 林为
 *
 */
@SuppressWarnings("serial")
public class ProductInOut implements Serializable {

	private Integer pioid; // 操作编号
	private Product product;
	private Integer proid; // 商品编号
	private Account account;
	private Integer accid; // 用户编号
	private Integer pioquantity; // 操作数量
	private Integer piocount; // 操作次数
	private String piotype; // 操作类型
	private String piooperation; // 灌机人
	private Integer piooperationnum; // 灌机点数
	private String pioagreementid; // 合同编号
	private String pioprojectid; // 项目编号
	private String pioprojectname; // 项目名称
	private String piouttime; // 操作时间
	private String piointime; // 归还时间
	private String piosign; // 签约公司（最终）
	private String pioapply; // 申请人
	private String piodelivery; // 提货人
	private String pioremark; // 操作备注
	private String pioadminsign; // 库管审核

	/**
	 * 
	 */
	public ProductInOut() {
		super();
		// TODO 自动生成的构造函数存根
	}

	/**
	 * 
	 * @param pioid
	 * @param proid
	 * @param accid
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
	 * @param piodelivery
	 * @param pioremark
	 * @param pioadminsign
	 */
	public ProductInOut(Integer pioid, Integer proid, Integer accid,
			Integer pioquantity, Integer piocount, String piotype,
			String piooperation, Integer piooperationnum,
			String pioagreementid, String pioprojectid, String pioprojectname,
			String piouttime, String piointime, String piosign,
			String pioapply, String piodelivery, String pioremark,
			String pioadminsign) {

		super();
		this.pioid = pioid;
		this.accid = accid;
		this.proid = proid;
		this.accid = accid;
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
		this.piodelivery = piodelivery;
		this.pioremark = pioremark;
		this.pioadminsign = pioadminsign;
	}

	@Override
	public String toString() {

		return "ProductInOut [pioid=" + pioid + ", proid=" + proid + ", accid="
				+ accid + ", pioquantity=" + pioquantity + ", piocount="
				+ piocount + ", piotype=" + piotype + ", piooperation="
				+ piooperation + ", piooperationnum=" + piooperationnum
				+ ", pioagreementid=" + pioagreementid + ", pioprojectid="
				+ pioprojectid + ", pioprojectname=" + pioprojectname
				+ ", piouttime=" + piouttime + ", piointime=" + piointime
				+ ", piosign=" + piosign + ", pioapply=" + pioapply
				+ ", piodelivery=" + piodelivery + ", pioremark=" + pioremark
				+ ", pioadminsign=" + pioadminsign + "]";
	}

	/**
	 * @return pioid
	 */
	public Integer getPioid() {
		return pioid;
	}

	/**
	 * @param pioid
	 *            要设置的 pioid
	 */
	public void setPioid(Integer pioid) {
		this.pioid = pioid;
	}

	/**
	 * @return pioquantity
	 */
	public Integer getPioquantity() {
		return pioquantity;
	}

	/**
	 * @param pioquantity
	 *            要设置的 pioquantity
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
	 * @param piocount
	 *            要设置的 piocount
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
	 * @param piotype
	 *            要设置的 piotype
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
	 * @param piooperation
	 *            要设置的 piooperation
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
	 * @param piooperationnum
	 *            要设置的 piooperationnum
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
	 * @param pioagreementid
	 *            要设置的 pioagreementid
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
	 * @param pioprojectid
	 *            要设置的 pioprojectid
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
	 * @param pioprojectname
	 *            要设置的 pioprojectname
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
	 * @param piouttime
	 *            要设置的 piouttime
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
	 * @param piointime
	 *            要设置的 piointime
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
	 * @param piosign
	 *            要设置的 piosign
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
	 * @param pioapply
	 *            要设置的 pioapply
	 */
	public void setPioapply(String pioapply) {
		this.pioapply = pioapply;
	}

	/**
	 * @return piodelivery
	 */
	public String getPiodelivery() {
		return piodelivery;
	}

	/**
	 * @param piodelivery
	 *            要设置的 piodelivery
	 */
	public void setPiodelivery(String piodelivery) {
		this.piodelivery = piodelivery;
	}

	/**
	 * @return pioremark
	 */
	public String getPioremark() {
		return pioremark;
	}

	/**
	 * @param pioremark
	 *            要设置的 pioremark
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
	 * @param pioadminsign
	 *            要设置的 pioadminsign
	 */
	public void setPioadminsign(String pioadminsign) {
		this.pioadminsign = pioadminsign;
	}

	public Product getProduct() {
		return product;
	}

	public Account getAccount() {
		return account;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setProduct(Integer proid) {
		this.product.setProid(proid);
	}

	public Integer getProid() {
		return proid;
	}

	public Integer getAccid() {
		return accid;
	}

	public void setProid(Integer proid) {
		this.proid = proid;
	}

	public void setAccid(Integer accid) {
		this.accid = accid;
	}

}
