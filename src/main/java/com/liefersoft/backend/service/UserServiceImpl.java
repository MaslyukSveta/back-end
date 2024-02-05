package com.liefersoft.backend.service;


import com.liefersoft.backend.model.User;
import com.liefersoft.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registrationUser(User user) {
        return userRepository.save(user);
    }


}
