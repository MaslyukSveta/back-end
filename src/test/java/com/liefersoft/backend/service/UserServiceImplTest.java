package com.liefersoft.backend.service;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.liefersoft.backend.model.User;
import com.liefersoft.backend.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Test class for UserServiceImpl.
 * This class uses Mockito for mocking dependencies and JUnit for testing.
 */
public class UserServiceImplTest {

    /**
     * Mock annotation for UserRepository.
     * This creates a mock implementation for the repository to be used in tests.
     */
    @Mock
    private UserRepository userRepository;

    /**
     * InjectMocks annotation for UserServiceImpl.
     * This injects the mocked dependencies into the service being tested.
     */
    @InjectMocks
    private UserServiceImpl userService;

    /**
     * Setup method, annotated with BeforeEach to run before each test method.
     * Initializes mocks before each test execution.
     */
    @BeforeEach
    public void setup() {

        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test method for the registrationUser method of UserServiceImpl.
     * This test ensures that the user registration process works as expected.
     */
    @Test
    public void testRegisterUser() {

        User user = new User("Svitlana", "Masliuk", "0952101768", "Female");


        when(userRepository.save(any(User.class))).thenReturn(user);


        User savedUser = userService.registrationUser(user);


        assertNotNull(savedUser);
        assertEquals("Svitlana", savedUser.getFirstName());
        assertEquals("Masliuk", savedUser.getLastName());
        assertEquals("0952101768", savedUser.getPhoneNumber());
        assertEquals("Female", savedUser.getGender());
    }
}
