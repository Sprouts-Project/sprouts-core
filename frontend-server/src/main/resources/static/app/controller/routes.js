'use strict';
(function() {
    angularApp.controllers.config([ '$routeProvider', function($routeProvider) {
        $routeProvider.when('/', {
            controller : 'WelcomeController',
            templateUrl : '/app/view/welcome/welcome.html'
        }).when('/login', {
            controller : 'LoginController',
            templateUrl : '/app/view/login/login.html'
        }).when('/apiDoc', {
            templateUrl: 'app/view/api/api.html',
            controller: 'ApiDocController'
        }).otherwise('/');
    } ]);
})();