package com.co.pruebaimagine.backend_parte1.application.mappers;

import com.co.pruebaimagine.backend_parte1.domain.collections.Sale;
import com.co.pruebaimagine.backend_parte1.domain.dto.SaleDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SaleMapper {

    public Function<Sale, SaleDTO> mapToDTOSale(){

        return sale -> new SaleDTO(
                sale.getId(),
                sale.getUserId(),
                sale.getProductId()
        );
    }

    public Function<SaleDTO, Sale> mapToCollectionSale(){

        return saleDTO -> new Sale(
                saleDTO.getId(),
                saleDTO.getUserId(),
                saleDTO.getProductId()
        );
    }
}
