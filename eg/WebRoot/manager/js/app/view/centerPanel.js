
Ext.define('AM.view.centerPanel',{
	extend:'Ext.tab.Panel',
    alias: 'widget.centerpanel',
    bodyStyle:'border:0;',
    items: [
        {
            xtype: 'panel',
            title: '首页',
    		icon:'images/treemenu/rosette.png',
            html : '<iframe id="welcome" name="welcome" src="welcome.htm" width="100%" height="100%" frameborder="no" scrolling="auto"></iframe>'
		}
    ]
});