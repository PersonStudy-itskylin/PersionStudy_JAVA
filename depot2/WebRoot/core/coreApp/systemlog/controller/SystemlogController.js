Ext.define("core.systemlog.controller.SystemlogController", {
	extend : "Ext.app.Controller",
	
	init : function() {
		var self = this;
		this.control({
			/**
			 * 添加用户form的返回按钮
			 */
			"systemlogform button[ref=return]" : {
				click : function(btn) {
					var form = btn.up("systemlogform");
					var grid = form.up("systemloglayout").down("systemlog_grid");
					form.hide();
					grid.show();
				}
			},

			/**
			 * 删除用户
			 */
			"systemlog_grid button[ref=removeSystemlog]" : {
				click : function(btn) {
					var grid = btn.up("systemlog_grid");
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
						data.push(Ext.JSON.encode(model.get('sysid')));
					});
					Ext.Ajax.request({
								waitMsg : '正在进行处理,请稍后...', 
								url : "syslog/delSyslog.action",
								params : {
									sysid : data.join(",")
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
			"systemlog_grid" : {
				itemdblclick : function(_grid, record, item, index, e, eOpts) {
					var form = _grid.up("systemloglayout").down("systemlogform");
					var grid = form.up("systemloglayout").down("systemlog_grid");
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
	},
	views : [
		"core.systemlog.view.SystemlogLayout",
		"core.systemlog.view.SystemlogGrid",
		"core.systemlog.view.SystemlogForm"
	],
	stores : [
	    "core.systemlog.store.SystemlogStore"
	],
	models : [
		"core.systemlog.model.SystemlogModel"
	]
});