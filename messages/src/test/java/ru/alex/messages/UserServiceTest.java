package ru.alex.messages;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.alex.messages.model.User;
import ru.alex.messages.repository.UserRepository;
import ru.alex.messages.service.UserService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private PasswordEncoder provider;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    User user1;
    User user2;
    User user3;

    @BeforeEach
    void init() {
        user1 = new User("Ivanov Ivan", provider.encode("12345"));
        user2 = new User("Sergey Sergeev", provider.encode("45333"));
        user3 = new User("Petr petrov", provider.encode("123434"));
        user1 = userService.save(user1);
        user2 = userService.save(user2);
        user3 = userService.save(user3);
    }

    @AfterEach
    void deleteData(){
        userRepository.deleteAll();
    }

    @Test
    void userServiceSaveTest() {
        List<User> users = userService.findAll();
        assertThat(users.size()).isEqualTo(3);
    }

    @Test
    void userFindByNameTest() {
        User test1 = userService.findByUsername("Ivanov Ivan");
        assertThat(test1.getName()).isEqualTo(user1.getName());
        assertThat(test1.getPassword()).isEqualTo(user1.getPassword());
    }




}
