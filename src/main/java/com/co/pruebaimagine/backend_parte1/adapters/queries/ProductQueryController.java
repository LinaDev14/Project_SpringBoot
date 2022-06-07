package com.co.pruebaimagine.backend_parte1.adapters.queries;

import com.co.pruebaimagine.backend_parte1.application.service.product.ProductService;
import com.co.pruebaimagine.backend_parte1.domain.dto.ProductDTO;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/query/product")
// React project route
@CrossOrigin(origins = "http://localhost:3000")
public class ProductQueryController {

    /*
     * GET -> consult
     * POST -> create
     * PUT -> Edit
     * DELETE -> delete
     * */

    private final ProductService productService;

    // list products
    // localhost:8080/api/query/product/listUser
    @GetMapping("/listProduct")
    public ResponseEntity<List<ProductDTO>> listProduct(){
        return new ResponseEntity<>(productService.listProduct(), HttpStatus.OK);
    }

    // find by id
    // localhost:8080/api/query/product/findById?id={id}
    @GetMapping("/findProductById")
    public ResponseEntity<Optional<ProductDTO>> findById(@RequestParam String id){
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    // find by productName
    // localhost:8080/api/query/product/findAllByProductName?na={name}
    @GetMapping("/findAllByProductName")
    public ResponseEntity<List<ProductDTO>>findAllProduct(@RequestParam(name="na") String name){
        return new ResponseEntity<>(productService.findAllByProduct(name), HttpStatus.OK);
    }

    // find by price less than
    // localhost:8080/api/query/product/findByAllPriceLessThan?pc={price}
    @GetMapping("/findAllByPriceLessThan")
    public ResponseEntity<List<ProductDTO>>findAllByPriceLessThan(@RequestParam(name="pc") Double price){
        return new ResponseEntity<>(productService.findAllByPriceLessThan(price), HttpStatus.OK);
    }

    // find by price greater than
    // localhost:8080/api/query/product/findByAllPriceGreaterThan?pc={price}
    @GetMapping("/findAllByPriceGreaterThan")
    public ResponseEntity<List<ProductDTO>>findAllByPriceGreaterThan(@RequestParam(name="pc") Double price){
        return new ResponseEntity<>(productService.findAllByPriceGreaterThan(price), HttpStatus.OK);
    }

    // find by price
    // localhost:8080/api/query/product/findAllByPrice?pc={price}
    @GetMapping("/findAllByPrice")
    public ResponseEntity<List<ProductDTO>>findAllByPrice(@RequestParam(name="pc") Double price){
        return new ResponseEntity<>(productService.findAllByPrice(price), HttpStatus.OK);
    }
}
