
Ext.define('core.user.view.UserForm',{
	extend:'Ext.form.Panel',
	alias:'widget.userform',
	layout : {
		type : 'table',
		columns : 2
	},
	align:'left',
	bodyStyle:'margin:50px;padding:50px;',
	defaults:{
		margin:'10 0 0 10',
		selectOnFocus:true,
		width:300,
		msgTarget:'side', //提示信息现在的位置
		labelAlign:'right',
		labelWidth:60,
		widht:60
	},
	tbar:[{
		xtype:'button',
		ref:'save',
		iconCls:'table_save',
		text:'保存'
	},{
		xtype:'button',
		ref:'return',
		iconCls:'return',
		text:'返回'
	}],
	items:[{
		xtype:'textfield',
		hidden:true,
		fieldLabel:'ID',
		name:'id'
	},{
		xtype:'textfield',
		fieldLabel:'用户名',
		name:'username',
		allowBlank : false,//不允许为空
		blankText : '用户名不能为空',//错误提示内容 
		readOnly:false
	},{
		xtype:'textfield',
		fieldLabel:'密码',
		inputType : 'password',  
		name:'password',
		allowBlank : false,//不允许为空
		blankText : '密码不能为空',//错误提示内容 
		regex:/^([?=.*A-z0-9]){6,16}$/,
		regexText:'密码长度为6-16位字符',
		emptyText:'长度为6-16位字符..',
		readOnly:false
	},{
		xtype:'textfield',
		fieldLabel:'姓名', 
		name:'realname',
		allowBlank : false,//不允许为空
		blankText : '姓名不能为空',//错误提示内容 
		readOnly:false
	},{
		xtype:'textfield',
		fieldLabel:'手机号码',
		name:'phone',
		allowBlank : false,//不允许为空
		blankText : '手机不能为空',//错误提示内容
		vtype:'mobile',
        emptyText:'请填写11位手机号...',
		readOnly:false
	},{
		xtype:'textfield',
		fieldLabel:'电话',
		name:'tel',
		allowBlank : false,//不允许为空
		blankText : '电话不能为空',//错误提示内容
		vtype:'telphone',
        emptyText:'请填写座机电话...',
		readOnly:false
	},{
		xtype:'textfield',
		fieldLabel:'QQ',
		name:'qq',
		allowBlank:false,
		blankText : '姓名不能为空',//错误提示内容 
		readOnly:false
	},{
		xtype:'textfield',
		fieldLabel:'Email',
		name:'email',
		allowBlank:false,
		blankText : 'email不能为空',//错误提示内容 
		vtype:'email',
		vtypeText:'不是有效的email地址，如：langsin@gmail.com',
		readOnly:false
	},{
		xtype:'textfield',
		hidden:true
	},{
		xtype:'combobox',
		id:'stateId',
		name:'state',
        maxPickerHeight:160,
 	    editable:false,
        fieldLabel: '账号状态',
        store: Ext.create('Ext.data.Store', {
        	 fields: ['state', 'name'],
        	 data:[
        	       {'state':'0', 'name':'正常'},
        	       {'state':'1', 'name':'锁定'},
        	       {'state':'2','name':'欠费'}
        	 ]
         }),
         displayField: 'name',
 	     valueField: 'state',
 	    value:0
	},{
		xtype:'combobox',
		name:'role',
		id:'roleId',
        fieldLabel: '权限',
        maxPickerHeight:160,
 	    editable:false,
        store: Ext.create('Ext.data.Store', {
	       	 fields: ['role', 'name'],
	       	 data:[
	       	       {'role':'0', 'name':'系统管理员'},
	       	       {'role':'1', 'name':'入库员'},
	       	       {'role':'2', 'name':'出库员'}
	       	       ]
	        }),
        displayField: 'name',
	    valueField: 'role',
 	    value:0
	},{xtype: 'textfield',
        style: {
            border:'0',
            display:'none'
          }
	},{
		xtype:'textareafield',
		fieldLabel:'描述',
		name:'description',
		readOnly:false
	},{
		xtype:'textareafield',
		fieldLabel:'备注',
		name:'remark',
		readOnly:false
	}],
	initComponent:function(){
		this.callParent(arguments);
	}
});