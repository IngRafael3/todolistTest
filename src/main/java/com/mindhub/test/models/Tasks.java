package com.mindhub.test.models;


import jakarta.persistence.*;

@Entity
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title, description;
    @Enumerated(EnumType.STRING)
    private EnumTask status;

    @ManyToOne( fetch = FetchType.LAZY)
    private UserEntity user;

    public Tasks() {
    }

    public Tasks( String title, String description, EnumTask status) {
        this.title = title;
        this.description = description;
        this.status = status;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EnumTask getStatus() {
        return status;
    }

    public void setStatus(EnumTask status) {
        this.status = status;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
