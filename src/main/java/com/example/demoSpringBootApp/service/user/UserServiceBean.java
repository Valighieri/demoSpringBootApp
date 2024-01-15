package com.example.demoSpringBootApp.service.user;

import com.example.demoSpringBootApp.domain.Book;
import com.example.demoSpringBootApp.domain.History;
import com.example.demoSpringBootApp.domain.User;
import com.example.demoSpringBootApp.repository.UserRepository;
import com.example.demoSpringBootApp.service.book.BookService;
import com.example.demoSpringBootApp.service.history.HistoryService;
import com.example.demoSpringBootApp.util.exception.UserBookLimitException;
import com.example.demoSpringBootApp.util.exception.UserWithoutThatBookException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceBean implements UserService {

    private final UserRepository userRepository;
    private final BookService bookService;
    private final HistoryService historyService;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User borrowBook(Integer userId, Integer bookId) {
        return userRepository.findById(userId)
                .map(entity -> {
                    if (entity.getBooks().size() < 7) {
                        Book book = bookService.getById(bookId);
                        book.setIsHandled(Boolean.TRUE);
                        entity.getBooks().add(book);
                        entity.getHistories().add(
                                historyService.create(entity, book));
                        return userRepository.save(entity);
                    } else throw new UserBookLimitException
                            ("User can't have more books");
                })
                .orElseThrow(() -> new EntityNotFoundException
                        ("User not found with id = " + userId));
    }

    @Override
    public User returnBook(Integer userId, Integer bookId) {
        return userRepository.findById(userId)
                .map(entity -> {
                    Book book = bookService.getHiddenBookById(bookId);

                    if (entity.getBooks().contains(book)) {
                        book.setIsHandled(Boolean.FALSE);

                        entity.getBooks().remove(book);
                    } else throw new UserWithoutThatBookException
                            ("User doesn't have book with id = " + bookId);

                    return userRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException
                        ("User not found with id = " + userId));
    }

    @Override
    public List<User> getAllWithDebts() {
        return userRepository.findAllByBooksIsHandled().stream()
                .filter(this::isLate).toList();
    }

    private boolean isLate(User user){
        boolean isLate = false;
        for (History h : user.getHistories()){
            if (h.getReturnDate() != null) continue;
            isLate = LocalDate.now().isAfter(h.getBorrowDate().plusMonths(1));
            if (isLate) break;
        }
        return isLate;
    }
}
