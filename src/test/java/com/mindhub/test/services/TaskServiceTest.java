package com.mindhub.test.services;

import com.mindhub.test.dtos.TaskDTO;
import com.mindhub.test.models.EnumTask;
import com.mindhub.test.models.Tasks;
import com.mindhub.test.models.UserEntity;
import com.mindhub.test.repositories.TaskRepository;
import com.mindhub.test.repositories.UserEntityRepository;
import com.mindhub.test.services.impl.TaskServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private UserEntityRepository userEntityRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById_Success() {
        Tasks task = new Tasks();
        task.setId(1L);
        task.setTitle("Test Task");
        task.setDescription("This is a test task.");
        task.setUser(new UserEntity());
        task.getUser().setId(1L);
        task.setStatus(EnumTask.PENDING);

        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        TaskDTO taskDTO = taskService.findById(1L).orElse(null);

        assertNotNull(taskDTO);
        assertEquals(1L, taskDTO.getId());
        assertEquals("Test Task", taskDTO.getTitle());
    }

    @Test
    void testFindById_NotFound() {
        when(taskRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<TaskDTO> taskDTO = taskService.findById(1L);

        assertFalse(taskDTO.isPresent());
    }

    @Test
    void testFindAll() {
        Tasks task1 = new Tasks();
        task1.setId(1L);
        task1.setTitle("Test Task 1");
        task1.setDescription("This is a test task.");
        task1.setUser(new UserEntity());
        task1.getUser().setId(1L);
        task1.setStatus(EnumTask.PENDING);

        Tasks task2 = new Tasks();
        task2.setId(2L);
        task2.setTitle("Test Task 2");
        task2.setDescription("This is a test task.");
        task2.setUser(new UserEntity());
        task2.getUser().setId(2L);
        task2.setStatus(EnumTask.PENDING);

        when(taskRepository.findAll()).thenReturn(List.of(task1, task2));

        List<TaskDTO> taskDTOs = taskService.findAll();

        assertEquals(2, taskDTOs.size());
        assertEquals("Test Task 1", taskDTOs.get(0).getTitle());
    }

    @Test
    void testCreateNewTask() {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("New Task");
        taskDTO.setDescription("Task description");
        taskDTO.setStatus(EnumTask.PENDING);

        UserEntity user = new UserEntity();
        user.setId(1L);

        Tasks task = new Tasks();
        task.setId(1L);
        task.setTitle("New Task");
        task.setDescription("Task description");
        task.setStatus(EnumTask.PENDING);
        task.setUser(user);

        when(userEntityRepository.findById(1L)).thenReturn(Optional.of(user));
        when(taskRepository.save(any(Tasks.class))).thenReturn(task);

        TaskDTO createdTaskDTO = taskService.createNewTask(taskDTO);

        assertNotNull(createdTaskDTO);
        assertEquals("New Task", createdTaskDTO.getTitle());
    }


    @Test
    void testDeleteTask() {
        when(taskRepository.existsById(1L)).thenReturn(true);

        taskService.deleteTask(1L);

        verify(taskRepository, times(1)).deleteById(1L);
    }
}
