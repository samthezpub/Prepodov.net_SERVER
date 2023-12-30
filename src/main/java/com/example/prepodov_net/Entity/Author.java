package com.example.prepodov_net.Entity;

import jakarta.persistence.*;

import java.util.List;

@Inheritance
public abstract class Author {

    private List<PostEntity> posts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    public List<PostEntity> getPosts() {
        return posts;
    }

}
