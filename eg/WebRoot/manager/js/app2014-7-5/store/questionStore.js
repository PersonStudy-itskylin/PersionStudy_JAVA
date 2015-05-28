Ext.define('AM.store.questionStore', {
			extend : 'Ext.data.Store',
			alias : 'widget.questionStore',
			fields : ['id', 'name'],
			data : [{
						id : 0,
						name : '--请选择问题--'
					}, {
						id : 1,
						name : '您父亲的姓名是？'
					}, {
						id : 2,
						name : '您母亲的姓名是？'
					}, {
						id : 3,
						name : '您配偶的姓名是？'
					}, {
						id : 4,
						name : '您的出生地是？'
					}, {
						id : 5,
						name : '您高中班主任的名字是？'
					}, {
						id : 6,
						name : '您初中班主任的名字是？'
					}, {
						id : 7,
						name : '您小学班主任的名字是？'
					}, {
						id : 8,
						name : '您的小学校名是？'
					}, {
						id : 9,
						name : '您的学号（或工号）是？'
					}, {
						id : 10,
						name : '您父亲的生日是？'
					}, {
						id : 11,
						name : '您母亲的生日是？'
					}, {
						id : 12,
						name : '您配偶的生日是？'
					}]
		});