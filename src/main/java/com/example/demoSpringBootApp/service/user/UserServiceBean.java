package com.example.demoSpringBootApp.service.user;

import com.example.demoSpringBootApp.domain.User;
import com.example.demoSpringBootApp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceBean implements UserService {

    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }
}
