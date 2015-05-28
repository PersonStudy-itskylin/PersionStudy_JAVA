
//user table store
Ext.define('AM.store.productsStore',{
	extend:'Ext.data.Store',
	model:'AM.model.productsModel',
	id:'productsstore',
	proxy:{
		type:'ajax',
		method:'post',
		url:'js/app/data/productsjson.jsp',
		reader:{
			type:'json',
			totalProperty:'totalProperty',
			root:'columns'
		}
	},
	autoLoad:true
});

