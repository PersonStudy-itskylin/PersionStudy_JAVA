//国家下拉菜单
Ext.define('AM.view.ethnic', {
			extend : 'Ext.form.ComboBox',
			alias : 'widget.ethnic',
			queryMode : 'local',
			displayField : 'name',
			matchFieldWidth:false,
			anchor:'100%',
			valueField : 'id',
			editable : false,
			store : 'ethnicStore'
		});