package com.example.prepodov_net.Entity.Roles;

import com.example.prepodov_net.Entity.PostEntity;
import com.example.prepodov_net.Entity.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.FetchType.LAZY;

@Data
@Entity
@Table(schema = "post_role")
public class PostRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "post_id")
    private PostEntity post;

    @Enumerated(EnumType.STRING)
    private PostRoleType postRoleType;
}
