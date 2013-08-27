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

timesheetsApp.controller('timesheetCtrl', ['$scope',
function($scope) {

}]);