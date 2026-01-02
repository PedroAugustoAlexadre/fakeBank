package io.github.fakeBank.api.service;

import io.github.fakeBank.api.dto.UserDto;
import io.github.fakeBank.api.model.User;
import io.github.fakeBank.api.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final AccountService accountService;

    public UserService(UserRepository userRepository, AccountService accountService) {
        this.userRepository = userRepository;
        this.accountService = accountService;
    }

    @Transactional
    public User createUser(UserDto userDto) {

        if (userRepository.findByEmail(userDto.email()).isPresent()) {
            throw new RuntimeException("Email already in use");
        }

        User user = new User();

        user.setName(userDto.name());

        user.setEmail(userDto.email());

        user.setDocument(userDto.document());

        User userSaved = userRepository.save(user);

        accountService.createAccount(userSaved);

        return userSaved;

    }

    public User updateUser(UserDto userDto, UUID id) {

        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(userDto.name());

        user.setEmail(userDto.email());

        user.setDocument(userDto.document());

        userRepository.save(user);

        return user;
    }

    public void deleteUser(UUID id) {

        userRepository.deleteById(id);

    }

}
