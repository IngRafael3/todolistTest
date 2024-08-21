package com.mindhub.test.controller;

import com.mindhub.test.controllers.TaskController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(TaskController.class)
@SpringBootTest
public class TaskControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;


    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testCreateTask() throws Exception {
        String taskJson = "{ \"title\": \"Test Task\", \"description\": \"Description\" }";

        mockMvc.perform(post("/api/tarea/createdTask")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(taskJson))
                .andExpect(status().isCreated())  // Verifica que la respuesta sea 201 Created.
                .andExpect(jsonPath("$.title").value("Test Task"))  // Verifica el contenido del JSON devuelto.
                .andExpect(jsonPath("$.description").value("Description"));
    }

    @Test
    public void testPutTask()throws Exception{
        String requestBody = "{\"title\":\"nuevaTarea\"}";
        mockMvc.perform(put("/api/tarea/updatetask/1")
                        .contentType("application/json")
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("nuevaTarea"));
    }

    @Test
    public void testDeleteTask()throws Exception{
        mockMvc.perform(delete("/api/tarea/delete/1"))
                .andExpect(status().isOk());
    }
}
