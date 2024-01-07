package com.example.prepodov_net.Repository;

import com.example.prepodov_net.Entity.Roles.PostRole;
import com.example.prepodov_net.Entity.Roles.PostRoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface PostRoleRepository extends JpaRepository<PostRole, Long> {

    @Query("""
        SELECT pr.type FROM PostRole pr
        JOIN pr.post p
        JOIN p.group g
        WHERE ur.user.id = :userId AND g.id = :groupId
        """)
    Set<PostRoleType> findRoleTypesByUserIdAndCommunityId(Long userId, Long communityId);

    @Query("""
        SELECT pr.type FROM PostRole pr
        WHERE pr.user.id = :userId AND pr.post.id = :postId
        """)
    Set<PostRoleType> findRoleTypesByUserIdAndPostId(Long userId, Long postId);

}
