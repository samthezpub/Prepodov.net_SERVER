package com.example.prepodov_net.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "group_table")
public class GroupEntity extends Author {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany
    private List<UserEntity> users;

    @OneToMany
    private List<PostEntity> posts;

}
