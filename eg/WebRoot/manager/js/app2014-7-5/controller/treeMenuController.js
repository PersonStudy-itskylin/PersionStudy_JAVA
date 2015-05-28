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
    	if(record.raw.text == '用户列表'){
    		var title = record.raw.text;
    		var tabs = Ext.getCmp('center-panel');
    		var tab = tabs.query('usertable')[0];
    		if(tab == null){
    			tab = {
    				xtype: 'usertable',
    				closeAction:'destroy',
    				title:title
    			};
    			console.info(tab);
    			tabs.add(tab);
    			tabs.setActiveTab('usertable');
    		}else{
    			tabs.setActiveTab('usertable');
    		}
    	};
    	if(record.raw.text == '商品列表'){
    		var title = record.raw.text;
    		var tabs = Ext.getCmp('center-panel');
    		var tab = tabs.query('products')[0];
    		if(tab == null){
    			tab = {
    				xtype: 'products',
    				closeAction:'destroy',
    				title:title
    			};
    			tabs.add(tab);
    			tabs.setActiveTab('products');
    		}else{
    			tabs.setActiveTab('products');
    		}
    	}
    },
    views: [
        'userTable',
        'treeMenu',
        'products'
    ],
    stores:[
    	'userTableStore',
    	'userTableSearchStore',
    	'productsStore'
    ],
    models:[
    	'userTableModel',
    	'productsModel'
    ]
});
