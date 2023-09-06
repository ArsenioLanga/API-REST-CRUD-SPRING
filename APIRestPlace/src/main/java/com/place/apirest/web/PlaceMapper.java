package com.place.apirest.web;

import com.place.apirest.domain.Place;
import com.place.apiresta.api.PlaceResponse;

public class PlaceMapper {

	public static PlaceResponse forPlaceToResponse(Place place) {
		return new PlaceResponse(place.name(), place.slug(), place.status(), place.created_at(), place.updated_at());
	}
}
