Ext.define('AM.store.countryStore', {
			extend : 'Ext.data.Store',
			alias : 'widget.countryStore',
			fields : ['id', 'name'],
			/*
				"波兰", "西班牙", "意大利", "俄罗斯", 
				"荷兰", "美国", "加拿大", "巴西", 
				"阿根廷", "新西兰", "澳大利亚", 
				"印度", "埃及"]);
			 * */
			data : [{
						id : '无',
						name : '请选择'
					}, {
						id : '中国',
						name : '中国'
					}, {
						id : '韩国',
						name : '韩国'
					}, {
						id : '日本',
						name : '日本'
					}, {
						id : '新加坡',
						name : '新加坡'
					}, {
						id : '德国',
						name : '德国'
					}, {
						id : '英国',
						name : '英国'
					}, {
						id : '法国',
						name : '法国'
					}, {
						id : '美国',
						name : '美国'
					}, {
						id : '加拿大',
						name : '加拿大'
					}, {
						id : '新西兰',
						name : '新西兰'
					}, {
						id : '澳大利亚',
						name : '澳大利亚'
					}]
		});