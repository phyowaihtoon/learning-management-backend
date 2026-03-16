package com.creatip.lms.domain.learning.enums;

public enum CourseType {
    ONLINE(1),
    IN_PERSON(2);

    private final int code;

    CourseType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static CourseType fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (CourseType value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown CourseType code: " + code);
    }
}