package com.place.apirest.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

public record Place(
		Long id, String name, String slug, String status, 
		@CreatedDate LocalDateTime created_at, @LastModifiedDate LocalDateTime updated_at) {

}
