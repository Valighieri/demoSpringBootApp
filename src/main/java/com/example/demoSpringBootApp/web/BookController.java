package com.example.demoSpringBootApp.web;

import com.example.demoSpringBootApp.domain.Book;
import com.example.demoSpringBootApp.dto.BookDto;
import com.example.demoSpringBootApp.service.book.BookService;
import com.example.demoSpringBootApp.util.mappers.BookMapper;
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
    private final BookMapper bookMapper;

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book saveBook(@RequestBody BookDto bookDto){
        log.debug("saveBook() - start: book = {}", bookDto);
        Book response = bookService.create(
                bookMapper.toBook(bookDto)
        );
        log.debug("saveBook() - stop: book_id = {}", response.getId());
        return response;
    }

    @GetMapping("/books/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Book getBookById(@PathVariable Integer id){
        log.debug("saveBook() - start: book id = {}", id);
        Book response = bookService.getById(id);
        log.debug("saveBook() - stop: book = {}", response);
        return response;
    }
}
