package ru.alex.messages;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.alex.messages.controler.AuthController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
class AuthControllerTest {

    @Autowired
    private AuthController authController;

    @Test
    void registrationUserTest() {
        assertThat(authController).isNotNull();
    }

}
