package ru.alex.messages.controler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alex.messages.dto.MessageDto;
import ru.alex.messages.service.MessageService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("")
    public ResponseEntity<Map> messageJob(@Valid @RequestBody MessageDto requestDto) {
        if(!requestDto.getMessage().equalsIgnoreCase("history 10")){
            try {
                messageService.save(requestDto);
                return ResponseEntity.ok().build();
            } catch (BadCredentialsException e){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }
        List<MessageDto> messages = messageService.top10Messages();
        Map<Object, Object> response = new HashMap<>();
        response.put("name", requestDto.getName());
        response.put("messages", messages);
        return ResponseEntity.ok(response);
    }

}
