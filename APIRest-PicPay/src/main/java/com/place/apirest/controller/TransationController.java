package com.place.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.place.apirest.domain.transation.Transation;
import com.place.apirest.dto.TransationDTO;
import com.place.apirest.services.TransationService;

@RestController
@RequestMapping("/transations")
public class TransationController {

	@Autowired
	TransationService transationService;
	
	@PostMapping("/create")
	public ResponseEntity<Transation> createTransation(@RequestBody TransationDTO transation) throws Exception{
		Transation newTaransation = transationService.createTransation(transation);
		return new ResponseEntity<>(newTaransation, HttpStatus.CREATED);
	}
}
