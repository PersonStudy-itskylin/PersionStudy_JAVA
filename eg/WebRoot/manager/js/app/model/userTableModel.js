Ext.define('AM.model.userTableModel', {
    extend: 'Ext.data.Model',
	fields: [
		{name:'user_id',type:'int',sortable:true},
        {name: 'loginname',  type: 'String',sortable : true},
		{name: 'user_name',  type: 'String',sortable : true},
		{name: 'pwd',  type: 'String',sortable : true},
	    {name: 'sex',   type: 'int',sortable : true,convert:function(val){
                if(val == 1){
                    return '<span style="color:#00f;">男</span>';
                } else if(val == 2){
                    return '<span style="color:#f00;">女</span>';
                } else {
                    return '无';
                }
            }
        },
	    {name: 'birthdate',   type: 'String',sortable : true},
	    {name: 'photo',   type: 'String',sortable : true},
	    {name: 'country',   type: 'String',sortable : true},
	    {name: 'province',   type: 'String',sortable : true},
	    {name: 'city',   type: 'String',sortable : true},
	    {name: 'address',   type: 'String',sortable : true},
	    {name: 'tel',   type: 'String',sortable : true},
	    {name: 'email',   type: 'String',sortable : true},
	    {name: 'qq',   type: 'String',sortable : true},
	    {name: 'pwd_question1', type: 'int',sortable : true,convert:function(val){
                if(val == '1'){
                    return '您父亲的姓名是？';
                } else if(val == '2'){
                    return '您母亲的姓名是？';
                } else if(val == '3'){
                    return '您配偶的姓名是？';
                } else if(val == '4'){
                    return '您的出生地是？';
                } else if(val == '5'){
                    return '您高中班主任的名字是？';
                } else if(val == '6'){
                    return '您高中班主任的名字是？';
                } else if(val == '7'){
                    return '您初中班主任的名字是？';
                } else if(val == '8'){
                    return '您小学班主任的名字是？';
                } else if(val == '9'){
                    return '您的小学校名是？';
                } else if(val == '10'){
                    return '您的学号（或工号）是？';
                } else if(val == '11'){
                    return '您母亲的生日是？';
                } else if(val == '12'){
                    return '您配偶的生日是？';
                } else {
                    return "无";
                }
            }
        },
	    {name: 'pwd_anser1',   type: 'String',sortable : true},
	    {name: 'pwd_question2', type: 'int',sortable : true,convert:function(val){
                if(val == '1'){
                    return '您父亲的姓名是？';
                } else if(val == '2'){
                    return '您母亲的姓名是？';
                } else if(val == '3'){
                    return '您配偶的姓名是？';
                } else if(val == '4'){
                    return '您的出生地是？';
                } else if(val == '5'){
                    return '您高中班主任的名字是？';
                } else if(val == '6'){
                    return '您高中班主任的名字是？';
                } else if(val == '7'){
                    return '您初中班主任的名字是？';
                } else if(val == '8'){
                    return '您小学班主任的名字是？';
                } else if(val == '9'){
                    return '您的小学校名是？';
                } else if(val == '10'){
                    return '您的学号（或工号）是？';
                } else if(val == '11'){
                    return '您母亲的生日是？';
                } else if(val == '12'){
                    return '您配偶的生日是？';
                } else {
                    return "无";
                }
            }
        },
	    {name: 'pwd_anser2',   type: 'String',sortable : true},
	    {name: 'pwd_question3', type: 'int',sortable : true,convert:function(val){
                if(val == '1'){
                    return '您父亲的姓名是？';
                } else if(val == '2'){
                    return '您母亲的姓名是？';
                } else if(val == '3'){
                    return '您配偶的姓名是？';
                } else if(val == '4'){
                    return '您的出生地是？';
                } else if(val == '5'){
                    return '您高中班主任的名字是？';
                } else if(val == '6'){
                    return '您初中班主任的名字是？';
                } else if(val == '7'){
                    return '您小学班主任的名字是？';
                } else if(val == '8'){
                    return '您的小学校名是？';
                } else if(val == '9'){
                    return '您的学号（或工号）是？';
                } else if(val == '10'){
                    return '您父亲的生日是？';
                } else if(val == '11'){
                    return '您母亲的生日是？';
                } else if(val == '12'){
                    return '您配偶的生日是？';
                } else {
                    return '无';
                }
            }
        },
	    {name: 'pwd_anser3',   type: 'String',sortable : true},
	    {name: 'married',   type: 'int',sortable :true,convert:function(val){
               	if(val == 1){
                    return '<span style="color:#0f0;">未婚</span>';
                } else if(val == 2){
                    return '<span style="color:#f0f;">已婚</span>';
                } else if(val == 3){
                    return '<span style="color:#00f;">离异</span>';
                } else if(val == 4){
                    return '<span style="color:#f00;">其他</span>';
                }else{
                	return '无';
                }
	    	}
        },
	    {name: 'like',   type: 'String',sortable : true},
	    {name: 'description',   type: 'String',sortable : true},
	    {name: 'ethnic',   type: 'String',sortable : true},
	    {name: 'education',   type: 'String',sortable : true},
	    {name: 'job',   type: 'String',sortable : true},
	    {name: 'party',   type: 'String',sortable : true},
	    {name: 'ipaddress',   type: 'String',sortable : true},
	    {name: 'creator',   type: 'String',sortable : true},
	    {name: 'editor',   type: 'String',sortable : true},
	    {name: 'createTime',   type: 'Timestamp',sortable : true},
        {name: 'updateTime',   type: 'Timestamp',sortable : true},
        {name: 'remark',   type: 'String',sortable : true}
	]
});