package com.example.demoSpringBootApp.service.book;

import com.example.demoSpringBootApp.domain.Book;
import com.example.demoSpringBootApp.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceBean implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getById(Integer id) {
        return bookRepository.findById(id)
                .filter(this::isBookPresent)
                .orElseThrow(() -> new EntityNotFoundException
                        ("Book not found with id = " + id));
    }

    @Override
    public Book getHiddenBookById(Integer id) {
        return bookRepository.findById(id)
                .filter(entity -> !isBookPresent(entity))
                .orElseThrow(() -> new EntityNotFoundException
                        ("Book doesn't exist or available with id = " + id));
    }


    private boolean isBookPresent(Book book) {
        if (book.getIsHandled().equals(Boolean.TRUE)) return false;
        else return true;
    }
}
