
Ext.define('AM.store.treeMenuStore',{
	extend:'Ext.data.TreeStore',
	proxy:{
		type:'ajax',
		url:'js/app/data/treejson.jsp',
		reader:{
			type:'json'
		},
		autoLoad:true
	}
});