package com.example.prepodov_net.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "groups")
public class GroupEntity extends Author {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "group_type")
    private GroupTypeEnum groupType;


    @OneToMany
    private List<UserEntity> users;

    @OneToMany
    private List<UserEntity> admins;

    @OneToMany
    private List<PostEntity> posts;
}

