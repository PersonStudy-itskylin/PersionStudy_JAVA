Ext.define('AM.view.married', {
			extend : 'Ext.form.ComboBox',
			alias : 'widget.married',
			queryMode : 'local',
			displayField : 'name',
			valueField : 'id',
			matchFieldWidth:false,
			editable : false,
			anchor:'100%',
			value : 0,
			store : 'marriedStore'
		});