Ext.define('AM.controller.productsController', {
    extend: 'Ext.app.Controller',
    init: function() {
    	this.control({
    		'products button[text="新增产品"]':{
    			click:function(btn){
    				var addproduct = Ext.create('AM.view.addProduct');
    				addproduct.show();
    			}
    		},
    		'products button[text="修改产品"]':{
    			click:function(btn){
    				alert(btn);
    			}
    		},
    		'products button[text="删除产品"]':{
    			click:function(btn){
    				Ext.Msg.confirm('删除产品：','确定要删除这个产品吗？',function(e){
						if(e == 'yes'){
							Ext.Msg.alert('删除','删除');
						}		
    				})
    			}
    		},
    		'products button[text="设置"]':{
    			click:function(btn){
    				alert(btn);
    			}
    		},
    		'products':{
    			itemdblclick:function(_this, record, item,index, e, Opts ){
    				//_this  = this,record  值  ， item  组件   , 在本表中的索引值，  e  事件，opts 对象
    				var _record = _this.getSelectionModel().getSelection();
    				var property = Ext.create('AM.view.addProduct');
    				property.show();
    				property.down('form').loadRecord(_record[0]);
    			}
    		}
    	})
    },
    views: [
    	'addProduct'
    ],
    stores:[
    	'productsSearchStore'
    ],
    models:[
    	'productsModel'
    ]
});
