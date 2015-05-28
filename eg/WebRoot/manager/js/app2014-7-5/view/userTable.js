Ext.define('AM.view.userTable', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.usertable',
	id:'usertable',
	icon : 'images/usertable/user.png',
	closable : true,
	split : true,
	model:'userTableModel',
	store : 'userTableStore',
	columns : [
		{xtype : 'rownumberer', style:'border-left:0;'},
		{
			header : '用户ID',
			dataIndex : 'user_id',
			width : 50,
			editor : {
				allowBlank : false
			}
		}, {
			header : '姓名',
			dataIndex : 'loginname',
			width : 60,
			editor : {
				allowBlank : false
			}
		}, {
			header : '账号',
			dataIndex : 'user_name',
			editor : {
				allowBlank : false
			}
		}, {
			header : '密码',
			dataIndex : 'pwd',
			editor : {
				allowBlank : false
			}
		}, {
			header : '性别',
			dataIndex : 'sex',
			width : 35,
			editor : {
				allowBlank : false
			}
		}, {
			header : '出生日期',
			dataIndex : 'birthdate',
			width : 80,
			editor : {
				allowBlank : false
			}
		}, {
			header : '照片路径',
			dataIndex : 'photo',
			editor : {
				allowBlank : false
			}
		}, {
			header : '国籍',
			dataIndex : 'country',
			editor : {
				allowBlank : false
			}
		}, {
			header : '省份',
			dataIndex : 'province',
			editor : {
				allowBlank : false
			}
		}, {
			header : '城市',
			dataIndex : 'city',
			editor : {
				allowBlank : false
			}
		}, {
			header : '详细地址',
			dataIndex : 'address',
			editor : {
				allowBlank : false
			}
		}, {
			header : '联系电话',
			dataIndex : 'tel',
			editor : {
				allowBlank : false
			}
		}, {
			header : '电子邮箱',
			dataIndex : 'email',
			editor : {
				allowBlank : false
			}
		}, {
			header : 'QQ',
			dataIndex : 'qq',
			editor : {
				allowBlank : false
			}
		}, {
			header : '密保问题1',
			dataIndex : 'pwd_question1',
			editor : {
				allowBlank : false
			}
		}, {
			header : '密保答案1',
			dataIndex : 'pwd_anser1',
			editor : {
				allowBlank : false
			}
		}, {
			header : '密保问题2',
			dataIndex : 'pwd_question2',
			editor : {
				allowBlank : false
			}
		}, {
			header : '密保答案2',
			dataIndex : 'pwd_anser2',
			editor : {
				allowBlank : false
			}
		}, {
			header : '密保问题3',
			dataIndex : 'pwd_question3',
			editor : {
				allowBlank : false
			}
		}, {
			header : '密保答案3',
			dataIndex : 'pwd_anser3',
			editor : {
				allowBlank : false
			}
		}, {
			header : '婚否',
			dataIndex : 'married',
			editor : {
				allowBlank : false
			}
		}, {
			header : '爱好',
			dataIndex : 'like',
			editor : {
				allowBlank : false
			}
		}, {
			header : '自我介绍',
			dataIndex : 'description',
			editor : {
				allowBlank : false
			}
		}, {
			header : '民族',
			dataIndex : 'ethnic',
			editor : {
				allowBlank : false
			}
		}, {
			header : '教育程度',
			dataIndex : 'education',
			editor : {
				allowBlank : false
			}
		}, {
			header : '职业',
			dataIndex : 'job',
			editor : {
				allowBlank : false
			}
		}, {
			header : '政治面貌',
			dataIndex : 'party',
			editor : {
				allowBlank : false
			}
		}, {
			header : '注册IP',
			dataIndex : 'ipaddress',
			editor : {
				allowBlank : false
			}
		}, {
			header : '创建者',
			dataIndex : 'creator',
			editor : {
				allowBlank : false
			}
		}, {
			header : '编辑者',
			dataIndex : 'editor',
			editor : {
				allowBlank : false
			}
		}, {
			header : '注册时间',
			dataIndex : 'createTime',
			width:130,
			editor : {
				allowBlank : false
			}
		}, {
			header : '修改时间',
			dataIndex : 'updateTime',
			width:130,
			editor : {
				allowBlank : false
			}
		}, {
			header : '备注',
			dataIndex : 'remark',
			editor : {
				allowBlank : false
			}
	}],
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
				xtype:'combobox',
				store:'userTableSearchStore',
				id:'search',
				width:150,
				labelWidth:60,
				value:'userId',
				forceSelction:true,
				fieldLabel:'检索条件',
				queryModel:'local',
				displayField:'name',
				valueField:'id'
			},{
				xtype:'triggerfield',
				triggerCls:Ext.baseCSSPrefix + 'form-search-trigger',
				listeners:{
					'change':function(_this,_new,_old,_option){
						var _store = _this.ownerCt.ownerCt.getStore();
						var search = Ext.getCmp('search').getValue();
						_store.clearFilter(false);
						_store.filter(search,_new);
					},
					onTriggerClick:function(){
						alert(this.getValue());
						_store.clearFilter(false);
						_store.filter(search,this.getValue());
						
					}
				}
				
			}
	],
	// 分页工具
	bbar : new Ext.PagingToolbar({
				autoHeight : true,
				displayInfo : true,
				store : Ext.create('AM.store.userTableStore'),
				displayMsg : '显示  {0}  -  {1} 条   ，共计 {2} 条 ',
				emptyMsg : '没有记录'
			})
});