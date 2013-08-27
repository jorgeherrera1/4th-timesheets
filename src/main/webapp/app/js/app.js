'use strict';

var timesheetsApp = angular.module('timesheets', [])
    .config(['$routeProvider', '$httpProvider', function ($routeProvider, $httpProvider) {
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

        var httpInterceptor = function($rootScope, $q, $location) {
            function success(response) {
                return response;
            };

            function error(response) {
                var status = response.status;
                var config = response.config;
                var method = config.method;
                var url = config.url;

                if (status == 403) {
                    $location.path('/login');
                } else {
                    console.log(method + ' on ' + url + ' failed with status ' + status);
                }

                return $q.reject(response);
            };

            return function(promise) {
                return promise.then(success, error);
            };
        };
        $httpProvider.responseInterceptors.push(httpInterceptor);
    }]);