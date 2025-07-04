package ru.itgirls.SPRING_PROJECT_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itgirls.SPRING_PROJECT_1.entity.User;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Long> {
    @Query(value = "select * from users where email = :email", nativeQuery = true)
    Optional<User> findByEmail(String email);
}
