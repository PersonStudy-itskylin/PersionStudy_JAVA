Ext.define('AM.store.educationStore', {
			extend : 'Ext.data.Store',
			alias : 'widget.educationStore',
			fields : ['id', 'name'],
			data : [{
						id : '无',
						name : '--请选择--'
					}, {
						id : '小学',
						name : '小学或以下'
					}, {
						id : '初中',
						name : '初中'
					}, {
						id : '高中',
						name : '高中'
					}, {
						id : '大专',
						name : '大专'
					}, {
						id : '本科',
						name : '本科'
					}, {
						id : '硕士研究生',
						name : '硕士研究生'
					}, {
						id : '博士研究生或以上',
						name : '博士研究生或以上'
					}]
		});