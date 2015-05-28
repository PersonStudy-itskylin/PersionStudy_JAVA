Ext.define('Am.view.test',{
	extend:'Ext.window.Window',
	alias:'widget.test',
	resizable:false, //变大小
    layout:{type:'vbox',align:'center'},
	initComponent : function() {
	var me=this;
	 Ext.define('jieModel',{
			extend:'Ext.data.Model',
			fields:[
			        {name:'pkid',mapping:'pkid'},
			        {name:'chname',mapping:'chname'}
			        ]
		});
   var Jie_Store=Ext.create('Ext.data.Store',{//界列表数据源
		autoLoad:true,
		model:'jieModel',
		proxy:{
			type:'ajax',
			url:'getJieList.do',
			render:{
				type:'json',
				root:'data'
				}
		},
		listeners:{
			load:function(v){
				
			}
		}
	});
   var  jiestore=Ext.create('Ext.form.ComboBox',{
		fieldLabel: '界',
		valueField: 'pkid',
		displayField: 'chname',
		id:'wz_jie',
		name:'wz_jie',				
		allowBlank:false, //不允许为空
        blankText:'不可以空',
        editable : false,
        queryMode:'local',
        emptyText:'请选择···', 
        store:Jie_Store,
        triggerAction:'all',
       margin:'10 0 0 10',
       listeners : { 
    	   select : function() {   
    	                             var wz_men=Ext.getCmp("wz_men");   
    	                              wz_men.reset();  
    	                              var wz_gang=Ext.getCmp("wz_gang");   
    	   	                          wz_gang.reset();
    	   	                       var wz_ke=Ext.getCmp("wz_ke");   
      	                          wz_ke.reset();  
      	                         var wz_mu=Ext.getCmp("wz_mu");   
     	                          wz_mu.reset();  
     	                         var wz_shu=Ext.getCmp("wz_shu");  
     	                        wz_shu.reset();  
     	                      gang_Store.removeAll();
     	                     mu_Store.removeAll();	
     	                    ke_Store.removeAll();
     	                   shu_Store.removeAll();	
    	                              men_Store.load({
    	                            	  url: "getMenList.do",
    	                            	  params: { pid: this.value } 
    	                              });   	                             
    	                           }   
    	                      }   

	});
   var men_Store=Ext.create('Ext.data.Store',{//门列表数据源
		autoLoad:false,
		model:'jieModel',
		proxy:{
			type:'ajax',
			url:'getMenList.do',
			render:{
				type:'json',
				root:'data'
				}
		}
		
	});
   var  menstore=Ext.create('Ext.form.ComboBox',{
		fieldLabel: '门',
		valueField: 'pkid',
		displayField: 'chname',
		id:'wz_men',
		name:'wz_men',				
		allowBlank:false, //不允许为空
       blankText:'不可以空',
       editable : false,
       queryMode:'local',
       emptyText:'请选择···', 
       store:men_Store,
       triggerAction:'all',
      margin:'10 0 0 10',
      listeners : { 
   	   select : function() {   
   	                           var wz_gang=Ext.getCmp("wz_gang");   
   	                          wz_gang.reset();  
   	                       var wz_ke=Ext.getCmp("wz_ke");   
	                          wz_ke.reset();  
	                         var wz_mu=Ext.getCmp("wz_mu");   
	                          wz_mu.reset();  
	                         var wz_shu=Ext.getCmp("wz_shu");   
	                         wz_shu.reset();
	                         mu_Store.removeAll();	
	     	                    ke_Store.removeAll();
	     	                   shu_Store.removeAll();	                   
   	                       gang_Store.load({
   	                            	  url: "getGangList.do",
   	                            	  params: { pid: this.value } 
   	                              });   	                             
   	                           }   
   	                      }   

	});
   
   var gang_Store=Ext.create('Ext.data.Store',{//纲列表数据源
		autoLoad:false,
		model:'jieModel',
		proxy:{
			type:'ajax',
			url:'getGangList.do',
			render:{
				type:'json',
				root:'data'
				}
		}
		
	});
  var  gangstore=Ext.create('Ext.form.ComboBox',{
		fieldLabel: '纲',
		valueField: 'pkid',
		displayField: 'chname',
		id:'wz_gang',
		name:'wz_gang',				
		allowBlank:false, //不允许为空
      blankText:'不可以空',
      editable : false,
      queryMode:'local',
      emptyText:'请选择···', 
      store:gang_Store,
      triggerAction:'all',
     margin:'10 0 0 10' ,
     listeners : { 
     	   select : function() {   
     	                           
     	                         var wz_mu=Ext.getCmp("wz_mu");   
    	                          wz_mu.reset();  
    	                          var wz_ke=Ext.getCmp("wz_ke");   
     	                          wz_ke.reset(); 
    	                         var wz_shu=Ext.getCmp("wz_shu");   
     	                         wz_shu.reset(); 
     	                        ke_Store.removeAll();
 	     	                   shu_Store.removeAll();	                   
     	                        mu_Store.load({
     	                            	  url: "getMuList.do",
     	                            	  params: { pid: this.value } 
     	                              });   	                             
     	                           }   
     	                      }
	});
  var mu_Store=Ext.create('Ext.data.Store',{//科列表数据源
		autoLoad:false,
		model:'jieModel',
		proxy:{
			type:'ajax',
			url:'getMuList.do',
			render:{
				type:'json',
				root:'data'
				}
		}
		
	});
var  mustore=Ext.create('Ext.form.ComboBox',{
		fieldLabel: '目',
		valueField: 'pkid',
		displayField: 'chname',
		id:'wz_mu',
		name:'wz_mu',				
		allowBlank:false, //不允许为空
    blankText:'不可以空',
    editable : false,
    queryMode:'local',
    emptyText:'请选择···', 
    store:mu_Store,
    triggerAction:'all',
   margin:'10 0 0 10' ,
	   listeners : { 
     	   select : function() {   
     	                           var wz_ke=Ext.getCmp("wz_ke");   
     	                          wz_ke.reset();  
     	                         var wz_shu=Ext.getCmp("wz_shu");   
      	                         wz_shu.reset();
      	                      shu_Store.removeAll();                   
     	                         ke_Store.load({
     	                            	  url: "getMuList.do",
     	                            	  params: { pid: this.value } 
     	                              });   	                             
     	                           }   
     	                      }
	});
var ke_Store=Ext.create('Ext.data.Store',{//目列表数据源
	autoLoad:false,
	model:'jieModel',
	proxy:{
		type:'ajax',
		url:'getKeList.do',
		render:{
			type:'json',
			root:'data'
			}
	}
	
});
var  kestore=Ext.create('Ext.form.ComboBox',{
	fieldLabel: '科',
	valueField: 'pkid',
	displayField: 'chname',
	id:'wz_ke',
	name:'wz_ke',				
	allowBlank:false, //不允许为空
blankText:'不可以空',
editable : false,
queryMode:'local',
emptyText:'请选择···', 
store:ke_Store,
triggerAction:'all',
margin:'10 0 0 10',
listeners : { 
  	   select : function() {   
  	                           var wz_shu=Ext.getCmp("wz_shu");   
  	                         wz_shu.reset();  	                    
  	                        shu_Store.load({
  	                            	  url: "getShuList.do",
  	                            	  params: { pid: this.value } 
  	                              });   	                             
  	                           }   
  	                      }
});
var shu_Store=Ext.create('Ext.data.Store',{//目列表数据源
	id:"shu_data",
	autoLoad:false,
	model:'jieModel',
	proxy:{
		type:'ajax',
		url:'getShuList.do',
		render:{
			type:'json',
			root:'data'
			}
	}
	
});
var  shustore=Ext.create('Ext.form.ComboBox',{
	fieldLabel: '属',
	valueField: 'pkid',
	displayField: 'chname',
	id:'wz_shu',
	name:'wz_shu',				
	allowBlank:false, //不允许为空
blankText:'不可以空',
editable : false,
queryMode:'local',
emptyText:'请选择···', 
store:shu_Store,
triggerAction:'all',
margin:'10 0 0 10'       
});
  
/*	autoLoad:true,
	proxy:{
		type:'ajax',
		url:'getJieList.do',
		render:{
			type:'json',
			root:'data'
			}*/
		var fp=Ext.create("Ext.form.Panel",{
    		id:'from',
    		width: 645,
    		height:710,
    		autoScroll:true,
    		method: 'POST',
    		layout:{
    			type:'vbox',
    			align:'stretch'
    		},
    		defaultType: 'textfield',
    		defaults: {
    	        // applied to each contained panel
    	    },
			items:[
			      {
			    	  xtype:'panel',
			    	  title:'基本信息',		    	 
			    	  layout:{
			    		  type:'table',
			    		  columns:2
			    	  },
			    	  items:[
			    	         {
			    	        	 xtype:'textfield',
			    	        	 id:'namech',
			    	        	 name:'namech',
			    	        	 fieldLabel:'中文名称',
			    	        	 margin:'10 0 0 10'
			    	        	
			    	         },
			    	         {
			    	        	 xtype:'textfield',
			    	        	 id:'nameen',
			    	        	 name:'nameen',
			    	        	 fieldLabel:'拉丁名称',
			    	        	 margin:'10 0 0 10'
			    	         }
			    	         ,
			    	         {
			    	        	 xtype:'textfield',
			    	        	 id:'cspcode',
			    	        	 name:'cspcode',
			    	        	 fieldLabel:'物种代码',
			    	        	 margin:'10 0 0 10'
			    	         },
			    	         jiestore,//界
			    	         menstore,//门
			    	         gangstore,//纲
			    	         mustore,//目
			    	         kestore,//科   
			    	         shustore//属 
			    	         ]
			      },{
			    	  
				    	  xtype:'panel',
				    	  title:'评估信息',				    	 
				    	  autoHeight  : false,//使用固定高度
				    	
				    	  layout:{
				    		  type:'table',
				    		  columns:2
				    	  },
				    	  items:[
								{
									 xtype:'textfield',
									 id:'iucn',
									 name:'iucn',
									 fieldLabel:'iucn濒危等级',
									 margin:'10 0 0 10'
								},
								{
									 xtype:'textfield',
									 id:'redlist',
									 name:'redlist',
									 fieldLabel:'中国物种红色名录等级',
									 margin:'10 0 0 10'
								},
								{
									 xtype:'textfield',
				    	        	 fieldLabel:'CITES附录等级',
				    	        	 name:'cites',
				    	        	 id:'cites',
				    	        	 editable: false,
				   		    	  	 disableKeyFilter:true,
				   		    	  	 hideTrigger :true,
				    	        	 margin:'10 0 0 10'
								},
								{
									 xtype:'textfield',
				    	        	 fieldLabel:'中国红皮书',
				    	        	 name:'redbook',
				    	        	 id:'redbook',
				    	        	 editable: false,
				   		    	  	 disableKeyFilter:true,
				   		    	  	 hideTrigger :true,
				    	        	 margin:'10 0 0 10'
								},
								{
									 xtype:'textfield',
				    	        	 fieldLabel:'国家重点物种等级',
				    	        	 name:'counlevel',
				    	        	 id:'counlevel',
				    	        	 editable: false,
				   		    	  	 disableKeyFilter:true,
				   		    	  	 hideTrigger :true,
				    	        	 margin:'10 0 0 10'
								},
								 {
				    	        	 xtype:'datefield',
				    	        	 fieldLabel:'评估日期',
				    	        	 name:'pingdate',
				    	        	 id:'pingdate',
				    	        	 editable: false,
				   		    	  	 disableKeyFilter:true,
				   		    	  	 hideTrigger :true,
				    	        	 margin:'10 0 0 10'
				    	         },
								{
									 xtype:'textfield',
									 id:'redpeople',
									 name:'redpeople',
									 fieldLabel:'评估人',
									 margin:'10 0 0 10'
								},
								{
									 xtype:'textfield',
									 id:'endmic',
									 name:'endmic',
									 fieldLabel:'是否中国特有',
									 margin:'10 0 0 10'
							    }
								,
								{
									 xtype:'textarea',
									 id:'spcremark',
									 name:'spcremark',
									 width:523,
									 fieldLabel:'描述',
									 colspan:2,
									 margin:'10 0 10 10'
								}	
								
				    	         ]
			      },{
			    	  xtype:'panel',
			    	  title:'生存范围',			    	
			    	  autoHeight  : false,//使用固定高度
			    
			    	  layout:{
			    		  type:'table',
			    		  columns:2
			    	  },
			    	  items:[
			    	         {
			    	        	 xtype:'textarea',
			    	        	 fieldLabel:'生存范围',
			    	        	 name:'rangeone',
			    	        	 id:'rangeone',
			    	        	 width:523,
			    	        	 colspan:2,
			    	        	 margin:'10 0 10 10'
			    	         },
			    	         {
			    	        	 xtype:'textarea',
			    	        	 fieldLabel:'形态',
			    	        	 name:'xingtai',
			    	        	 id:'xingtai',
			    	        	 width:523,
			    	        	 colspan:2,
			    	        	 margin:'10 0 10 10'
			    	         },
			    	         {
			    	        	 xtype:'textarea',
			    	        	 fieldLabel:'习性',
			    	        	 name:'xixing',
			    	        	 id:'xixing',
			    	        	 width:523,
			    	        	 colspan:2,
			    	        	 margin:'10 0 10 10'
			    	         }
			    	         ]
			      },{
			    	  xtype:'panel',
			    	  title:'生存坏境',
			    	
			    	  autoHeight  : false,//使用固定高度
			   
			    	  layout:{
			    		  type:'table',
			    		  columns:2
			    	  },
			    	  items:[
			    	         {
			    	        	 xtype:'textarea',
			    	        	 fieldLabel:'生存坏境',
			    	        	 name:'envrionment',
			    	        	 id:'envrionment',
			    	        	 width:523,
			    	        	 colspan:2,
			    	        	 margin:'10 0 0 10'
			    	         }
			    	         ]
			      },{
			    	  xtype:'panel',
			    	  title:'物种数量',
			    	 
			    	  autoHeight  : false,//使用固定高度
			    	
			    	  layout:{
			    		  type:'table',
			    		  columns:2
			    	  },
			    	  items:[
			    	         {
			    	        	 xtype:'textfield',
			    	        	 fieldLabel:'数量',
			    	        	 name:'num',
			    	        	 id:'num',
			    	        	 margin:'10 0 0 10'
			    	         },
			    	         {
			    	        	 xtype:'textfield',
			    	        	 fieldLabel:'数量趋势',
			    	        	 name:'numrange',
			    	        	 id:'numrange',
			    	        	 margin:'10 0 0 10'
			    	         }
			    	         ]
			      },
			      {
			    	  xtype:'panel',
			    	  title:'威胁来源',
			    	 
			    	  autoHeight  : false,//使用固定高度
			    	 
			    	  layout:{
			    		  type:'table',
			    		  columns:2
			    	  },
			    	  items:[
			    	         {
			    	        	 xtype:'textarea',
			    	        	 fieldLabel:'威胁来源',
			    	        	 name:'danger',
			    	        	 id:'danger',
			    	        	 width:523,
			    	        	 colspan:2,
			    	        	 margin:'10 0 10 10'
			    	         }
			    	         ]
			      },{
			    	  xtype:'panel',
			    	  title:'保护行动',
			    	  
			    	  autoHeight  : false,//使用固定高度
			    
			    	  layout:{
			    		  type:'table',
			    		  columns:2
			    	  },
			    	  items:[
			    	         {
			    	        	 xtype:'textarea',
			    	        	 fieldLabel:'保护行动',
			    	        	 name:'protect',
			    	        	 id:'protect',
			    	        	 width:523,
			    	        	 colspan:2,
			    	        	 margin:'10 0 10 10'
			    	         }
			    	         ]
			      },
			      {
			    	  xtype:'panel',
			    	  title:'其他',
			    	
			    	  autoHeight  : true,//使用固定高度
			    	  
			    	  layout:{
			    		  type:'table',
			    		  columns:2
			    	  },
			    	  items:[
			    	         {
			    	        	 xtype:'textfield',
			    	        	 fieldLabel:'引用',
			    	        	 name:'yinyong',
			    	        	 id:'yinyong',
			    	        	 margin:'10 0 0 10'
			    	         }
			    	         ]
			      }
			      
			       ]
		});
		var panel_button=Ext.create("Ext.panel.Panel",{
			id:'wztj_tjcz',
    		width: 645,
    		height:55,
    		frame:true,
    		layout:{
    			type:'hbox',
    			pack:'center',
    			align:'middle'
    		},
    		items:[ {
	        	
	            	xtype: 'button',
					id:'wztj_tj',
					text:'添加',
					handler: function () {
						var form= Ext.getCmp('from').getForm();
						//基本信息
						var cspcode = Ext.getCmp('cspcode').getValue();
				    	var shuid = Ext.getCmp('wz_shu').getValue();
				    	var namech = Ext.getCmp('namech').getValue();
				    	var nameen = Ext.getCmp('nameen').getValue();
				    	//评估等级
				    	var iucn = Ext.getCmp('iucn').getValue();
				    	var redlist = Ext.getCmp('redlist').getValue();
				    	var cites = Ext.getCmp('cites').getValue();
				    	var redbook = Ext.getCmp('redbook').getValue();
				    	var counlevel = Ext.getCmp('counlevel').getValue();
				    	var redpeople = Ext.getCmp('redpeople').getValue();
				    	var pingdate = Ext.getCmp('pingdate').getValue();
				    	var spcremark = Ext.getCmp('spcremark').getValue();
				    	var endmic = Ext.getCmp('endmic').getValue();
				    	//生存范围
				    	var rangeone = Ext.getCmp('rangeone').getValue();
				    	var xingtai = Ext.getCmp('xingtai').getValue();
				    	var xixing = Ext.getCmp('xixing').getValue();
				    	//生存环境
				    	var envrionment = Ext.getCmp('envrionment').getValue();
				    	//物种数量
				    	var num = Ext.getCmp('num').getValue();
				    	var numrange = Ext.getCmp('numrange').getValue();
				    	//威胁来源
				    	var danger = Ext.getCmp('danger').getValue();
				    	//保护行动
				    	var protect = Ext.getCmp('protect').getValue();
				    	//其他
				    	var yinyong = Ext.getCmp('yinyong').getValue();
				    	
				    	Ext.Ajax.request({
			    			url:'addSpecies.do',
			    			params:{	
			    				cspcode:cspcode,
			    				shuid:shuid,
			    				namech:namech,
			    				nameen:nameen,
			    				iucn:iucn,
			    				redlist:redlist,
			    				cites:cites,
			    				redbook:redbook,
			    				counlevel:counlevel,
			    				redpeople:redpeople,
			    				pingdate:pingdate,
			    				redlist:redlist,
			    				spcremark:spcremark,
			    				endmic:endmic,
			    				rangeone:rangeone,
			    				xingtai:xingtai,
			    				xixing:xixing,
			    				envrionment:envrionment,
			    				num:num,
			    				numrange:numrange,
			    				danger:danger,
			    				protect:protect,
			    				yinyong:yinyong
			    			},
			    			method:'POST',
			    			success:function(response){
			                    var re = response.responseText;
			                    if(re== '1'){
			                       Ext.MessageBox.alert('提示','保存数据成功！');
			                       me.destroy();
			                    }else if(re=='0'){
			                    	Ext.Msg.alert('提示', "添加数据失败");
			    					return false;
			                    }else{
			                       Ext.MessageBox.alert('警告','保存数据失败');
			                    }
								}
			    		});
					}
	            },
	            {
	            	xtype: 'button',
					id:'wztj_cg',
					text:'重置',
					margin:'0 20 0 20',
					handler: function () {
						 Ext.getCmp('from').getForm().reset();
					}
	            }
	            ]
		})
		me.items=[fp,panel_button];
		me.callParent(arguments);
	}
});

