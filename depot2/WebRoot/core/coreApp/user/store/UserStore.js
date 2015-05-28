/*
 * ClassName 用户数据集
 */
 Ext.define("core.user.store.UserStore",{
 	extend:'Ext.data.Store',
	model:'core.user.model.UserModel',
	pageSize:[10],//每页显示10条记录
	//autoSync:true,//与服务器同步
	proxy:{
		type:"ajax",
		url:"user/getAccountPage.action",
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