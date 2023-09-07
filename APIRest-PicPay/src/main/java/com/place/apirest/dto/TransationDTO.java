package com.place.apirest.dto;

import java.math.BigDecimal;

public record TransationDTO(BigDecimal value, Long sender_id, Long receiver_id) {

}
