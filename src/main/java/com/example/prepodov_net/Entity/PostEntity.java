package com.example.prepodov_net.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "post")
public class PostEntity extends Author {

    @Id
    private Long id;

    private Long authorId;

    private String content;

    @Enumerated(EnumType.STRING)
    private AuthorType authorType;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<CommentEntity> comments;

}

enum AuthorType {
    USER,
    COMMUNITY
}