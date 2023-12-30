package com.example.prepodov_net.Controller;


// TODO: придумать нормальное название для класса

import com.example.prepodov_net.Entity.UserDTO;
import com.example.prepodov_net.Entity.UserEntity;
import com.example.prepodov_net.Services.Implementation.UserServiceImplementation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserEntity> getUserInfo(@PathVariable Long id) throws Exception {
        UserEntity user = userService.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @PostMapping("/newuser")
    public ResponseEntity<?> createUser(@RequestBody UserEntity user){
        if (user.getUsername() == null || user.getPassword() == null){
            return new ResponseEntity<>("Неправильное имя или пароль!", HttpStatus.BAD_REQUEST);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);

        return new ResponseEntity<>("Пользователь " + user.getUsername() + " успешно добавлен!", HttpStatus.CREATED);
    }

    @PostMapping("/deleteuser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        try {
            UserEntity user = userService.getUser(id);
            userService.deleteUser(user);

            return new ResponseEntity<>("Пользователь " + user.getUsername() + " успешно удалён!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Не удалось удалить пользователя " + id, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(path = "/user/{id}/friends")
    public ResponseEntity<List<UserEntity>> getUserFriends(@PathVariable Long id){
        try {
            return new ResponseEntity<>(userService.getUser(id).getFriends(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(List.of(), HttpStatus.NO_CONTENT);
        }
    }
}
