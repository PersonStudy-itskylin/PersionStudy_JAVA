/*
 * Copyright (c) 2005-2020 BeiJing Jidi Information Tech Co.,Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 北京极地信息安全安全有限公司.
 */
package com.ssi.depot.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ssi.depot.action.common.BaseAction;
import com.ssi.depot.entity.ProductInOut;
import com.ssi.depot.service.IProductInOutService;

/** 
 * CopyRright (c)2005-2014:   <极地信息Jidi Information> 
 * Project:  depot2
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package com.ssi.depot.action;
 * Author：      林为 
 * Create Date： 2014年10月28日 上午10:46:58
 * Modified By：  林为 
 * Modified Date: 2014年10月28日 上午10:46:58
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */

@Controller
@Scope("prototype")
@ParentPackage("json-default")
@Namespace("/producthistory")
public class ProductInOutAction extends BaseAction<ProductInOut> {

	private static final long serialVersionUID = -4333502447249419970L;
	@Autowired
	private IProductInOutService productInOutService;

	
	/**
	 * 
	 * 方  法 名: add
	 * 功能描述： 
	 * 输入参数: ProductInOutAction
	 * 返 回 值:  ProductInOutAction
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月28日 下午1:17:33
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月28日 下午1:17:33
	 */
	@Action(value = "addProductInOut",results={@Result(name = SUCCESS,type = "json",params={"root","result"})})
	public String add(){
		String proid = request.getParameter("proid");//产品编号
		String pioquantity = request.getParameter("pioquantity");//操作数量
		String piotype = request.getParameter("piotype");//操作类型
		String piooperation = request.getParameter("piooperation");//灌机人
		String piooperationnum = request.getParameter("piooperationnum");//灌机点数
		String pioagreementid = request.getParameter("pioagreementid");//合同编号
		String pioprojectid = request.getParameter("pioprojectid");//项目编号
		String pioprojectname = request.getParameter("pioprojectname");//项目名称
		String piointime = request.getParameter("piointime");//归还时间
		String piosign = request.getParameter("piosign");//签约公司（最终用户）
		String piodelivery = request.getParameter("piodelivery");//提货人
		String pioremark = request.getParameter("pioremark");//操作备注
		
		entity.setProid(Integer.valueOf(proid));
		entity.setPioquantity(Integer.valueOf(pioquantity));
		entity.setPiotype(piotype);
		entity.setPiooperation(piooperation);
		entity.setPiooperationnum(Integer.valueOf(piooperationnum));
		entity.setPioagreementid(pioagreementid);
		entity.setPioprojectid(pioprojectid);
		entity.setPioprojectname(pioprojectname);
		entity.setPiointime(piointime);
		entity.setPiosign(piosign);
		entity.setPiodelivery(piodelivery);
		entity.setPioremark(pioremark);
		
		result = productInOutService.addProductInOut(entity,servletActionContext);
		return SUCCESS;
	}
	
	
	/**
	 * 
	 * 方  法 名: del
	 * 功能描述： 
	 * 输入参数: ProductInOutAction
	 * 返 回 值:  ProductInOutAction
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月28日 下午1:17:29
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月28日 下午1:17:29
	 */
	@Action(value = "delProductInOut",results={@Result(name = SUCCESS,type = "json",params={"root","result"})})
	public String del(){
		String pioid = request.getParameter("pioid");//操作编号
		
		result = productInOutService.deleteProductInOutById(pioid,servletActionContext);
		return SUCCESS;
	}
	

	/**
	 * 
	 * 方  法 名: update
	 * 功能描述： 
	 * 输入参数: ProductInOutAction
	 * 返 回 值:  ProductInOutAction
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月28日 下午1:17:24
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月28日 下午1:17:24
	 */
	@Action(value = "updateProductInOut",results={@Result(name = SUCCESS,type = "json",params={"root","result"})})
	public String update(){
		String pioid = request.getParameter("pioid");//操作编号
		String proid = request.getParameter("proid");//产品编号
		String pioquantity = request.getParameter("pioquantity");//操作数量
		String piotype = request.getParameter("piotype");//操作类型
		String piooperation = request.getParameter("piooperation");//灌机人
		String piooperationnum = request.getParameter("piooperationnum");//灌机点数
		String pioagreementid = request.getParameter("pioagreementid");//合同编号
		String pioprojectid = request.getParameter("pioprojectid");//项目编号
		String pioprojectname = request.getParameter("pioprojectname");//项目名称
		String piointime = request.getParameter("piointime");//归还时间
		String piosign = request.getParameter("piosign");//签约公司（最终用户）
		String piodelivery = request.getParameter("piodelivery");//提货人
		String pioremark = request.getParameter("pioremark");//操作备注
		
		entity.setPioid(Integer.valueOf(pioid));
		entity.setProid(Integer.valueOf(proid));
		entity.setPioquantity(Integer.valueOf(pioquantity));
		entity.setPiotype(piotype);
		entity.setPiooperation(piooperation);
		entity.setPiooperationnum(Integer.valueOf(piooperationnum));
		entity.setPioagreementid(pioagreementid);
		entity.setPioprojectid(pioprojectid);
		entity.setPioprojectname(pioprojectname);
		entity.setPiointime(piointime);
		entity.setPiosign(piosign);
		entity.setPiodelivery(piodelivery);
		entity.setPioremark(pioremark);

		result = productInOutService.updateProductInOut(entity,servletActionContext);
		return SUCCESS;
	}

	/**
	 * 
	 * 方  法 名: update
	 * 功能描述： 
	 * 输入参数: ProductInOutAction
	 * 返 回 值:  ProductInOutAction
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月28日 下午1:17:24
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月28日 下午1:17:24
	 */



	@Action(value = "getProductInOutById",results={@Result(name = SUCCESS,type = "json",params={"root","result"})})
	public String findById(){
		String pioid = request.getParameter("pioid");//操作编号
		String state = request.getParameter("state");
		result = productInOutService.findProductInOutById(pioid,servletActionContext);
		ProductInOut pio = (ProductInOut) result.get("rows");
		if(pio != null && state =="1"){
			request.getSession().setAttribute("p", pio);
		}
		System.out.println(pioid+"-----" + state + "--------");
		return SUCCESS;
	}
	
	@Action(value = "getById",results={@Result(name = SUCCESS,location="/core/coreApp/history/view/library.jsp")})
	public String findByIdaa(){
		String pioid = request.getParameter("pioid");//操作编号
		ProductInOut pro = productInOutService.findInOutById(pioid,servletActionContext);
		
		if(pro != null){
			request.getSession().setAttribute("pro", pro);
			//request.getSession().setAttribute("pro", pro);
			
		}
		return SUCCESS;
	}


	/**
	 * 
	 * 方  法 名: findByPage
	 * 功能描述： 
	 * 输入参数: ProductInOutAction
	 * 返 回 值:  ProductInOutAction
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月28日 下午1:30:54
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月28日 下午1:30:54
	 */
	@Action(value = "getProductInOutPage",results={@Result(name = SUCCESS,type = "json",params={"root","result"})})
	public String findByPage(){
		String start = request.getParameter("start");//开始下标
		String page = request.getParameter("page");//页数
		String limit = request.getParameter("limit");//页面记录数
		
		result = productInOutService.findProductInOutPage(page, start, limit,servletActionContext);
		return SUCCESS;
	}

	/**
	 * 
	 * 方  法 名: findByPage
	 * 功能描述： 
	 * 输入参数: ProductInOutAction
	 * 返 回 值:  ProductInOutAction
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月28日 下午1:30:58
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月28日 下午1:30:58
	 */
	@Action(value = "getProductInOutAll",results={@Result(name = SUCCESS,type = "json",params={"root","result"})})
	public String findByAll(){	
		
		result = productInOutService.findProductInOutAll(servletActionContext);
		return SUCCESS;
	}
	
	 
/**********************   setter  and  getter  ****************************/	
	/** 
	 * 方  法 名: setServletResponse
	 * 功能描述： 
	 * 输入参数: ServletResponseAware
	 * 返 回 值:  ServletResponseAware
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月28日 上午10:47:15
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月28日 上午10:47:15
	 */
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	/** 
	 * 方  法 名: setServletRequest
	 * 功能描述： 
	 * 输入参数: ServletRequestAware
	 * 返 回 值:  ServletRequestAware
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月28日 上午10:47:15
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月28日 上午10:47:15
	 */
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/** 
	 * 方  法 名: getModel
	 * 功能描述： 
	 * 输入参数: ModelDriven<ProductInOut>
	 * 返 回 值:  ModelDriven<ProductInOut>
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月28日 上午10:47:15
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月28日 上午10:47:15
	 */
	@Override
	public ProductInOut getModel() {
		return entity;
	}

	public IProductInOutService getProductInOutService() {
		return productInOutService;
	}

	public void setProductInOutService(IProductInOutService productInOutService) {
		this.productInOutService = productInOutService;
	}

}
