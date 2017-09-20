angular.module("xyyhApp").controller("userFormCtrl", function($scope, $location, $http) {

	$scope.tolist = function() {
		$location.path("/uap/users-list.html");
	}

	$scope.submit = function() {
		console.log($scope.userinfo);
		$http.post("uap/user", $scope.userinfo).success(function(data) {
			console.log(data);
		});
	}

});