'use strict';

timesheetsApp.controller('appCtrl', ['$scope', function($scope) {

}]);

timesheetsApp.controller('loginCtrl', ['$scope', function($scope) {
    $scope.login = function() {
        console.log('logging in ' + $scope.username);
    };
}]);