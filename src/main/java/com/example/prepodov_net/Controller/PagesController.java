package com.example.prepodov_net.Controller;


// TODO: придумать нормальное название для класса

import com.example.prepodov_net.Entity.UserDTO;
import com.example.prepodov_net.Entity.UserEntity;
import com.example.prepodov_net.Services.Implementation.UserServiceImplementation;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class PagesController {

    private UserServiceImplementation userService;
    private PasswordEncoder passwordEncoder;

    @GetMapping("/getuser/{id}")
    public UserEntity getUserInfo(@PathVariable Long id) throws Exception {
        UserEntity user = userService.getUser(id);
        return user;
    }

    @PostMapping("/newuser")
    public String createUser(@RequestBody UserEntity user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);

        return "Пользователь " + user.getUsername() + " успешно добавлен!";
    }

    @PostMapping("/deleteuser")
    public String deleteUser(@RequestBody UserEntity user){
        userService.deleteUser(user);

        return "Пользователь " + user.getUsername() + " успешно добавлен!";
    }

    @GetMapping(path = "/user/{id}/friends")
    public List<UserEntity> getUserFriends(@PathVariable Long id){
        try {
            return userService.getUser(id).getFriends();
        } catch (Exception e) {
            return List.of();
        }
    }
}
