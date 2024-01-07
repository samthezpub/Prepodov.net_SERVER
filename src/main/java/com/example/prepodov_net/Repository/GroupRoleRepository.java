package com.example.prepodov_net.Repository;

import com.example.prepodov_net.Entity.Roles.GroupRole;
import com.example.prepodov_net.Entity.Roles.GroupRoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface GroupRoleRepository extends JpaRepository<GroupRole, Long> {

    @Query("""
        SELECT gr.type FROM GroupRole gr
        WHERE gr.user.id = :userId AND gr.group.id = :communityId
        """)
    Set<GroupRoleType> findRoleTypesByUserIdAndCommunityId(Long userId, Long communityId);

    @Query("""
        SELECT gr.type FROM GroupRole gr
        JOIN gr.group g
        JOIN g.post p
        WHERE gr.user.id = :userId AND p.id = :postId
        """)
    Set<GroupRoleType> findRoleTypesByUserIdAndPostId(Long userId, Long postId);

}
