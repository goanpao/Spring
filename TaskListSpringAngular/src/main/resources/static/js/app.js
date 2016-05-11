var taskManagerModule = angular.module('taskManagerApp', ['ngAnimate']);

taskManagerModule.controller('taskManagerController', function($scope, $http) 
		{
	var urlBase = "";
	$scope.toggle=true;
	$scope.selection=[];
	$scope.statuses=['ACTIVE', 'COMPLETED'];
	$scope.priorities=['HIGH','LOW','MEDIUM'];
	$http.defaults.headers.post["Content-Type"] = "application/json";
	
	function findAllTaskse() {
		
	}
	}
) 