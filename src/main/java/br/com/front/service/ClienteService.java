package br.com.front.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.front.model.Cliente;
import br.com.front.repository.ClienteRepository;



@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public Cliente cadastrar(Cliente cliente) {
		return clienteRepository.save(cliente);

	}

	public Collection<Cliente> buscacClientes() {
		return clienteRepository.findAll();
	}

	public void excluir(Integer id) {
		clienteRepository.deleteById(id);
	}

	public Optional<Cliente> buscaPorId(Integer id) {
		return clienteRepository.findById(id);
	}

	public Cliente alterarClient(Cliente cliente) {
		return cadastrar(cliente);
	}

	public void excluir(Optional<Cliente> clieteEncontrado) {
		excluir(clieteEncontrado);
	}

}