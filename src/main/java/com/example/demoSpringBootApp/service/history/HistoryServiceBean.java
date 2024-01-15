package com.example.demoSpringBootApp.service.history;

import com.example.demoSpringBootApp.domain.Book;
import com.example.demoSpringBootApp.domain.History;
import com.example.demoSpringBootApp.domain.User;
import com.example.demoSpringBootApp.repository.HistoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
@AllArgsConstructor
public class HistoryServiceBean implements HistoryService {

    private final HistoryRepository historyRepository;

    @Override
    public History create(User user, Book book) {
        History history = new History(0, user, book, LocalDate.now(), null);
        return historyRepository.save(history);
    }

    @Override
    public History getById(Integer historyId) {
        return historyRepository.findById(historyId)
                .orElseThrow(() -> new EntityNotFoundException
                        ("History not found with id = " + historyId));
    }

    @Override
    public List<User> getAllWithDebts() {
        return historyRepository.findAllByReturnDateNotEmpty().stream()
                .filter(history -> LocalDate.now().isAfter(
                        history.getBorrowDate().plusMonths(1))
                ).map(entity -> entity.getUser()).toList();
    }

    @Override
    public List<Book> getTopFiveBooks() {
        return getTopFive(
                historyRepository.findAllByDateLastYear(
                        LocalDate.of(LocalDate.now().getYear() - 1, 1, 1),
                        LocalDate.of(LocalDate.now().getYear() - 1, 12, 31)
                ).stream().map(history -> history.getBook()).toList()
        );
    }

    private List<Book> getTopFive(List<Book> list) {
        // sorting must be here
        return list;
    }
}










