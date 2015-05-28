Ext.define("core.product.controller.ProductController", {
	extend : "Ext.app.Controller",
	
	init : function() {
		var self = this;
		this.control({
			/**
			 * 添加用户
			 */
			"product_grid button[ref=addProduct]" : {
				click : function(btn) {
					var form = btn.up("productlayout").down("productform");
					//清空数据
					form.getForm().reset();
					grid = form.up("productlayout").down("product_grid");
					grid.hide();
					form.show();
				}
			},
			/**
			 * 修改用户,这个功能在保存按钮中完成， 要修改用户，请双击记录
			 */
			"product_grid button[ref=updateProduct]" : {
				click : function(btn) {
					
					var grid=btn.up("productlayout").down("product_grid");
					var form = grid.up("productlayout").down("productform");
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
			"productform button[ref=save]" : {
				click : function(btn) {
					//根据id值来做判断，如果id为null说明是做添加操作，否则就是做修改操作
					//1获得form
					var form = btn.up("productform");
					var id = form.getForm().findField("proid").getValue();
					var url = "";
					if(id == "" || null == id){
						url = "product/addProduct.action";
					}else{
						url = "product/updateProduct.action";
					}
					//2.把数据保存到数据库中去
					form.getForm().submit({
						clientValidation : true,
						waitMsg : '正在进行处理,请稍后...', 
						url : url,
						method : 'POST',
						success : function(form, action) {
							var resObj = Ext.decode(action.response.responseText);
							if (resObj.success) {
								form.reset();
								//定义得到grid
								var grid = Ext.getCmp("product_grid");
								grid.getStore().load();
								//定义得到form
								var form =grid.up("productlayout").down("product_grid");
								//3.把这条数据加到grid中
								form.hide();
								grid.show();
							}
							Ext.Msg.alert("提示", resObj.msg);
							
						},
						failure : function(form, action) {
							Ext.Msg.alert("提示","请求处理失败！");
						}
				});

				}
			},
			/**
			 * 添加用户form的返回按钮
			 */
			"productform button[ref=return]" : {
				click : function(btn) {
					var form = btn.up("productform");
					var grid = form.up("productlayout").down("product_grid");
					form.hide();
					grid.show();
				}
			},

			/**
			 * 删除用户
			 */
			"product_grid button[ref=removeProduct]" : {
				click : function(btn) {
					var grid = btn.up("product_grid");
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
						data.push(Ext.JSON.encode(model.get('proid')));
					});
					Ext.Ajax.request({
								waitMsg : '正在进行处理,请稍后...', 
								url : "product/delProduct.action",
								params : {
									proid : data.join(",")
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
			"product_grid" : {
				itemdblclick : function(_grid, record, item, index, e, eOpts) {
					var form = _grid.up("productlayout").down("productform");
					var grid = form.up("productlayout").down("product_grid");
					//把选择的数据加载到form中去
					var _record = grid.getSelectionModel().getSelection();
					form.loadRecord(_record[0]);
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
	        proprice:function (value, field) {
	            return /^[1-9][0-9]{0,2}(?:,?[0-9]{3})*(?:\.[0-9]{1,2})?$/.test(value);
	        },
	        propriceText:'只能输入数字,小数'
		},{
	        accid:function (value, field) {
	            return /^[0-9]{0,10}?$/.test(value);
	        },
	        accidText:'只能输入数字,小数'
		});
	},
	views : [
		"core.product.view.ProductLayout",
		"core.product.view.ProductGrid",
		"core.product.view.ProductForm"
	],
	stores : [
	    "core.product.store.ProductStore",
	    "core.product.store.ProductSearchStore"
	],
	models : ["core.product.model.ProductModel"]
});