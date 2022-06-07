package com.co.pruebaimagine.backend_parte1.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String id;

    private String userName;
    private String password;
    private String city;
    private String email;
    private String phoneNumber;
}
