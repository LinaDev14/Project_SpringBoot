package com.co.pruebaimagine.backend_parte1.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {

    private String id;

    private String userId;
    private String productId;
}
