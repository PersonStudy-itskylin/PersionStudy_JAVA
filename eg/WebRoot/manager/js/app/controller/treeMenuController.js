Ext.define('AM.controller.treeMenuController', {
    extend: 'Ext.app.Controller',
     refs: [
        {
            ref: 'treemenu',
            selector: 'treemenu'
        },{
        	ref:'center-panel',
        	selector:'center-panel'
        }
    ],
    init: function() {
    	this.control({
    		'treemenu treepanel':{
    			itemclick:this.itemsclick
    		}
    	});
    },
    itemsclick:function(view,record){
    	var title = record.raw.text;
    	var tabs = Ext.getCmp('center-panel');
    	if(record.raw.text == '用户列表'){
    		var tab = tabs.query('usertable')[0];
    		console.info(tab);
    		if(tab == null){
    			tab = {
    				xtype: 'usertable',
    				title:title
    			};
    			tabs.add(tab);
    		}
    		tabs.setActiveTab('usertable');
    	};
    	if(record.raw.text == '商品列表'){
    		var tab = tabs.query('products')[0];
    		if(tab == null){
    			tab = {
    				xtype: 'products',
    				title:title
    			};
    			tabs.add(tab);
    		}
    		tabs.setActiveTab('products');
    	};
    	if(record.raw.text == '订单管理'){
    		var tab = tabs.query('orders')[0];
    		if(tab == null){
    			tab = {
    				xtype: 'orders',
    				title:title
    			};
    			tabs.add(tab);
    		}
    		tabs.setActiveTab('orders');
    	}
    },
    views: [
        'userTable',
        'treeMenu',
        'products',
        /*'orders',*/
        'PageSizePlugin'
    ]
});
