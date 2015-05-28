Ext.define("core.comptroller.view.ComptrollerLayout", {
			extend : 'Ext.panel.Panel',
			alias : 'widget.comptrollerlayout',
			title : "<center height=40>行为审计</center>",
			defaults : {
				bodyStyle : 'padding:1px'
			},
			layout : 'fit',
			items:[{
				xtype:"comptroller_grid",
				id:'comptroller_grid'
			},{
				xtype:"comptrollerform",
				hidden:true
			}]
});