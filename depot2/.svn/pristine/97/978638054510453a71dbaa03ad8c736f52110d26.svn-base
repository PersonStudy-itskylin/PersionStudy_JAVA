Ext.define('core.comptroller.view.ComptrollerForm', {
    extend: 'Ext.form.Panel',
    alias : 'widget.comptrollerform',
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
                fieldLabel: '商品编号',
                labelWidth:70,
                //hidden : true
	        },{
		        xtype: 'textfield',
                name : 'accid',
                fieldLabel: '用户编号',
                labelWidth:70,
                allowBlank: false,
                blankText : '用户ID不能为空',//错误提示内容 
                vtype:'accid',
                emptyText:"只能输数字"
                //hidden : true
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
                 allowBlank: false,
                 
                 blankText : '产品价格不能为空',//错误提示内容 
                 vtype:'proprice',
                 emptyText:'请输入数字,小数',
         		readOnly:false
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
                displayField: 'name',
        	     valueField: 'state',
        	     value:0,
        	     editable:false,
                store: Ext.create('Ext.data.Store', {
               	 fields: ['state', 'name'],
               	 data:[
               	       {"state":0, "name":"正常"},
               	       {"state":1, "name":"锁定"}
               	       ]
                })
	        },{
		        xtype: 'numberfield',
                name : 'proquantity',
                fieldLabel: '产品数量',
                labelWidth:70,
                value:0,
                minValue: 0
                
	        },{
		        xtype: 'textfield',
                name : 'piooperationnum',
                fieldLabel: ' 灌机点数',
                labelWidth:70,
                allowBlank: false,
                blankText : '产品来源不能为空',//错误提示内容 
        		readOnly:false
	        },{
		        xtype: 'textfield',
                name : 'pioagreementid',
                fieldLabel: '合同编号',
                labelWidth:70,
                readOnly:false
	        },{
		        xtype: 'textfield',
                name : 'pioprojectid',
                fieldLabel: '项目编号',
                labelWidth:70,
                readOnly:false
	        },{
		        xtype: 'textfield',
                name : 'pioprojectname',
                fieldLabel: '项目名称',
                labelWidth:70,
                readOnly:false
	        },{
		        xtype: 'textfield',
                name : 'piouttime',
                fieldLabel: '操作时间',
                labelWidth:70,
                readOnly:false
	        },{
		        xtype: 'textfield',
                name : 'piointime',
                fieldLabel: '归还时间',
                labelWidth:70,
                readOnly:false
	        },{
		        xtype: 'textfield',
                name : 'piosign',
                fieldLabel: '签约公司',
                labelWidth:70,
                readOnly:false
	        },{
		        xtype: 'textfield',
                name : 'pioapply',
                fieldLabel: '申请人',
                labelWidth:70,
                readOnly:false
	        },{
		        xtype: 'textfield',
                name : 'pioDelivery',
                fieldLabel: '提货人',
                labelWidth:70,
                readOnly:false
	        },{
		        xtype: 'textareafield',
                name : 'pioremark',
                fieldLabel: '操作备注',
                labelWidth:70
	        },{
		        xtype: 'textareafield',
                name : 'pioadminsign',
                fieldLabel: '操作备注',
                labelWidth:70
	        }],
    initComponent: function() {
        this.callParent(arguments);
    }
});
