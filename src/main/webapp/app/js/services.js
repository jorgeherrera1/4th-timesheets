'use strict';

timesheetsApp.factory('loginService', ['$http', function($http) {
    return {
        login: function(username, password, successCallback) {
            $http({
                method: 'POST',
                url: '/resource/login',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                data: $.param({
                    'username': username,
                    'password': password
                })
            }).success(successCallback).error(function(data, status, headers, config) {
                console.log('error');
            });
        }
    };
}]);