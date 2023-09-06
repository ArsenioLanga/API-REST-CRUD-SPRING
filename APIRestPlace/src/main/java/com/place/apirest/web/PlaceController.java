package com.place.apirest.web;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.place.apirest.domain.PlaceService;
import com.place.apiresta.api.PlaceRequest;
import com.place.apiresta.api.PlaceResponse;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/places")
public class PlaceController {

	private PlaceService placeService;
	
	public PlaceController(PlaceService placeService) {
		this.placeService = placeService;
	}

	@PostMapping("/createPlace")
	public ResponseEntity<Mono<PlaceResponse>> create(@Valid @RequestBody PlaceRequest request){
		var placeResponse = placeService.create(request).map(PlaceMapper::forPlaceToResponse);
		return ResponseEntity.status(HttpStatus.CREATED).body(placeResponse);
	}
}
