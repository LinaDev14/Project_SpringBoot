package com.co.pruebaimagine.backend_parte1.adapters.commands;

import com.co.pruebaimagine.backend_parte1.application.service.user.UserService;
import com.co.pruebaimagine.backend_parte1.domain.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/command/user")
// React project route
@CrossOrigin(origins = "http://localhost:3000")
public class UserCommandController {

    /*
    * GET -> consult
    * POST -> create
    * PUT -> Edit
    * DELETE -> delete
    * */

    private final UserService userService;

    // fill Data
    // localhost:8080/api/command/user/fillData
    @PostMapping("/fillData")
    public ResponseEntity<List<UserDTO>> saveAll(@RequestBody List<UserDTO> userDTO){
        return new ResponseEntity<>(userService.fillData(userDTO), HttpStatus.OK);
    }

    // save user
    // localhost:8080/api/command/user/saveUser
    @PostMapping("/saveUser")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.saveUser(userDTO), HttpStatus.CREATED);
    }

    // update user
    // localhost:8080/api/command/user/updateUser
    @PutMapping("/updateUser")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO ){
        return new ResponseEntity<>(userService.updateUser(userDTO), HttpStatus.ACCEPTED);
    }

    // delete user
    // localhost:8080/api/command/user/deleteUserById?id={}
    @DeleteMapping("/deleteUserById")
    public ResponseEntity<HttpStatus> deleteUser(@RequestParam String id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // delete All
    // localhost:8080/api/command/user/deleteAll
    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllUsers(){
        userService.deleteAllUsers();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
