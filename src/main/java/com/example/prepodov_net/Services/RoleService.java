package com.example.prepodov_net.Services;

import com.example.prepodov_net.Entity.Roles.Role;

public interface RoleService {

    boolean hasAnyRoleByGroupId(Long communityId, Role... roles);
    boolean hasAnyRoleByPostId(Long postId, Role... roles);
    boolean hasAnyRoleByUserId(Long userId, Role... roles);

}
