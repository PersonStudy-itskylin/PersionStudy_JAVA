Ext.define('AM.view.party', {
			extend : 'Ext.form.ComboBox',
			alias : 'widget.party',
			queryMode : 'local',
			layout:'anchor',
			matchFieldWidth:false,
			anchor:'100%',
			displayField : 'name',
			valueField : 'id',
			editable : false,
			value:'群众',
			store : 'partyStore'
		});