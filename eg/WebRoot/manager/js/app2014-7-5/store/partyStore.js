Ext.define('AM.store.partyStore', {
			extend : 'Ext.data.Store',
			alias : 'widget.partyStore',
			fields : ['id', 'name'],
			data : [{
						id : '群众',
						name : '群众'
					}, {
						id : '团员',
						name : '团员'
					}, {
						id : '预备党员',
						name : '预备党员'
					}, {
						id : '党员',
						name : '党员'
					}, {
						id : '其他',
						name : '其他'
					}]
		});