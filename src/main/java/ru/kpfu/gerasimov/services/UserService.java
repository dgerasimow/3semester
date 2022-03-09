package ru.kpfu.gerasimov.services;

import ru.kpfu.gerasimov.dto.CreateUserDto;
import ru.kpfu.gerasimov.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto getByEmail(String email);

    UserDto getById(Integer id);

    List<UserDto> getAll();

    UserDto save(CreateUserDto createUserDto);
}
