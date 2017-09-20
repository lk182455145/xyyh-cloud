/**
 * Created by LiDong on 2016/9/15.
 */
angular.module("xyyhApp", ["ui.bootstrap", 'ui.router', "oc.lazyLoad", "ui.grid"]).controller('DropdownCtrl', function ($scope, $log) {
    $scope.items = [
        'The first choice!',
        'And another choice for you.',
        'but wait! A third!'
    ];

    $scope.name = "123";

    $scope.testclick = function () {
        alert("hello world");
    }

    $scope.status = {
        isopen: false
    };

    $scope.toggled = function (open) {
        $log.log('Dropdown is now: ', open);
    };

    $scope.toggleDropdown = function ($event) {
        $event.preventDefault();
        $event.stopPropagation();
        $scope.status.isopen = !$scope.status.isopen;
    };

    $scope.appendToEl = angular.element(document.querySelector('#dropdown-long-content'));
}).config(['$stateProvider', function ($stateProvider) {
    $stateProvider.state("p1", {
        "url": "/p1",
        templateUrl: 'views/page1.html',
        controller: "DatepickerPopupDemoCtrl",
        resolve: {
            deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load({
                    name: 'MetronicApp',
                    insertBefore: '#ng_load_plugins_before', // load the above css files before a LINK element with this ID. Dynamic CSS files must be loaded between core and theme css files
                    files: [
                        'app/controller/page1.js'
                    ]
                });
            }]
        }
    }).state("/p2", {
        url: "/p2",
        templateUrl: 'views/page2.html',
        controller: "DatepickerDemoCtrl",
        resolve: {
            deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load({
                    name: 'MetronicApp',
                    insertBefore: '#ng_load_plugins_before', // load the above css files before a LINK element with this ID. Dynamic CSS files must be loaded between core and theme css files
                    files: [
                        'app/controller/page2.js'
                    ]
                });
            }]
        }
    }).state("userlist", {
        url: "/uap/users-list.html",
        templateUrl: "views/uap/user-list.html",
        controller: "userListCtrl",
        resolve: {
            deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load({
                    name: 'MetronicApp',
                    insertBefore: '#ng_load_plugins_before', // load the above css files before a LINK element with this ID. Dynamic CSS files must be loaded between core and theme css files
                    files: [
                        'app/controller/uap/user-list.js'
                    ]
                });
            }]
        }
    }).state("userform", {
        url: "/uap/user-form.html",
        templateUrl: "views/uap/user-form.html",
        controller: "userFormCtrl",
        resolve: {
            deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load({
                    name: 'MetronicApp',
                    insertBefore: '#ng_load_plugins_before', // load the above css files before a LINK element with this ID. Dynamic CSS files must be loaded between core and theme css files
                    files: [
                        'app/controller/uap/user-form.js',
                        "app/services/uap/UserService.js"
                    ]
                });
            }]
        }
    });
}]);
