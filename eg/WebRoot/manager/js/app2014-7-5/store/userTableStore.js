
//user table store
Ext.define('AM.store.userTableStore',{
	extend:'Ext.data.Store',
	model:'AM.model.userTableModel',
	id:'userstore',
	proxy:{
		type:'ajax',
		pageSize:10,
		url:'js/app/data/usertablejson.jsp',
		reader:{
			type:'json',
			totalProperty:'totalProperty',
			root:'columns'
		}
	},
	autoLoad:true
});

