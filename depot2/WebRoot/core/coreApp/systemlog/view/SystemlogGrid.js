/**
 * ClassName 流程挂接视图
 * */
var store=Ext.create("core.systemlog.store.SystemlogStore");

Ext.define("core.systemlog.view.SystemlogGrid",{
	extend:"Ext.grid.Panel",
	alias:"widget.systemlog_grid",
	model :"core.systemlog.model.SystemlogModel",
	store:store,
	id:"systemlog_grid",
	selModel:{
		selType:"checkboxmodel"
	},
	border:0,
	multiSelect:true,
	frame:true,
	tbar:[
		{xtype:'button',text:'删除',ref:'removeSystemlog',iconCls:'table_remove'}
		/*,
		"->",
		{
		 xtype : 'combobox',
		 store : 'core.History.store.historySearchStore',
		 id: 'search',
		 editable:false,
		 width : 150,
		 labelWidth : 60,
		 value : '产品ID',
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
							var search = Ext.getCmp('search').getValue();
							
							_store.clearFilter(false);
							_store.filter(search, _new);
						},
						onTriggerClick : function() {
							alert(this.getValue());
							_store.clearFilter(false);
							_store.filter(search, this.getValue());
						}
					}
			}*/
		],
	bbar:{
		xtype:'pagingtoolbar',
		store:store,
		dock:'bottom',
		displayInfo:true
	},
	enableKeyNav:true,  //可以使用键盘控制上下
	columnLines:true, //展示竖线
	columns:[
		{xtype: 'rownumberer'},
		{text:"日志ID",dataIndex:"sysid",width:50,border: 20},
		{text:"用户编号",dataIndex:"accid",width:70},
		{text:"操作模块",dataIndex:"sysname",width:80},
		{text:"操作时间",dataIndex:"systime",width:100},
		{text:"操作者IP",dataIndex:"sysip",width:80},
		{text:"操作说明",dataIndex:"sysremark",width:250}
	],
	initComponent:function(){
		this.callParent(arguments);
	}
});