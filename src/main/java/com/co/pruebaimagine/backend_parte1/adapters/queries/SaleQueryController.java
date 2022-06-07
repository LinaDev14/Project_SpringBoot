package com.co.pruebaimagine.backend_parte1.adapters.queries;

import com.co.pruebaimagine.backend_parte1.application.service.sale.SaleService;
import com.co.pruebaimagine.backend_parte1.domain.dto.ProductDTO;
import com.co.pruebaimagine.backend_parte1.domain.dto.SaleDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/query/sale")
// React project route
@CrossOrigin(origins = "http://localhost:3000")
public class SaleQueryController {

    /*
     * GET -> consult
     * POST -> create
     * PUT -> Edit
     * DELETE -> delete
     * */

    private final SaleService saleService;

    // find by id
    // localhost:8080/api/query/sale/findById?id={id}
    @GetMapping("/findUserById")
    public ResponseEntity<Optional<SaleDTO>> findById(@RequestParam String id){
        return new ResponseEntity<>(saleService.findById(id), HttpStatus.OK);
    }

    // find products by userId
    // localhost:8080/api/query/sale/findAllProductsByUserId?userId={id}
    @GetMapping("/findAllProductsByUserId")
    public ResponseEntity<List<ProductDTO>> findAllProductsByUserId(@RequestParam String userId){
        return new ResponseEntity<>(saleService.findAllProductsByUserId(userId), HttpStatus.OK);
    }

}
