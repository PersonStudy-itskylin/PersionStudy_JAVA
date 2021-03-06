/*
 * 商品实体类
 */
Ext.define("core.history.model.HistoryModel", {
			extend : "Ext.data.Model",
			fields : [{
						name : "pioid",
						type : "int",
						srotable : true
					}, {
						name : "proid",
						type : "int",
						srotable : true
					}, {
						name : "accid",
						type : "string",
						srotable : true
					}, {
						name : "pioquantity",
						type : "string",
						srotable : true
					}, {
						name : "piocount",
						type : "string",
						srotable : true
					}, {
						name : "piotype",
						type : "string",
						srotable : true
					}, {
						name : "piooperation",
						type : "string",
						srotable : true
					}, {
						name : "piooperationnum",
						type : "int",
						srotable : true
					}, {
						name : "pioagreementid",
						type : "string",
						srotable : true
					}, {
						name : "pioprojectid",
						type : "string",
						srotable : true
					}, {
						name : "pioprojectname",
						type : "string",
						srotable : true
					}, {
						name : "piouttime",
						type : "string",
						srotable : true
					}, {
						name : "piointime",
						type : "string",
						srotable : true
					}, {
						name : "piosign",
						type : "string",
						srotable : true
					}, {
						name : "pioapply",
						type : "string",
						srotable : true
					}, {
						name : "piodelivery",
						type : "string",
						srotable : true
					}, {
						name : "pioremark",
						type : "string",
						srotable : true
					}/*
						 * , {name:"pioadminsign",type:"string",srotable:true}
						 */
			]
		});