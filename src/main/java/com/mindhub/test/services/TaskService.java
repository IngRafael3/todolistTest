package com.mindhub.test.services;

import com.mindhub.test.dtos.TaskDTO;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    //Tasks findById(Long id);

    Optional<TaskDTO> findById(Long id);

    //List<Tasks> findAll();
    List<TaskDTO> findAll();

    TaskDTO createNewTask(TaskDTO taskDTO);

    TaskDTO updateTask(Long id, TaskDTO taskDTO);

    void deleteTask(Long id);


}