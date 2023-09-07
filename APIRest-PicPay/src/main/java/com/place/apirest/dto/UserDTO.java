package com.place.apirest.dto;

import java.math.BigDecimal;

import com.place.apirest.domain.user.UserType;

public record UserDTO(String firstName, String lastName, String document, BigDecimal balance, String email, String password, UserType usertype) {

}
