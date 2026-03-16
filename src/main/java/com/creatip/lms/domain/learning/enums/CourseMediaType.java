package com.creatip.lms.domain.learning.enums;

public enum CourseMediaType {
    INTRO_VIDEO(1),
    IMAGE(2);

    private final int code;

    CourseMediaType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static CourseMediaType fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (CourseMediaType value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown CourseMediaType code: " + code);
    }
}