package com.example.demoSpringBootApp.service.book;

import com.example.demoSpringBootApp.domain.Book;

import java.util.List;

public interface BookService {
    Book create(Book book);

    Book getById(Integer id);

    Book getHiddenBookById(Integer id);

    List<Book> getAll();

    List<Book> getAllHidden();
}
