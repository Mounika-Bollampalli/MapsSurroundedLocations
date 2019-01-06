(function () {
    'use strict';
    var RegisterController = function ($scope,$location,$rootScope,$routeParams,ajaxFactory) {
  console.log("check:::: register")
  //$scope.passwordMessage=false ;
  $scope.regSubmit=function(regform){
	  if(regform.$valid){
		  console.log("check:::: register valid")
		  if(regform.email==regform.email_confirm){
			  console.log("check:::: email ok") 
			  $scope.emailMessage=false ;
		  }else{
			  $scope.emailMessage=true ;
		  }
		  if(regform.password==regform.password_confirm){
			  console.log("check:::: password ok") 
			  $scope.passwordMessage=false ;
		  }else{
			  $scope.passwordMessage=true ;  
		  }
		  
		  
		  ajaxFactory.postAjaxCall("http://localhost:8080/hackathon/register",
				  regform).then(function(message) {
      				if(message=="201"){
      					
      				$location.path("/login");
      				}else{
      					
      				}
					});
	  }
  }
    };
    RegisterController.$inject = ['$scope','$location','$rootScope','$routeParams','ajaxFactory'];

    angular.module('app.MYApp').controller('RegisterController', RegisterController);
}());

