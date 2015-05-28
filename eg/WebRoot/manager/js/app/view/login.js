Ext.define('AM.store.login',{
	extend:'Ext.window.Window',
	alias:'widget.login',
	title:'管理员登陆',
	id:'mylogin',
	width:470,
	height:280,
	closable:false,
	draggable:false,
	modal:true,
	bodyPadding:40,
	fbar:[
		{text:'登陆',handler:function(){
		   //Ext.getCmp('mylogin').hidden();
			alert(345);
		   window.location.href='index.htm';
			
			
		}},
		{text:'退出'}
	],
	items:{
		xtype: 'form',
        width: 388,
        frame:true,
        style:'border:0;',
        items: [{
            xtype: 'textfield',
            fieldLabel: '账号',
            labelAlign: 'right',
            labelWidth: 60,
            width: 220,
            style:'margin-bottom:10px;',
            name:'user_name'
       	},{
            xtype: 'textfield',
            fieldLabel: '密码',
            labelAlign: 'right',
            labelWidth: 60,
            width: 220,
            name:'pwd'
       	},{
            layout: 'column',
        	frame:true,
            style:'border:0;',
            items: [{
                  xtype: 'textfield',
		          labelAlign: 'right',
		          labelWidth: 60,
                  width: 160,
                  style:'margin-left:-5px',
                  fieldLabel: '验证码',
                  name:'code'
            },{
                  xtype: 'image',
                  width: 60,
                  src: 'js/app/data/codeimg.jsp'
            }]
      },{
        xtype: 'checkboxgroup',
        width:180,
        style:'margin-left:20px;',
        items: [
            {
                xtype: 'checkboxfield',
                boxLabel: '记住密码'
            },
            {
                xtype: 'checkboxfield',
                boxLabel: '自动登录'
            }
        ]
    }]
	}
});



/*
 Ext.define('AM.view.login',{
	extend:'Ext.window.Window',
	alias:'widget.login',
	title:'管理员登陆',
	width:470,
	closable:false,
	draggable:false,
	height:280,
	modal:true,
	bodyPadding:40,
	renderTo:Ext.getBody(),
	fbar:[
		{text:'登陆'},
		{text:'退出'}
	],
	fieldDefaults:{
	},
	items:{
		xtype: 'form',
        width: 388,
        frame:true,
        style:'border:0;',
        items: [{
            xtype: 'textfield',
            fieldLabel: '账号',
            labelAlign: 'right',
            labelWidth: 60,
            width: 220,
            style:'margin-bottom:10px;',
            name:'user_name'
       	},{
            xtype: 'textfield',
            fieldLabel: '密码',
            labelAlign: 'right',
            labelWidth: 60,
            width: 220,
            name:'pwd'
       	},{
            layout: 'column',
        	frame:true,
            style:'margin-bottom:10px;border:0;',
            items: [{
                  xtype: 'textfield',
		          labelAlign: 'right',
		          labelWidth: 60,
                  width: 160,
                  style:'margin-left:-5px',
                  fieldLabel: '验证码',
                  name:'code'
            },{
                  xtype: 'image',
                  width: 60,
                  src: 'js/app/data/codeimg.jsp'
           },{
        xtype: 'checkboxgroup',
        width:180,
        style:'margin-left:20px;',
        items: [
            {
                xtype: 'checkboxfield',
                boxLabel: '记住密码'
            },
            {
                xtype: 'checkboxfield',
                boxLabel: '自动登录'
            }]
    	}]
  	}]
  }
});
 */
