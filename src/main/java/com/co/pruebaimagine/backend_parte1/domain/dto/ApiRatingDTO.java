package com.co.pruebaimagine.backend_parte1.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiRatingDTO {

    private Double rate;
    private Integer count;
}
