package com.co.pruebaimagine.backend_parte1.application.service.sale;

import com.co.pruebaimagine.backend_parte1.application.mappers.ProductMapper;
import com.co.pruebaimagine.backend_parte1.application.mappers.SaleMapper;
import com.co.pruebaimagine.backend_parte1.domain.collections.Product;
import com.co.pruebaimagine.backend_parte1.domain.collections.Sale;
import com.co.pruebaimagine.backend_parte1.domain.dto.ProductDTO;
import com.co.pruebaimagine.backend_parte1.domain.repository.ProductRepository;
import com.co.pruebaimagine.backend_parte1.domain.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import com.co.pruebaimagine.backend_parte1.domain.dto.SaleDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SaleService implements  SaleServiceInterface{

    private final SaleRepository saleRepository;
    private final SaleMapper saleMapper;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<SaleDTO> fillDataSale(List<SaleDTO> saleDTOS) {
        return saleRepository.saveAll(saleDTOS.stream()
                .map(saleMapper.mapToCollectionSale())
                .collect(Collectors.toList()))
                .stream()
                .map(saleMapper.mapToDTOSale())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SaleDTO> findById(String id) {
        return saleRepository.findById(id)
                .map(saleMapper.mapToDTOSale());
    }

    @Override
    public List<ProductDTO> findAllProductsByUserId(String userId) {

        List<Sale> sales = saleRepository.findAllByUserId(userId);

        List<String> productIds = sales
                .stream()
                .map(Sale::getProductId)
                .collect(Collectors.toList());

        List<ProductDTO> productDTOS = new ArrayList<>();

        productIds.forEach(productId -> {
            Optional<Product> product = productRepository.findById(productId);

            product.ifPresent(value -> productDTOS.add(productMapper.mapToDTOProduct().apply(value)));
        });

        return productDTOS;

    }

    @Override
    public SaleDTO saveSale(SaleDTO saleDTO) {
        return saleMapper.mapToDTOSale()
                .apply(saleRepository.save(saleMapper.mapToCollectionSale().apply(saleDTO)));

    }

}
