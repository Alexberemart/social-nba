angular.module('myApp', [ 'ui.router', 'app.Controllers', 'app.Factory'])

    .config(['$stateProvider', function ($stateProvider) {

        $stateProvider
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
            .state('dashboard.main', {
                url: '/main',
                views: {
                    dashboardContent: {
                        templateUrl: 'app/main/main.html',
                        controller: 'main'
                    }
                }
            })
            .state('dashboard.twitter', {
                url: '/twitter',
                views: {
                    dashboardContent: {
                        templateUrl: 'app/twitter/twitter.html',
                        controller: 'twitter'
                    }
                }
            })
    }])

    .config(['$urlRouterProvider', '$httpProvider', function ($urlRouterProvider) {
        $urlRouterProvider.otherwise('/dashboard/main');
    }]);