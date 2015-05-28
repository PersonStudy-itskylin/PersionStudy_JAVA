/**主控制器*/
Ext.define("core.app.controller.MainController",{
	extend : "Ext.app.Controller",
	init : function(){
		var self = this;
		
		/**显示登陆窗口*/
		var loginWin =Ext.create("core.app.view.LoginWindow");
		loginWin.show();
		
		/**公用添加页面的方法*/
		/**
		 * 动态加载controller并渲染它的主窗体
		 */
		this.addFunItem=function(funInfo){
			if(funInfo){
				var mainView=funInfo.mainView;
				var funPanel=mainView.down(funInfo.funViewXtype);
				if(!funPanel){
					self.application.getController(funInfo.funController).init();
					funPanel=Ext.create(funInfo.funViewName);
					mainView.add(funPanel);
					mainView.setActiveTab(funPanel);
				}else{									
					mainView.setActiveTab(funPanel);
				}
			}
		},
		/**下在是控制部分*/
		this.control({
			/**控制登陆窗口的登陆*/
			"loginwindow button[ref=login]":{
				click : function(btn){
					var remember = btn.up("loginwindow").down("checkbox[name=remember]");
					var autologin = btn.up("loginwindow").down("checkbox[name=autologin]");
					var loginWin = btn.up("loginwindow");
					var username = loginWin.down("form").getForm().findField("username").getValue();
					var password = loginWin.down("form").getForm().findField("password").getValue();
					
					Ext.Ajax.request({
						waitMsg : '正在登陆,请稍后...', 
						url:"./user/login.action",
						params:{username:username,password:password},
						method:"POST",
						timeout:4000,
						success:function(response,opts){
							var resObj=Ext.decode(response.responseText);
							if(resObj.success){
								var userObj=resObj.obj;
								var dis=Ext.getCmp("displaylogin");
								dis.setValue("<font color=red><b>"+username+",</b>您好</font>");
								
								//登陆成功后设置cookie
								if(remember.getValue()){
									Ext.util.Cookies.set("username",username);
									Ext.util.Cookies.set("password",password);
									Ext.util.Cookies.set("remember",remember.getValue());
									if(autologin.getValue()){
										Ext.util.Cookies.set("autologin",true);
									}else{
										Ext.util.Cookies.clear("autologin");
									}
								}else{
									Ext.util.Cookies.clear("username");
									Ext.util.Cookies.clear("password");
									Ext.util.Cookies.clear("remember");
								}
								
								btn.up("loginwindow").close();
							}else{
								Ext.Msg.alert("提示","用户名和密码错误");
							}
						}
			 		});
					
				}
			},
			
			/**注销*/
			"topview button[ref=logout]" : {
				click: function(btn){
					var dis=Ext.getCmp("displaylogin");
					
					Ext.Msg.confirm("提示","是否要注销？",function(btn){
						if(btn == 'yes'){
							Ext.Ajax.request({
								waitMsg : '正在登陆,请稍后...', 
								url:"./user/loginOut.action",
								method:"POST",
								timeout:4000,
								success:function(response,opts){
								
								}
							});
							
							dis.setValue("<font color=white><b>未登录</b></font>");
							Ext.util.Cookies.clear("autologin");
							Ext.create("core.app.view.LoginWindow").show();
						}
					},this);
				}
			},
			
			/**退出系统*/
			"topview button[ref=exit]" : {
				click: function(btn){
					Ext.Msg.confirm("提示","是否要退出系统",function(btn){
						if(btn == 'yes'){
							if(document.all){//IE
								window.open('', '_parent', '');
								window.close();
							}else{//FF
								window.open('', '_self', '');
								window.close();
							}
						}
					},this);
				}
			},
			
			"westview treepanel":{
				itemclick:function(tree,record,item,index,e,eOpts){
					var mainView=tree.up("mainviewlayout").down("centerview");
					switch(record.data["id"]){
						case "usermanager":/**用户管理*/
							self.addFunItem({
								mainView:mainView,
								funViewXtype:"userlayout",
								funController:"core.user.controller.UserController",
								funViewName:"core.user.view.UserLayout"
							});
							break;
						case "productmanager":/**仓库管理*/
							self.addFunItem({
								mainView:mainView,
								funViewXtype:"productlayout",
								funController:"core.product.controller.ProductController",
								funViewName:"core.product.view.ProductLayout"
							});
							break;
						case "historyinfo":/**历史记录*/
							self.addFunItem({
								mainView:mainView,
								funViewXtype:"historylayout",
								funController:"core.history.controller.HistoryController",
								funViewName:"core.history.view.HistoryLayout"
							});	
							break;
						case "systemlog":/**审计*/
							self.addFunItem({
								mainView:mainView,
								funViewXtype:"systemloglayout",
								funController:"core.systemlog.controller.SystemlogController",
								funViewName:"core.systemlog.view.SystemlogLayout"
							});
							break;
					}
				} //itemclick end
			}//"westview treepanel" end
		});
	},
	views : [
		"core.app.view.TopView",
		"core.app.view.WestView",
		"core.app.view.CenterView",
		"core.app.view.MainViewLayout",
		"core.app.view.LoginWindow"
	]
});