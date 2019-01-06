(function () {
    'use strict';
    var LoginController = function ($scope,$location,$rootScope,$routeParams,ajaxFactory) {
  console.log("check:::: login")
  
  $scope.login=function(loginform){
	  if(loginform.$valid){
	  ajaxFactory.postAjaxCall("http://localhost:8080/hackathon/login",
			  loginform).then(function(data) {
  				if(data.status=="Success"){
  					$rootScope.loginObj=data;
  					// $rootScope.$emit('loginObj', { obj: data});
  					$location.path("/dashboard");
  				}else{
  					
  				}
				});
	  }
  }
  
 
    };
    LoginController.$inject = ['$scope','$location','$rootScope','$routeParams','ajaxFactory'];

    angular.module('app.MYApp').controller('LoginController', LoginController);
}());