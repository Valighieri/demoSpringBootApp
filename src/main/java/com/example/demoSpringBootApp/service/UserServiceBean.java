package com.example.demoSpringBootApp.service;

import com.example.demoSpringBootApp.domain.User;
import com.example.demoSpringBootApp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceBean implements UserService{

    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }
}
