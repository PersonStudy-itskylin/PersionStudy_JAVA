
Ext.define('AM.view.centerPanel',{
	extend:'Ext.tab.Panel',
    alias: 'widget.centerpanel',
    id:'centerpanel',
    items: [
        {
            xtype: 'panel',
            title: '首页',
            html : '<iframe id="welcome" name="welcome" src="welcome.htm" width="100%" height="100%" frameborder="no" scrolling="auto"></iframe>'
		},{
			xtype:'usertable',
			title:'用户列表'
		}///
    ]
});