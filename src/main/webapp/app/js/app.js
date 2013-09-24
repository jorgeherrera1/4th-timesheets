'use strict';

var timesheetsApp = angular.module('timesheets', [])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when('/', {
                redirectTo: '/timesheet'
            })
            .when('/login', {
                templateUrl: 'partials/login.html'
            })
            .when('/timesheet', {
                redirectTo: function() {
                    var today = Date.today(),
                        currentWeekEnding = today;
                    if (!today.is().saturday()) {
                        currentWeekEnding = today.next().saturday();
                    }

                    var redirectUrl = '/timesheet' +
                        '/' + currentWeekEnding.toString('yyyy') +
                        '/' + currentWeekEnding.toString('M') +
                        '/' + currentWeekEnding.toString('d');

                    return redirectUrl;
                }
            })
            .when('/timesheet/:year/:month/:day', {
                templateUrl: 'partials/timesheet.html',
                controller: 'timesheetCtrl',
                resolve: {
                    timesheet: function(timesheetLoader) {
                        return timesheetLoader();
                    }
                }
            })
            .otherwise({
                templateUrl: 'partials/timesheet.html'
            });
    }])
    .run(['$http', '$templateCache', function($http, $templateCache) {
        $http.get('partials/add-time.html').success(function(addTimeHtml) {
            $templateCache.put('partials/add-time.html', addTimeHtml);
        });
    }]);