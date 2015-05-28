Ext.define('AM.store.marriedStore', {
			extend : 'Ext.data.Store',
			alias : 'widget.marriedStore',
			fields : ['id', 'name'],
			data : [{
						id : 0,
						name : '--请选择--'
					}, {
						id : 1,
						name : '未婚'
					}, {
						id : 2,
						name : '已婚'
					}, {
						id : 3,
						name : '离异'
					}, {
						id : 4,
						name : '其他'
					}]
		});