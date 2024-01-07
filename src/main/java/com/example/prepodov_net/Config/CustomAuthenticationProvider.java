package com.example.prepodov_net.Config;

import com.example.prepodov_net.Entity.UserEntity;
import com.example.prepodov_net.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        UserEntity user = userRepository.getUserByUsername(username).orElseThrow(() -> new AuthenticationServiceException("Пользователь не найден!"));

        String password = passwordEncoder.encode(String.valueOf(authentication.getCredentials()));

        if (user.getPassword().equals(password)) {
            return new UsernamePasswordAuthenticationToken(username, password, authentication.getAuthorities());
        } else {
            throw new AuthenticationServiceException("Error in authentication!");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}