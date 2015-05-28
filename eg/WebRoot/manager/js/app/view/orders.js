var store = Ext.create('AM.store.ordersStore');

//商品管理列表
Ext.define('AM.view.orders',{
	extend : 'Ext.grid.Panel',
	alias:'widget.orders',
	id:'orders',
	icon : 'images/usertable/user.png',
	closable : true,
	model:'ordersModel',
	store : store,
	selModel : new Ext.selection.CheckboxModel(),
	selType : 'cellmodel',
	viewConfig : {
		loadMask : {
			msg : '数据加载中，请稍后...',
			style : 'border:0;background:url(images/topback.jpg);'
		}
	},
	// 工具条
	tbar : [{
				xtype : 'button',
				text : '审核通过',
				icon : 'images/usertable/user_edit.png'
			}, '-', {
				xtype : 'button',
				text : '审核不通过',
				icon : 'images/usertable/user_delete.png'
			}, '-', {
				xtype : 'button',
				text : '删除',
				icon : 'images/usertable/user_delete.png'
			}, '->', {
				xtype:'combobox',
				store:store,
				width:150,
				labelWidth:60,
				value:'id',
				forceSelction:true,
				fieldLabel:'检索条件',
				queryModel:'local',
				displayField:'name',
				valueField:'id'
			},{
				xtype:'triggerfield',
				triggerCls:Ext.baseCSSPrefix + 'form-search-trigger',
				listeners:{
					'change':function(_this,_new,_old,_option){
						var _store = _this.ownerCt.ownerCt.getStore();
						var ordersSearch = Ext.getCmp('ordersSearch').getValue();
						_store.clearFilter(false);
						_store.filter(ordersSearch,_new);
					},
					onTriggerClick:function(){
						alert(this.getValue());
						_store.clearFilter(false);
						_store.filter(ordersSearch,this.getValue());
					}
				}
			}
	],
	// 分页工具
	bbar : new Ext.PagingToolbar({
				autoHeight : true,
				displayInfo : true,
				store : store,
				displayMsg : '显示  {0}  -  {1} 条   ，共计 {2} 条 ',
				emptyMsg : '没有记录',
				plugins:[new AM.view.PageSizePlugin()]
	}),
	columns : [
		{xtype : 'rownumberer', style:'border-left:0;'},
		{
			header : '订单编号',
			dataIndex : 'id',
			width : 50,
			editor : {
				allowBlank : false
			}
		}, {
			header : '员工编号',
			dataIndex : 'employess_id',
			width : 80,
			editor : {
				allowBlank : false
			}
		}, {
			header : '订单用户',
			dataIndex : 'customer_id',
			editor : {
				allowBlank : false
			}
		}, {
			header : '订单创建日期',
			dataIndex : 'orderDate',
			editor : {
				allowBlank : false
			}
		}, {
			header : '订单发货日期',
			dataIndex : 'shippedDate',
			width : 100,
			editor : {
				allowBlank : false
			}
		}, {
			header : '发货商',
			dataIndex : 'shipped_id',
			width : 100,
			editor : {
				allowBlank : false
			}
		}, {
			header : '发货国家',
			dataIndex : 'shipCountry',
			width : 100,
			editor : {
				allowBlank : false
			}
		}, {
			header : '发货省份',
			dataIndex : 'shipProvince',
			width : 100,
			editor : {
				allowBlank : false
			}
		}, {
			header : '发货城市',
			dataIndex : 'shipCity',
			width : 100,
			editor : {
				allowBlank : false
			}
		}, {
			header : '发货地址',
			dataIndex : 'shipAddress',
			width : 100,
			editor : {
				allowBlank : false
			}
		}, {
			header : '发货邮编',
			dataIndex : 'shipZip',
			width : 100,
			editor : {
				allowBlank : false
			}
		}, {
			header : '运费',
			dataIndex : 'shippingfee',
			width : 100,
			editor : {
				allowBlank : false
			}
		}, {
			header : '付款类型',
			dataIndex : 'paymentTypes',
			width : 100,
			editor : {
				allowBlank : false
			}
		}, {
			header : '付款时间',
			dataIndex : 'paidDate',
			width : 100,
			editor : {
				allowBlank : false
			}
		}, {
			header : '订单状态',
			dataIndex : 'orderStatus_id',
			width : 100,
			editor : {
				allowBlank : false
			}
		}, {
			header : '创建者',
			dataIndex : 'creator',
			editor : {
				allowBlank : false
			}
		}, {
			header : '编辑者',
			dataIndex : 'editor',
			editor : {
				allowBlank : false
			}
		}, {
			header : '创建时间',
			dataIndex : 'createTime',
			width:130,
			editor : {
				allowBlank : false
			}
		}, {
			header : '修改时间',
			dataIndex : 'updateTime',
			width:130,
			editor : {
				allowBlank : false
			}
		}, {
			header : '备注',
			dataIndex : 'remark',
			editor : {
				allowBlank : false
			}
		}
	]
});