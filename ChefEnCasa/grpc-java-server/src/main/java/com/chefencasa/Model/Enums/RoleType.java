package com.chefencasa.Model.Enums;

public enum RoleType {
    USER,
    MODERATOR;

    public static RoleType valueOf(int role) {
        switch (role) {
            case 1:
                return RoleType.USER;
            case 2:
                return RoleType.MODERATOR;
            default:
                throw new IllegalArgumentException("Valor de rol no válido: " + role);
        }
    }
}
