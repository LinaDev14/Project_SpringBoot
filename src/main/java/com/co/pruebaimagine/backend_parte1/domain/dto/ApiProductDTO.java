package com.co.pruebaimagine.backend_parte1.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiProductDTO {

    private String id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;
    private ApiRatingDTO rating;
}
