package com.liefersoft.backend.service;

import com.liefersoft.backend.model.User;
import com.liefersoft.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of the UserService interface.
 * This class is marked with @Service to indicate that it's a Spring service class.
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * Injects the UserRepository dependency.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Implementation of the registrationUser method from UserService.
     * This method uses UserRepository to save the User entity to the database.
     *
     * @param user The User object to be registered.
     * @return The User object saved in the database, typically with its ID set.
     */
    @Override
    public User registrationUser(User user) {
        return userRepository.save(user);
    }


}
