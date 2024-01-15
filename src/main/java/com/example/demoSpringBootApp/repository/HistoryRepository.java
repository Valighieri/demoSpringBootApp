package com.example.demoSpringBootApp.repository;

import com.example.demoSpringBootApp.domain.Book;
import com.example.demoSpringBootApp.domain.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Integer> {
    @Query(value = "SELECT * FROM history WHERE return_date is not null", nativeQuery = true)
    List<History> findAllByReturnDateNotEmpty();

    @Query(value = "SELECT * FROM history WHERE borrow_date BETWEEN :begin AND :end", nativeQuery = true)
    List<History> findAllByDateLastYear(LocalDate begin, LocalDate end);
}
