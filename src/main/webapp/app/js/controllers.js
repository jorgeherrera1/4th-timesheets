'use strict';

timesheetsApp.controller('appCtrl', ['$scope', function($scope) {

}]);

timesheetsApp.controller('loginCtrl', ['$scope', 'loginService', function($scope, loginService) {
    $scope.login = function() {
        loginService.login($scope.username, $scope.password);
    };
}]);