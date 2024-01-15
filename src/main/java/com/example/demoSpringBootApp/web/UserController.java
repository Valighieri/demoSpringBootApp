package com.example.demoSpringBootApp.web;

import com.example.demoSpringBootApp.domain.User;
import com.example.demoSpringBootApp.dto.UserDto;
import com.example.demoSpringBootApp.dto.UserReadDto;
import com.example.demoSpringBootApp.service.user.UserService;
import com.example.demoSpringBootApp.util.mappers.BookMapper;
import com.example.demoSpringBootApp.util.mappers.UserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserReadDto saveUser(@RequestBody UserDto userDto) {
        log.debug("saveUser() - start: ");
        User user = userService.create(
                userMapper.toUser(userDto)
        );
        UserReadDto response = userMapper.toUserReadDto(user);
        log.debug("saveUser() - stop: ");
        return response;
    }

    @PatchMapping("/users/books/borrow")
    @ResponseStatus(HttpStatus.OK)
    public UserReadDto borrowBook(@RequestParam Integer userId,
                                  @RequestParam Integer bookId) {
        log.debug("borrowBook() - start: ");
        UserReadDto response = userMapper.toUserReadDto(
                userService.borrowBook(userId, bookId)
        );
        log.debug("borrowBook() - stop:");
        return response;
    }

    @PatchMapping("/users/books/return")
    @ResponseStatus(HttpStatus.OK)
    public UserReadDto returnBook(@RequestParam Integer historyId) {
        log.debug("returnBook() - start: ");
        UserReadDto response = userMapper.toUserReadDto(
                userService.returnBook(historyId)
        );
        log.debug("returnBook() - stop: ");
        return response;
    }

    @GetMapping("/users/books/inactive")
    @ResponseStatus(HttpStatus.OK)
    public List<UserReadDto> getAllInactiveUsers(){
        log.debug("getAllInactiveUsers() - start: ");
        List<UserReadDto> response = userMapper.toListUserReadDto(
                userService.getAllInactiveUsers()
        );
        log.debug("getAllInactiveUsers() - stop: ");
        return response;
    }
}
