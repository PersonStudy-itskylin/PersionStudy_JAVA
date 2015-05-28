Ext.define('AM.view.addProduct', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.addproduct',
	height : 400,
	width : 500,
	layout : 'fit',
	items : [{
		xtype : 'form',
		columns : 2,
		layout : 'column',
		url:'js/app/data/addproduct.jsp',
		suspendLayout : true,
		bodyPadding : 10,
		titleCollapse : true,
		fieldDefaults : {
			labelWidth : 60,
			labelAlign : 'right'
		},
		items : [{
			frame:true,
			height : 400,
			maxHeight : 400,
			maxWidth : 240,
			width : 240,
			items : [{
				xtype : 'hiddenfield',
				fieldLabel : 'id',
				name : 'id'
			}, {
				xtype : 'textfield',
				fieldLabel : '产品代码',
				name : 'productCode'
			}, {
				xtype : 'textfield',
				fieldLabel : '产品名称',
				name : 'productName'
			}, {
				xtype : 'numberfield',
				fieldLabel : '进价',
				name : 'purchasingPrice'
			}, {
				xtype : 'numberfield',
				fieldLabel : '售价',
				name : 'sellingPrice'
			}, {
				xtype : 'numberfield',
				fieldLabel : '库存量',
				name : 'quantity'
			}, {
				xtype : 'combobox',
				fieldLabel : '产品类型',
				name : 'category'
			}, {
				xtype : 'textfield',
				fieldLabel : '创建者',
				name : 'creator',
				readOnly:true
			}, {
				xtype : 'textfield',
				fieldLabel : '修改者',
				name : 'editor',
				readOnly:true
			}, {
				xtype : 'textareafield',
				fieldLabel : '产品介绍',
				name : 'desctiption'
			}]
		}, {
			maxWidth : 250,
			width : 240,
			frame:true,
			items : [{
				xtype : 'image',
				height : 160,
				width : 130,
				id : 'photo',
				margin : '5 0 10 80',
				src : 'testing'
			}, {
				xtype : 'filefield',
				fieldLabel : '产品照片',
				name : 'productPhoto'
			}, {
				xtype : 'textfield',
				fieldLabel : '创建时间',
				name : 'createTime',
				readOnly:true
			}, {
				xtype : 'textfield',
				fieldLabel : '更新时间',
				name : 'updateTime',
				readOnly:true
			}, {
				xtype : 'textareafield',
				fieldLabel : '备注'
			}]
		}]
	}]
});