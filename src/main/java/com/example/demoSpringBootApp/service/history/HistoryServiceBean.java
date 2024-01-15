package com.example.demoSpringBootApp.service.history;

import com.example.demoSpringBootApp.domain.Book;
import com.example.demoSpringBootApp.domain.History;
import com.example.demoSpringBootApp.domain.User;
import com.example.demoSpringBootApp.repository.HistoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
                .filter(this::isLate).map(entity -> entity.getUser()).toList();
    }

    private boolean isLate(History history) {
        return LocalDate.now().isAfter(history.getBorrowDate().plusMonths(1));
    }
}
