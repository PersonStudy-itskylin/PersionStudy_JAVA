//国家下拉菜单
Ext.define('AM.view.country', {
			extend : 'Ext.form.ComboBox',
			alias : 'widget.country',
			queryMode : 'local',
			id:'country1',
			displayField : 'name',
			valueField : 'id',
			matchFieldWidth:false,
			anchor:'100%',
			editable : false,
			store : 'countryStore'
		});