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

timesheetsApp.factory('timesheetService', ['$http',
function($http) {
    return {
        timesheetForWeekEnding: function(year, month, day, successCallback) {
            $http.get('/timesheet/' + year + '/' + month + '/' + day)
                .success(successCallback);
        }
    };
}]);

timesheetsApp.factory('timesheetLoader', ['$route', '$q', 'timesheetService',
function($route, $q, timesheetService) {
    return function() {
        var year = $route.current.params.year,
            month = $route.current.params.month,
            day = $route.current.params.day;

        var delay = $q.defer();

        var successCallback = function(timesheet) {
            delay.resolve(timesheet);
        };

        timesheetService.timesheetForWeekEnding(year, month, day, successCallback);

        return delay.promise;
    };
}]);