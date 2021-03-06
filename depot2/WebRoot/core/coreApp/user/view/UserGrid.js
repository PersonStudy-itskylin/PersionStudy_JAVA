/**
 * ClassName 流程挂接视图
 * */
var store=Ext.create("core.user.store.UserStore");

Ext.define("core.user.view.UserGrid",{
	extend:"Ext.grid.Panel",
	alias:"widget.usergrid",
	model :"core.user.model.UserModel",
	store:store,
	id:"usergrid",
	selModel:{
		selType:"checkboxmodel"
	},
	border:0,
	multiSelect:true,
	frame:true,
	tbar:[
		{xtype:'button',text:'新增用户',ref:'addUser',iconCls:'table_add'},
		{xtype:'button',text:'修改用户',ref:'updateUser',iconCls:'table_edit'},
		{xtype:'button',text:'删除用户',ref:'removeUser',iconCls:'table_remove'},
		"->",
		{
		 xtype : 'combobox',
		 store : 'core.user.store.UserSearchStore',
		 id: 'search1',
		 editable:false,
		 width : 150,
		 labelWidth : 60,
		 value : '用户ID',
		 triggerAction : 'all',
		 forceSelction : true,
		 fieldLabel : '检索条件',
		 queryModel : 'local',
		 displayField : 'name',
		 valueField : 'id'
		 }, {
			 xtype : 'triggerfield',
			 triggerCls : Ext.baseCSSPrefix + 'form-search-trigger',
			 listeners : {
						'change' : function(_this, _new, _old, _option) {
							var _store = _this.ownerCt.ownerCt.getStore();
							var search = Ext.getCmp('search1').getValue();
							
							_store.clearFilter(false);
							_store.filter(search, _new);
						},
						onTriggerClick : function() {
							alert(this.getValue());
							_store.clearFilter(false);
							_store.filter(search, this.getValue());
						}
					}
			}],
	bbar:{
		xtype:'pagingtoolbar',
		store:store,
		dock:'bottom',
		plugins:[Ext.create("core.util.PageSizePlugin")],
		displayInfo:true
	},
	enableKeyNav:true,  //可以使用键盘控制上下
	columnLines:true, //展示竖线
	columns:[
		{xtype: 'rownumberer'},
		{text:"ID",dataIndex:"id",width:20,border: 20},
		{text:"用户名",dataIndex:"username",width:100,border: 50},
		{text:"用户姓名",dataIndex:"realname",width:80},
		{text:"权限",dataIndex:"role",width:80},
		{text:"手机号",dataIndex:"phone",width:100},
		{text:"电话",dataIndex:"tel",width:100},
		{text:"QQ",dataIndex:"qq",width:100},
		{text:"电子邮箱",dataIndex:"email",width:100},
		{text:"账号状态",dataIndex:"state",width:50},
		{text:"注册IP",dataIndex:"ip",width:70},
		{text:"注册时间",dataIndex:"createtime",width:130},
		{text:"更新时间",dataIndex:"updatetime",width:130},
		{text:"备注",dataIndex:"remark",width:100}
		
	],
	initComponent:function(){
		this.callParent(arguments);
	}
});