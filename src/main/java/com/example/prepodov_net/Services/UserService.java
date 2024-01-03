package com.example.prepodov_net.Services;

import com.example.prepodov_net.Entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    void saveUser(UserEntity user);
    void deleteUser(UserEntity user);
    UserEntity getUser(long id) throws Exception;
    List<UserEntity> getAllUsers();
    void updateUser(UserEntity user);

}
