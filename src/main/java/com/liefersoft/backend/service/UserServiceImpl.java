package com.liefersoft.backend.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.liefersoft.backend.model.User;
import com.liefersoft.backend.repository.UserRepository;

import java.util.Optional;

/**
 * Service implementation for user-related operations.
 * This class is annotated with @Service, marking it as a Spring-managed service class.
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * Logger for logging important actions and exceptions.
     */
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * Repository for performing database operations on User entities.
     * The final keyword ensures that the repository is immutable once it's initialized.
     */
    private final UserRepository userRepository;

    /**
     * Constructor for UserServiceImpl.
     * @param userRepository Repository for user-related database operations.
     * Autowired by Spring to inject the UserRepository bean.
     */
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Registers a new user in the system.
     * This method first checks if a user with the same first name, last name, and phone number
     * already exists in the database. If such a user exists, it throws a RuntimeException
     * to prevent duplicate entries. If no such user exists, it saves the new user to the database.
     *
     * @param user The User object containing information about the user to be registered.
     *             It should include the user's first name, last name, and phone number.
     * @return The saved User object with additional data populated (like the generated ID).
     *         This object is returned after successful registration in the database.
     * @throws RuntimeException if a user with the same first name, last name, and phone number
     *                          already exists or if there is an error during the database operation.
     */

    @Override
    public User registrationUser(User user) {
        // Check if user already exists
        Optional<User> existingUser = userRepository.findByFirstNameAndLastNameAndPhoneNumber(
                user.getFirstName(), user.getLastName(), user.getPhoneNumber()
        );

        if (existingUser.isPresent()) {
            // You might want to throw a specific exception or handle this case differently
            throw new RuntimeException("User already exists with provided name, surname, and phone number");
        }

        try {
            User savedUser = userRepository.save(user);
            logger.info("User registered successfully: {}", savedUser);
            return savedUser;
        } catch (Exception e) {
            logger.error("Error registering user: {}", e.getMessage());
            throw new RuntimeException("Registration failed", e);
        }
    }


}
