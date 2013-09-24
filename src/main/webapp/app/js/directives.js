'use strict';

timesheetsApp.directive('addTime', ['$templateCache', function($templateCache) {
    return {
        restrict: 'A',
        scope: {},
        link: function(scope, elem, attrs) {
            elem.popover({
                html: true,
                placement: 'bottom',
                content: $templateCache.get('partials/add-time.html')
            });
        }
    };
}]);

timesheetsApp.directive('weeklyTimesheet', function() {
    return {
        restrict: 'E',
        scope: true,
        templateUrl: 'partials/weekly-timesheet.html',
        link: function(scope, elem, attrs) {

        }
    };
});

