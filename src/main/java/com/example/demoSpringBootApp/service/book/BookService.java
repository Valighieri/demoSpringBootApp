package com.example.demoSpringBootApp.service.book;

import com.example.demoSpringBootApp.domain.Book;

public interface BookService {
    Book create(Book book);

    Book getById(Integer id);

    Book getHiddenBookById(Integer id);
}
