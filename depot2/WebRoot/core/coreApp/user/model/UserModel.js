/*
 * 用户实体类
 */
Ext.define("core.user.model.UserModel", {
			extend : "Ext.data.Model",
			fields : [{
						name : "id",
						type : "int",
						srotable : true
					}, {
						name : "username",
						type : "string",
						srotable : true
					}, {
						name : "password",
						type : "string",
						srotable : true
					}, {
						name : "realname",
						type : "string",
						srotable : true
					}, {
						name : "description",
						type : "string",
						srotable : true
					}, {
						name : "role",
						type : "int",
						srotable : true,
						convert : function(val) {
							if (val == 0) {
								return '系统管理员';
							} else if (val == 1) {
								return '入库员';
							} else if (val == 2) {
								return '出库员';
							} else {
								return '错误';
							}
						}
					}, {
						name : "phone",
						type : "long",
						srotable : true
					}, {
						name : "tel",
						type : "string",
						srotable : true
					}, {
						name : "qq",
						type : "long",
						srotable : true
					}, {
						name : "email",
						type : "string",
						srotable : true
					}, {
						name : "state",
						type : "int",
						srotable : true,
						convert : function(val) {
							if (val == 0) {
								return '正常';
							} else if (val == 1) {
								return '锁定';
							} else if (val == 2) {
								return '欠费';
							} else {
								return '错误';
							}
						}

					}, {
						name : "ip",
						type : "string",
						srotable : true
					}, {
						name : "createtime",
						type : "string",
						srotable : true,
						renderer : function(val) {
							return Ext.Date.format(val, 'Y-m-d H:i');
						}
					}, {
						name : "updatetime",
						type : "string",
						srotable : true,
						renderer : function(val) {
							return Ext.Date.format(val,"Y-m-d H:i");
						}
					}, {
						name : "remark",
						type : "string",
						srotable : true
					}]
		});