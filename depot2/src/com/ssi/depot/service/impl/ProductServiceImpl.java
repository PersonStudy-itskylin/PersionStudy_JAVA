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

import com.ssi.depot.dao.IProductDAO;
import com.ssi.depot.entity.Account;
import com.ssi.depot.entity.Product;
import com.ssi.depot.entity.SystemLog;
import com.ssi.depot.service.IProductService;
import com.ssi.depot.service.ISystemLogService;
import com.ssi.depot.util.DateUtil;
import com.ssi.depot.util.PageUtil;
import com.ssi.depot.util.SysLogUtil;

/** 
 * CopyRright (c)2005-2014:   <极地信息Jidi Information> 
 * Project:  depot
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package com.ssi.depot.service.impl;
 * Author：      林为 
 * Create Date： 2014年10月20日 下午2:28:56
 * Modified By：  林为 
 * Modified Date: 2014年10月20日 下午2:28:56
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
@SuppressWarnings("all")
@Service("productService")
@Transactional
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductDAO productDao;
	@Autowired
	private ISystemLogService syslogService;
	private Product product;
	private String msg = "";
	private Map<String, Object> json;
	private boolean flag;
	private Integer userId;
	private String userName;
	private String SystemRemark;
	
	/** 
	 * 方  法 名: findProductByid
	 * 功能描述： 
	 * 输入参数: ProductServiceImpl
	 * 返 回 值:  ProductServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月20日 下午2:28:56
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月20日 下午2:28:56
	 */
	@Override
	public Map<String, Object> findProductById(String id,ServletActionContext servletActionContext) {
		flag = false;
		msg = "未找到id为  "+ id + " 的产品！";
		json = new HashMap<String, Object>();
		Product pro = productDao.selectProductById(id);
		if(pro != null){
			flag = true;
			json.put("rows", pro);
			Account accSession = (Account) servletActionContext.getRequest().getSession().getAttribute("account");
			
			/********添加 系统记录**********/
			userId = accSession.getId();
			userName = accSession.getRealname();
			
			SystemRemark = "管理员:" + userName + "(ID:" + userId + ") 查询ID：" + pro.getProid() + "产品";

			SystemLog sys = new SystemLog();
			sys.setAccid(userId);
			sys.setSysname(SysLogUtil.SystemModule_SELECTProduct);
			sys.setSysremark(SystemRemark);
			syslogService.addSystemLog(sys, servletActionContext);
			
			/*****************************/
		}else{
			json.put("msg", msg);
		}
		json.put("success", flag);
		return json;
	}

	/** 
	 * 方  法 名: addProduct
	 * 功能描述： 
	 * 输入参数: ProductServiceImpl
	 * 返 回 值:  ProductServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月20日 下午2:28:56
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月20日 下午2:28:56
	 */
	@Override
	public Map<String, Object> addProduct(Product product,ServletActionContext servletActionContext) {
		flag = false;
		msg  = "添加产品失败，请重试...";
		json = new HashMap<String, Object>();
		Product proIfNull = productDao.selectProductByIfProduct(product);
		
		//判断仓库是否存在同名同型号的产品，不存在直接添加
		if(proIfNull == null){
			
			Account accSession = (Account)servletActionContext.getRequest().getSession().getAttribute("account");
			userId = accSession.getId();
			userName = accSession.getRealname();
			
			product.setAccid(userId);//获得用户ID
			product.setProcreatetime(DateUtil.format(new Date()));//获得系统时间
			if (productDao.insertProduct(product) > 0) {
				flag = true;
				msg = "添加成功！";
				
				/********添加 系统记录**********/
				Product pro = productDao.selectProductByIfProduct(product);
				
				SystemRemark = "管理员:" + userName + "(ID:" + userId + ") 入库产品ID：" + pro.getProid();
				
				SystemLog sys = new SystemLog();
				sys.setAccid(userId);
				sys.setSysname(SysLogUtil.SystemModule_ADDProduct);
				sys.setSysremark(SystemRemark);
				syslogService.addSystemLog(sys, servletActionContext);
				
				/*****************************/
			}else{
				flag = false;
				msg = "添加失败！";
			}
		}else{
			product.setProid(proIfNull.getProid());
			if(productDao.updateProduct(product) > 0){
				flag = true;
				msg = "修改成功！";
				
				/********添加 系统记录**********/

				SystemRemark = "管理员:" + userName + "(ID:" + userId + ") 入库产品ID：" + product.getProid();
				
				SystemLog sys = new SystemLog();
				sys.setAccid(userId);
				sys.setSysname(SysLogUtil.SystemModule_UPDATEProduct);
				sys.setSysremark(SystemRemark);
				syslogService.addSystemLog(sys, servletActionContext);
				
				/*****************************/
			}else{
				flag = false;
				msg = "修改失败！";
			}
		}
		json.put("success", flag);
		json.put("msg", msg);
		return json;
	}

	/** 
	 * 方  法 名: findProductAll
	 * 功能描述： 
	 * 输入参数: ProductServiceImpl
	 * 返 回 值:  ProductServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月20日 下午2:28:56
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月20日 下午2:28:56
	 */
	@Override
	public Map<String, Object> findProductAll(ServletActionContext servletActionContext) {
		flag = false;
		json = new HashMap<String, Object>();
		List<Product> rows = productDao.selectProductAll();
		if (rows != null) {
			flag = true;
			json.put("total", rows.size());
			json.put("rows", rows);
			Account accSession = (Account) servletActionContext.getRequest().getSession().getAttribute("account");
			
			/********添加 系统记录**********/
			
			userId = accSession.getId();
			userName = accSession.getRealname();
			
			SystemRemark = "管理员:" + userName + "(ID:" + userId + ") 查询仓库所有产品";
			
			SystemLog sys = new SystemLog();
			sys.setAccid(userId);
			sys.setSysname(SysLogUtil.SystemModule_SELECTProduct);
			sys.setSysremark(SystemRemark);
			syslogService.addSystemLog(sys, servletActionContext);
			
			/*****************************/
		}
		json.put("success", flag);
		return json;
	}

	/** 
	 * 方  法 名: findProductPage
	 * 功能描述： 
	 * 输入参数: ProductServiceImpl
	 * 返 回 值:  ProductServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月20日 下午2:28:56
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月20日 下午2:28:56
	 */
	@Override
	public Map<String, Object> findProductPage(String page,String start, String pageSize,ServletActionContext servletActionContext) {
		flag = false;
		json = new HashMap<String, Object>();
		List<Product> list = productDao.selectProductByPage(PageUtil.page(page,start, pageSize));
		if (list != null) {
			flag = true;
			json.put("total", productDao.selectProductAll().size());
			json.put("rows", list);
			
			/********添加 系统记录**********/
			Account accSession =(Account) servletActionContext.getRequest().getSession().getAttribute("account");
			userId = accSession.getId();
			userName = accSession.getRealname();
			
			SystemRemark = "管理员:" + userName + "(ID:" + userId + ") 查询仓库所有产品";
			
			SystemLog sys = new SystemLog();
			sys.setAccid(userId);
			sys.setSysname(SysLogUtil.SystemModule_SELECTProduct);
			sys.setSysremark(SystemRemark);
			syslogService.addSystemLog(sys, servletActionContext);
			
			/*****************************/
		}
		json.put("success", flag);
		return json;
	}

	/** 
	 * 方  法 名: updateProduct
	 * 功能描述： 
	 * 输入参数: ProductServiceImpl
	 * 返 回 值:  ProductServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月20日 下午2:28:56
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月20日 下午2:28:56
	 */
	@Override
	public Map<String, Object> updateProduct(Product product,ServletActionContext servletActionContext) {
		json = new HashMap<String, Object>();
		flag = false;
		String msg = "修改失败，请重试...";
		Account accSession =(Account)servletActionContext.getRequest().getSession().getAttribute("account");
		String editor = accSession.getRealname();
		product.setProeditor(editor);//产品修改者
		if (productDao.updateProduct(product) > 0) {
			flag = true;
			msg = "修改成功！";
			
			/********添加 系统记录**********/
			
			userId = accSession.getId();
			userName = accSession.getRealname();
			
			SystemRemark = "管理员:" + userName + "(ID:" + userId + ") 修改产品ID：" + product.getProid();
			
			SystemLog sys = new SystemLog();
			sys.setSysname(SysLogUtil.SystemModule_UPDATEProduct);
			sys.setSysremark(SystemRemark);
			syslogService.addSystemLog(sys, servletActionContext);
			
			/*****************************/
		}
		json.put("success", flag);
		json.put("msg", msg);
		return json;
	}

	/** 
	 * 方  法 名: deleteProductById
	 * 功能描述： 
	 * 输入参数: ProductServiceImpl
	 * 返 回 值:  ProductServiceImpl
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月20日 下午2:28:56
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月20日 下午2:28:56
	 */
	@Override
	public Map<String, Object> deleteProductById(String idStr,ServletActionContext servletActionContext) {
		json = new HashMap<String, Object>();
		flag = false;
		String[] ids = idStr.split(",");
		String error = "";
		String ok = "";
		msg = "删除ID为   " + idStr + " 的产品失败，请重试...";
		System.out.println(" idstr  = " + idStr);
		for(int i = 0; i< ids.length; i++){
			System.out.println();
			System.out.println("=======   " + i + "    --   " + ids[i]);
			System.out.println("-----");
			if(productDao.delProduct(ids[i])>0){
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
		msg = "用户ID: " + ok + "  删除成功!";
		if(error.length() != 0 ){
			msg +="用户ID:" + error + " 删除失败..";
			json.put("error", error);
		}
		if(ok.length() != 0){
			/********添加 系统记录**********/
			Account accsession =(Account)servletActionContext.getRequest().getSession().getAttribute("account");
			userId = accsession.getId();
			userName = accsession.getRealname();
			
			SystemRemark = "管理员:" + userName + "(ID:" + userId + ") 清理产品ID：" + ok;
			
			SystemLog sys = new SystemLog();
			sys.setAccid(userId);
			sys.setSysname(SysLogUtil.SystemModule_DELProduct);
			sys.setSysremark(SystemRemark);
			syslogService.addSystemLog(sys, servletActionContext);
			
			/*****************************/
		}
		json.put("ok", ok);
		json.put("success", flag);
		json.put("msg", msg);
		return json;
	}

/*******************   setter and getter   **********************************/
	
	
	
	public IProductDAO getProductDao() {
		return productDao;
	}

	public void setProductDao(IProductDAO productDao) {
		this.productDao = productDao;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ISystemLogService getSyslogService() {
		return syslogService;
	}

	public void setSyslogService(ISystemLogService syslogService) {
		this.syslogService = syslogService;
	}

}
