package ru.alex.messages;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.alex.messages.dto.MessageDto;
import ru.alex.messages.model.User;
import ru.alex.messages.repository.MessageRepository;
import ru.alex.messages.repository.UserRepository;
import ru.alex.messages.service.MessageService;
import ru.alex.messages.service.UserService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MessageServiceTest {

    @Autowired
    private MessageService messageService;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void init() {
        User user1 = new User();
        user1.setName("test1");
        user1.setPassword("111");
        userService.save(user1);

        for (int i = 0; i <= 19; i++) {
            MessageDto messageDto = new MessageDto();
            messageDto.setMessage(" New message " + i);
            messageDto.setName("test1");
            messageService.save(messageDto);
        }

    }

    @AfterEach
    void clear() {
        messageRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    void testLoad10LastMessages() {
        List<MessageDto> messages = messageService.top10Messages();
        assertThat(messages.size()).isEqualTo(10);
    }

}
