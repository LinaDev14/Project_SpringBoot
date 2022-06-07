package com.co.pruebaimagine.backend_parte1.application.mappers;

import com.co.pruebaimagine.backend_parte1.domain.collections.Product;
import com.co.pruebaimagine.backend_parte1.domain.dto.ApiProductDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ApiProductMapper {

    public Function<ApiProductDTO, Product> mapToDTOApiProducto(){

        return apiProductDTO -> new Product(
                apiProductDTO.getId(),
                apiProductDTO.getTitle(),
                apiProductDTO.getPrice(),
                apiProductDTO.getDescription(),
                apiProductDTO.getCategory(),
                apiProductDTO.getImage(),
                apiProductDTO.getRating().getRate(),
                apiProductDTO.getRating().getCount()
        );
    }
}
