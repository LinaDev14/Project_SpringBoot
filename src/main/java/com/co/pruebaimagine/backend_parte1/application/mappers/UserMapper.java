package com.co.pruebaimagine.backend_parte1.application.mappers;

import com.co.pruebaimagine.backend_parte1.domain.collections.User;
import com.co.pruebaimagine.backend_parte1.domain.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserMapper {

    public Function<User, UserDTO> mapToDTOUser(){

        return user -> new UserDTO(
                user.getId(),
                user.getUserName(),
                user.getPassword(),
                user.getCity(),
                user.getEmail(),
                user.getPhoneNumber()
        );
    }

    public Function<UserDTO, User> mapToCollectionUser(){

        return userDTO ->  new User(
                userDTO.getId(),
                userDTO.getUserName(),
                userDTO.getPassword(),
                userDTO.getCity(),
                userDTO.getEmail(),
                userDTO.getPhoneNumber()
        );
    }
}
