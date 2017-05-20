'use strict';
(function () {
    var NoteController = function ($scope, $http, $location) {
        $scope.publicNotes = [],
        $scope.principalNotes = [],
        $scope.note = {
            public : true,
        },
        $scope.error = false;

        $scope.loadPublicNotes = function() {
            $http({
                method : 'GET',
                url : '/note/findAllPublic'
            }).success(function(response) {
                $scope.publicNotes = response;
                $scope.error = false;
            }).error(function (response) {
                $scope.error = true;
            });
        }

        $scope.loadPrincipalNotes = function() {
            $http({
                method : 'GET',
                url : '/note/user/findByPrincipal'
            }).success(function(response) {
                $scope.principalNotes = response;
                $scope.error = false;
            }).error(function (response) {
                $scope.error = true;
            });
        }

        $scope.saveNote = function() {
            $http({
                method : 'POST',
                url : '/note/user/save',
                data : $scope.note,
                headers : {
                    'Content-type' : 'application/json;charset=utf-8'
                }
            }).success(function(response) {
                $scope.error = false;
                $location.path('/note/user');
            }).error(function(response) {
                $scope.error = true;
            });
        }
    };

    angularApp.controllers.controller('NoteController', ['$scope', '$http', '$location', 'AuthService', NoteController]);
})();