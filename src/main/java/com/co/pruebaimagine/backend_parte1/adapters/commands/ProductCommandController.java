package com.co.pruebaimagine.backend_parte1.adapters.commands;

import com.co.pruebaimagine.backend_parte1.application.service.product.ProductService;
import com.co.pruebaimagine.backend_parte1.domain.dto.ProductDTO;
import com.co.pruebaimagine.backend_parte1.domain.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/command/product")
// React project route
@CrossOrigin(origins = "http://localhost:3000")
public class ProductCommandController {

    private final ProductService productService;

    // fetch Data
    // localhost:8080/api/command/product/fetchData
    @PostMapping("/fetchData")
    public ResponseEntity<List<ProductDTO>> saveAll(){
        return new ResponseEntity<>(productService.fetchData(), HttpStatus.OK);
    }
}
