package com.co.pruebaimagine.backend_parte1.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private String id;

    private String product;
    private Double price;
    private String description;
    private String category;
    private String image;
    private Double rate;
    private Integer stock;
}
