Ext.define('AM.controller.productsController', {
    extend: 'Ext.app.Controller',
    init: function() {
    	this.control({
    		'products button[text="新增产品"]':{
    			click:function(btn){
    				var product = Ext.create('AM.view.addProduct');
    				product.show();
    			}
    		},
    		'products button[text="修改产品"]':{
    			click:function(btn){
    				alert(btn);
    			}
    		},
    		'products button[text="删除产品"]':{
    			click:function(btn){
    				var table = btn.ownerCt.ownerCt;
    				var selection = table.getView().getSelectionModel().getSelection();
    				if(selection<1){
    					Ext.Msg.alert('提示：','请选择产品后再删除');
    				}else{
    					Ext.Msg.confirm('提示：','确定要删除该用户吗？',function(e){
							if(e == 'yes'){
								Ext.Ajax.request({
									url:'js/app/data/delUser.jsp',
									timeout:5000,
									waitMsg:'数据删除中，请稍后...',
									params:{
										id:selection[0].data.id
									},
									success : function(response,opt) { // 请求成功后的回调函数
										Ext.Msg.alert('提示信息：',response.responseText);
										table.getStore().remove(selection[0]);
										table.getStore().reload();
									},
									failure : function(response) {
										Ext.Msg.alert('提示信息：',response.responseText);
									}
								});
							}		
	    				});
    				}
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
    				var property = Ext.create('AM.view.proProduct');
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
    	'productsStore',
    	'productsSearchStore'
    ],
    models:[
    	'productsModel'
    ]
});
