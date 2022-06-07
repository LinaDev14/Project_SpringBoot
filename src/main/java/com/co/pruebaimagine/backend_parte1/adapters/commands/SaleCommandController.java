package com.co.pruebaimagine.backend_parte1.adapters.commands;

import com.co.pruebaimagine.backend_parte1.application.service.sale.SaleService;
import com.co.pruebaimagine.backend_parte1.domain.dto.SaleDTO;
import com.co.pruebaimagine.backend_parte1.domain.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/command/sale")
// React project route
@CrossOrigin(origins = "http://localhost:3000")
public class SaleCommandController {

    /*
     * GET -> consult
     * POST -> create
     * PUT -> Edit
     * DELETE -> delete
     * */

    private final SaleService saleService;

    //fill Data
    // localhost:8080/api/command/sale/fillDataSale
    @PostMapping("/fillDataSale")
    public ResponseEntity<List<SaleDTO>> saveAll(@RequestBody List<SaleDTO> saleDTOS){
        return new ResponseEntity<>(saleService.fillDataSale(saleDTOS), HttpStatus.OK);
    }

    // save sale
    // localhost:8080/api/command/sale/saveSale
    @PostMapping("/saveSale")
    public ResponseEntity<SaleDTO> saveSale(@RequestBody SaleDTO saleDTO){
        return new ResponseEntity<>(saleService.saveSale(saleDTO), HttpStatus.CREATED);
    }
}
