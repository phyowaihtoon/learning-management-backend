package com.creatip.lms.domain.learning.enums;

public enum CourseStatus {
    DRAFT(1),
    PUBLISHED(2),
    ARCHIVED(3);

    private final int code;

    CourseStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static CourseStatus fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (CourseStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown CourseStatus code: " + code);
    }
}
