'use strict';

var timesheetsApp = angular.module('timesheets', [])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/login', {
            templateUrl: 'partials/login.html',
            controller: 'loginCtrl'
        });

        $routeProvider.when('/timesheet', {
            templateUrl: 'partials/timesheet.html',
            controller: 'timesheetCtrl'
        });

        $routeProvider.otherwise({
            templateUrl: 'partials/timesheet.html'
        });
    }]);