package com.example.prepodov_net.Services;

import com.example.prepodov_net.Entity.GroupEntity;
import com.example.prepodov_net.Entity.UserEntity;
import com.example.prepodov_net.Exception.AlreadyHaveGroupException;
import com.example.prepodov_net.Exception.FoundUserException;
import com.example.prepodov_net.Exception.GroupNotFindException;
import com.example.prepodov_net.Exception.GroupUserNotFoundedException;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    void saveUser(UserEntity user);

    void deleteUser(UserEntity user);

    UserEntity getUser(long id) throws Exception;

    List<UserEntity> getAllUsers();

    void updateUser(UserEntity user);

    void addGroupForUser(Long userId, Long group_id) throws GroupNotFindException, FoundUserException, AlreadyHaveGroupException;
    void removeGroupForUser(Long userId, Long group_id) throws FoundUserException, GroupNotFindException, GroupUserNotFoundedException;
}
