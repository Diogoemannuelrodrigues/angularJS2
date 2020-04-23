var appCliente = angular.module("appCliente", ["ngRoute"]);

appCliente.config(function($routeProvider, $locationProvider) {
	$routeProvider
	.when("/clientes", {
		templateUrl : "/views/cliente.html",
		controller : "clientecontroller"
	}).when("/clientes/:clienteId", {
		templateUrl : "/views/clienteDetalhe.html",
		controller : "clienteDetalheController"
	}).when("/cidade", {
		templateUrl : "/views/cidade.html",
		controller : "cidadecontroller"
	}).
	otherwise({
		rediretTo : '/clientes'});
	
	  $locationProvider.html5Mode(true);
	  $locationProvider.hashPrefix('');


	
});
