package com.liefersoft.backend.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liefersoft.backend.model.User;
import com.liefersoft.backend.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Test class for UserController.
 * This class uses Mockito to mock the UserService and tests the controller's behavior.
 */
public class UserControllerTest {


    private MockMvc mockMvc;

    /**
     * Mock annotation for UserService.
     * Creates a mock implementation of UserService to be used in the tests.
     */
    @Mock
    private UserService userService;

    /**
     * InjectMocks annotation for UserController.
     * This injects the mocked UserService into the UserController being tested.
     */
    @InjectMocks
    private UserController userController;

    /**
     * Setup method, annotated with BeforeEach to run before each test method.
     * Initializes the mock objects and sets up the MockMvc environment.
     */
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = standaloneSetup(userController).build();
    }

    /**
     * Test method for the addUser method in UserController.
     * This test simulates the user registration process and verifies the response.
     *
     * @throws Exception if any exception occurs during request processing.
     */
    @Test
    public void testAddUser() throws Exception {
        User mockUser = new User("John", "Doe", "1234567890", "Male");
        when(userService.registrationUser(any(User.class))).thenReturn(mockUser);

        ObjectMapper objectMapper = new ObjectMapper();
        String userJson = objectMapper.writeValueAsString(mockUser);

        mockMvc.perform(post("/users/registration")
                        .contentType("application/json")
                        .content(userJson))
                .andExpect(status().isOk())
                .andExpect(content().string("New user is registered successfully."));

        verify(userService, times(1)).registrationUser(any(User.class));
    }
}
