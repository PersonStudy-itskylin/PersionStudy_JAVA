/*
 * Copyright (c) 2005-2020 BeiJing Jidi Information Tech Co.,Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 北京极地信息安全安全有限公司.
 */
package com.ssi.depot.util;

/** 
 * CopyRright (c)2005-2014:   <极地信息Jidi Information> 
 * Project:  depot2
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  菜单列表
 * JDK version used: <JDK1.6>                              
 * Namespace: package com.ssi.depot.util;
 * Author：      林为 
 * Create Date： 2014年11月25日 上午10:53:01
 * Modified By：  林为 
 * Modified Date: 2014年11月25日 上午10:53:01
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
public class MenuUtil {

	public static final String AccountMenu = new StringBuffer()
														.append("{")//用户管理菜单
															.append("title:'用户管理',")
															.append("items:[{")
															.append("xtype:'treepanel',")
															.append("rootVisible : false,")
															.append("displayField : 'text',")
															.append("border:0,")
															.append("root: {")
															.append("expanded: true,")
															.append("children: [")
																	.append("{ ")
																		.append("id:'usermanager',")
																		.append("text: '用户基本信息', ")
																		.append("leaf: true ")
																	.append("}]")
																.append("}")
															.append("}]")
														.append("}")
													.toString();
	
	public static final String DepotMenu = new StringBuffer()
														.append("{")
															.append("title:'仓库管理',")
															.append("items:[{")
																.append("xtype:'treepanel',")
																.append("rootVisible : false,")
																.append("displayField : 'text',")
																.append("border:0,")
																.append("root: {")
																	.append("expanded: true,")
																	.append("children: [{ ")
																			.append("text: '仓库基本信息',")
																			.append("id:'productmanager',")
																			.append("leaf: true ")
																		.append("},{")
																			.append("text:'出入库记录',")
																			.append("id:'historyinfo',")
																			.append("}]")
																	.append("}")
																.append("}]")
															.append("}")
														.toString();
	public static final String ProductMenu = new StringBuffer()
															.append("{")
																.append("title:'仓库管理',")
																.append("items:[{")
																	.append("xtype:'treepanel',")
																	.append("rootVisible : false,")
																	.append("displayField : 'text',")
																	.append("border:0,")
																	.append("root: {")
																		.append("expanded: true,")
																		.append("children: [{ ")
																			.append("text: '仓库基本信息',")
																			.append("id:'productmanager',")
																			.append("leaf: true ")
																		.append("}]")
																	.append("}")
																.append("}]")
															.append("}")
														.toString();
	
	public static final String ProductInOutMenu = new StringBuffer()
															.append("{")
															.append("title:'仓库管理',")
															.append("items:[{")
															.append("xtype:'treepanel',")
															.append("rootVisible : false,")
															.append("displayField : 'text',")
															.append("border:0,")
															.append("root: {")
															.append("expanded: true,")
															.append("children: [{")
																	.append("text:'出入库记录',")
																	.append("id:'historyinfo',")
																	.append("}]")
																	.append("}")
																.append("}]")
															.append("}")
														.toString();
	

	public static final String SystemLogMenu = new StringBuffer()
															.append("{")
															.append("title:'审计',")
															.append("items:[{")
																.append("xtype:'treepanel',")
																.append("rootVisible : false,")
																.append("displayField : 'text',")
																.append("border:0,")
																.append("root: {")
																	.append("expanded: true,")
																	.append("children: [{ ")
																			.append("id:'systemlog',")
																			.append("text: '内部审计',") 
																			.append("leaf: true")
																		.append("}")
																	.append("]")
																.append("}")
															.append("}]")
														.append("}")
														.toString();
	public static final String BackupMenu = new StringBuffer()
															.append("{")
															.append("title:'审计',")
															.append("items:[{")
																.append("xtype:'treepanel',")
																.append("rootVisible : false,")
																.append("displayField : 'text',")
																.append("border:0,")
																.append("root: {")
																	.append("expanded: true,")
																	.append("children: [{ ")
																		.append("id:'systemlog',")
																		.append("text: '内部审计',") 
																		.append("leaf: true")
																		.append("}")
																	.append("]")
																.append("}")
															.append("}]")
														.append("}")
														.toString();
}
