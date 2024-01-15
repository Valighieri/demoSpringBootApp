package com.example.demoSpringBootApp.service.user;

import com.example.demoSpringBootApp.domain.Book;
import com.example.demoSpringBootApp.domain.User;

import java.util.List;

public interface UserService {
    User create(User user);

    User borrowBook(Integer userId, Integer bookId);

    User returnBook(Integer historyId);

    List<User> getAllInactiveUsers();
}
