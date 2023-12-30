package com.example.prepodov_net.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class UserEntity extends Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer age;

    private LocalDate birthdate;

    @OneToMany
    private List<GroupEntity> groups;

    @OneToMany
    private List<UserEntity> friends;

    @OneToMany
    private List<CommentEntity> comments;

    @OneToMany
    private List<PostEntity> posts;

    public UserEntity() {
    }
}
