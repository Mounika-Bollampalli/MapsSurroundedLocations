(function () {
    'use strict';
    var DashBoardController = function ($scope,$location,$rootScope,$routeParams,$interval,ajaxFactory) {
  console.log("check:::: dashboard")
  $scope.dataLoader=true;	
  var t=localStorage.getItem('addroute');
  console.log("check:::: dashboard"+t);
  var d=localStorage.getItem('drivername')
   console.log("check:::: dashboard"+d);
 
/*  $scope.$watch(function() {
	     // alert('hey, myVar has changed!');
	      
	      $interval(callAtInterval, 1000);
	      function callAtInterval() {
	          $scope.dataLoader=false;
	      }
	  });*/
  
  var init=function(){
	  console.log("check:::: dashboard"+$rootScope.loginObj)
	  var loginObj=$rootScope.loginObj;
	  if(loginObj!=null&&loginObj.role=="DRIVER"){
	  ajaxFactory.postAjaxCall("http://localhost:8080/hackathon/getallpackage",loginObj).then(function(data) {
  				if(data!=null){
  					 $scope.dataLoader=false;
  					$interval(callAtInterval, 1000);
  			      function callAtInterval() {
  			          $scope.dataLoader=false;
  			        $scope.packgeList=data;
  			      }
  					console.log("check:::: dashboard"+data)
  					//$location.path("/dashboard");
  				}else{
  					
  				}
				});
	  }else{
		  ajaxFactory.getAjaxCall("http://localhost:8080/hackathon/getallpackage").then(function(data) {
				if(data!=null){
					 $scope.dataLoader=false;
					 $scope.packgeList=data; 
					 var t=localStorage.getItem('addroute');
					  console.log("check:::: dashboard"+t);
					  var d=localStorage.getItem('drivername')
					   console.log("check:::: dashboard"+d);
					  var value=t.split(",,");
					  if(value!=null){
					  for (var i in value) {  
						  console.log("value:::::   "+value[i]);  
						  $scope.packgeList.push({package_id: $scope.packgeList.length+1,form_address:"Syntel Plot No. H7 or H8, SIPCOT IT Park, Old Mahabalipuram Road, Navallur Post, Siruseri, Tamil Nadu 603103",to_address:value[i],driver_details:{name:d}})
						}}
					  console.log("check:::: value"+value);
					  $scope.packgeListTemp=$scope.packgeList;
				
					$interval(callAtInterval, 100);
			      function callAtInterval() {
			          $scope.dataLoader=false;
			        
			      }
					console.log("check:::: dashboard"+data)
					//$location.path("/dashboard");
				}else{
					
				}
				})  
	  }
  }
	  
  init();
  
 $scope.map=function(item){
	 console.log("check:::: dashboard"+item.form_address)
	  $rootScope.$broadcast('loginObj', { obj: $rootScope.loginObj});
	 $location.path('/route/'+item.to_address+'/');
	// $location.path("/route");
 }
    };
    DashBoardController.$inject = ['$scope','$location','$rootScope','$routeParams','$interval','ajaxFactory'];

    angular.module('app.MYApp').controller('DashBoardController', DashBoardController);
}());