package com.clientes.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clientes.apirest.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
