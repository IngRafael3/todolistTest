package com.mindhub.test.dtos;


import com.mindhub.test.models.RolEnum;
import com.mindhub.test.models.UserEntity;

public class UserDTO {

    private Long id;

    private String username;
    private String password;
    private String  email;
    private RolEnum rol;

    public UserDTO(UserEntity userEntity) {
        this.username = userEntity.getUsername();
        this.email = userEntity.getEmail();
        this.id = userEntity.getId();
        this.rol = userEntity.getRol();
    }

    public UserDTO() {
    }

    public RolEnum getRol() {
        return rol;
    }

    public void setRol(RolEnum rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
