package ru.kpfu.gerasimov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.gerasimov.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> getUserByEmail(String email);
}
