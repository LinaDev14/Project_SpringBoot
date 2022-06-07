package com.co.pruebaimagine.backend_parte1.application.service.product;

import com.co.pruebaimagine.backend_parte1.adapters.webclients.WebClientAdapter;
import com.co.pruebaimagine.backend_parte1.application.mappers.ApiProductMapper;
import com.co.pruebaimagine.backend_parte1.application.mappers.ProductMapper;
import com.co.pruebaimagine.backend_parte1.domain.collections.Product;
import com.co.pruebaimagine.backend_parte1.domain.dto.ApiProductDTO;
import com.co.pruebaimagine.backend_parte1.domain.dto.ProductDTO;
import com.co.pruebaimagine.backend_parte1.domain.repository.ProductRepository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService implements ProductServiceInterface{

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ApiProductMapper apiProductMapper;
    private final WebClientAdapter webClientAdapter;


    @Override
    public List<ProductDTO> listProduct() {
        return productRepository.findAll()
                .stream()
                .map(productMapper.mapToDTOProduct())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDTO> findById(String id) {
        return productRepository.findById(id)
                .map(productMapper.mapToDTOProduct());
    }

    @Override
    public List<ProductDTO> findAllByProduct(String productName) {
        return productRepository.findByProductContainingIgnoreCaseOrderByProduct(productName)
                .stream()
                .map(productMapper.mapToDTOProduct())
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findAllByPriceLessThan(Double productPrice) {
        return productRepository.findAllByPriceLessThan(productPrice)
                .stream()
                .map(productMapper.mapToDTOProduct())
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findAllByPriceGreaterThan(Double productPrice) {
        return productRepository.findAllByPriceGreaterThan(productPrice)
                .stream()
                .map(productMapper.mapToDTOProduct())
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findAllByPrice(Double productPrice) {
        return productRepository.findAllByPrice(productPrice)
                .stream()
                .map(productMapper.mapToDTOProduct())
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> fetchData() {

        List<ApiProductDTO> apiProductDTOS = webClientAdapter.retrieveAllProducts();

        List<Product> products = apiProductDTOS.stream()
                .map(apiProductMapper.mapToDTOApiProducto())
                .collect(Collectors.toList());

        return productRepository.saveAll(products).stream()
                .map(productMapper.mapToDTOProduct())
                .collect(Collectors.toList());
    }

}
