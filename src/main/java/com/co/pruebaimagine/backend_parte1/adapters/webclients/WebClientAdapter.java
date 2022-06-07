package com.co.pruebaimagine.backend_parte1.adapters.webclients;

import com.co.pruebaimagine.backend_parte1.domain.dto.ApiProductDTO;
import com.co.pruebaimagine.backend_parte1.domain.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static com.co.pruebaimagine.backend_parte1.adapters.webclients.Constants.GET_ALL_PRODUCTS;

@Component
@RequiredArgsConstructor
public class WebClientAdapter {


    //https://fakestoreapi.com/products
    private static  final String baseUrl = "https://fakestoreapi.com/products";
    private final WebClient webClient = WebClient.create(baseUrl);

    public List<ApiProductDTO> retrieveAllProducts(){

        return webClient.get()
                .uri("https://fakestoreapi.com/products")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<ApiProductDTO>>() {})
                .block();
    }

    /*public List<ProductDTO> fetchApi(String apiUrl){
        return webClient
                .get()
                .uri(apiUrl)
                .retrieve()
                .bodyToFlux(ProductDTO.class)
                .collectList()
                .block();
    }*/

}
