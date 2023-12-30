package com.example.prepodov_net.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "post")
public class PostEntity extends Author {

    private Long id;

    private Author author;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<CommentEntity> comments;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
