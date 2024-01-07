package com.example.prepodov_net.Entity.Roles;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum GroupRoleType implements Role {
    MODERATOR, MANAGER, ADMIN, CREATOR;

    private final Set<Role> children = new HashSet<>();

    static {
        MODERATOR.children.add(MANAGER);
        MODERATOR.children.addAll(List.of(PostRoleType.EDITOR, PostRoleType.REPORTER));
        ADMIN.children.add(MODERATOR);
        CREATOR.children.add(ADMIN);
    }

    @Override
    public boolean isInclude(Role role) {
        return this.equals(role) || children.stream().anyMatch(r -> r.isInclude(role));
    }
}
