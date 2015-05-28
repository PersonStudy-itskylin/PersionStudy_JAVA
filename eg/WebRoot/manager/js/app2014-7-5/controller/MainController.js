Ext.define('AM.controller.MainController', {
    extend: 'Ext.app.Controller',
    init: function(application) {
    	this.control({
    		'mainLayout button[text="退出系统"]':{
    			click:function(btn,o){
    				Ext.Msg.confirm('提示：', '确定要退出吗？', function(e) {
					if (e == 'yes') {
						window.close();
						}
					});
    			}
    		}
    	})
    },
    stores:[
    	'treeMenuStore'
    ],
	views: [
        'MainLayout',
        'treeMenu',
        'centerPanel',
        'products'
    ]
});
