Ext.define('AM.view.userTable', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.usertable',
	title : '用户管理',
	//hidden : true,
	icon : 'image/folder_user.png',
	closable : true,
	model:'userTableModel',
	store : 'userTableStore',
	columns : [
		{xtype : 'rownumberer',width : 50},
		{
			header : '用户ID',
			dataIndex : 'userId',
			width : 60,
			editor : {
				allowBlank : false
			}
		}, {
			header : '姓名',
			dataIndex : 'loginName',
			width : 60,
			editor : {
				allowBlank : false
			}
		}, {
			header : '账号',
			dataIndex : 'userName',
			editor : {
				allowBlank : false
			}
		}, {
			header : '密码',
			dataIndex : 'userPwd',
			editor : {
				allowBlank : false
			}
		}, {
			header : '性别',
			dataIndex : 'userSex',
			width : 35,
			editor : {
				allowBlank : false
			}
		}, {
			header : '出生日期',
			dataIndex : 'birthdate',
			width : 70,
			editor : {
				allowBlank : false
			}
		}, {
			header : '照片',
			dataIndex : 'photo',
			editor : {
				allowBlank : false
			}
		}, {
			header : '国籍',
			dataIndex : 'contry',
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
			dataIndex : 'pwdQuestion1',
			editor : {
				allowBlank : false
			}
		}, {
			header : '密保答案1',
			dataIndex : 'pwdAnser1',
			editor : {
				allowBlank : false
			}
		}, {
			header : '密保问题2',
			dataIndex : 'pwdQuestion2',
			editor : {
				allowBlank : false
			}
		}, {
			header : '密保答案2',
			dataIndex : 'pwdAnser2',
			editor : {
				allowBlank : false
			}
		}, {
			header : '密保问题3',
			dataIndex : 'pwdQuestion3',
			editor : {
				allowBlank : false
			}
		}, {
			header : '密保答案3',
			dataIndex : 'pwdAnser3',
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
			dataIndex : 'decription',
			editor : {
				allowBlank : false
			}
		}, {
			header : '政治面貌',
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
			header : '名族',
			dataIndex : 'party',
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
			header : '创建时间',
			dataIndex : 'createTime',
			editor : {
				allowBlank : false
			}
		}, {
			header : '修改时间',
			dataIndex : 'updateTime',
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
	/*
	 * plugins:[
	 * Ext.create('Ext.grid.plugin.CellEditing',{clicksToEdit:1}) ],
	 */
	// forceFit:true,//自动填充空白
	// 工具条
	tbar : [{
				xtype : 'button',
				text : '新增',
				icon : 'images/user_add.png'
			}, '-', {
				xtype : 'button',
				text : '修改',
				icon : 'images/user_edit.png'
			}, '-', {
				xtype : 'button',
				text : '删除',
				icon : 'images/user_delete.png'
			}, '-', {
				xtype : 'button',
				text : '设置',
				style : 'margin-right:10px',
				icon : 'images/wrench.png'
			}, '->', '检索'/*, new Ext.ux.form.SearchField({
						store : 'userTableStore',
						width : 150
					})*/],
	// 分页工具
	bbar : new Ext.PagingToolbar({
				autoHeight : true,
				displayInfo : true,
				store : 'userTableStore',
				displayMsg : '显示  {0}  -  {1} 条   ，共计 {2} 条 ',
				emptyMsg : '没有记录'
			})
});