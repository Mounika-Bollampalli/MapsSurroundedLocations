(function () {
    'use strict';
    //var gpi = angular.module('google-maps');
    var RouteController = function ($scope,$location,$rootScope,$routeParams,$document) {
  console.log("check:::: login")
  var Destination=$routeParams.Destination;
  $scope.login=function(loginform){
	  $location.path("/dashboard");
  }
  $scope.map = {
		    control: {},
		    center: {
		        latitude: -37.812150,
		        longitude: 144.971008
		    },
		    zoom: 14
		  };
		  
		  // marker object
		  $scope.marker = {
		    center: {
		        latitude: -37.812150,
		        longitude: 144.971008
		    }
		  }
		  
		  // instantiate google map objects for directions
		  var directionsDisplay = new google.maps.DirectionsRenderer();
		  var directionsService = new google.maps.DirectionsService();
		  var geocoder = new google.maps.Geocoder();
		  
		  
		  
		  $rootScope.$on('item', function (event, args) {
			  console.log("check::::  $rootScope")
			  $scope.Origin = args.Origin; 
			  $scope.Destination = args.Destination; 
		  });
		  // directions object -- with defaults
		  $scope.directions = {
		    origin: "Syntel Plot No. H7 or H8, SIPCOT IT Park, Old Mahabalipuram Road, Navallur Post, Siruseri, Tamil Nadu 603103",
		    destination:  Destination,
		    showList: false
		  }
		  
		  var init=function(){
			  var request = {
				      origin: "Syntel Plot No. H7 or H8, SIPCOT IT Park, Old Mahabalipuram Road, Navallur Post, Siruseri, Tamil Nadu 603103",
				      destination: Destination,
				      travelMode: google.maps.DirectionsTravelMode.DRIVING
				    };
				    directionsService.route(request, function (response, status) {
				      if (status === google.maps.DirectionsStatus.OK) {
				        directionsDisplay.setDirections(response);
				        directionsDisplay.setMap($scope.map.control.getGMap());
				        directionsDisplay.setPanel(document.getElementById('directionsList'));
				        $scope.directions.showList = true;
				      } else {
				        alert('Google route unsuccesfull!');
				      }
				    });  
		  }
		  init();
		  // get directions using google maps api
		  $scope.getDirections = function () {
		    var request = {
		      origin: $scope.directions.origin,
		      destination: $scope.directions.destination,
		      travelMode: google.maps.DirectionsTravelMode.DRIVING
		    };
		    directionsService.route(request, function (response, status) {
		      if (status === google.maps.DirectionsStatus.OK) {
		        directionsDisplay.setDirections(response);
		        directionsDisplay.setMap($scope.map.control.getGMap());
		        directionsDisplay.setPanel(document.getElementById('directionsList'));
		        $scope.directions.showList = true;
		      } else {
		        alert('Google route unsuccesfull!');
		      }
		    });
		  }
		  $scope.getBack=function(){
			  $location.path("/dashboard");
		  }
		  
  
    };
    RouteController.$inject = ['$scope','$location','$rootScope','$routeParams','$document'];
    var gpi = angular.module('google-maps').controller('RouteController', RouteController);

    
}());