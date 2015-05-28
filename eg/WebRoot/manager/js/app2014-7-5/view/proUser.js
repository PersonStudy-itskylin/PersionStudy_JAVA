Ext.define('AM.view.proUser', {
	extend : 'Ext.window.Window',
	alias : 'widget.prouser',
	height : 550,
	width : 560,
	titleCollapse : true,
	border : false,
	modal : true,
	shadow : true,
	layout : 'fit',
	initComponent : function() {
		var me = this;
		Ext.apply(me, {
			items : [{
				xtype : 'form',
				border : false,
				frame : true,
				url : 'js/app/data/proUser.jsp',
				fileUpload : true,
				padding : '10 0 10 5',
				width : 600,
				layout : 'column',
				columns : 2,
				bodyPadding : 0,
				frameHeader : false,
				fieldDefaults : {
					labelAlign : 'right',
					labelWidth : 60,
					disabled : true
				},
				items : [{
							columnWidth : 280,
							maxWidth : 280,
							frame : true,
							style : 'border:0;',
							padding : '10 0 5 30',
							fieldDefaults : {
								disabled : true
							},
							items : [{
										xtype : 'textfield',
										fieldLabel : '账号',
										msgTarget : 'side',
										name : 'user_name',
										allowBlank : false,
										blankText : '请输入账号'
									}, {
										xtype : 'textfield',
										fieldLabel : '密码',
										msgTarget : 'side',
										name : 'pwd'
									}, {
										xtype : 'textfield',
										fieldLabel : '确认密码',
										msgTarget : 'side',
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
										msgTarget : 'side',
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
										editable : false,
										maxValue : new Date(),
										format : 'Y-m-d',
										msgTarget : 'side',
										name : 'birthdate'
									}, {
										layout : 'column',
										columns : 4,
										height : 30,
										width : 260,
										frame : true,
										style : 'border:0;',
										items : [{
													xtype : 'country',
													width : 130,
													fieldLabel : '国省市',
													labelAlign : 'right',
													labelWidth : 55,
													name : 'country'
												}, {
													xtype : 'province',
													width : 60,
													name : 'province'
												}, {
													xtype : 'city',
													width : 60,
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
										name : 'tel'
									}, {
										xtype : 'textfield',
										fieldLabel : '电子邮箱',
										msgTarget : 'side',
										name : 'email',
										vtype : 'email',
										vtypeText : '请输入邮箱地址...'
									}, {
										xtype : 'married',
										width : 160,
										fieldLabel : '婚姻情况',
										name : 'married'
									}, {
										xtype : 'combobox',
										width : 160,
										fieldLabel : '教育程度',
										msgTarget : 'side',
										name : 'education'
									}, {
										xtype : 'combobox',
										width : 160,
										fieldLabel : '职业',
										msgTarget : 'side',
										name : 'job'
									}, {
										xtype : 'combobox',
										width : 160,
										fieldLabel : '民族',
										msgTarget : 'side',
										name : 'ethnic'
									}, {
										xtype : 'combobox',
										width : 160,
										fieldLabel : '政治面貌',
										msgTarget : 'side',
										name : 'party'
									}, {
										xtype : 'textfield',
										fieldLabel : 'QQ号',
										name : 'qq'
									}]
						}, {
							columnWidth : 250,
							maxWidth : 250,
							style : 'border:0;',
							frame : true,
							padding : '30 10 0 0',
							items : [{
								xtype : 'image',
								id : 'image',
								name:'photo',
								height : 190,
								padding : '10 0 10 60',
								width : 190,
								src : '/eg/manager/upload/images/1404234177637.jpg'
							}, {
								xtype : 'textfield',
								width : 250,
								fieldLabel : '选择照片',
								inputType : 'file',
								name : 'photo'
							}, {
								xtype : 'question',
								fieldLabel : '问题1',
								editable : false,
								name : 'pwd_question1'
							}, {
								xtype : 'textfield',
								fieldLabel : '答案1',
								name : 'pwd_anser1'
							}, {
								xtype : 'question',
								fieldLabel : '问题2',
								editable : false,
								name : 'pwd_question2'
							}, {
								xtype : 'textfield',
								fieldLabel : '答案2',
								name : 'pwd_anser2'
							}, {
								xtype : 'question',
								fieldLabel : '问题3',
								editable : false,
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
						text : '修改',
						style : 'font-size:18px'
					}]
		});

		me.callParent(arguments);
	}

});

/*
 * Ext.define('AM.view.proUser', { extend : 'Ext.window.Window', alias :
 * 'widget.prouser', icon : 'images/usertable/user.png', height : 550, width :
 * 560, titleCollapse : true, border:false, modal:true, shadow:true, layout :
 * 'fit', items : [{ xtype : 'form', border : false, frame : true, id :
 * 'form12345', url:'js/app/data/proUser.jsp', fileUpload: true, padding : '10 0
 * 10 5', width : 600, layout : 'column', columns: 2, bodyPadding : 0,
 * frameHeader : false, fieldDefaults:{ labelAlign : 'right', labelWidth : 60,
 * disabled:true }, items : [{ columnWidth : 280, maxWidth : 280, frame:true,
 * style:'border:0;', padding : '10 0 5 30', fieldDefaults:{ disabled:true },
 * items : [{ xtype : 'textfield', fieldLabel : '账号', msgTarget : 'side', name :
 * 'user_name', allowBlank : false, blankText : '请输入账号' }, { xtype :
 * 'textfield', fieldLabel : '密码', msgTarget : 'side', name : 'pwd' }, { xtype :
 * 'textfield', fieldLabel : '确认密码', msgTarget : 'side', name : 'pwd2' }, {
 * xtype : 'textfield', fieldLabel : '姓名', msgTarget : 'side', name :
 * 'loginname' }, { xtype : 'radiogroup', width : 200, fieldLabel : '性别',
 * msgTarget : 'side', items : [{ xtype : 'radiofield', name : 'sex', boxLabel :
 * '男', inputValue : '1', checked : true }, { xtype : 'radiofield', name :
 * 'sex', inputValue : '2', boxLabel : '女' }] }, { xtype : 'datefield',
 * fieldLabel : '出生日期', editable:false, maxValue : new Date(), format:'Y-m-d',
 * msgTarget : 'side', name : 'birthdate' }, { layout : 'column', columns : 4,
 * height : 30, width:260, frame:true, style:'border:0;', items : [{ xtype :
 * 'combobox', width : 130, fieldLabel : '国省市', labelAlign : 'right', labelWidth :
 * 55, name : 'country' }, { xtype : 'combobox', width : 60, name : 'province' }, {
 * xtype : 'combobox', width : 60, name : 'city' }] }, { xtype : 'textfield',
 * fieldLabel : '详细地址', msgTarget : 'side', name : 'address' }, { xtype :
 * 'textfield', fieldLabel : '联系电话', msgTarget : 'side', name : 'tel' }, { xtype :
 * 'textfield', fieldLabel : '电子邮箱', msgTarget : 'side', name : 'email', vtype :
 * 'email', vtypeText : '请输入邮箱地址...' }, { xtype : 'combobox', width : 160,
 * fieldLabel : '婚姻情况', name : 'married', value:'1' }, { xtype : 'combobox',
 * width : 160, fieldLabel : '教育程度', msgTarget : 'side', name : 'education' }, {
 * xtype : 'combobox', width : 160, fieldLabel : '名族', msgTarget : 'side', name :
 * 'ethnic' }, { xtype : 'combobox', width : 160, fieldLabel : '政治面貌', msgTarget :
 * 'side', name : 'party' }, { xtype : 'textfield', fieldLabel : 'QQ号', name :
 * 'qq' }] }, { columnWidth : 250, maxWidth : 250, style:'border:0;',
 * frame:true, padding : '30 10 0 0', items : [{ xtype : 'image', id : 'image',
 * height : 190, padding : '10 0 10 60', width : 190, src :
 * '/eg/manager/upload/images/1404234177637.jpg' }, { xtype : 'textfield', width :
 * 250, fieldLabel : '选择照片', inputType:'file', name : 'photo' }, { xtype :
 * 'question', fieldLabel : '问题1', editable:false, name : 'pwd_question1' }, {
 * xtype : 'textfield', fieldLabel : '答案1', name : 'pwd_anser1' }, { xtype :
 * 'question', fieldLabel : '问题2', editable:false, name : 'pwd_question2' }, {
 * xtype : 'textfield', fieldLabel : '答案2', name : 'pwd_anser2' }, { xtype :
 * 'question', fieldLabel : '问题3', editable:false, name : 'pwd_question3' }, {
 * xtype : 'textfield', fieldLabel : '答案3', name : 'pwd_anser3' }, { xtype :
 * 'textfield', hidden : true, fieldLabel : '修改者', name : 'editor' }, { xtype :
 * 'textfield', hidden : true, fieldLabel : '注册时间', name : 'createTime' }, {
 * xtype : 'textfield', hidden : true, fieldLabel : '修改时间', name : 'updateTime' }, {
 * xtype : 'textareafield', hidden : true, fieldLabel : '备注', name : 'remark' }, {
 * xtype : 'textfield', hidden : true, fieldLabel : 'IP地址', name : 'ipaddress' }] }]
 * }], fbar : ['->', { xtype : 'button', text : '修改', style:'font-size:18px' }]
 * });
 * 
 * 
 */