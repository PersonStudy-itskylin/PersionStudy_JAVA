Ext.define('core.product.view.HistoryItemForm', {
    extend: 'Ext.form.Panel',
    alias : 'widget.historyitemform',
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
	items:[
	       {
		        xtype: 'textfield',
                name : 'pioid',
                id:"pioid",
                fieldLabel: '出库编号',
                labelWidth:70,
                hidden:true
	        },{
		        xtype: 'textfield',
                name : 'proid',
                id:"proid",
                fieldLabel: '商品编号',
                labelWidth:70
	        },{
		        xtype: 'textfield',
                name : 'pioquantity',
                fieldLabel: '操作数量',
                labelWidth:70,
                allowBlank: false,
                blankText : '产品名称不能为空',//错误提示内容 
        		readOnly:false
	        },{
		        xtype: 'textfield',
                name : 'piocount',
                fieldLabel: '操作次数',
                labelWidth:70,
                vtype:'proprice',
         		readOnly:false,
         		hidden:true
	        },{
		        xtype: 'textfield',
                name : 'piooperation',
                fieldLabel: '灌机人',
                labelWidth:70,
                allowBlank: false,
                blankText : '产品型号不能为空',//错误提示内容 
        		readOnly:false
	        },{
        		xtype:"combobox",
                name: 'piotype', 
                fieldLabel: '操作类型',
                maxPickerHeight:160,
                labelWidth:70,
                displayField: 'state',
        	    valueField: 'state',
        	    value:"出库",
        	    editable:false,
                store: Ext.create('Ext.data.Store', {
               	 fields: ['state'],
               	 data:[
               	       {"state":"入库"},
               	       {"state":"出库"}
               	       ]
                })
	        },{
		        xtype: 'numberfield',
                name : 'proquantity',
                fieldLabel: '产品数量',
                allowBlank: false,
                labelWidth:70,
                value:1,
                minValue: 1
                
	        },{
		        xtype: 'textfield',
                name : 'piooperationnum',
                fieldLabel: ' 灌机点数',
                labelWidth:70,
                allowBlank: false,
                value:1,
                minValue:1
	        },{
		        xtype: 'textfield',
                name : 'pioagreementid',
                fieldLabel: '合同编号',
                labelWidth:70
	        },{
		        xtype: 'textfield',
                name : 'pioprojectid',
                fieldLabel: '项目编号',
                labelWidth:70
	        },{
		        xtype: 'textfield',
                name : 'pioprojectname',
                fieldLabel: '项目名称',
                labelWidth:70
	        },{
		        xtype: 'textfield',
                name : 'piosign',
                fieldLabel: '签约公司',
                labelWidth:70
	        },{
		        xtype:'datefield',
                width : 300,
						format : 'Y-m-d',
                name : 'piointime',
                fieldLabel: '归还时间',
                labelWidth:70,
                minDate:new Date()
	        },{
		        xtype: 'textfield',
                name : 'piodelivery',
                fieldLabel: '提货人',
                labelWidth:70
	        },{
		        xtype: 'textareafield',
                name : 'pioremark',
                fieldLabel: '操作备注',
                labelWidth:70
	        }],
	
    initComponent: function() {
        this.callParent(arguments);
    }
});
