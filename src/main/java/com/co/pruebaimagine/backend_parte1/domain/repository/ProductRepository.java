package com.co.pruebaimagine.backend_parte1.domain.repository;

import com.co.pruebaimagine.backend_parte1.domain.collections.Product;
import com.co.pruebaimagine.backend_parte1.domain.dto.ProductDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    // find by productName
    List<Product> findByProductContainingIgnoreCaseOrderByProduct(String productName);

    // find by price less than
    List<Product> findAllByPriceLessThan(Double productPrice);

    // find by price greater than
    List<Product> findAllByPriceGreaterThan(Double productPrice);

    // find by price
    List<Product> findAllByPrice(Double productPrice);
}
