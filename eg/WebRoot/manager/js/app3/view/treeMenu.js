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
	icon : 'images/icon_home.gif',
	bodyStyle : 'background:none;padding:5px;',
	store:'treeMenuStore',
	layout:'accordion',
	items:[
		{id:2,title:'商品管理',frame:true,icon:'images/folder.gif',xtype:'treepanel',id:'spgl',rootVisible:false,
			root:{
				children:[
					{id:11,text:'商品',children:[
							{id:111,text:'食品类',children:[
								{id:1111,text:'瓜子',leaf:true},
								{id:1112,text:'面包',leaf:true}
							]},
							{id:122,text:'户外类',children:[
								{id:1121,text:'登山',leaf:true},
								{id:1122,text:'旅游',leaf:true}
							]},
							{id:123,text:'数码类',children:[
								{id:1131,text:'登山',leaf:true},
								{id:1132,text:'旅游',leaf:true}
							]}
						]
					},
					{id:12,text:'商品分类',leaf:true}
				]
			}
		},
		{id:'order',title:'订单管理',frame:true,icon:'images/user.png',xtype:'treepanel',rootVisible:false,
			root:{
				children:[
					{text:'订单列表',icon:'images/user.png',leaf:true}
				]
			}
		},
		{id:'user',title:'用户管理',frame:true,icon:'images/user.png',xtype:'treepanel',rootVisible:false,
			root:{
				children:[
					{text:'用户列表',icon:'images/user.png',leaf:true},
					{text:'管理员列表',icon:'images/user.png',leaf:true}
				]
			}
		},
		{id:'setting',title:'系统设置',frame:true,icon:'images/icon_settings.gif',xtype:'treepanel',lines:false,rootVisible:false,
			root:{
				children:[
					{id:41,text:'数据库管理',children:[
							{id:411,text:'数据库状态',leaf:true},
							{id:412,text:'数据库备份',leaf:true},
							{id:413,text:'数据库恢复',leaf:true}
						]
					},
					{id:42,text:'系统日志',leaf:true}
				]
			}
		}
	]
});