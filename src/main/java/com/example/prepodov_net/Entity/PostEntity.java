package com.example.prepodov_net.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "post")
public class PostEntity extends Author {
    private Long id;

    private Author author;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
