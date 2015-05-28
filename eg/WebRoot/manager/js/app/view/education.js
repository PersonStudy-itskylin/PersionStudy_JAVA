Ext.define('AM.view.education', {
			extend : 'Ext.form.ComboBox',
			alias : 'widget.education',
			queryMode : 'local',
			displayField : 'name',
			valueField : 'id',
			matchFieldWidth:false,
			anchor:'100%',
			editable : false,
			store : 'educationStore'
		});