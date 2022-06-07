package com.co.pruebaimagine.backend_parte1.application.service.product;

import com.co.pruebaimagine.backend_parte1.domain.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductServiceInterface {

    // list products
    List<ProductDTO> listProduct();

    // find by id
    Optional<ProductDTO> findById(String id);

    // find by productName
    List<ProductDTO> findAllByProduct(String productName);

    // find by price less than
    List<ProductDTO> findAllByPriceLessThan(Double productPrice);

    // find by price greater than
    List<ProductDTO> findAllByPriceGreaterThan(Double productPrice);

    // find all products by price
    List<ProductDTO> findAllByPrice(Double productPrice);

    //fetch Data
    List<ProductDTO> fetchData();
}
