/*
 * 商品实体类
 */
 Ext.define("core.systemlog.model.SystemlogModel",{
 	extend:"Ext.data.Model",
 	fields:[
 	        {name:"sysid",type:"int",srotable:true},
 	 		{name:"accid",type:"string",srotable:true},
 	 		{name:"sysname",type:"string",srotable:true},
 	 		{name:"systime",type:"string",srotable:true},
 	 		{name:"sysip",type:"string",srotable:true},
 	 		{name:"sysremark",type:"string",srotable:true}
 	 	]
 });