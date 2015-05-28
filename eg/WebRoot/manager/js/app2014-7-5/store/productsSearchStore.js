

Ext.define('AM.store.productsSearchStore',{
	extend:'Ext.data.Store',
	fields:['id','name'],
	data:[
		{id:'userId',name:'产品ID'},
		{id:'productCode',name:'产品代码'},
		{id:'productName',name:'产品名称'},
		{id:'productPhoto',name:'产品照片'},
		{id:'desctiption',name:'描述'},
		{id:'purchasingPrice',name:'进价'},
		{id:'sellingPrice',name:'售价'},
		{id:'quantity',name:'库存'},
		{id:'category',name:'产品类别'},
		{id:'creator',name:'创建者'},
		{id:'editor',name:'编辑者'},
		{id:'createTime',name:'注册时间'},
		{id:'editeTime',name:'修改时间'},
		{id:'remark',name:'备注'}
	]
});