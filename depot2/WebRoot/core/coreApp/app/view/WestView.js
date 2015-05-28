/**
 * 宸﹁竟閮ㄥ垎
 */
Ext.define("core.app.view.WestView",{
	extend: 'Ext.panel.Panel',
	alias: 'widget.westview',
	collapsible: true,
	split: true,
	defaults: {
		bodyStyle: 'padding:2px'
	}, 	
	border:1,
	margins: '2 2 0 0',
	width: 225,
	minSize: 100,
	maxSize: 250,
	title:"功能模块导航",
	layout : 'accordion',
	layoutConfig :{
				titleCollapse: false,
				animate: true,
				activeOnTop: true,
				blockRefresh:true
			},
	items:[{
		title:"用户管理",
		items:[{
			xtype:"treepanel",
			rootVisible : false,// 不展示根节点
			displayField : "text",
			border:0,
			root: {
	       	 	expanded: true,
	        	children: [
	            	{ 
	            		id:"usermanager",
	            		text: "用户基本信息", 
	            	 	leaf: true 
	            	}
	        	]
    		}
		}]
	},{
		title:"仓库管理",
		items:[{
			xtype:"treepanel",
			rootVisible : false,// 不展示根节点
			displayField : "text",
			border:0,
			root: {
	       	 	expanded: true,
	        	children: [{ 
	            		text: "仓库基本信息",
	            		id:"productmanager",
	            	 	leaf: true 
	            	},{ 
	            		text: "出入库记录",
	            		id:"historyinfo",
	            	 	leaf: true 
	            	}
	        	]
    		}
		}]
	
	},{
		title:"审计",
		items:[{
			xtype:"treepanel",
			rootVisible : false,// 不展示根节点
			displayField : "text",
			border:0,
			root: {
	       	 	expanded: true,
	        	children: [
	            	{ 
	            		id:"systemlog",
	            		text: "内部审计", 
	            	 	leaf: true 
	            	}
	        	]
    		}
		}]
	}/*,{
		title:"订单管理",
		items:[{
			xtype:"treepanel",
			rootVisible : false,// 不展示根节点
			displayField : "text",
			border:0,
			root: {
	       	 	expanded: true,
	        	children: [
	            	{ 
	            		id:"salesorderment",
	            		text: "订单列表", 
	            	 	leaf: true 
	            	}
	        	]
    		}
		}]
	},{
		title:"系统设置",
		html: "权限管理"	
	}*/],
    initComponent: function(){
        this.callParent(arguments);
    }
});



