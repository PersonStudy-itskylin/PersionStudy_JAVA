/*
 * 用户实体类
 */
 Ext.define("core.user.model.UserModel",{
 	extend:"Ext.data.Model",
 	fields:[
 		{name:"id",type:"int",srotable:true},
 		{name:"username",type:"string",srotable:true},
 		{name:"password",type:"string",srotable:true},
 		{name:"realname",type:"string",srotable:true},
 		{name:"description",type:"string",srotable:true},
 		{name:"role",type:"int",srotable:true
 		 			
 		},
 		{name:"phone",type:"long",srotable:true},
 		{name:"tel",type:"string",srotable:true},
 		{name:"qq",type:"long",srotable:true},
 		{name:"email",type:"string",srotable:true},
 		{name:"state",type:"int",srotable:true
 		
 		},
 		{name:"ip",type:"string",srotable:true},
 		{name:"cratetime",type:"string",srotable:true},
 		{name:"updatetime",type:"string",srotable:true},
 		{name:"remark",type:"string",srotable:true}
 	]
 });