package ru.alex.messages.service;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alex.messages.dto.MessageDto;
import ru.alex.messages.model.Message;
import ru.alex.messages.model.User;
import ru.alex.messages.repository.MessageRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MessageService {
    private final MessageRepository messageRepository;
    private final UserService userService;

    public MessageService(MessageRepository messageRepository, UserService userService) {
        this.messageRepository = messageRepository;
        this.userService = userService;
    }

    public Message save(MessageDto messageDto) {
        Message message = new Message();
        User user = userService.findByUsername(messageDto.getName());
        if (user == null) {
            throw new BadCredentialsException("User " + messageDto.getName() + " not found.");
        }
        message.setText(messageDto.getMessage());
        message.setUser(user);
        message.setDateSave(LocalDateTime.now());
        return messageRepository.save(message);
    }

    public List<MessageDto> top10Messages() {
        List<MessageDto> messages = messageRepository.findFirst10ByOrderByDateSaveDesc()
                .stream()
                .map(message -> {
                    MessageDto messageDto = new MessageDto();
                    messageDto.setName(message.getUser().getName());
                    messageDto.setMessage(message.getText());
                    return messageDto;
                }).collect(Collectors.toList());
        return messages;
    }

}
