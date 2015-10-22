angular.module('myApp', [ 'ui.router'])

    .config(['$stateProvider', function ($stateProvider) {

        $stateProvider
            .state('login', {
                url: '/login',
                views: {
                    content: {
                        templateUrl: 'app/Login/index1.html',
                        controller: 'index2'
                    }
                }
            })
            .state('dashboard', {
                url: '/dashboard',
                abstract: true,   //marca este estado como no navegable.
                views: {
                    head: {
                        templateUrl: 'app/components/head_menu/head_menu.html',
                        controller: 'head_menu'
                    },
                    content: {
                        template: '<div ui-view="dashboardContent"></div>'
                    }
                }
            })
    }]);