Ext.define('AM.model.userTableModel', {
    extend: 'Ext.data.Model',
	fields: [
		{name:'userId',type:'int',sortable:true},
        {name: 'loginName',  type: 'String',sortable : true},
		{name: 'userName',  type: 'String',sortable : true},
		{name: 'userPwd',  type: 'String',sortable : true},
	    {name: 'userSex',   type: 'int',sortable : true,convert:function(val){
                if(val == '1'){
                    return "男";
                } else if(val == '2'){
                    return "女";
                } else {
                    return "不男不女";
                }
            }
        },
	    {name: 'birthdate',   type: 'String',sortable : true},
	    {name: 'photo',   type: 'String',sortable : true},
	    {name: 'contry',   type: 'String',sortable : true},
	    {name: 'province',   type: 'String',sortable : true},
	    {name: 'city',   type: 'String',sortable : true},
	    {name: 'address',   type: 'String',sortable : true},
	    {name: 'tel',   type: 'String',sortable : true},
	    {name: 'email',   type: 'String',sortable : true},
	    {name: 'qq',   type: 'String',sortable : true},
	    {name: 'pwdQuestion1',   type: 'String',sortable : true},
	    {name: 'pwdAnser1',   type: 'String',sortable : true},
	    {name: 'pwdQuestion2',   type: 'String',sortable : true},
	    {name: 'pwdAnser2',   type: 'String',sortable : true},
	    {name: 'pwdQuestion3',   type: 'String',sortable : true},
	    {name: 'pwdAnser3',   type: 'String',sortable : true},
	    {name: 'married',   type: 'int',sortable :true, trueconvert:function(val){
                if(val == '1'){
                    return "未婚";
                } else if(val == '2'){
                    return "已婚";
                } else if(val == '3'){
                    return "离异";
                }else{
                	return "无";
                }
            }
        },
	    {name: 'like',   type: 'String',sortable : true},
	    {name: 'decription',   type: 'String',sortable : true},
	    {name: 'ethnic',   type: 'String',sortable : true},
	    {name: 'education',   type: 'String',sortable : true},
	    {name: 'job',   type: 'String',sortable : true},
	    {name: 'party',   type: 'String',sortable : true},
	    {name: 'creator',   type: 'String',sortable : true},
	    {name: 'editor',   type: 'String',sortable : true},
	    {name: 'createTime',   type: 'Date',sortable : true},
        {name: 'updateTime',   type: 'Timestamp',sortable : true},
        {name: 'remark',   type: 'String',sortable : true}
	]
});