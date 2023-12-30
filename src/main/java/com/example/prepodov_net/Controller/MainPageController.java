package com.example.prepodov_net.Controller;

import com.example.prepodov_net.Services.Implementation.UserServiceImplementation;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MainPageController {

    private UserServiceImplementation userService;

    @GetMapping("/")
    public String getMainPage(){
        return "Продам гараж +7 (949) 352 - 56 - 43";
    }
}