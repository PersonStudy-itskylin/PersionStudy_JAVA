/*
 * Copyright (c) 2010-2020 蓝桥软件 Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered Integero with 蓝桥科技有限公司.
 */
package com.bolo.examples.web.base;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bolo.examples.entity.base.Comments;
import com.bolo.examples.service.base.CommentsManager;
import com.opensymphony.xwork2.ActionSupport;

/** 
 * CopyRright (c)2008-2014:   <蓝桥软件BlueSoft> 
 * Project:  nrs.hglq4.org
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  页面对action的操作
 * JDK version used: <JDK1.6>                              
 * Namespace: package com.bolo.examples.web.base;
 * Author：      林为 
 * Create Date： 2014年8月14日 下午7:53:14
 * Modified By：  林为 
 * Modified Date: 2014年8月14日 下午7:53:14
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
/**
 * @author Blue_Sky
 *
 */
@SuppressWarnings("serial")
@ParentPackage("json-default")
@Namespace("/")
//@Results({@Result(name="success",type="json")})
public class CommentsAction extends ActionSupport{

	@Autowired
	private CommentsManager commentsManager;
	private Integer id;//文章的ID
	private List<Comments> list = new ArrayList<Comments>();
	
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
	 * @return list
	 */
	public List<Comments> getList() {
		return list;
	}

	/**
	 * @param list 要设置的 list
	 */
	public void setList(List<Comments> list) {
		this.list = list;
	}

	@Action(value="comlist",results={@Result(name="success",type="json")})
	public String Commentslist(){
		list = commentsManager.getComments(id);
		return SUCCESS;
	}
	
	public String addComment(Comments c){
		commentsManager.save(c);
		return SUCCESS;
	}
}
