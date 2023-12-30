package com.example.prepodov_net.Entity;

import com.example.prepodov_net.Interface.IAuthor;
import jakarta.persistence.*;
import org.apache.catalina.User;

@Entity
public class UserPostEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String content;

    @ManyToOne
    private UserEntity author_id;

}
