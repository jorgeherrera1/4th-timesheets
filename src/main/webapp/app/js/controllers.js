'use strict';

timesheetsApp.controller('appCtrl', ['$scope', function($scope) {

}]);

timesheetsApp.controller('loginCtrl', ['$scope', '$rootScope', '$http', '$location', 'loginService',
function($scope, $rootScope, $http, $location, loginService) {
    $scope.login = function() {
        var successCallback = function(data, status, headers, config) {
            console.log(data.token)

            $rootScope.resource = data;
            $http.defaults.headers.common['Auth-Token'] = data.token;
            $location.path("/timesheet");
        };

        loginService.login($scope.username, $scope.password, successCallback);
    };
}]);

timesheetsApp.controller('timesheetCtrl', ['$scope', 'timesheet',
function($scope, timesheet) {
    $scope.weekEnding = Date.parseExact(timesheet.weekEnding, 'M/d/yyyy');
    $scope.totalTime = timesheet.totalTime;
    $scope.totalOvertime = timesheet.totalOvertime;

    $scope.previousWeekUrl = function() {
        var previousWeekEnding = Date.parseExact(timesheet.weekEnding, 'M/d/yyyy').last().saturday(),
            url = '#/timesheet' +
                '/' + previousWeekEnding.toString('yyyy') +
                '/' + previousWeekEnding.toString('M') +
                '/' + previousWeekEnding.toString('d');

        return url;
    };

    $scope.nextWeekUrl = function() {
        var nextWeekEnding = Date.parseExact(timesheet.weekEnding, 'M/d/yyyy').next().saturday(),
            url = '#/timesheet' +
                '/' + nextWeekEnding.toString('yyyy') +
                '/' + nextWeekEnding.toString('M') +
                '/' + nextWeekEnding.toString('d');

        return url;
    };
}]);