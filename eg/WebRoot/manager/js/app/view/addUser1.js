
Ext.define('AM.view.addUser1', {
			extend : 'Ext.window.Window',
			alias : 'widget.adduser',
			id:'adduser1',
			title : '新增用户',
			icon : 'images/usertable/user_add.png',
			height : 280,
			width : 300,
			titleCollapse : true,
			border:false,
			modal:true,
			shadow:true,
			layout : 'fit',
			items : [{
				xtype : 'form',
				border : false,
				frame : true,
				id : 'form12345',
				url:'js/app/data/addUser1.jsp',
				fileUpload: true,
				enctype:'multipart/form-data',
				padding : '10 5 10 5',
				width : 600,
				bodyPadding : 0,
				frameHeader : false,
				fieldDefaults:{
					labelAlign : 'right',
					labelWidth : 60
				},
				items : [{
					columnWidth : 250,
					maxWidth : 250,
					frame:true,
					style:'border:0;',
					padding : '10 5 5 10',
					width : 258,
					items : [{
						xtype : 'textfield',
						fieldLabel : '账号',
						msgTarget : 'side',
						name : 'user_name',
						id:'user_name',
						allowBlank : false,
						blankText : '请输入账号',
						validator:function (value) {
                            var validator = this;
                            var error = true;
                            Ext.Ajax.request({
                                async: false,
                                scope: validator,
					    		url: 'js/app/data/checkUser.jsp',
                                params: { user_name: this.value },
                                method: 'POST',
                                success: function (response) {
                                    var result =  Ext.JSON.decode(response.responseText);
                                    if (!result.success) {
                                        error = "该名称己经存在,请重新输入！";
                                    }
                                }
                            });
                            return error;
						}
					}, {
						xtype : 'textfield',
						fieldLabel : '密码',
						inputType:'password',
						allowBlank : false,
						msgTarget : 'side',
						id:'pwd',
						name : 'pwd'
					}, {
						xtype : 'textfield',
						fieldLabel : '确认密码',
						allowBlank : false,
						inputType:'password',
						msgTarget : 'side',
						id:'pwd2',
						name : 'pwd2'
					}, {
						xtype : 'textfield',
						fieldLabel : '姓名',
						allowBlank : false,
						msgTarget : 'side',
						name : 'loginname'
					}, {
						xtype : 'textfield',
						fieldLabel : '联系电话',
						msgTarget : 'side',
						allowBlank : false,
						regex:/^((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)$/,//支持手机号码，3-4位区号，7-8位直播号，1-4位分机号
						regexText:'联系方式输入有误，请重新输入...',
						name : 'tel'
					}, {
						xtype : 'textfield',
						fieldLabel : '电子邮箱',
						msgTarget : 'side',
						name : 'email',
						vtype : 'email',
						regexText:'邮箱地址输入有误，请重新输入...',
						vtypeText : '请输入邮箱地址...'
					}, {
						xtype : 'textfield',
						fieldLabel : 'QQ号',
						regex:/^([1-9])\d{4,11}$/,
						regexText:'QQ号格式输入有误，请重新输入...',
						name : 'qq'
					}, {
						xtype : 'textfield',
						hidden : true,
						fieldLabel : '修改者',
						name : 'editor'
					}, {
						xtype : 'textfield',
						hidden : true,
						fieldLabel : '注册时间',
						name : 'createTime'
					}, {
						xtype : 'textfield',
						hidden : true,
						fieldLabel : '修改时间',
						name : 'updateTime'
					}, {
						xtype : 'textareafield',
						hidden : true,
						fieldLabel : '备注',
						name : 'remark'
					}]
				}]
			}],
			fbar : ['->', {
				xtype : 'button',
				text : '提交'
			}, {
				xtype : 'button',
				text : '重置'
			}]
		});