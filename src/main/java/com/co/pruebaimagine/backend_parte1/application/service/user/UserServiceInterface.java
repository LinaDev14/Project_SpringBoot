package com.co.pruebaimagine.backend_parte1.application.service.user;

import com.co.pruebaimagine.backend_parte1.domain.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {

    // basic crud services

    // save all data
    List<UserDTO> fillData(List<UserDTO> userDTO);

    // list user
    List<UserDTO> listUser();

    // find by id
    Optional<UserDTO> findById(String id);

    // save user
    UserDTO saveUser(UserDTO userDTO);

    // update user
    UserDTO updateUser(UserDTO userDTO);

    // delete user
    void deleteUser(String id);

    // delete all resource
    void deleteAllUsers();

    // find by Username
    List<UserDTO> findByUserName(String userName);
}
