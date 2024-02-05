package com.liefersoft.backend.controller;


import com.liefersoft.backend.model.User;
import com.liefersoft.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/registration")
    public String add(@RequestBody User user){
        userService.registrationUser(user);
        return "New student is added";
    }


}
