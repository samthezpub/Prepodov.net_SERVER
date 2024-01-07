package com.example.prepodov_net.Entity.Roles;

import com.example.prepodov_net.Entity.GroupEntity;
import com.example.prepodov_net.Entity.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.FetchType.LAZY;

@Data
@Entity
@Table(schema = "group_role")
public class GroupRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "group_id")
    private GroupEntity group;

    @Enumerated(EnumType.STRING)
    private GroupRoleType groupRoleType;
}
