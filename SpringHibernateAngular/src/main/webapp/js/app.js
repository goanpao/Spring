var restAngular = angular.module('restAngular', [ 'ngRoute', 'raControllers','raServices' ]);

restAngular.config([ '$routeProvider',
function($routeProvider) {
	$routeProvider.
	when('/students', {
		templateUrl : 'partials/student-list.html',
		controller : 'StudentsListController'
	}).
	when('/student/:studentid', {
		templateUrl : 'partials/student-details.html',
		controller : 'StudentDetailsController'
	}).
	otherwise({
		redirectTo : '/students'
	});
} ]);