package com.co.pruebaimagine.backend_parte1.domain.collections;


import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "users")
public class User {

    @Id
    private final String id;

    private final String userName;
    private final String password;
    private final String city;
    private final String email;
    private final String phoneNumber;
    
}
