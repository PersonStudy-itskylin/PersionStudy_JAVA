Ext.define('AM.view.city', {
			extend : 'Ext.form.ComboBox',
			alias : 'widget.city',
			queryMode : 'local',
			layout:'anchor',
			matchFieldWidth:false,
			anchor:'100%',
			displayField : 'name',
			valueField : 'id',
			editable : false,
			store : 'cityStore'
		});