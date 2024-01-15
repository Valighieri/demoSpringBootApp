package com.example.demoSpringBootApp.service.history;

import com.example.demoSpringBootApp.domain.Book;
import com.example.demoSpringBootApp.domain.History;
import com.example.demoSpringBootApp.domain.User;

import java.util.List;

public interface HistoryService {

    History create(User user, Book book);

    History getById(Integer historyId);

    List<User> getAllWithDebts();

    List<Book> getTopFiveBooks();
}
