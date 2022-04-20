package ru.kpfu.gerasimov.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.gerasimov.dto.CreateUserDto;
import ru.kpfu.gerasimov.dto.UserDto;
import ru.kpfu.gerasimov.model.User;
import ru.kpfu.gerasimov.repository.UserRepository;
import ru.kpfu.gerasimov.services.EncryptingService;
import ru.kpfu.gerasimov.services.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @Operation(summary = "Return all users")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",
            description = "users were get", content = {@Content(mediaType = "application/json")})})
    @GetMapping("/user")
    @ResponseBody
    public Iterable<UserDto> getAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(UserDto::fromModel)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Return users by id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",
            description = "users were get", content = {@Content(mediaType = "application/json")})})
    @GetMapping("/user/{id}")
    @ResponseBody
    public UserDto get(@PathVariable Integer id) {
        return userRepository.findById(id).stream()
                .map(UserDto::fromModel)
                .findFirst()
                .orElse(null);
    }

    @Operation(summary = "Return sign up success view")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",
            description = "view was get", content = {@Content(mediaType = "text/html")})})
    @PostMapping("/sign_up")
    public String signUp(@ModelAttribute(name = "user") CreateUserDto userDto, HttpServletRequest request) {
        String url = request.getRequestURL().toString().replace(request.getServletPath(), "");
        userService.signUp(userDto, url);
        return "sign_up_success";
    }

    @Operation(summary = "Returns verification view")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",
            description = "view was get", content = {@Content(mediaType = "text/html")})})
    @GetMapping("/verification")
    public String verify(@Param("code") String code) {
        if (userService.verify(code)) {
            return "verification_success";
        } else {
            return "verification_failed";
        }
    }
}
