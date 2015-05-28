Ext.define('AM.view.province', {
			extend : 'Ext.form.ComboBox',
			alias : 'widget.province',
			queryMode : 'local',
			id:'province1',
			layout:'anchor',
			matchFieldWidth:false,
			anchor:'100%',
			displayField : 'name',
			valueField : 'id',
			editable : false,
			store : 'provinceStore'
		});