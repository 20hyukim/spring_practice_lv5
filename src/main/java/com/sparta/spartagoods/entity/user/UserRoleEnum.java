package com.sparta.spartagoods.entity.user;


public enum UserRoleEnum {
    ADMIN(Role.ADMIN),
    USER(Role.USER);

    private final String role;

    UserRoleEnum(String role) {
        this.role = role;
    }

    public String getAuthority() {
        return this.role;
    }

    public static class Role {
        public static final String ADMIN = "ROLE_ADMIN";
        public static final String USER = "ROLE_USER";
    }
}
