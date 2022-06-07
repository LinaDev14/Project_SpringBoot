package com.co.pruebaimagine.backend_parte1.application.utils;

import com.co.pruebaimagine.backend_parte1.domain.dto.UserDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Getter
public class JsonReader {

    private final String path = "src/main/java/com/co/pruebaimagine/backend_parte1/domain/utils/Data.json";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private List<UserDTO> userDTO;

    public JsonReader(){
        try{
            userDTO = objectMapper.readValue(new File(path), new TypeReference<>() {});
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
