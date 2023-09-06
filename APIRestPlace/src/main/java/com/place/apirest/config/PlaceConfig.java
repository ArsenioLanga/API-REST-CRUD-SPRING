package com.place.apirest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

import com.github.slugify.Slugify;
import com.place.apirest.domain.PlaceRepository;
import com.place.apirest.domain.PlaceService;

@Configuration
@EnableR2dbcAuditing
public class PlaceConfig {

	@Bean
	PlaceService placeService(PlaceRepository placeRepository) {
		return new PlaceService(placeRepository);
	}
}
