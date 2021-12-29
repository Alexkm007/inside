package ru.alex.messages.dto;

import lombok.Data;
import javax.validation.constraints.NotEmpty;

@Data
public class MessageDto {
    @NotEmpty
    String name;
    @NotEmpty
    String message;
}
