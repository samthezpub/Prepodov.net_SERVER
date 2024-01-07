package com.example.prepodov_net.Entity.Roles;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum UserRoleType implements Role {
    USER, MODERATOR, ADMIN;

    private final Set<Role> children = new HashSet<>();

    static {
        USER.children.add(PostRoleType.VIEWER);
        MODERATOR.children.addAll(List.of(USER, PostRoleType.EDITOR, PostRoleType.REPORTER));
        ADMIN.children.addAll(List.of(MODERATOR, GroupRoleType.CREATOR
        ));
    }

    @Override
    public boolean isInclude(Role role) {
        return this.equals(role) || children.stream().anyMatch(r -> r.isInclude(role));
    }
}
