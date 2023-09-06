package com.place.apirest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.place.apiresta.api.PlaceRequest;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ApiRestPlaceApplicationTests {
	
	@Autowired
	WebTestClient webTestClient;

	@Test
	public void testeCrestePlaceSucesso() {
		var name = "Valid name";
		var status = "Valid status";
		var slug = "valid-slug";
		
		webTestClient
			.post()
			.uri("/places")
			.bodyValue(
				new PlaceRequest(name, status)	
			)
			.exchange()
			.expectBody()
			.jsonPath("name").isEqualTo(name)
			.jsonPath("status").isEqualTo(status)
			.jsonPath("slug").isEqualTo(slug)
			.jsonPath("created_at").isNotEmpty()
			.jsonPath("updated_at").isNotEmpty();	
	}
	
	@Test
	public void testeCrestePlaceFailure() {
		var name = "";
		var status = "";
		var slug = "valid-slug";
		
		webTestClient
			.post()
			.uri("/places")
			.bodyValue(
				new PlaceRequest(name, status)	
			)
			.exchange()
			.expectStatus().isBadRequest();
	}

}
