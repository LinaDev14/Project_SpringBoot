package com.co.pruebaimagine.backend_parte1.domain.collections;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "sales")
public class Sale {

    @Id
    private final String id;

    private final String userId;
    private final String productId;

}
