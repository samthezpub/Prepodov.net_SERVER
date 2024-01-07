package com.example.prepodov_net.Entity.Roles;

import java.util.HashSet;
import java.util.Set;

public enum PostRoleType implements Role {
    VIEWER, EDITOR, REPORTER;

    private final Set<Role> children = new HashSet<>();

    static {
        EDITOR.children.add(VIEWER);
        REPORTER.children.add(VIEWER);
    }

    @Override
    public boolean isInclude(Role role) {
        return this.equals(role) || children.stream().anyMatch(r -> r.isInclude(role));
    }
}
