package com.place.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.place.apirest.domain.user.User;
import com.place.apirest.dto.UserDTO;
import com.place.apirest.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody UserDTO user){
		User newUser = userService.createUser(user);
		return  new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<User>> gettAll(){
		 List<User> users = userService.getAllUsers();
		 return  new ResponseEntity<>(users, HttpStatus.CREATED);
	}
}
