package com.example.prepodov_net.Entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@id")
public class UserEntity extends Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

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

}
