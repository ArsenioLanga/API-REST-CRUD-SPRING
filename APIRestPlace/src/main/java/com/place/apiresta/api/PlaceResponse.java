package com.place.apiresta.api;

import java.time.LocalDateTime;

public record PlaceResponse(String name, String slug, String status, LocalDateTime created_at, LocalDateTime updated_at) {

}
