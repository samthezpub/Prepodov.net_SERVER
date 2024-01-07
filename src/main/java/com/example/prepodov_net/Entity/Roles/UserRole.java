package com.example.prepodov_net.Entity.Roles;

import com.example.prepodov_net.Entity.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.FetchType.LAZY;

@Data
@Entity
@Table(schema = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Enumerated(EnumType.STRING)
    private UserRoleType userRoleType;
}
