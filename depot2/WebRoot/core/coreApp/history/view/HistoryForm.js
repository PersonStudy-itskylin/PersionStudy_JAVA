Ext.define('core.history.view.HistoryForm', {
    extend: 'Ext.form.Panel',
    alias : 'widget.historyform',
    align:"right",
    layout:'fit',
	bodyStyle:"margin:50px;padding:50px;",
	defaults:{
		margin:"10 0 0 10",
		selectOnFocus:true,
		width:'100%',
		msgTarget:"side", //提示信息现在的位置
		labelAlign:"right",
		labelWidth:60
	},
	tbar:[{
		xtype:"button",
		ref:"save",
		iconCls:"table_save",
		text:"导出",
		style:"margin:0px 0px 0px 900px;"
	},{
        text: '打印',
        ref:"reset"
    },{
		xtype:"button",
		ref:"return",
		iconCls:"return",
		text:"返回"
	}],
	items:[{
    	layout:'fit',
    	html:'<iframe id="welcome" name="welcome" src="core/coreApp/history/view/library.jsp" width="100%" height="100%" frameborder="no" scrolling="auto"></iframe>'
    },{
    	xtype:"textfield",
    	name : 'pioid',
        id:"pioid",
        hidden:true
    }],
	fbar: [
	       { xtype:"button", text: '修改',iconCls:"table_save",
	    	   style:"margin:0px 100px 0px 0px;"}
	     ],
	
    initComponent: function() {
        this.callParent(arguments);
    }
});
