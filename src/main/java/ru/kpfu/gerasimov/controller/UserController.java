package ru.kpfu.gerasimov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.gerasimov.dto.CreateUserDto;
import ru.kpfu.gerasimov.dto.UserDto;
import ru.kpfu.gerasimov.model.User;
import ru.kpfu.gerasimov.respository.UserRepository;
import ru.kpfu.gerasimov.services.EncryptingService;

import javax.validation.Valid;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    public Iterable<UserDto> getAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(UserDto::fromModel)
                .collect(Collectors.toList());
    }

    @GetMapping("/user/{id}")
    public UserDto get(@PathVariable Integer id) {
        return userRepository.findById(id).stream()
                .map(UserDto::fromModel)
                .findFirst()
                .orElse(null);
    }


    @PostMapping("/user")
    public UserDto createUser(@Valid @RequestBody CreateUserDto user) {
        return UserDto.fromModel(userRepository.save(new User(user.getName(),
                user.getEmail(),
                EncryptingService.encrypt(user.getPassword()))));
    }
}
