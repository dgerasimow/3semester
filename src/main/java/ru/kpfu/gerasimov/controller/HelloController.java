package ru.kpfu.gerasimov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.gerasimov.model.Welcome;
import ru.kpfu.gerasimov.respository.UserRepository;
import ru.kpfu.gerasimov.services.NetworkService;

import java.util.Optional;

@RestController
public class HelloController {

//    private final UserRepository userRepository;

    private final NetworkService networkService;

    @Autowired
    public HelloController(NetworkService networkService) {
//        this.userRepository = userRepository;
        this.networkService = networkService;
    }

    @GetMapping("/weather")
    public Welcome weather(@RequestParam Optional<String> city) {
        System.out.println(city);
        if(city.isPresent()){
            return networkService.fetchData(city.get());
        } else {
            return networkService.fetchData("Kazan");
        }
    }



}
