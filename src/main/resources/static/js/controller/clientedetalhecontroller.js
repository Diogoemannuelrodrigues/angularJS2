appCliente.controller("clienteDetalheController", function($scope, $routeParams, 
		$http, $routeProvider ) {

	$scope.cliente = {};
	
	$http.get('clientes/'+$routeParams.clienteId).then(function(response){
		$scope.cliente = response.data;
		
	}, function(response){
		console.log(response)		
	});
	
//	$http.get("clientes/"+$routeParams.clienteId)
//	  .then(function(response) {
//	    $scope.cliente = response.data;
//	  });
//	
	
	
});