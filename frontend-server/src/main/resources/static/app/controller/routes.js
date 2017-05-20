'use strict';
(function() {
    angularApp.controllers.config([ '$routeProvider', function($routeProvider) {
        $routeProvider.when('/', {
            controller : 'NoteController',
            templateUrl : '/app/view/note/public.html'
        }).when('/note/user/list', {
            controller : 'NoteController',
            templateUrl : '/app/view/note/principal.html'
        }).when('/note/user/create', {
            controller : 'NoteController',
            templateUrl : '/app/view/note/create.html'
        }).when('/login', {
            controller : 'LoginController',
            templateUrl : '/app/view/login/login.html'
        }).when('/apiDoc', {
            templateUrl: 'app/view/api/api.html',
            controller: 'ApiDocController'
        }).otherwise('/');
    } ]);
})();