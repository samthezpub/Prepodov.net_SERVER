package com.example.prepodov_net.Controller;

import com.example.prepodov_net.Entity.UserEntity;
import com.example.prepodov_net.Services.CustomUserDetailsService;
import com.example.prepodov_net.Utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password){

        // Создай объект UsernamePasswordAuthenticationToken с данными пользователя
        Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);

        // Передай его в authenticationManager для аутентификации
        Authentication result = authenticationManager.authenticate(authentication);

        // Установи аутентифицированного пользователя в SecurityContext
        SecurityContextHolder.getContext().setAuthentication(result);

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        if (!userDetails.getPassword().equals(password)){
            return new ResponseEntity<>("Не удалось авторизоваться!", HttpStatus.BAD_REQUEST);
        }

        String token = JwtUtils.generateToken(userDetails);

        return new ResponseEntity<>(token, HttpStatus.OK);

    }
}
