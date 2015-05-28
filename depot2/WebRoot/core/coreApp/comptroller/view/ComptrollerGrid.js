/**
 * ClassName 流程挂接视图
 * */
var store=Ext.create("core.comptroller.store.ComptrollerStore");

Ext.define("core.comptroller.view.ComptrollerGrid",{
	extend:"Ext.grid.Panel",
	alias:"widget.comptroller_grid",
	model :"core.comptroller.model.ComptrollerModel",
	store:store,
	id:"comptroller_grid",
	selModel:{
		selType:"checkboxmodel"
	},
	border:0,
	multiSelect:true,
	frame:true,
	tbar:[
		{xtype:'button',text:'新增',ref:'addHistory',iconCls:'table_add'},
		{xtype:'button',text:'修改',ref:'updateHistory',iconCls:'table_edit'},
		{xtype:'button',text:'删除',ref:'removeHistory',iconCls:'table_remove'}/*,
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
			}*/],
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
		{text:"操作编号",dataIndex:"pioid",width:100,border: 20},
		{text:"商品编号",dataIndex:"proid",width:100,border: 50},
		{text:"用户编号",dataIndex:"accid",width:100},
		{text:"操作数量",dataIndex:"pioquantity",width:100},
		{text:"操作次数",dataIndex:"piocount",width:100},
		{text:"操作类型",dataIndex:"piotype",width:100},
		{text:"灌机人",dataIndex:"piooperation",width:100},
		{text:"灌机点数",dataIndex:"piooperationnum",width:100},
		{text:"合同编号",dataIndex:"pioagreementid",width:100},
		{text:"项目编号",dataIndex:"pioprojectid",width:100},
		{text:"项目名称",dataIndex:"pioprojectname",width:100},
		{text:"操作时间",dataIndex:"piouttime",width:100},
		{text:"归还时间",dataIndex:"piointime",width:100},
		{text:"签约公司",dataIndex:"piosign",width:100},
		{text:"申请人",dataIndex:"pioapply",width:100},
		{text:"提货人",dataIndex:"pioDelivery",width:100},
		{text:"操作备注",dataIndex:"pioremark",width:100},
		{text:"库管签字",dataIndex:"pioadminsign",width:100}
	],
	initComponent:function(){
		this.callParent(arguments);
	}
});