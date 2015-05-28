Ext.define('AM.model.productsModel', {
    extend: 'Ext.data.Model',
	fields: [
		{name:'id',type:'int',sortable:true},
        {name: 'productCode',  type: 'String',sortable : true},
		{name: 'productName',  type: 'String',sortable : true},
		{name: 'productPhoto',  type: 'String',sortable : true},
	    {name: 'desctiption',   type: 'String',sortable : true},
	    {name: 'purchasingPrice',   type: 'String',sortable : true},
	    {name: 'sellingPrice',   type: 'String',sortable : true},
	    {name: 'quantity',   type: 'String',sortable : true},
	    {name: 'category',   type: 'String',sortable : true},
	    {name: 'attachments',   type: 'String',sortable : true},
	    {name: 'creator',   type: 'String',sortable : true},
	    {name: 'editor',   type: 'String',sortable : true},
	    {name: 'createTime',   type: 'String',sortable : true},
        {name: 'updateTime',   type: 'Timestamp',sortable : true},
        {name: 'remark',   type: 'String',sortable : true}
	]
});