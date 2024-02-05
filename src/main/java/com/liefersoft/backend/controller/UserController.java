package com.liefersoft.backend.controller;

import com.liefersoft.backend.model.User;
import com.liefersoft.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling user-related requests.
 * Annotated with @RestController, indicating that it is a RESTful controller.
 */
@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

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
    public String add(@RequestBody User user){
        userService.registrationUser(user);
        return "New student is added";
    }

}
