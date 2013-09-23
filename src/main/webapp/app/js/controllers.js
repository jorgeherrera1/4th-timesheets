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

    var toUrl = function(weekEnding) {
        var url = '#/timesheet' +
            '/' + weekEnding.toString('yyyy') +
            '/' + weekEnding.toString('M') +
            '/' + weekEnding.toString('d');

        return url;
    };

    $scope.previousWeek = function() {
        var previousWeek = Date.parseExact(timesheet.weekEnding, 'M/d/yyyy').last().saturday();

        return previousWeek;
    };

    $scope.nextWeek = function() {
        var nextWeek = Date.parseExact(timesheet.weekEnding, 'M/d/yyyy').next().saturday();

        return nextWeek;
    };

    $scope.previousWeekUrl = function() {
        var previousWeekEnding = $scope.previousWeek(),
            url = toUrl(previousWeekEnding);

        return url;
    };

    $scope.nextWeekUrl = function() {
        var nextWeekEnding = $scope.nextWeek(),
            url = toUrl(nextWeekEnding);

        return url;
    };
}]);