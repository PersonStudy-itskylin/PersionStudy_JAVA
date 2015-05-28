Ext.define('core.systemlog.view.SystemlogForm', {
    extend: 'Ext.form.Panel',
    alias : 'widget.systemlogform',
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
		        name : 'sysid',
		        id:"sysid",
		        fieldLabel: '系统日志ID',
		        labelWidth:70,
		        hidden : true
	       },{
		        xtype: 'textfield',
                name : 'accid',
                id:"accid",
                fieldLabel: '用户编号',
                labelWidth:70
	        },{
		        xtype: 'textfield',
                name : 'sysname',
                fieldLabel: '操作模块',
                labelWidth:70
	        },{
		        xtype: 'textfield',
                name : 'systime',
                fieldLabel: '操作时间',
                labelWidth:70
	        },{
		        xtype: 'textfield',
                 name : 'sysip',
                 fieldLabel: '操作IP',
                 labelWidth:70
	        },{
		        xtype: 'textfield',
                name : 'sysremark',
                fieldLabel: '操作说明',
                labelWidth:70
	        }],
    initComponent: function() {
        this.callParent(arguments);
    }
});
