package com.example.prepodov_net.Repository;

import com.example.prepodov_net.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> getUserByUsername(String username);
}
