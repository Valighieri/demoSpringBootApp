package com.example.demoSpringBootApp.repository;

import com.example.demoSpringBootApp.domain.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT DISTINCT u.* FROM users u JOIN books b ON u.id = b.user_id " +
            "WHERE b.is_handled = true", nativeQuery = true)
    List<User> findAllByBooksIsHandled();

}
