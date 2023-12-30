package com.example.prepodov_net.Services.Implementation;

import com.example.prepodov_net.Entity.UserEntity;
import com.example.prepodov_net.Services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    @Override
    public void saveUser(UserEntity user) {

    }

    @Override
    public void deleteUser(UserEntity user) {

    }

    @Override
    public UserEntity getUser(long id) throws Exception {
        return null;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return null;
    }

    @Override
    public void updateUser(UserEntity user) {

    }
}
