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
        // Initializes annotations for mock objects.
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test method for the registrationUser method of UserServiceImpl.
     * This test ensures that the user registration process works as expected.
     */
    @Test
    public void testRegisterUser() {
        // Creating a test user instance.
        User user = new User("Svitlana", "Masliuk", "0952101768", "Female");

        // Defining the behavior of the mocked UserRepository.
        // When save method is called with any User object, it will return the test user.
        when(userRepository.save(any(User.class))).thenReturn(user);

        // Calling the registrationUser method and storing the result.
        User savedUser = userService.registrationUser(user);

        // Assertions to check if the returned user has the expected values.
        assertNotNull(savedUser); // Check if the user is not null.
        assertEquals("Svitlana", savedUser.getFirstName()); // Check the first name.
        assertEquals("Masliuk", savedUser.getLastName()); // Check the last name.
        assertEquals("0952101768", savedUser.getPhoneNumber()); // Check the phone number.
        assertEquals("Female", savedUser.getGender()); // Check the gender.
    }
}
