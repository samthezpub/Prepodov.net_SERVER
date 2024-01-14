package com.example.prepodov_net.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class LikeEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private UserEntity liker;

    @ManyToOne
    private PostEntity liked;


}
