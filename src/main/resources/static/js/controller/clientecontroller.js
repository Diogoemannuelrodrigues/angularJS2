appCliente.controller("clientecontroller", function($scope, $http) {

	$scope.clientes = [];
	$scope.cliente = {};

	listaClientes = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:8080/clientes'
		}).then(function successCallback(response) {
			$scope.clientes = response.data;
			 
			console.log(response.data);
			console.log(response.status);
		}, function errorCallback(response) {
			console.log(response.data);
			console.log(response.status);

		});

	}
	
	
	$scope.cadastraCliente = function(){
		
		$http({
			method : 'POST',
			url : 'http://localhost:8080/cadastrar',
			data: $scope.cliente
			}).then(function successCallback(response) {
				listaClientes();
//			$scope.clientes.push(response.data);
			 delete $scope.cliente;


		}, function errorCallback(response) {
			console.log(response.data);
			console.log(response.status);

		});
		
	}
	
	
	$scope.deletarCliente = function(cliente){
		$http({
			method : 'Delete',
			url : 'http://localhost:8080/clientes/'+cliente.id
			}).then(function successCallback(response) {

				pos = $scope.clientes.indexOf(cliente)
				
				$scope.clientes.splice(pos, 1);

		}, function errorCallback(response) {
			console.log(response.data);
			console.log(response.status);

		});
		
	}
	
	
	$scope.alterarCliente = function(cli){
		$scope.cliente = angular.copy(cli);
	};
	
	$scope.cancelaAlterarCliente = function(){
		$scope.cliente = {};
	};
	
	listaClientes();
	
	
});
