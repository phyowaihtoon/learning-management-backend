package com.creatip.lms.domain.learning.enums;

public enum CategoryStatus {
    ACTIVE(1),
    INACTIVE(0);

    private final int code;

    CategoryStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static CategoryStatus fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (CategoryStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown CategoryStatus code: " + code);
    }
}