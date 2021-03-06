/*
 * 商品数据集类
 */
 Ext.define("core.product.store.ProductStore",{
 	extend:'Ext.data.Store',
	model:'core.product.model.ProductModel',
	pageSize:[10],
	//autoSync:true,//与服务器同步
	proxy:{
		type:"ajax",
		url:"product/getProductPage",
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