package com.mindhub.test.controllers;


import com.mindhub.test.dtos.UserDTO;
import com.mindhub.test.repositories.UserEntityRepository;
import com.mindhub.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserEntityRepository userEntityRepository;


    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id){
        return userService.findById(id).orElse(null);
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        UserDTO created = userService.createNewUser(userDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }


}
