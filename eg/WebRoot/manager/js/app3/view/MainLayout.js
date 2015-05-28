Ext.define('AM.view.MainLayout', {
    extend: 'Ext.container.Viewport',
    alias: 'widget.mainLayout',
    layout: {
        type: 'border'
    },

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'toolbar',
                    region: 'north',
                    style:'border:0;',
                    split: true,
                    height: 80,
                    id: 'north-panel',
                    padding: '5 5 5 5',
                    style : 'background:#aa5 url(image/topback.jpg); padding-left:5px;',
                    html:'<h1>电子商城后台管理系统</h1>',
					items:[
						'->','<span style="font-size:15px;">欢迎您， <a href="index.htm">O(∩_∩)O哈哈~</a></span>',
							{
								text : '退出系统',
								widht : 20,
								icon : 'image/user_edit.png'
						}]
                },
                {
                    xtype: 'treemenu',
                    region: 'west',
                    split: true,
                    id: 'west-panel',
                    padding: '0 0 5 5 ',
                    width: 200,
                    collapsible: true,
                    title: '后台菜单'
                },
                {
                    xtype: 'panel',
                    region: 'south',
                    id: 'south-panel',
                    padding: '0',
                    title: 'CopyRight:BlueSky© 邮箱:403415171@qq.com',
                    titleAlign:'center'
                },
                {
                    xtype: 'centerpanel',
                    region: 'center',
                    padding: '0 5 5 0'
                }
            ]
        });

        me.callParent(arguments);
    }

});