package com.liefersoft.backend.service;

import com.liefersoft.backend.model.User;

/**
 * Interface for the user service.
 * Defines the contract for services related to user operations.
 */
public interface UserService {

    /**
     * Method for registering a new user.
     * This method is intended to handle the business logic associated with user registration.
     *
     * @param user The User object containing information about the user to be registered.
     * @return The registered User object, typically with additional information such as an ID set.
     */
    User registrationUser(User user);

}
