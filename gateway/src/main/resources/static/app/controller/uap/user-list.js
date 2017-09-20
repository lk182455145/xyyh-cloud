angular.module("xyyhApp").controller("userListCtrl", function ($scope, $location) {

    $scope.newuser = function () {
        $location.path("/uap/user-form.html");
    }

    $scope.table=[{username: "lidong", age: 10}, {username: "lidong2", age: 12}];

    $scope.gridOptions = {
        enableSorting: false,
        data: [{username: "lidong", age: 10}, {username: "lidong2", age: 12}],
        columnDefs: [{field: 'username'}, {field: 'age'}]
        /*
         ,
         headerTemplate: "<div class='ui-grid-top-panel' style='text-align: center'>I am a Custom Grid Header</div>"
         onRegisterApi: function( gridApi ) {
         gridApi.core.addRowHeaderColumn( { name: 'rowHeaderCol', displayName: '', width: 30, cellTemplate: cellTemplate} );
         }*/
    }
    $scope.result = {age: 12};

    $scope.clickme = function () {
        console.log($scope.result);
    };
    $scope.switch=function(){
        $http.post(url,$scop.result).then();
        $http().then(function(){
            $scope.table=[{username: "张宏", age: 10}, {username: "冉桂玲", age: 12}];
        });

    }

});