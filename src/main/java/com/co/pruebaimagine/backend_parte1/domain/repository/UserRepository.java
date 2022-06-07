package com.co.pruebaimagine.backend_parte1.domain.repository;

import com.co.pruebaimagine.backend_parte1.domain.collections.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    // find by name
    List<User> findAllByUserNameContainingIgnoreCaseOrderByUserName(String name);
}
