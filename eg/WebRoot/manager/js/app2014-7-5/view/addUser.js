
Ext.define('AM.view.addUser', {
			extend : 'Ext.window.Window',
			alias : 'widget.adduser',
			id:'adduser',
			title : '新增用户',
			icon : 'images/usertable/user_add.png',
			height : 550,
			width : 560,
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
				url:'js/app/data/addUser.jsp',
				fileUpload: true,
				enctype:'multipart/form-data',
				padding : '10 5 10 5',
				width : 600,
				layout : 'column',
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
						hidden : true,
						name : 'user_id'
					}, {
						xtype : 'textfield',
						fieldLabel : '账号',
						name : 'user_name',
						id:'user_name',
						allowBlank : false,
//						regex:/^&/,
//						regexText:'',
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
						msgTarget : 'side',
						name : 'loginname'
					}, {
						xtype : 'radiogroup',
						width : 200,
						fieldLabel : '性别',
						items : [{
							xtype : 'radiofield',
							name : 'sex',
							boxLabel : '男',
							inputValue : '1',
							checked : true
						}, {
							xtype : 'radiofield',
							name : 'sex',
							inputValue : '2',
							boxLabel : '女'
						}]
					}, {
						xtype : 'datefield',
						fieldLabel : '出生日期',
						maxValue : new Date(),
						format:'Y-m-d',
						msgTarget : 'side',
						name : 'birthdate'
					}, {
						xtype : 'container',
						columns : '3',
						height : 30,
						layout : 'column',
						items : [{
							xtype : 'country',
							width : 130,
							fieldLabel : '国省市',
							labelAlign : 'right',
							labelWidth : 60,
							value:'无',
							name : 'country'
						}, {
							xtype : 'province',
							width : 50,
							value:'无',
							name : 'province'
						}, {
							xtype : 'city',
							width : 50,
							value:'无',
							name : 'city'
						}]
					}, {
						xtype : 'textfield',
						fieldLabel : '详细地址',
						msgTarget : 'side',
						name : 'address'
					}, {
						xtype : 'textfield',
						fieldLabel : '联系电话',
						msgTarget : 'side',
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
						xtype : 'married',
						width : 160,
						fieldLabel : '婚姻情况',
						name : 'married',
						value:'--请选择--'
					}, {
						xtype : 'education',
						width : 160,
						fieldLabel : '教育程度',
						msgTarget : 'side',
						value:'--请选择--',
						name : 'education'
					}, {
						xtype : 'ethnic',
						width : 160,
						fieldLabel : '民族',
						msgTarget : 'side',
						value:'汉族',
						name : 'ethnic'
					}, {
						xtype : 'party',
						width : 160,
						fieldLabel : '政治面貌',
						msgTarget : 'side',
						name : 'party'
					}, {
						xtype : 'textfield',
						fieldLabel : 'QQ号',
						regex:/^([1-9])\d{4,11}$/,
						regexText:'QQ号格式输入有误，请重新输入...',
						name : 'qq'
					}]
				}, {
					xtype : 'container',
					columnWidth : 300,
					maxWidth : 280,
					padding : '20 10 0 10',
					width : 307,
					layout : 'anchor',
					items : [{
						xtype : 'image',
						id : 'image',
						height : 190,
						padding : '10 0 10 60',
						width : 190,
						src : 'images/usertable/loginlogo.gif'
					}, {
						xtype : 'filefield',
						width : 250,
						fieldLabel : '选择照片',
						name : 'photo'
					}, {
						xtype : 'question',
						fieldLabel : '问题1',
						name : 'pwd_question1'
					}, {
						xtype : 'textfield',
						fieldLabel : '答案1',
						name : 'pwd_anser1'
					}, {
						xtype : 'question',
						fieldLabel : '问题2',
						name : 'pwd_question2'
					}, {
						xtype : 'textfield',
						fieldLabel : '答案2',
						name : 'pwd_anser2'
					}, {
						xtype : 'question',
						fieldLabel : '问题3',
						name : 'pwd_question3'
					}, {
						xtype : 'textfield',
						fieldLabel : '答案3',
						name : 'pwd_anser3'
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
					}, {
						xtype : 'textfield',
						hidden : true,
						fieldLabel : 'IP地址',
						name : 'ipaddress'
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