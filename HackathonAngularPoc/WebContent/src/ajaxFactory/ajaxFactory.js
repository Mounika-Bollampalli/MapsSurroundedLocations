(function () {
    'use strict';

    angular.module('app.MYApp').factory('ajaxFactory', ['$http', '$q', '$timeout', function ($http, $q, $timeout) {
   
    	var ajaxFactory = {};
        return { 
			getAjaxCall : function(url){
						var deferred = $q.defer();
						
						var res = $http.get(url,{cache: true}).success(function(result) {
							deferred.resolve(result);
							return result;
						}).error(function(reason) {
							deferred.reject(reason);
						});
						return deferred.promise;
			}
			,postAjaxCall : function(url,param){
						var deferred = $q.defer();
						var res = $http.post(url,param,{cache: true}).success(function(result,message) {
							deferred.resolve(result);
							return result;
						}).error(function(reason) {
							deferred.reject(reason);
						});
						return deferred.promise;
			}
		};
        return ajaxFactory;        
    }]);

}());