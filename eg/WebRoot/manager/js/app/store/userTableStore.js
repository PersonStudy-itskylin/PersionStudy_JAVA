
//user table store
Ext.define('AM.store.userTableStore',{
	extend:'Ext.data.Store',
	model:'AM.model.userTableModel',
	//id:'userstore',
	pageSize:5,
	proxy:{
		type:'ajax',
		url:'js/app/data/usertablejson.jsp',
		waitMsg:'数据读取中，请稍后...',
		reader:{
			type:'json',
			totalProperty:'totalProperty',
			root:'columns'
		}
	},
	autoLoad:true
});

