package ru.alex.messages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alex.messages.model.Message;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findFirst10ByOrderByDateSaveDesc();
}
