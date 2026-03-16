package com.creatip.lms.domain.learning.enums;

public enum LessonContentType {
    VIDEO(1),
    DOCUMENT(2);

    private final int code;

    LessonContentType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static LessonContentType fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (LessonContentType value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown LessonContentType code: " + code);
    }
}