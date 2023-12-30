package com.example.prepodov_net.Services.Implementation;

import com.example.prepodov_net.Entity.UserEntity;
import com.example.prepodov_net.Repository.UserRepository;
import com.example.prepodov_net.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImplementation implements UserService {

    private UserRepository userRepository;

    @Override
    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(UserEntity user) {
        userRepository.delete(user);
    }

    @Override
    public Optional<UserEntity> getUser(long id) throws Exception {
        return userRepository.findById(id);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(UserEntity user) {
        userRepository.save(user);
    }
}
