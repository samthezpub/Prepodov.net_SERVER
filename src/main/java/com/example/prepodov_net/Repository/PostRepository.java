package com.example.prepodov_net.Repository;

import com.example.prepodov_net.Entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
