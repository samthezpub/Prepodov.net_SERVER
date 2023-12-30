package com.example.prepodov_net.Controller;


// TODO: придумать нормальное название для класса

import com.example.prepodov_net.Entity.UserEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PagesController {

    @GetMapping("/getuser/{id}")
    public UserEntity getUserInfo(@PathVariable Long id){
        UserEntity user = new UserEntity();
        user.setId(id);
        user.setAge(18);
        user.setUsername("oleg88");

        return user;
    }
}
