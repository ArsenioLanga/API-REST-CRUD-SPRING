package com.place.apirest.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.place.apirest.model.Todo;
import com.place.apirest.repository.TodoRepository;

@Service
public class TodoService {
	
	private TodoRepository todoRepository;
	
	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public List<Todo> listAll(){
		Sort sort = Sort.by("prioridade").descending().and(
			Sort.by("nome").ascending()
		);	
		return todoRepository.findAll(sort);
	}
	
	public List<Todo> create(Todo todo) {
		 todoRepository.save(todo);
		 return listAll();
	}
	
	public List<Todo> update(Todo todo) {
		 todoRepository.save(todo);
		 return listAll();
	}
	
	public List<Todo> delete(Long id) {
		 todoRepository.deleteById(id);
		 return listAll();
	}
}
