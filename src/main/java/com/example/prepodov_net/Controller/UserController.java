package com.example.prepodov_net.Controller;

import com.example.prepodov_net.Entity.UserEntity;
import com.example.prepodov_net.Services.Implementation.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImplementation userService;

    @GetMapping(path = "/friends/{id}")
    public List<UserEntity> getUserFriends(@PathVariable Long id){
        try {
            return userService.getUser(id).getFriends();
        } catch (Exception e) {
            return List.of();
        }
    }
}
