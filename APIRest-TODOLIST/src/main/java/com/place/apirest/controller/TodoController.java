package com.place.apirest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.place.apirest.model.Todo;
import com.place.apirest.service.TodoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/todo")
public class TodoController {

	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}
	
	@PostMapping("/create")
	List<Todo> create(@RequestBody @Valid Todo todo){
		return todoService.create(todo);
	}
	
	@GetMapping("/all")
	List<Todo> list(){
		return todoService.listAll();
	}
	
	@PutMapping("/update")
	List<Todo> update(@RequestBody Todo todo){
		return todoService.update(todo);
	}
	
	@DeleteMapping("/delete/{id}")
	List<Todo> delete(@PathVariable("id") Long id){
		return todoService.delete(id);
	}
}
