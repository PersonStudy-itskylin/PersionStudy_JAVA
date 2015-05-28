//商品管理列表
Ext.define('AM.view.products',{
	extend : 'Ext.grid.Panel',
	alias:'widget.products',
	id:'products',
	icon : 'images/usertable/user.png',
	closable : true,
//	model:'productsModel',
//	store : 'productsStore',
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
				text : '新增产品',
				icon : 'images/usertable/user_add.png'
			}, '-', {
				xtype : 'button',
				text : '修改产品',
				icon : 'images/usertable/user_edit.png'
			}, '-', {
				xtype : 'button',
				text : '删除产品',
				icon : 'images/usertable/user_delete.png'
			}, '->', {
				xtype:'combobox',
				store:'productsSearchStore',
				id:'productsSearch',
				width:150,
				labelWidth:60,
				value:'userId',
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
						var productsSearch = Ext.getCmp('productsSearch').getValue();
						_store.clearFilter(false);
						_store.filter(productsSearch,_new);
					},
					onTriggerClick:function(){
						alert(this.getValue());
						_store.clearFilter(false);
						_store.filter(productsSearch,this.getValue());
					}
				}
			}
	],
	// 分页工具
	bbar : new Ext.PagingToolbar({
				autoHeight : true,
				displayInfo : true,
				store : Ext.create('AM.store.userTableStore'),
				displayMsg : '显示  {0}  -  {1} 条   ，共计 {2} 条 ',
				emptyMsg : '没有记录'
	}),
	columns : [
		{xtype : 'rownumberer', style:'border-left:0;'},
		{
			header : '产品ID',
			dataIndex : 'id',
			width : 50,
			editor : {
				allowBlank : false
			}
		}, {
			header : '产品代码',
			dataIndex : 'productCode',
			width : 80,
			editor : {
				allowBlank : false
			}
		}, {
			header : '产品名称',
			dataIndex : 'productName',
			editor : {
				allowBlank : false
			}
		}, {
			header : '产品照片',
			dataIndex : 'productPhoto',
			editor : {
				allowBlank : false
			}
		}, {
			header : '描述',
			dataIndex : 'desctiption',
			width : 100,
			editor : {
				allowBlank : false
			}
		}, {
			header : '进价',
			dataIndex : 'purchasingPrice',
			width : 100,
			editor : {
				allowBlank : false
			}
		}, {
			header : '售价',
			dataIndex : 'sellingPrice',
			width : 100,
			editor : {
				allowBlank : false
			}
		}, {
			header : '库存',
			dataIndex : 'quantity',
			width : 100,
			editor : {
				allowBlank : false
			}
		}, {
			header : '产品类别',
			dataIndex : 'category',
			width : 100,
			editor : {
				allowBlank : false
			}
		}, {
			header : '附件',
			dataIndex : 'attachments',
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
			header : '注册时间',
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