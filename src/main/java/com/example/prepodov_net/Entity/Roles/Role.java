package com.example.prepodov_net.Entity.Roles;

import java.util.Set;

public interface Role {
    boolean isInclude(Role role);

    static Set<Role> roots() {
        return Set.of(UserRoleType.ADMIN);
    }
}
