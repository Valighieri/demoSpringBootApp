package com.example.demoSpringBootApp.web;

import com.example.demoSpringBootApp.domain.User;
import com.example.demoSpringBootApp.dto.UserDto;
import com.example.demoSpringBootApp.service.user.UserService;
import com.example.demoSpringBootApp.util.mappers.UserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody UserDto userDto){
        log.debug("saveUser() - start: user = {}", userDto);
        User response = userService.create(
                userMapper.toUser(userDto)
        );
        log.debug("saveUser() - stop: user id = {}", response.getId());
        return response;
    }

    @PatchMapping("/users/books/borrow")
    @ResponseStatus(HttpStatus.OK)
    public User borrowBook(@RequestParam Integer userId,
                           @RequestParam Integer bookId){
        log.debug("borrowBook() - start: user id = {}", userId);
        User response = userService.borrowBook(userId, bookId);
        log.debug("borrowBook() - stop: user = {}", response);
        return response;
    }

    @PatchMapping("/users/books/return")
    @ResponseStatus(HttpStatus.OK)
    public User returnBook(@RequestParam Integer userId,
                           @RequestParam Integer bookId){
        log.debug("returnBook() - start: user id = {}", userId);
        User response = userService.returnBook(userId, bookId);
        log.debug("returnBook() - stop: user = {}", response);
        return response;
    }
}
