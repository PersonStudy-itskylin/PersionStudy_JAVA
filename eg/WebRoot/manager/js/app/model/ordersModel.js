Ext.define('AM.model.ordersModel', {
    extend: 'Ext.data.Model',
	fields: [
		{name:'id',type:'int',sortable:true},
        {name: 'employess_id',  type: 'int',sortable : true},
		{name: 'customer_id',  type: 'int',sortable : true},
		{name: 'orderDate',  type: 'Date',sortable : true},
	    {name: 'shippedDate',   type: 'Date',sortable : true},
	    {name: 'shipped_id',   type: 'String',sortable : true},
	    {name: 'shipCountry',   type: 'String',sortable : true},
	    {name: 'shipProvince',   type: 'String',sortable : true},
	    {name: 'shipCity',   type: 'String',sortable : true},
	    {name: 'shipAddress',   type: 'String',sortable : true},
	    {name: 'shipZip',   type: 'String',sortable : true},
	    {name: 'shippingfee',   type: 'double',sortable : true},
	    {name: 'paymentTypes',   type: 'String',sortable : true},
	    {name: 'paidDate',   type: 'datetime',sortable : true},
	    {name: 'orderStatus_id',   type: 'int',sortable : true,convert:function(val){
                if(val == 1){
                    return '<span style="color:#f00;">未处理</span>';
                } else if(val == 2){
                    return '<span style="color:#ff0;">处理中...</span>';
                } else if(val == 3){
                    return '<span style="color:#00f;">订单完成</span>';
                } else if(val == 4){
                    return '<span style="color:#0ff;">已退款</span>';
                } else {
                    return '<span style="color:#000;">订单关闭</span>';
                }
            }
        },
	    {name: 'creator',   type: 'String',sortable : true},
	    {name: 'editor',   type: 'String',sortable : true},
	    {name: 'createtime',   type: 'String',sortable : true},
        {name: 'updatetime',   type: 'String',sortable : true},
        {name: 'remark',   type: 'String',sortable : true}
	]
});