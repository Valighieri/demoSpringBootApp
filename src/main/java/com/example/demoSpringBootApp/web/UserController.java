package com.example.demoSpringBootApp.web;

import com.example.demoSpringBootApp.domain.User;
import com.example.demoSpringBootApp.service.UserService;
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

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user){
        log.debug("saveUser() - start: user name = {}", user.getName());
        var response = userService.create(user);
        log.debug("saveUser() - stop: user id = {}", response.getId());
        return response;
    }
}
