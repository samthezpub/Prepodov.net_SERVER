package com.example.prepodov_net.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class GroupPostEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String content;

    @ManyToOne
    private GroupEntity author_id;
}
