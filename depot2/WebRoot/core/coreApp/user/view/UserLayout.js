/**用户管理视图布局类*/
Ext.define("core.user.view.UserLayout", {
	extend : 'Ext.panel.Panel',
	alias : 'widget.userlayout',
	title : "<center height=40>用户管理</center>",
	//closable:true,
	defaults : {
		bodyStyle : 'padding:1px'
	},
	layout : 'fit',
	items:[{
		xtype:"usergrid",
		id:'usergrid'
	},{
		xtype:"userform",
		hidden:true
	}]
});