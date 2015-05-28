/*
 * Copyright (c) 2005-2020 BeiJing Jidi Information Tech Co.,Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 北京极地信息安全安全有限公司.
 */
package com.ssi.depot.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssi.depot.dao.IProductInOutDAO;
import com.ssi.depot.entity.Account;
import com.ssi.depot.entity.ProductInOut;
import com.ssi.depot.entity.SystemLog;
import com.ssi.depot.service.IProductInOutService;
import com.ssi.depot.service.ISystemLogService;
import com.ssi.depot.util.DateUtil;
import com.ssi.depot.util.PageUtil;
import com.ssi.depot.util.SysLogUtil;

/** 
 * CopyRright (c)2005-2014:   <极地信息Jidi Information> 
 * Project:  depot2
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package com.ssi.depot.service.impl;
 * Author：      林为 
 * Create Date： 2014年10月28日 上午10:12:52
 * Modified By：  林为 
 * Modified Date: 2014年10月28日 上午10:12:52
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
@SuppressWarnings("all")
@Service("productInOutService")
@Transactional
public class ProductInOutServiceImpl implements IProductInOutService {

	@Autowired
	private IProductInOutDAO productInOutDao;
	@Autowired
	private ISystemLogService syslogService;
	private ProductInOut productInOut;
	private Map<String, Object> json; 
	private String msg = "";
	private boolean flag;
	private Integer userId;
	private String userName;
	private String SystemRemark;
	
	
	/** 
	 * 方  法 名: findProductInOutById
	 * 功能描述： 
	 * 输入参数: ProductInOutServiceImpl
	 * 返 回 值:  ProductInOutServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月28日 上午10:12:52
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月28日 上午10:12:52
	 */
	@Override
	public Map<String, Object> findProductInOutById(String pioid,ServletActionContext servletActionContext) {
		json = new HashMap<String, Object>();
		flag = false;
		ProductInOut rows = productInOutDao.selectProductInOutById(pioid);
		if(rows != null){
			flag = true;
			json.put("rows", rows);
			json.put("total", 1);
			
			/********添加 系统记录**********/
			Account accSession = (Account) servletActionContext.getRequest().getSession().getAttribute("account");
			userId = accSession.getId();
			userName = accSession.getRealname();
			SystemRemark = "管理员:" + userName + "(ID:" + userId + ") 查询 出入库记录ID：" + rows.getPioid();

			SystemLog sys = new SystemLog();
			sys.setAccid(userId);
			sys.setSysname(SysLogUtil.SystemModule_SELECTProductInOut);
			sys.setSysremark(SystemRemark);
			syslogService.addSystemLog(sys, servletActionContext);
			
			/*****************************/
			
		}else{
			msg = "未找到ID为  " + pioid + " 的信息,请核实后查询！";
			json.put("msg", msg);
		}
		json.put("success", flag);
		return json;
	}

	/** 
	 * 方  法 名: addProductInOut
	 * 功能描述： 
	 * 输入参数: ProductInOutServiceImpl
	 * 返 回 值:  ProductInOutServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月28日 上午10:12:52
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月28日 上午10:12:52
	 */
	@Override
	public Map<String, Object> addProductInOut(ProductInOut productInOut,ServletActionContext servletActionContext) {
		json = new HashMap<String, Object>();
		flag = false;
		ProductInOut productInoutIfNull = productInOutDao.selectProductInOutByProductInOut(productInOut);
		Account accSession = (Account) servletActionContext.getRequest().getSession().getAttribute("account");//得到Session
		userId = accSession.getId();
		userName = accSession.getRealname();
		productInOut.setPioapply(accSession.getRealname());//添加申请人
		productInOut.setAccid(accSession.getId());//添加操作用户ID
		productInOut.setPiocount(5);//产品操作次数
		productInOut.setPiouttime(DateUtil.format(new Date()));//操作时间
		productInOut.setPiointime(productInOut.getPiointime() + " " + DateUtil.format(new Date(), "HH:mm"));
		productInOut.setPiodelivery(accSession.getRealname());//操作用户姓名
		if(productInoutIfNull == null){
			if(productInOutDao.insertProductInOut(productInOut) > 0){
				flag = true;
				msg ="添加成功！";
				
				/********添加 系统记录**********/
				
				ProductInOut proInOut = productInOutDao.selectProductInOutByProductInOut(productInOut);
				SystemRemark = "管理员:" + userName + "(ID:" + userId + ") 添加 出库记录ID：" + proInOut.getPioid();
	
				SystemLog sys = new SystemLog();
				sys.setAccid(userId);
				sys.setSysname(SysLogUtil.SystemModule_ADDProductInOut);
				sys.setSysremark(SystemRemark);
				syslogService.addSystemLog(sys, servletActionContext);
				
				/*****************************/
			}else{
				flag = false;
				msg ="添加失败，请重试！";
			}
		}else{
			if(productInOutDao.updateProductInOut(productInOut) > 0){
				flag = true;
				msg ="修改成功！";
				
				/********添加 系统记录**********/
				
				SystemRemark = "管理员:" + userName + "(ID:" + userId + ") 修改 出库记录ID：" + productInOut.getPioid();
	
				SystemLog sys = new SystemLog();
				sys.setAccid(userId);
				sys.setSysname(SysLogUtil.SystemModule_UPDATEProductInOut);
				sys.setSysremark(SystemRemark);
				syslogService.addSystemLog(sys, servletActionContext);
				
				/*****************************/
				
			}else{
				flag = false;
				msg ="修改失败，请重试！";
			}
		}
		json.put("success", flag);
		json.put("msg", msg);
		return json;
	}

	/** 
	 * 方  法 名: findProductInOutAll
	 * 功能描述： 
	 * 输入参数: ProductInOutServiceImpl
	 * 返 回 值:  ProductInOutServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月28日 上午10:12:52
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月28日 上午10:12:52
	 */
	@Override
	public Map<String, Object> findProductInOutAll(ServletActionContext servletActionContext) {
		json = new HashMap<String, Object>();
		flag = false;
		List<ProductInOut> productInOuts = productInOutDao.selectProductInOutAll();
		if(productInOuts != null){
			flag = true;
			json.put("rows", productInOuts);
			json.put("total", productInOuts.size());
			
			/********添加 系统记录**********/
			Account accSession = (Account) servletActionContext.getRequest().getSession().getAttribute("account");
			userId = accSession.getId();
			userName = accSession.getRealname();
			SystemRemark = "管理员:" + userName + "(ID:" + userId + ") 查询所有出入库记录";

			SystemLog sys = new SystemLog();
			sys.setAccid(userId);
			sys.setSysname(SysLogUtil.SystemModule_SELECTProductInOut);
			sys.setSysremark(SystemRemark);
			syslogService.addSystemLog(sys, servletActionContext);
			
			/*****************************/
			
		}else{
			msg ="查询失败，请重试！";
			json.put("msg", msg);
		}
		json.put("success", flag);
		return json;
	}

	/** 
	 * 方  法 名: findProductInOutPage
	 * 功能描述： 
	 * 输入参数: ProductInOutServiceImpl
	 * 返 回 值:  ProductInOutServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月28日 上午10:12:52
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月28日 上午10:12:52
	 */
	@Override
	public Map<String, Object> findProductInOutPage(String page,String start, String limit,ServletActionContext servletActionContext) {
		json = new HashMap<String, Object>();
		flag = false;
		List<ProductInOut> rows = productInOutDao.selectProductInOutByPage(PageUtil.page(page, start, limit));
		if(rows != null){
			flag = true;
			json.put("rows", rows);
			json.put("total", productInOutDao.selectProductInOutAll().size());
			
			/********添加 系统记录**********/
			Account accSession = (Account) servletActionContext.getRequest().getSession().getAttribute("account");
			userId = accSession.getId();
			userName = accSession.getRealname();
			
			SystemRemark = "管理员:" + userName + "(ID:" + userId + ") 查询所有出入库记录";

			SystemLog sys = new SystemLog();
			sys.setAccid(userId);
			sys.setSysname(SysLogUtil.SystemModule_SELECTProductInOut);
			sys.setSysremark(SystemRemark);
			syslogService.addSystemLog(sys, servletActionContext);
			
			/*****************************/
			
		}else{
			msg ="查询失败，请重试！";
			json.put("msg", msg);
		}
		json.put("success", flag);
		return json;
	}

	
	/** 
	 * 方  法 名: updateProductInOut
	 * 功能描述： 
	 * 输入参数: ProductInOutServiceImpl
	 * 返 回 值:  ProductInOutServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月28日 上午10:12:52
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月28日 上午10:12:52
	 */
	@Override
	public Map<String, Object> updateProductInOut(ProductInOut productInOut,ServletActionContext servletActionContext) {
		json = new HashMap<String, Object>();
		flag = false;
		if(productInOutDao.updateProductInOut(productInOut) > 0){
			flag = true;
			msg = "修改成功！";
			SystemLog sys = new SystemLog();
			
			/********添加 系统记录**********/
			Account accSession = (Account) servletActionContext.getRequest().getSession().getAttribute("account");
			userId = accSession.getId();
			userName = accSession.getRealname();
			
			SystemRemark = "管理员:" + userName + "(ID:" + userId + ") 修改出库记录ID:" + productInOut.getPioid();

			sys.setAccid(userId);
			sys.setSysname(SysLogUtil.SystemModule_UPDATEProductInOut);
			sys.setSysremark(SystemRemark);
			syslogService.addSystemLog(sys, servletActionContext);
			
			/*****************************/
			
		}else{
			msg="修改失败！";
			json.put("msg", msg);
		}
		json.put("success", flag);
		return json;
	}

	/** 
	 * 方  法 名: deleteProductInOutById
	 * 功能描述： 
	 * 输入参数: ProductInOutServiceImpl
	 * 返 回 值:  ProductInOutServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月28日 上午10:12:52
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月28日 上午10:12:52
	 */
	@Override
	public Map<String, Object> deleteProductInOutById(String idStr,ServletActionContext servletActionContext) {
		json = new HashMap<String, Object>();
		flag = false;		
		String[] ids = idStr.split(",");
		String error = "";
		String ok = "";
		msg = "删除ID为   " + idStr + " 的信息失败，请重试...";
		System.out.println(" idstr  = " + idStr);
		for(int i = 0; i< ids.length; i++){
			System.out.println();
			System.out.println("=======   " + i + "    --   " + ids[i]);
			System.out.println("-----");
			if(productInOutDao.delProductInOut(ids[i]) > 0){
				flag = true;
				ok += ids[i];
				if(i != (ids.length-1)){
					ok +=",";
				}
			}else{
				error += ids[i];
				if(i != (ids.length-2)){
					error +=",";
				}
			}
		}
		msg = "用户ID: " + ok + "  删除成功；";
		if(error.length() != 0 ){
			msg +="用户ID:" + error + " 删除失败..";
			json.put("error", error);
		}
		if(ok.length() != 0){

			/********添加 系统记录**********/
			Account accSession = (Account) servletActionContext.getRequest().getSession().getAttribute("account");
			userId = accSession.getId();
			userName = accSession.getRealname();
			SystemRemark = "管理员:" + userName + "(ID:" + userId + ") 删除出库记录ID：" + ok;

			SystemLog sys = new SystemLog();
			sys.setAccid(userId);
			sys.setSysname(SysLogUtil.SystemModule_DELProductInOut);
			sys.setSysremark(SystemRemark);
			syslogService.addSystemLog(sys, servletActionContext);
			
			/*****************************/
			
		}
		json.put("ok", ok);
		json.put("success", flag);
		json.put("msg", msg);
		return json;
	}
	
	/**
	 * 
	 */
	@Override
	public ProductInOut findInOutById(String pioid,
			ServletActionContext servletActionContext) {
		return productInOutDao.selectProductInOutById(pioid);
	}
	
/******************   getter and setter   *********************/
	public IProductInOutDAO getProductInOutDao() {
		return productInOutDao;
	}

	public ProductInOut getProductInOut() {
		return productInOut;
	}

	public void setProductInOutDao(IProductInOutDAO productInOutDao) {
		this.productInOutDao = productInOutDao;
	}

	public void setProductInOut(ProductInOut productInOut) {
		this.productInOut = productInOut;
	}

	public ISystemLogService getSyslogService() {
		return syslogService;
	}

	public void setSyslogService(ISystemLogService syslogService) {
		this.syslogService = syslogService;
	}
	
}
