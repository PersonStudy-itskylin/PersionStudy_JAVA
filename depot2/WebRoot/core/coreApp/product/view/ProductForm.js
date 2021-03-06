Ext.define('core.product.view.ProductForm', {
    extend: 'Ext.form.Panel',
    alias : 'widget.productform',
    layout : {
		type : "table",
		columns : 2
		
	},
	align:"left",
	bodyStyle:"margin:50px;padding:50px;",
	defaults:{
		margin:"10 0 0 10",
		selectOnFocus:true,
		width:300,
		msgTarget:"side", //提示信息现在的位置
		labelAlign:"right",
		labelWidth:60
	},
	tbar:[{
		xtype:"button",
		ref:"save",
		iconCls:"table_save",
		text:"保存"
	},{
        text: '重置',
        ref:"reset"
    },{
		xtype:"button",
		ref:"return",
		iconCls:"return",
		text:"返回"
	}],
	items:[{
		        xtype: 'textfield',
                name : 'proid',
                id:"proid",
                fieldLabel: '产品ID',
                labelWidth:70,
                hidden : true
	        },{
		        xtype: 'textfield',
                name : 'accid',
                fieldLabel: '用户ID',
                labelWidth:70,
                hidden : true
	        },{
		        xtype: 'textfield',
                name : 'proname',
                fieldLabel: '产品名称',
                labelWidth:70,
                allowBlank: false,
                blankText : '产品名称不能为空',//错误提示内容 
        		readOnly:false
	        },{
		        xtype: 'textfield',
                 name : 'proprice',
                 fieldLabel: '产品价格',
                 labelWidth:70,
                 allowBlank: false,
                 blankText : '产品价格不能为空',//错误提示内容 
                 vtype:'proprice',
                 emptyText:'请输入产品价格',
         		readOnly:false
	        },{
		        xtype: 'textfield',
                name : 'promodel',
                fieldLabel: '产品型号',
                labelWidth:70,
                allowBlank: false,
                blankText : '产品型号不能为空',//错误提示内容 
        		readOnly:false
	        },{
        		xtype:"combobox",
                name: 'protype', 
                fieldLabel: '产品类型',
                maxPickerHeight:160,
                labelWidth:70,
                displayField: 'state',
        	    valueField: 'state',
        	    value:"产品",
        	    editable:false,
                store: Ext.create('Ext.data.Store', {
               	 fields: ['state'],
               	 data:[
               	       {"state":"产品"},
               	       {"state":"设备"}
               	       ]
                })
	        },{
		        xtype: 'numberfield',
                name : 'proquantity',
                fieldLabel: '产品数量',
                labelWidth:70,
              	allowBlank: false,
                value:1,
                minValue: 0
                
	        },{
		        xtype: 'textfield',
                name : 'prosource',
                fieldLabel: ' 产品来源',
                labelWidth:70,
//              allowBlank: false,
//              blankText : '产品来源不能为空',//错误提示内容 
        		readOnly:false
	        },{
		        xtype: 'textfield',
                name : 'proeditor',
                fieldLabel: '产品修改者',
                labelWidth:70,
                hidden : true
	        },{
		        xtype: 'textareafield',
                name : 'proremark',
                fieldLabel: '产品备注',
                labelWidth:70
	        }],
    initComponent: function() {
        this.callParent(arguments);
    }
});
