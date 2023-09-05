package com.clientes.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clientes.apirest.model.Cliente;
import com.clientes.apirest.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente salvarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> listarCliente() {
		return clienteRepository.findAll();
	}
	
	public Optional<Cliente> buscarCliente(Long id) {
		return clienteRepository.findById(id);
	}
	
	public void deletarCliente(Long id) {
		clienteRepository.deleteById(id);
	}
}

