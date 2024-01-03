package com.example.prepodov_net.Entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "users")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@id")
public class UserEntity extends Author implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;



    @Transient
    private Integer age;

    private LocalDate birthdate;



    private LocalDateTime register_date = LocalDateTime.now();

    @OneToMany
    private List<GroupEntity> groups;

    @OneToMany
    private List<UserEntity> friends;

    @OneToMany
    private List<CommentEntity> comments;

    @OneToMany
    private List<PostEntity> posts;


    @Column(name = "is_banned")
    private boolean isBanned = false;

    @Enumerated(EnumType.STRING)
    private banReason ban_reason;

    public UserEntity() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isBanned;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

// TODO: написать возможные причины для банов

enum banReason {
    SPAM,
    OTHER
}
