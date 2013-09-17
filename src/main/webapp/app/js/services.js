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
        timesheetForWeekEnding: function(weekEnding, successCallback) {
            var timesheet = {
                weekEnding: '9/21/2013',
                totalTime: 1,
                totalOvertime: 0
            };

            successCallback(timesheet);
        }
    };
}]);

timesheetsApp.factory('timesheetLoader', ['$route', '$q', 'timesheetService',
function($route, $q, timesheetService) {
    return function() {
        var year = $route.current.params.year,
            month = $route.current.params.month,
            day = $route.current.params.day,
            weekEnding = new Date(year, month, day);

        var delay = $q.defer();

        var successCallback = function(timesheet) {
            delay.resolve(timesheet);
        };

        timesheetService.timesheetForWeekEnding(weekEnding, successCallback);

        return delay.promise;
    };
}]);