package ru.alex.messages.dto;

import lombok.Data;
import javax.validation.constraints.NotEmpty;

@Data
public class UserDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String password;
}
