/*
 * 商品实体类
 */
Ext.define("core.product.model.ProductModel", {
			extend : "Ext.data.Model",
			fields : [{
						name : "proid",
						type : "int",
						srotable : true
					}, {
						name : "accid",
						type : "string",
						srotable : true
					}, {
						name : "proname",
						type : "string",
						srotable : true
					}, {
						name : "promodel",
						type : "string",
						srotable : true
					}, {
						name : "protype",
						type : "string",
						srotable : true
					}, {
						name : "proprice",
						type : "float",
						srotable : true
					}, {
						name : "proquantity",
						type : "int",
						srotable : true
					}, {
						name : "prosource",
						type : "string",
						srotable : true
					}, {
						name : "proeditor",
						type : "string",
						srotable : true
					}, {
						name : "procreatetime",
						type : "string",
						srotable : true,
						renderer : function(val) {
							return Ext.Date.format(val, 'Y-m-d H:i');
						}
					}, {
						name : "proedittime",
						type : "string",
						srotable : true,
						renderer : function(val) {
							return Ext.Date.format(val, 'Y-m-d H:i');
						}
					}, {
						name : "proremark",
						type : "string",
						srotable : true
					}]
		});