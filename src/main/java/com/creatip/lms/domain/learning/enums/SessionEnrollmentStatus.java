package com.creatip.lms.domain.learning.enums;

public enum SessionEnrollmentStatus {
    CONFIRMED(1),
    CANCELLED(2),
    ATTENDED(3);

    private final int code;

    SessionEnrollmentStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static SessionEnrollmentStatus fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (SessionEnrollmentStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown SessionEnrollmentStatus code: " + code);
    }
}
