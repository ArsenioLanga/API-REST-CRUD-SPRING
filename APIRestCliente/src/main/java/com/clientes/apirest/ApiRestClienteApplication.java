package com.clientes.apirest;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiRestClienteApplication {

    @Bean
    ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setSkipNullEnabled(false);
		return modelMapper;
	}
    
    
	public static void main(String[] args) {
		SpringApplication.run(ApiRestClienteApplication.class, args);
	}

}
