Ext.define("core.user.controller.UserController", {
	extend : "Ext.app.Controller",
	
	init : function() {
		var self = this;
		this.control({
			/**
			 * 添加用户
			 */
			"usergrid button[ref=addUser]" : {
				click : function(btn) {
					var form = btn.up("userlayout").down("userform");
					//清空数据
					form.getForm().reset();
					grid = form.up("userlayout").down("usergrid");
					grid.hide();
					form.show();
				}
			},
			/**
			 * 修改用户,这个功能在保存按钮中完成， 要修改用户，请双击记录
			 */
			"usergrid button[ref=updateUser]" : {
				click : function(btn) {
					var grid=btn.up("userlayout").down("usergrid");
					var form = grid.up("userlayout").down("userform");
					var _record = grid.getSelectionModel().getSelection();
					form.loadRecord(_record[0]);
					grid.hide();
					form.show();
				},
				itemdblclick:function(btn){
					Ext.Msg.alert("友情提示", "请双击需要修改的记录进行修改!");
				}
			},
			/**
			 * 添加用户form的保存按钮
			 */
			"userform button[ref=save]" : {
				click : function(btn) {
					//根据id值来做判断，如果id为null说明是做添加操作，否则就是做修改操作
					//1获得form
					var form = btn.up("userform");
					
					var role = Ext.getCmp("roleId");
					var roleVal = role.getValue();
					if(roleVal.indexOf("系统管理员") >= 0){
						roleVal = '0';
					}else if(roleVal.indexOf("入库员") >= 0){
						roleVal = '1';
					}else if(roleVal.indexOf("出库员") >= 0){
						roleVal = '2';
					}
					role.setValue(roleVal);
					
					var state = Ext.getCmp("stateId");
					var stateVal = state.getValue();
					if(stateVal.indexOf("正常") >= 0){
						stateVal = '0';
					}else if(stateVal.indexOf("停用") >= 0){
						stateVal = '1';
					}else if(stateVal.indexOf("欠费") >= 0){
						stateVal = '2';
					}
					state.setValue(stateVal);
					
					var id = form.getForm().findField("id").getValue();
					var url = "";
					if(id == "" || null == id){
						url = "user/reg.action";
					}else{
						url = "user/updateAccount.action";
					}
					//2.把数据保存到数据库中去
					form.submit({
						clientValidation : true,
						waitMsg : '正在进行处理,请稍后...', 
						url : url,
						method : 'POST',
						success : function(form, action) {
							var resObj = Ext.decode(action.response.responseText);
							if (resObj.success) {
								form.reset();
								//定义得到grid
								var grid = Ext.getCmp("usergrid");
								grid.getStore().load();
								//定义得到form
								var form =grid.up("userlayout").down("usergrid");
								//3.把这条数据加到grid中
								form.hide();
								grid.show();
							}
							Ext.Msg.alert("提示", resObj.msg);
						},
						failure : function(form, action) {
							Ext.Msg.show({
							     title:'提示',
							     msg: '请求处理失败！',
							     buttons: Ext.Msg.OK,
							     icon: Ext.Msg.ERROR
							});
						}
					});

				}
			},
			/**
			 * 添加用户form的返回按钮
			 */
			"userform button[ref=return]" : {
				click : function(btn) {
					var form = btn.up("userform");
					var grid = form.up("userlayout").down("usergrid");
					form.hide();
					grid.show();
				}
			},

			/**
			 * 删除用户
			 */
			"usergrid button[ref=removeUser]" : {
				click : function(btn) {
					var grid = btn.up("usergrid");
					var store = grid.getStore();
					//你选择的将要删除的记录
					var records = grid.getSelectionModel().getSelection();
					if (!records || records.length <= 0) {
						Ext.Msg.alert("提示", "请选择需要删除的数据!");
						return;
					}
					// 根据id删除多条记录
					var data = [];
					Ext.Array.each(records, function(model) {
						data.push(Ext.JSON.encode(model.get('id')));
					});
					Ext.Ajax.request({
								waitMsg : '正在进行处理,请稍后...', 
								url : "user/delAccount.action",
								params : {
									id : data.join(",")
								},// 根据id删除
								method : "POST",
								timeout : 4000,
								success : function(response, opts) {
									var resObj = Ext.decode(response.responseText);
									if (resObj.success) {
										// 不用查询，从grid中去掉对应的记录就OK了
										store.load();
										Ext.Msg.alert("提示", resObj.msg);
									} else {
										Ext.Msg.alert("提示", resObj.msg);
									}
								}
							});
				}
			},
			/**
			 * 单击进入form，修改信息
			 */
			"usergrid" : {
				itemdblclick : function(_grid, record, item, index, e, eOpts) {
					var form = _grid.up("userlayout").down("userform");
					var grid = form.up("userlayout").down("usergrid");
					//把选择的数据加载到form中去
					var _record = grid.getSelectionModel().getSelection();
					form.loadRecord(_record.raw);
					grid.hide();
					form.show();
				}
			},
			// 任务节点事件添加
			"taskeventgrid button[ref=addEvent]" : {
				click : function(btn) {
				}
			}
		});
		Ext.apply(Ext.form.VTypes, {
	        mobile:function (value, field) {
	            return /^((\(\d{3}\))|(\d{3}\-))?1[38][0-9]\d{8}|15[89]\d{8}|170\d{8}$/.test(value);
	        },
	        mobileText:'手机格式不正确'
		},{
			telphone:function (value, field) {
				return /^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$/.test(value);
			},
			telphoneText:'座机电话格式不正确'
		});
	},
	views : [
		"core.user.view.UserLayout",
		"core.user.view.UserGrid",
		"core.user.view.UserForm"
	],
	stores : [
	    "core.user.store.UserStore",
	    "core.user.store.UserSearchStore"
	],
	models : ["core.user.model.UserModel"]
});