var raServices = angular.module('raServices', [ 'ngResource' ]);

raServices.factory('StudentsService', [ '$resource',

function($resource) {
	return $resource('http://localhost:8080/school/service/:call', {}, {
		students : {
			method : 'GET',
			params : {
				call : 'students'
			},
			isArray : true
		},

		student : {
			method : 'GET',
			params : {
				call : 'student'
			},
			isArray : false
		}
	});

} ]);