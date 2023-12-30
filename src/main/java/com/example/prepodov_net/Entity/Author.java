package com.example.prepodov_net.Entity;

import com.example.prepodov_net.Entity.PostEntity;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Inheritance
public abstract class Author {
    private List<PostEntity> posts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    public List<PostEntity> getPosts() {
        return posts;
    }
}
