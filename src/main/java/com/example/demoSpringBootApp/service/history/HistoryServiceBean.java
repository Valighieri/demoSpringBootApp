package com.example.demoSpringBootApp.service.history;

import com.example.demoSpringBootApp.domain.Book;
import com.example.demoSpringBootApp.domain.History;
import com.example.demoSpringBootApp.domain.User;
import com.example.demoSpringBootApp.repository.HistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class HistoryServiceBean implements HistoryService {

    private final HistoryRepository historyRepository;

    @Override
    public History create(User user, Book book) {
        History history = new History(0, user, book, LocalDate.now(), null);
        return historyRepository.save(history);
    }
}
