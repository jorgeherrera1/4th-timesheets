'use strict';

timesheetsApp.directive('tooltip', function() {
    return {
        restrict: 'A',
        scope: true,
        link: function(scope, elem, attrs) {
            elem.attr('title', scope.$eval(attrs.tooltip));
            elem.tooltip();
        }
    };
});

timesheetsApp.directive('weeklyTimesheet', function() {
    return {
        restrict: 'E',
        scope: true,
        templateUrl: 'partials/weekly-timesheet.html',
        link: function(scope, elems, attrs) {

        }
    };
});

