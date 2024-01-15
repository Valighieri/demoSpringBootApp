package com.example.demoSpringBootApp.web;

import com.example.demoSpringBootApp.dto.BookReadDto;
import com.example.demoSpringBootApp.dto.UserReadDto;
import com.example.demoSpringBootApp.service.history.HistoryService;
import com.example.demoSpringBootApp.util.mappers.BookMapper;
import com.example.demoSpringBootApp.util.mappers.UserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
@AllArgsConstructor
public class HistoryController {

    private final HistoryService historyService;
    private final UserMapper userMapper;
    private final BookMapper bookMapper;

    @GetMapping("/history/late")
    @ResponseStatus(HttpStatus.OK)
    public List<UserReadDto> getAllWithDebts() {
        log.debug("getAllUsersWithDebts() - start: ");
        List<UserReadDto> response = userMapper.toListUserReadDto(
                historyService.getAllWithDebts());
        log.debug("getAllUsersWithDebts() - stop: ");
        return response;
    }

    @GetMapping("/history/top-five-books")
    @ResponseStatus(HttpStatus.OK)
    public List<BookReadDto> getTopFiveBooks() {
        log.debug("getAllUsersWithDebts() - start: ");
        List<BookReadDto> response = bookMapper.toListBookReadDto(
                historyService.getTopFiveBooks());
        log.debug("getAllUsersWithDebts() - stop: ");
        return response;
    }
}
