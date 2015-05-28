Ext.define("core.history.view.HistoryLayout", {
			extend : 'Ext.panel.Panel',
			alias : 'widget.historylayout',
			title : "<center height=40>出入库记录</center>",
			defaults : {
				bodyStyle : 'padding:1px'
			},
			layout : 'fit',
			items:[{
				xtype:"history_grid",
				id:'history_grid'
				//hidden:true
			}/*,{
				xtype:"historyform",
				id:'historyfrom',
				hidden:true
			}*/,{
				xtype:"historyitemform",
				id:'historyitemfrom',
				hidden:true
			}]
});