package com.example.prepodov_net.Services;

import com.example.prepodov_net.Entity.UserEntity;
import com.example.prepodov_net.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.prepodov_net.Config.CustomUserDetails;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.getUserByUsername(username);
        try {
            return user.map(CustomUserDetails::new)
                    .orElseThrow(() -> new Exception("Пользователь " + username + " не найден"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
