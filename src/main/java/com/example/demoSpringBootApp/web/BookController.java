package com.example.demoSpringBootApp.web;

import com.example.demoSpringBootApp.domain.Book;
import com.example.demoSpringBootApp.dto.BookDto;
import com.example.demoSpringBootApp.dto.BookReadDto;
import com.example.demoSpringBootApp.service.book.BookService;
import com.example.demoSpringBootApp.util.mappers.BookMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
@AllArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public BookReadDto saveBook(@RequestBody BookDto bookDto){
        log.debug("saveBook() - start:");
        Book book = bookService.create(bookMapper.toBook(bookDto));
        BookReadDto response = bookMapper.toBookReadDto(book);
        log.debug("saveBook() - stop:");
        return response;
    }

    @GetMapping("/books/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public BookReadDto getBookById(@PathVariable Integer id){
        log.debug("getBookById() - start:");
        Book book = bookService.getById(id);
        BookReadDto response = bookMapper.toBookReadDto(book);
        log.debug("getBookById() - stop:");
        return response;
    }

    @GetMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public List<BookReadDto> getAllBooks(){
        log.debug("getAllBooks() - start:");
        List<Book> books = bookService.getAll();
        List<BookReadDto> response = bookMapper.toListBookReadDto(books);
        log.debug("getAllBooks() - stop:");
        return response;
    }

    @GetMapping("/books/hidden/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public BookReadDto getHiddenBookById(@PathVariable Integer id){
        log.debug("getHiddenBookById() - start: ");
        Book book = bookService.getHiddenBookById(id);
        BookReadDto response = bookMapper.toBookReadDto(book);
        log.debug("getHiddenBookById() - stop: ");
        return response;
    }

    @GetMapping("/books/hidden")
    @ResponseStatus(HttpStatus.CREATED)
    public List<BookReadDto> getAllHiddenBooks(){
        log.debug("getAllHiddenBooks() - start:");
        List<Book> books = bookService.getAllHidden();
        List<BookReadDto> response = bookMapper.toListBookReadDto(books);
        log.debug("getAllHiddenBooks() - stop:");
        return response;
    }

}
