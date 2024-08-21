package com.mindhub.test.services.impl;

import com.mindhub.test.dtos.UserDTO;
import com.mindhub.test.models.UserEntity;
import com.mindhub.test.repositories.UserEntityRepository;
import com.mindhub.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserEntityRepository userEntityRepository;

   /* @Override
    public UserEntity findById(Long id) {
        return userEntityRepository.findById(id).orElseThrow( ()-> new NotFoundUserException("no existe usuario con id "+ id));
    }*/

    @Override
    public Optional<UserDTO> findById(Long id) {
        return userEntityRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public List<UserDTO> findAll(){
        return userEntityRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
/*    public List<Tasks> findAll(){
        return taskRepository.findAll();
    }*/

//

    private UserDTO convertToDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setUsername(userEntity.getUsername());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setRol(userEntity.getRol());

        return userDTO;

    }

    @Override
    public UserDTO createNewUser(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDTO.getId());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(userDTO.getPassword());
        //UserEntity user1 = userEntityRepository.findById(1L).orElse(null);
        // tasks1.setUser(user1);
        UserEntity savedUser = userEntityRepository.save(userEntity);
        return convertToDTO(savedUser);
    }
    //

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        UserEntity user = userEntityRepository.findById(id).orElseThrow();
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());

        return convertToDTO(user);
    }

    @Override
    public void deleteUser(Long id){
        if (userEntityRepository.existsById(id)){
            userEntityRepository.deleteById(id);
        }

    }
}
