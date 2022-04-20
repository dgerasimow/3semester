package ru.kpfu.gerasimov.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import ru.kpfu.gerasimov.dto.CreateUserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("")
    public String getIndexPage() {
        return "index";
    }

    @Operation(summary = "Returns sign up success view")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "View was get",
            content = {@Content(mediaType = "text/html")})})
    @GetMapping("/sign_up")
    public String getSignUp(Model model) {
        model.addAttribute("user", new CreateUserDto());
        return "sign_up";
    }

    @Operation(summary = "Returns home view")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "View was get",
            content = {@Content(mediaType = "text/html")})})
    @GetMapping("/home")
    public String getHome() {
        return "home";
    }
}