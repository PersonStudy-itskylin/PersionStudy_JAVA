Ext.Loader.setConfig({
    enabled: true
});
Ext.application({
    name: 'AM',
    paths: {
        'AM': 'js/app'
    },
    autoCreateViewport: true,
    
    controllers: [
        'MainController',
        'treeMenuController',
        'userTableController',
        'productsController'
    ],
    
    launch: function() {
        Ext.tip.QuickTipManager.init();
    }
});