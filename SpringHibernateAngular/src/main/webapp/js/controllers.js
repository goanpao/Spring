var raControllers = angular.module('raControllers', []);

raControllers.controller('StudentsListController', [ '$scope', 'StudentsService', function($scope, StudentsService) {
		$scope.students = StudentsService.students();
	} 
]);

raControllers.controller('StudentDetailsController', [ '$scope', '$routeParams', 'StudentsService',
	function($scope, $routeParams, StudentsService) {
		$scope.student = StudentsService.student({id : $routeParams.studentid});
	} 
]);