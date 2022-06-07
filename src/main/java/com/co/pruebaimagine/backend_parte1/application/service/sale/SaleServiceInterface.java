package com.co.pruebaimagine.backend_parte1.application.service.sale;

import com.co.pruebaimagine.backend_parte1.domain.dto.ProductDTO;
import com.co.pruebaimagine.backend_parte1.domain.dto.SaleDTO;
import com.co.pruebaimagine.backend_parte1.domain.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface SaleServiceInterface {

    //save all data
    List<SaleDTO> fillDataSale(List<SaleDTO> saleDTOS);

    // find by id
    Optional<SaleDTO> findById(String id);

    // find products by userId
    List<ProductDTO> findAllProductsByUserId(String userId);

    // save user
    SaleDTO saveSale(SaleDTO saleDTO);

}
