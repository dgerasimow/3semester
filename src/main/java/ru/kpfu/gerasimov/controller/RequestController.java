package ru.kpfu.gerasimov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.gerasimov.dto.RequestDto;
import ru.kpfu.gerasimov.services.RequestService;

import java.util.List;
import java.util.Optional;

@RestController
public class RequestController {
    private final RequestService requestService;


    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("/request/by-user-id")
    public List<RequestDto> requestByUserId(@RequestParam Integer id) {
        return requestService.findAllByUserId(id);
    }

    @GetMapping("/request/by-city")
    public List<RequestDto> requestByCity(@RequestParam String city) {
        return requestService.findAllByCity(city);
    }
}
