/**
 * ClassName 流程挂接视图
 * */
var store=Ext.create("core.product.store.ProductStore");

Ext.define("core.product.view.ProductGrid",{
	extend:"Ext.grid.Panel",
	alias:"widget.product_grid",
	model :"core.product.model.ProductModel",
	store:store,
	id:"product_grid",
	selModel:{
		selType:"checkboxmodel"
	},
	border:0,
	multiSelect:true,
	frame:true,
	tbar:[
		{xtype:'button',text:'新增',ref:'addProduct',iconCls:'table_add'},
		{xtype:'button',text:'修改',ref:'updateProduct',iconCls:'table_edit'},
		{xtype:'button',text:'删除',ref:'removeProduct',iconCls:'table_remove'},
		"->",
		{
		 xtype : 'combobox',
		 store : 'core.product.store.ProductSearchStore',
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
		{text:"产品ID",dataIndex:"proid",width:100,border: 20},
		{text:"产品名称",dataIndex:"proname",width:100,border: 50},
		{text:"产品型号",dataIndex:"promodel",width:100},
		{text:"产品类型",dataIndex:"protype",width:100},
		{text:"产品价格",dataIndex:"proprice",width:100},
		{text:"产品数量",dataIndex:"proquantity",width:100},
		{text:"产品来源",dataIndex:"prosource",width:100},
		{text:"产品修改者",dataIndex:"proeditor",width:100},
		{text:"产品创建时间",dataIndex:"procreatetime",width:100},
		{text:"修改时间",dataIndex:"proedittime",width:100},
		{text:"产品备注",dataIndex:"proremark",width:100}
		
		
	],
	initComponent:function(){
		this.callParent(arguments);
	}
});