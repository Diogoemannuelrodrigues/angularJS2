var appCliente = angular.module("appCliente", ["ngRoute"]);

appCliente.config(function($routeProvider, $locationProvider) {
	$routeProvider.when("/clientes", {
		templateUrl : "/views/cliente.html",
		controller : "clientecontroller"
	}).otherwise({
		rediretTo : '/clientes'});
	
	  $locationProvider.html5Mode(true);
	  $locationProvider.hashPrefix('');


	
});
