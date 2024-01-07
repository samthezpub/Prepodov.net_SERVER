package com.example.prepodov_net.Repository;

import com.example.prepodov_net.Entity.Roles.UserRole;
import com.example.prepodov_net.Entity.Roles.UserRoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    @Query("""
        SELECT ur.type FROM PostRole ur
        JOIN ur.post p
        JOIN p.group g
        WHERE ur.user.id = :userId AND g.id = :groupId
        """)
    Set<UserRoleType> findRoleTypesByUserIdAndCommunityId(Long userId, Long communityId);

    @Query("""
        SELECT pr.type FROM PostRole pr
        WHERE pr.user.id = :userId AND pr.post.id = :postId
        """)
    Set<UserRoleType> findRoleTypesByUserIdAndPostId(Long userId, Long postId);

}
