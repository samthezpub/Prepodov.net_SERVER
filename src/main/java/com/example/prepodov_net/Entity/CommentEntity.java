package com.example.prepodov_net.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "comment")
public class CommentEntity {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    public UserEntity user;
}
