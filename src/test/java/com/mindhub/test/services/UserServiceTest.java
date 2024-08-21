package com.mindhub.test.services;

import com.mindhub.test.dtos.UserDTO;
import com.mindhub.test.models.UserEntity;
import com.mindhub.test.repositories.UserEntityRepository;
import com.mindhub.test.services.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    private UserEntityRepository userEntityRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById(){
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setUsername("prueba");
        user.setEmail("algo@gmail.com");
        user.setPassword("123456");

        when(userEntityRepository.findById(1L)).thenReturn(Optional.of(user));

        UserDTO userDTO = userService.findById(1L).orElse(null);
        assertNotNull(userDTO);
        assertEquals(1L, userDTO.getId());
        assertEquals("prueba", userDTO.getUsername());
    }
}
