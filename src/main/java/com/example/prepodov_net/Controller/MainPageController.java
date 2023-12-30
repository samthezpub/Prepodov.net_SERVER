package com.example.prepodov_net.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainPageController {

    @GetMapping("/")
    public String getMainPage(){
        return "Продам гараж +7 (949) 352 - 56 - 43";
    }
}