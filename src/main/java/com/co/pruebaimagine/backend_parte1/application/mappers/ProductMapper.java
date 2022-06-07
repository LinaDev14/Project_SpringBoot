package com.co.pruebaimagine.backend_parte1.application.mappers;

import com.co.pruebaimagine.backend_parte1.domain.collections.Product;
import com.co.pruebaimagine.backend_parte1.domain.dto.ProductDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProductMapper {

    public Function<Product, ProductDTO> mapToDTOProduct(){

        return product -> new ProductDTO(
                product.getId(),
                product.getProduct(),
                product.getPrice(),
                product.getDescription(),
                product.getCategory(),
                product.getImage(),
                product.getRate(),
                product.getStock()
        );
    }

    public Function<ProductDTO, Product> mapToCollectionProduct(){

        return productDTO -> new Product(
                productDTO.getId(),
                productDTO.getProduct(),
                productDTO.getPrice(),
                productDTO.getDescription(),
                productDTO.getCategory(),
                productDTO.getImage(),
                productDTO.getRate(),
                productDTO.getStock()
        );
    }
}
