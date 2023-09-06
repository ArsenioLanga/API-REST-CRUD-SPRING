package com.place.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.place.apirest.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
