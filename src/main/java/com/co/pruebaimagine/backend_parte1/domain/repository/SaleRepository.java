package com.co.pruebaimagine.backend_parte1.domain.repository;

import com.co.pruebaimagine.backend_parte1.domain.collections.Sale;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SaleRepository extends MongoRepository<Sale, String> {

    public List<Sale> findAllByUserId(String userId);
}
