package com.liefersoft.backend.controller;

import com.liefersoft.backend.model.User;
import com.liefersoft.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;



/**
 * Controller class for handling user-related requests.
 * Annotated with @RestController, indicating that it is a RESTful controller.
 */
@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    /**
     * Injects UserService dependency.
     */
    @Autowired
    private UserService userService;

    /**
     * Constructor for UserController.
     * @param userService Service to handle user-related operations.
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Handles the user registration requests.
     * Accepts POST requests at /users/registration.
     *
     * @param user User data from the request body.
     * @return A confirmation string.
     */
    @PostMapping("/registration")
    public ResponseEntity<String> add(@Validated @RequestBody User user) {
        try {
            userService.registrationUser(user);
            logger.info("New user registered: {}", user);
            return ResponseEntity.ok("New user is registered successfully.");
        } catch (Exception e) {
            logger.error("Error registering user: {}", e.getMessage());
            return ResponseEntity.badRequest().body("Error during registration.");
        }
    }

}
