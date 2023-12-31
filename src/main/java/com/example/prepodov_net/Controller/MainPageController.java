package com.example.prepodov_net.Controller;

import com.example.prepodov_net.Services.Implementation.UserServiceImplementation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MainPageController {

    private UserServiceImplementation userService;

    @GetMapping("/")
    @ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT)
    public String getMainPage() {

        return "Продам гараж +7 (949) 801 73 00";
    }
}