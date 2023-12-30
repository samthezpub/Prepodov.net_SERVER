package com.example.prepodov_net.Entity;

import com.example.prepodov_net.Interface.IAuthor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class UserEntity extends IAuthor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer age;

    private LocalDate birthdate;

    private List<GroupEntity> groups;

    private List<UserEntity> friends;

    private List<CommentEntity> comments;

    private List<UserPostEntity> posts;

    public UserEntity() {
    }
}
