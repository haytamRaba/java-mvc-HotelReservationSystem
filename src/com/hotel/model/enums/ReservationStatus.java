package com.hotel.model.enums;

public enum ReservationStatus {
    PENDING("Pending Approval"),
    APPROVED("Approved"),
    DECLINED("Declined"),
    ON_HOLD("On Hold");

    private final String displayName;

    ReservationStatus(String displayName) {
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