package ru.alex.messages.service;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alex.messages.dto.UserDto;
import ru.alex.messages.model.User;
import ru.alex.messages.repository.UserRepository;

import java.util.List;

@Service
@Transactional
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User findByUsername(String username) {
        return userRepository.findByNameIgnoreCase(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByNameIgnoreCase(username);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public UserDto registration(UserDto userDto) {

        User user = userRepository.findByNameIgnoreCase(userDto.getName());
        if (user != null) {
            throw new BadCredentialsException("User " + userDto.getName() + " existed.");
        }
        user = new User(userDto.getName(), passwordEncoder.encode(userDto.getPassword()));
        userRepository.saveAndFlush(user);
        return userDto;

    }

}