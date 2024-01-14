package com.example.demoSpringBootApp.service.book;

import com.example.demoSpringBootApp.domain.Book;
import com.example.demoSpringBootApp.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceBean implements BookService{

    private final BookRepository bookRepository;

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }
}
