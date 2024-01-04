package com.example.prepodov_net.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "post")
public class PostEntity extends Author {

    @Id
    @GeneratedValue
    private Long id;

    private Long authorId;

    private String content;

    @OneToMany(fetch = FetchType.EAGER)
    private List<AttachmentEntity> file;

    @Enumerated(EnumType.STRING)
    private AuthorType authorType;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<CommentEntity> comments;

}

