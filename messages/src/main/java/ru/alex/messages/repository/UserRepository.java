package ru.alex.messages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alex.messages.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByNameIgnoreCase(String name);
}
