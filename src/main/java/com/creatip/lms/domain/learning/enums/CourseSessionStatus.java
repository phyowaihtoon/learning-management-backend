package com.creatip.lms.domain.learning.enums;

public enum CourseSessionStatus {
    OPEN(1),
    FULL(2),
    CANCELLED(3),
    COMPLETED(4);

    private final int code;

    CourseSessionStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static CourseSessionStatus fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (CourseSessionStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown CourseSessionStatus code: " + code);
    }
}
