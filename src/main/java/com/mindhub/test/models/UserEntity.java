package com.mindhub.test.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username, password;

    @Column(unique = true)
    private String  email;

    private RolEnum rol = RolEnum.ADMIN;

    @OneToMany( mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Tasks> tarea = new HashSet<>();

    public UserEntity(String username, String password, String email, RolEnum rol) {

        this.username = username;
        this.password = password;
        this.email = email;
        this.rol = rol;

    }

    public UserEntity() {
    }

    public RolEnum getRol() {
        return rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Set<Tasks> getTarea() {
        return tarea;
    }

    public void addTasks(Tasks task) {
        task.setUser(this);
        tarea.add(task);
    }
}
