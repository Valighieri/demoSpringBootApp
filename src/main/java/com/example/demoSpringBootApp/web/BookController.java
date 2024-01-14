package com.example.demoSpringBootApp.web;

import com.example.demoSpringBootApp.domain.Book;
import com.example.demoSpringBootApp.service.book.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book saveBook(@RequestBody Book book){
        log.debug("saveBook() - start: book = {}" + book);
        var response = bookService.create(book);
        log.debug("saveBook() - stop: book id = {}" + response.getId());
        return response;
    }
}
