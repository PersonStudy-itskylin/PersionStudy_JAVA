/*
 * 商品数据集类
 */
 Ext.define("core.history.store.HistoryStore",{
 	extend:'Ext.data.Store',
	model:'core.history.model.HistoryModel',
	pageSize:[10],
	//autoSync:true,//与服务器同步
	proxy:{
		type:"ajax",
		url:"producthistory/getProductInOutPage.action",
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