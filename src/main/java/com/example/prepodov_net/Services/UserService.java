package com.example.prepodov_net.Services;

import com.example.prepodov_net.Entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void saveUser(UserEntity user);
    void deleteUser(UserEntity user);
    Optional<UserEntity> getUser(long id) throws Exception;
    List<UserEntity> getAllUsers();
    void updateUser(UserEntity user);

}
