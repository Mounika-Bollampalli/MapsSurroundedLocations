(function () {
    'use strict';
var app = angular.module('app.MYApp', ['ngRoute','google-maps']);
var routeApp = angular.module('ngRoute');
routeApp.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.
             when('/login',
             {
                 templateUrl: 'src/login/login.html',
                 controller: 'LoginController'
             }).
             when('/register',
                     {
                         templateUrl: 'src/register/register.html',
                         controller: 'RegisterController'
                     }).
                     when('/dashboard',
                             {
                                 templateUrl: 'src/dashBoard/dashboard.html',
                                 controller: 'DashBoardController'
                             }).
                             when('/route/:Destination',
                                     {
                                         templateUrl: 'src/route/route.html',
                                         controller: 'RouteController'
                                     }).
                                     
            otherwise({
                redirectTo: '/login'
            });
    }]);
}());





