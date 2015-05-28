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
    	})
    	
    },
    itemsclick:function(view,record){
    	if(record.raw.text == '用户列表'){
    		var title = record.raw.text;
    		var tabs = Ext.getCmp('center-panel');
    		var tab = tabs.down('user-table');
    		if(tab == null){
    			tab = {
    				xtype: 'usertable',
    				id:'user-table',
    				title:title,
    				closeAction:'destroy'
    			};
    			tabs.add(tab);
    			tabs.setActiveTab('user-table');
    			console.info(" 测试：" + tab);
    		}else{
    			console.info("else  ---" + tab);
    			tabs.setActiveTab('user-table');
    		}
    	}
    },
    views: [
        'userTable',
        'treeMenu'
    ],
    stores:[
    	'userTableStore'
    ],
    models:[
    	'userTableModel'
    ]
});
