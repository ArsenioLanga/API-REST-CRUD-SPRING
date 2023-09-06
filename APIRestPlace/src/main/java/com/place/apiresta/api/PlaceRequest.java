package com.place.apiresta.api;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

//produrção
//public record PlaceRequest(String name, String slug, String status, LocalDateTime created_at, LocalDateTime updated_at) {
//
//}

//teste
public record PlaceRequest(
		@NotBlank String name, @NotBlank String status) {

}