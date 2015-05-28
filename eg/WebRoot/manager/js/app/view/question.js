//密保问题下拉框
Ext.define('AM.view.question', {
			extend : 'Ext.form.ComboBox',
			alias : 'widget.question',
			queryMode : 'local',
			maxWidth:180,
			displayField : 'name',
			valueField : 'id',
			editable : false,
			matchFieldWidth : false,
			anchor : '100%',
			value : 0,
			store : 'questionStore'
		});