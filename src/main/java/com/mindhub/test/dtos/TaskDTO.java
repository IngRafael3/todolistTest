package com.mindhub.test.dtos;


import com.mindhub.test.models.EnumTask;
import com.mindhub.test.models.Tasks;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class TaskDTO {

    private Long id;
    private String title, description;
    @Enumerated(EnumType.STRING)
    private EnumTask status;
    private Long userId;


    public TaskDTO(Tasks tasks) {
        this.id = tasks.getId();
        this.title = tasks.getTitle();
        this.description = tasks.getDescription();
        this.status = tasks.getStatus();
        this.userId = tasks.getUser().getId();
    }

    public TaskDTO() {
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

    public String getDescription() {
        return description;
    }

    public EnumTask getStatus() {
        return status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(EnumTask status) {
        this.status = status;
    }
}
