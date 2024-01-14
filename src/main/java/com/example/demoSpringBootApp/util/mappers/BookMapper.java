package com.example.demoSpringBootApp.util.mappers;

import com.example.demoSpringBootApp.domain.Book;
import com.example.demoSpringBootApp.dto.BookDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toBook(BookDto bookDto);
}
