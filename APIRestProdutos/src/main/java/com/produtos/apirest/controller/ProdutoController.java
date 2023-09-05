package com.produtos.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.model.Produto;
import com.produtos.apirest.repository.ProdutoResppository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos") //Titulo da API
@CrossOrigin(origins = "*")   //Liberar o acesso a todos dominios
public class ProdutoController {
	
	@Autowired
	ProdutoResppository produtoResppository; 
	
	@GetMapping("/produtos")
	@ApiOperation(value = "Retorna uma lista de Produtos")
	public List<Produto> listaProdutos(){
		return produtoResppository.findAll();
	}
	
	@GetMapping("/produto/{id}")
	@ApiOperation(value = "Retorna um Produto pelo id")
	public Produto listaProdutoUnico(@PathVariable(value = "id")long id){
		return produtoResppository.findById(id);
	}

	@PostMapping("/produto")
	@ApiOperation(value = "Grava um Produto")
	public Produto gravaProduto(@RequestBody Produto produto){
		return produtoResppository.save(produto);
	}
	
	@DeleteMapping("/produto")
	@ApiOperation(value = "Deleta um Produto")
	public void deletaProduto(@RequestBody Produto produto){
		produtoResppository.delete(produto);
	}
	
	@PutMapping("/produto")
	@ApiOperation(value = "Actualiza um Produto")
	public Produto editaProduto(@RequestBody Produto produto){
		return produtoResppository.save(produto);
	}
}
