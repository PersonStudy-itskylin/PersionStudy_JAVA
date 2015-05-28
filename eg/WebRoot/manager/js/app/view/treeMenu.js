Ext.define('AM.view.treeMenu', {
	extend : 'Ext.panel.Panel',
	alias:'widget.treemenu',
	titleCollapse : true,
	width : 190,
	rootVisible : false,
	autoScroll : true,
	resizable : false,
	titleAlign:'center',
	frame : true,
	collapsible : 'left',
	icon : 'images/treemenu/house.png',
	bodyStyle : 'background:none;padding:5px;',
	store:'treeMenuStore',
	layout:'accordion',
	useArrows:true,
	items:[
		{id:2,title:'商品管理',frame:true,icon:'images/usertable/user.png',xtype:'treepanel',id:'spgl',rootVisible:false,
			root:{
				children:[
					{id:11,text:'商品列表',icon:'images/usertable/user.png',leaf:true},
					{id:12,text:'商品分类',icon:'images/usertable/user.png',leaf:true}
				]
			}
		},
		{id:'order',title:'订单管理',frame:true,icon:'images/usertable/user.png',xtype:'treepanel',rootVisible:false,
			root:{
				children:[
					{text:'订单列表',icon:'images/usertable/user.png',leaf:true}
				]
			}
		},
		{id:'user',title:'用户管理',frame:true,icon:'images/usertable/user.png',xtype:'treepanel',rootVisible:false,
			root:{
				children:[
					{text:'用户列表',icon:'images/usertable/user.png',leaf:true},
					{text:'管理员列表',icon:'images/usertable/user.png',leaf:true}
				]
			}
		},
		{id:'setting',title:'系统设置',frame:true,icon:'images/treemenu/icon_settings.gif',xtype:'treepanel',lines:false,rootVisible:false,
			root:{
				children:[
					{id:41,text:'数据库管理',icon:'images/treemenu/database_wrench.png',children:[
							{id:411,text:'数据库状态',icon:'images/treemenu/database_start.png',leaf:true},
							{id:412,text:'数据库备份',icon:'images/treemenu/database_save.png',leaf:true},
							{id:413,text:'数据库恢复',icon:'images/treemenu/database_go.png',leaf:true}
						]
					},
					{id:42,text:'系统日志',icon:'images/usertable/user.png',leaf:true}
				]
			}
		}
	]
});