package com.mindhub.test.controllers;



import com.mindhub.test.dtos.TaskDTO;
import com.mindhub.test.services.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarea")
@CrossOrigin("*")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @GetMapping("/{id}")
    @Operation(summary = "Get ", description = "Retrieve a Task entity by its ID.")
    public TaskDTO geTaskById(@PathVariable Long id){
        return taskService.findById(id).orElse(null);
    }

    @GetMapping("/alltask")
    @Operation(summary = "Get ", description = "Retrieve all Task entities.")
    public ResponseEntity<List<TaskDTO>> geTaskById(){
        List<TaskDTO> allTask =  taskService.findAll();
        return new ResponseEntity<>( allTask, HttpStatus.OK);
    }


    @PostMapping("/createdTask")
    @Operation(summary = "POST ", description = "Create a new Task entity.")
    public ResponseEntity<TaskDTO> createdNewTask(@RequestBody TaskDTO taskDTO){
        TaskDTO create = taskService.createNewTask(taskDTO);
        return new ResponseEntity<>(create, HttpStatus.CREATED);
    }

    @PutMapping("/updatetask/{id}")
    @Operation(summary = "UPDATE ", description = "Update an existing Task entity.")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO){
        TaskDTO updateTask = taskService.updateTask(id, taskDTO);
        return new ResponseEntity<>(updateTask, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete ", description = "Delete a Task entity by its ID.")
    public ResponseEntity<String> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.ok("");
    }
}

