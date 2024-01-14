package com.example.demoSpringBootApp.service.user;

import com.example.demoSpringBootApp.domain.User;

public interface UserService {
    User create(User user);

    User borrowBook(Integer userId, Integer bookId);

    User returnBook(Integer userId, Integer bookId);
}
