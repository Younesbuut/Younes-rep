/**
 * 
 */

var app = angular.module("app",[]);
app.controller("catController",function($scope,$http){
	$scope.produits= [];
	$scope.name="charger";
	$scope.query=null;
	$scope.NumPage=0;
	$scope.charger = function(){
		$http.get("/produitsParMC?mc="+$scope.query+"&page="+$scope.NumPage)
		.success(function(data){
			$scope.produits=data;
			$scope.pages=new Array(data.totalPages);
		});
		
		

	};
	
	$scope.gotoPage = function(p){
		$scope.NumPage = p;
		$scope.charger();
	}

	
});