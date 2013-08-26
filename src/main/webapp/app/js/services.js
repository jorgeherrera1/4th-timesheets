'use strict';

timesheetsApp.factory('loginService', ['$http', function($http) {
    return {
        login: function(username, password) {
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
            }).success(function(data, status, headers, config) {
                $rootScope.resource = data;
                $http.defaults.headers.common['Auth-Token'] = data.token;
                $location.path("/timesheet");
            }).error(function(data, status, headers, config) {
                console.log('error');
            });
        }
    };
}]);