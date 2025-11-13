package com.hotel.model.enums;

public enum UserRole {
    GUEST("Guest"),
    CLIENT("Client"),
    STAFF("Staff Member");

    private final String displayName;

    UserRole(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}