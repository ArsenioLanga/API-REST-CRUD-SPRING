package com.clientes.apirest.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.clientes.apirest.model.Cliente;
import com.clientes.apirest.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	private ModelMapper modelMapper;
	
	@PostMapping("/criarCliente")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvarCliente(@RequestBody Cliente cliente) {
		return clienteService.salvarCliente(cliente);
	}
	
	@GetMapping("/listar")
	@ResponseStatus(HttpStatus.OK)
	public List<Cliente> listaCliente(){
		return clienteService.listarCliente();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Cliente buscaCliente(@PathVariable("id") Long id){
		return clienteService.buscarCliente(id)
				.orElseThrow(()-> new  ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));	
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarCliente(@PathVariable("id") Long id) {
		clienteService.buscarCliente(id).map(cliente-> { clienteService.deletarCliente(cliente.getId());
			return Void.TYPE;
		}).orElseThrow(()-> new  ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
	}
	
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void actualizarCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
		clienteService.buscarCliente(id).map(clienteExists -> { modelMapper.map(id, clienteExists);
		clienteService.salvarCliente(cliente);
		return Void.TYPE;
		}).orElseThrow(()-> new  ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
	}
}
