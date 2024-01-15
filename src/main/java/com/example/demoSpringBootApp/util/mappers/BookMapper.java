package com.example.demoSpringBootApp.util.mappers;

import com.example.demoSpringBootApp.domain.Book;
import com.example.demoSpringBootApp.dto.BookDto;
import com.example.demoSpringBootApp.dto.BookReadDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toBook(BookDto bookDto);

    BookReadDto toBookReadDto(Book book);

    List<BookReadDto> toListBookReadDto(List<Book> books);
}
