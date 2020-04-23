package br.com.front.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.front.model.Cliente;
import br.com.front.service.ClienteService;

@Controller
public class ClienteController {

		@Autowired
		ClienteService clienteService;

		@RequestMapping(method = RequestMethod.POST, value = "/cadastrar", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
			Cliente cCadastrado = clienteService.cadastrar(cliente);
			return new ResponseEntity<Cliente>(cCadastrado, HttpStatus.CREATED);
		}

		@RequestMapping(method = RequestMethod.GET, value = "/clientes", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Collection<Cliente>> buscaClientes1() {
			Collection<Cliente> clienteEncontrados = clienteService.buscacClientes();
			return new ResponseEntity<>(clienteEncontrados, HttpStatus.OK);
		}
		
		@RequestMapping(method = RequestMethod.GET, value = "/clientes/{id}", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
		public Optional<Cliente> buscaClientesPorId(@PathVariable Integer id) {
			Optional<Cliente> clienteEncontrado = clienteService.buscaPorId(id);
			return clienteEncontrado;
		}

		@RequestMapping(method = RequestMethod.DELETE, value = "/clientes/{id}")
		public ResponseEntity<Void> excluirCliente(@PathVariable Integer id) {
			Optional<Cliente> clieteEncontrado = clienteService.buscaPorId(id); // pesquisar como fazer ele apagar com a
																				// classe optional.
			clienteService.excluir(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}

		@RequestMapping(method = RequestMethod.PUT, value = "/clientes/{id}")
		public ResponseEntity<Cliente> alteraCliente(@RequestBody Cliente cliente) {
			Cliente clienteAlterado = clienteService.alterarClient(cliente);
			return new ResponseEntity<>(clienteAlterado, HttpStatus.OK);
		}

}

