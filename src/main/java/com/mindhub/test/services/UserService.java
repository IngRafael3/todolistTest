package com.mindhub.test.services;

import com.mindhub.test.dtos.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    //UserEntity findById(Long id);
    Optional<UserDTO> findById(Long id);

    List<UserDTO> findAll();

    UserDTO createNewUser(UserDTO userDTO);

    UserDTO updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);
}
