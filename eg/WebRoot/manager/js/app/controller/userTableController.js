Ext.define('AM.controller.userTableController', {
    extend: 'Ext.app.Controller',
    init: function() {
    	var edit = function(_this, record, item,index, e, Opts ){
    				//_this  = this,record  值  ， item  组件   , 在本表中的索引值，  e  事件，opts 对象
    				var _record = _this.getSelectionModel().getSelection();
    				var pro = Ext.create('AM.view.proUser',{
    					title:'用户属性',
    					icon:'images/usertable/user.png'
    				});
    				pro.down('form').loadRecord(_record[0]);
    				pro.show();
    			};
    	this.control({
    		'usertable button[text="新增"]':{
    			click:function(btn){
    				var adduser = Ext.create('AM.view.addUser1');
    				adduser.show();
    			}
    		},
    		'usertable button[text="修改"]':{
    			click:function(btn){
    				var table = btn.ownerCt.ownerCt;
    				var selection = table.getView().getSelectionModel().getSelection();
    				if(selection<1){
    					Ext.Msg.alert('提示：','请选择用户后再修改');
    				}else{
    				}
    			}
    		},
    		'usertable button[text="删除"]':{
    			click:function(btn){
    				var table = btn.ownerCt.ownerCt;
    				var selection = table.getView().getSelectionModel().getSelection();
    				if(selection<1){
    					Ext.Msg.alert('提示：','请选择用户后再删除');
    				}else{
    					Ext.Msg.confirm('提示：','确定要删除这条记录吗？',function(e){
							if(e == 'yes'){
								Ext.Ajax.request({
									url:'js/app/data/delUser.jsp',
									timeout:5000,
									waitMsg:'数据删除中，请稍后...',
									params:{
										user_id:selection[0].data.user_id
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
    		'usertable':{
    			itemdblclick:edit
    		},
    		'adduser textfield[id="pwd2"]':{
    			blur:function(_this){
    				var pwd2 = _this;
    				var pwd = _this.ownerCt.down('#pwd').getValue();
    				if(pwd != _this.getValue()){
    					pwd2.markInvalid('两次填写的密码不一致');
    				}
    			}
    		},
    		'adduser button[text="提交"]':{
    			click:function(btn){
					var adduserform = btn.ownerCt.ownerCt.down('form');
    				if(!adduserform.isValid()){
    					return Ext.Msg.alert('提示：','表单不允许为空，请填写后提交！');
    				}else{
						adduserform.getForm().submit({
							method:'post',
							success : function(form, action) { // 请求成功后的回调函数
								Ext.getCmp('adduser1').destroy();
								var usertable = Ext.getCmp('usertable');
								usertable.getStore().reload();
								Ext.Msg.alert('提示信息：',action.result.msg);
							},
							failure : function(form, action) {
								console.info(action);
								Ext.Msg.alert('提示信息：',action.result.msg);
							}
						});
					}
    			}
    		},
    		'adduser button[text="重置"]':{
    			click:function(btn){
					var reset = btn.ownerCt.ownerCt.down('form');
					reset.getForm().reset();
    			}
    		}
    	})
    },
    views: [
        'userTable',	//用户列表
        'addUser1',		//添加用户
        'question',		//问题下拉框
        'married',		//婚否下拉框
        'country',		//国籍下拉框
        'province',		//省份下拉框
        'city',			//城市下拉框
        'education',	//教育程度下拉框
        'ethnic',		//民族下拉框
        'party'
    ],
    stores:[
    	'userTableStore',
    	'questionStore',
    	'marriedStore',
    	'countryStore',
    	'provinceStore',
    	'cityStore',
    	'educationStore',
    	'ethnicStore',
        'partyStore'
    ],
    models:[
    	'userTableModel'
    ]
});
