/**
 * ClassName 流程挂接视图
 * */
Ext.define("core.user.view.UserGrid",{
	extend:"Ext.grid.Panel",
	alias:"widget.usergrid",
	store:"core.user.store.UserStore",
	selModel:{
		selType:"checkboxmodel"
	},
	border:0,
	multiSelect:true,
	frame:true,
	tbar:[
		{xtype:'button',text:'新增用户',ref:'addUser',iconCls:'table_add'},
		{xtype:'button',text:'修改用户',ref:'updateUser',iconCls:'table_edit'},
		{xtype:'button',text:'删除用户',ref:'removeUser',iconCls:'table_remove'},
		"->",
		"按用户名模糊查询:",
		{
			xtype: 'triggerfield', 
			triggerCls: Ext.baseCSSPrefix + 'form-search-trigger',
			listeners:{
            	"change":function(_this,_new,_old,_opt){ 
            		var _store = _this.ownerCt.ownerCt.getStore();
            		_store.clearFilter(false);
            		_store.filter("name",_new);
                }
            },
            onTriggerClick: function() {
            	var _store = this.ownerCt.ownerCt.getStore();
            	_store.clearFilter(false);
            	_store.filter("name",this.getValue());
		    }
		}
	],
	bbar:{
		xtype:'pagingtoolbar',
		store:'core.user.store.UserStore',
		dock:'bottom',
		displayInfo:true
	},
	enableKeyNav:true,  //可以使用键盘控制上下
	columnLines:true, //展示竖线
	columns:[
		{xtype: 'rownumberer'},
		{text:"ID",dataIndex:"id",width:100,border: 20},
		{text:"用户名称",dataIndex:"username",width:100,border: 50},
		{text:"姓名",dataIndex:"realname",width:100,
			 xtype : 'booleancolumn',
			 trueText : "<font color=green>女</font>",
			 falseText : "<font color=red>男</font>"
		},
		{text:"权限",dataIndex:"role",width:100},
		{text:"手机号",dataIndex:"phone",width:100},
		{text:"电话",dataIndex:"tel",width:100},
		{text:"QQ",dataIndex:"qq",width:100},
		{text:"Email",dataIndex:"email",width:100},
		{text:"账号状态",dataIndex:"state",width:100},
		{text:"注册IP",dataIndex:"ip",width:100},
		{text:"注册时间",dataIndex:"createtime",width:100},
		{text:"更新时间",dataIndex:"updatetime",width:100},
		{text:"备注",dataIndex:"remark",width:100}
	],
	initComponent:function(){
		this.callParent(arguments);
	}
});