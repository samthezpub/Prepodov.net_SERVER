package com.example.prepodov_net.Services.Implementation;

import com.example.prepodov_net.Config.CustomAuthentication;
import com.example.prepodov_net.Entity.Roles.GroupRoleType;
import com.example.prepodov_net.Entity.Roles.PostRoleType;
import com.example.prepodov_net.Entity.Roles.Role;
import com.example.prepodov_net.Repository.GroupRoleRepository;
import com.example.prepodov_net.Repository.PostRoleRepository;
import com.example.prepodov_net.Services.RoleService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Set;

@AllArgsConstructor
@Service
public class RoleServiceImplementation implements RoleService {

    private final GroupRoleRepository groupRoleRepository;
    private final PostRoleRepository postRoleRepository;

    @Override
    @Transactional
    public boolean hasAnyRoleByGroupId(Long communityId, Role... roles) {
        final Long userId = ((CustomAuthentication) SecurityContextHolder.getContext().getAuthentication()).getPrincipal();
        final Set<GroupRoleType> communityRoleTypes =
                groupRoleRepository.findRoleTypesByUserIdAndCommunityId(userId, communityId);
        for (Role role : roles) {
            if (communityRoleTypes.stream().anyMatch(communityRoleType -> communityRoleType.isInclude(role))) {
                return true;
            }
        }
        final Set<PostRoleType> postRoleTypes =
                postRoleRepository.findRoleTypesByUserIdAndCommunityId(userId, communityId);
        for (Role role : roles) {
            if (postRoleTypes.stream().anyMatch(postRoleType -> postRoleType.isInclude(role))) {
                return true;
            }
        }
        return false;
    }

    @Override
    @Transactional
    public boolean hasAnyRoleByPostId(Long postId, Role... roles) {
        final Long userId = getCurrentAuthentication().getPrincipal();
        final Set<GroupRoleType> groupRoleTypes =
                groupRoleRepository.findRoleTypesByUserIdAndPostId(userId, postId);
        for (Role role : roles) {
            if (groupRoleTypes.stream().anyMatch(communityRoleType -> communityRoleType.isInclude(role))) {
                return true;
            }
        }
        final Set<PostRoleType> postRoleTypes =
                postRoleRepository.findRoleTypesByUserIdAndPostId(userId, postId);
        for (Role role : roles) {
            if (postRoleTypes.stream().anyMatch(postRoleType -> postRoleType.isInclude(role))) {
                return true;
            }
        }
        return false;
    }

    @Override
    @Transactional
    public boolean hasAnyRoleByUserId(Long userId, Role... roles) {
        return false;
    }

    private static CustomAuthentication getCurrentAuthentication() {
        return (CustomAuthentication) SecurityContextHolder.getContext().getAuthentication();
    }
}
