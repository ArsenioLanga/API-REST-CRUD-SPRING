package com.place.apirest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.place.apirest.model.Todo;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ApiRestTodolistApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Test
	public void testeCreateTodoSucesso() {
		var nome = "Valid nome";
		var descricao = "Valid descricao";
		var realizado = false;
		var prioridade = 1;

		webTestClient
			.post()
			.uri("/todos")
			.bodyValue(
				new Todo(nome, descricao, realizado, prioridade)	
			)
			.exchange()
			.expectBody()
			.jsonPath("$").isArray()
			.jsonPath("$.length()").isEqualTo(1)
			.jsonPath("nome").isEqualTo(nome)
			.jsonPath("descricao").isEqualTo(descricao)
			.jsonPath("realizado").isEqualTo(realizado)
			.jsonPath("prioridade").isEqualTo(prioridade);
	}
	
	@Test
	public void testeCreateTodoFailure() {
		var nome = "";
		var descricao = "";
		var realizado = false;
		var prioridade = 1;

		webTestClient
			.post()
			.uri("/todos")
			.bodyValue(
				new Todo(nome, descricao, realizado, prioridade)	
			)
			.exchange()
			.expectStatus().isBadRequest();
	}
	


}
