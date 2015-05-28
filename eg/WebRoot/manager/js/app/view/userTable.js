var store = Ext.create('AM.store.userTableStore');

Ext.define('AM.view.userTable', {
			extend : 'Ext.grid.Panel',
			alias : 'widget.usertable',
			id:'usertable',
			icon : 'images/usertable/user.png',
			closable : true,
			split : true,
			model : 'userTableModel',
			store : store,
			selModel : new Ext.selection.CheckboxModel(),
			selType : 'cellmodel',
			viewConfig : {
				loadMask : {
					msg : '数据加载中，请稍后...',
					style : 'border:0;background:url(images/topback.jpg);'
				}
			},
			// 工具条
			tbar : [{
						xtype : 'button',
						text : '新增',
						icon : 'images/usertable/user_add.png'
					}, '-', {
						xtype : 'button',
						text : '修改',
						icon : 'images/usertable/user_edit.png'
					}, '-', {
						xtype : 'button',
						text : '删除',
						icon : 'images/usertable/user_delete.png'
					}, '->', {
						xtype : 'combobox',
						store : 'userTableSearchStore',
						id : 'search',
						width : 150,
						labelWidth : 60,
						value : 'userId',
						forceSelction : true,
						fieldLabel : '检索条件',
						queryModel : 'local',
						displayField : 'name',
						valueField : 'id'
					}, {
						xtype : 'triggerfield',
						triggerCls : Ext.baseCSSPrefix + 'form-search-trigger',
						listeners : {
							'change' : function(_this, _new, _old, _option) {
								var _store = _this.ownerCt.ownerCt.getStore();
								var search = Ext.getCmp('search').getValue();
								_store.clearFilter(false);
								_store.filter(search, _new);
							},
							onTriggerClick : function() {
								alert(this.getValue());
								_store.clearFilter(false);
								_store.filter(search, this.getValue());
							}
						}
					}],
			// 分页工具
			bbar : new Ext.PagingToolbar({
				autoHeight : true,
				displayInfo : true,
				store : store,
				displayMsg : '显示 {0} - {1} 条 ，共计 {2} 条 ',
				emptyMsg : '没有记录',
				plugins:[new AM.view.PageSizePlugin()]
				}),
			columns : [{
						xtype : 'rownumberer',
						style : 'border-left:0;'
					}, {
						header : '<span style="font-weight:bold;">用户ID</span>',
						dataIndex : 'user_id',
						width : 50,
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">姓名</span>',
						dataIndex : 'loginname',
						width : 60,
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">账号</span>',
						dataIndex : 'user_name',
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">密码</span>',
						dataIndex : 'pwd',
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">性别</span>',
						dataIndex : 'sex',
						width : 35,
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">出生日期</span>',
						dataIndex : 'birthdate',
						width : 80,
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">照片路径</span>',
						dataIndex : 'photo',
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">国籍</span>',
						dataIndex : 'country',
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">省份<span>',
						dataIndex : 'province',
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">城市</span>',
						dataIndex : 'city',
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">详细地址</span>',
						dataIndex : 'address',
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">联系电话<span>',
						dataIndex : 'tel',
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">电子邮箱</span>',
						dataIndex : 'email',
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">QQ</span>',
						dataIndex : 'qq',
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">密保问题1</span>',
						dataIndex : 'pwd_question1',
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">密保答案1</span>',
						dataIndex : 'pwd_anser1',
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">密保问题2</span>',
						dataIndex : 'pwd_question2',
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">密保答案2<span>',
						dataIndex : 'pwd_anser2',
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">密保问题3</span>',
						dataIndex : 'pwd_question3',
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">密保答案3</span>',
						dataIndex : 'pwd_anser3',
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">婚否</span>',
						dataIndex : 'married',
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">爱好</span>',
						dataIndex : 'like',
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">自我介绍</span>',
						dataIndex : 'description',
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">民族</span>',
						dataIndex : 'ethnic',
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">教育程度</span>',
						dataIndex : 'education',
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">职业</span>',
						dataIndex : 'job',
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">政治面貌</span>',
						dataIndex : 'party',
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">注册IP</span>',
						dataIndex : 'ipaddress',
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">创建者</span>',
						dataIndex : 'creator',
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">编辑者</spa>',
						dataIndex : 'editor',
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">注册时间</span>',
						dataIndex : 'createTime',
						width : 130,
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">修改时间</span>',
						dataIndex : 'updateTime',
						width : 130,
						editor : {
							allowBlank : false
						}
					}, {
						header : '<span style="font-weight:bold;">备注</span>',
						dataIndex : 'remark',
						editor : {
							allowBlank : false
						}
					}]
		});