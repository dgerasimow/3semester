package ru.kpfu.gerasimov.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CreateUserDto {
    @NotBlank(message = "Name shouldn't be blank!")
    private String name;

    @NotBlank(message = "Email shouldn't be blank!")
    @Pattern(regexp = "^(.+)@(.+)$", message = "Email should have @")
    private String email;

    @NotBlank(message = "Password shouldn't be blank!")
    @Pattern(regexp = "^(?=.*\\d).{4,8}$", message = "Password expression. Password must be between 4 " +
            "and 8 digits long and include at least one numeric digit.")
    private String password;

    public CreateUserDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public CreateUserDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
