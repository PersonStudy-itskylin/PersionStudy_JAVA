/*
 * 商品数据集类
 */
 Ext.define("core.comptroller.store.ComptrollerStore",{
 	extend:'Ext.data.Store',
	model:'core.comptroller.model.ComptrollerModel',
	pageSize:[10],
	//autoSync:true,//与服务器同步
	proxy:{
		type:"ajax",
		//url:"history/getHistoryPage",
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