package com.co.pruebaimagine.backend_parte1.adapters.queries;

import com.co.pruebaimagine.backend_parte1.application.service.user.UserService;
import com.co.pruebaimagine.backend_parte1.domain.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/query/user")
// React project route
@CrossOrigin(origins = "http://localhost:3000")
public class UserQueryController {

    /*
     * GET -> consult
     * POST -> create
     * PUT -> Edit
     * DELETE -> delete
     * */

    private final UserService userService;

    // list user
    // localhost:8080/api/query//user/listUser
    @GetMapping("/listUser")
    public ResponseEntity<List<UserDTO>> listUser(){
        return new ResponseEntity<>(userService.listUser(), HttpStatus.OK);
    }

    // find by id
    // localhost:8080/api/query/user/findUserById?id={id}
    @GetMapping("/findUserById")
    public ResponseEntity<Optional<UserDTO>> findById(@RequestParam String id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    // find by username
    // localhost:8080/api/query/user/findByUserName?na={name}
    @GetMapping("/findByUserName")
    public ResponseEntity<List<UserDTO>>findByUserName(@RequestParam(name="na") String name){
        return new ResponseEntity<>(userService.findByUserName(name), HttpStatus.OK);
    }
}
