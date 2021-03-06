/*
 * 商品数据集类
 */
 Ext.define("core.systemlog.store.SystemlogStore",{
 	extend:'Ext.data.Store',
	model:'core.systemlog.model.SystemlogModel',
	pageSize:[10],
	//autoSync:true,//与服务器同步
	proxy:{
		type:"ajax",
		url:"syslog/getSysLogPage.action",
		reader:{
			type:"json",
			root:"rows",
			totalProperty :'total'		
		},
		writer:{
			type:"json"
		}
	},
	autoLoad:true	
 });