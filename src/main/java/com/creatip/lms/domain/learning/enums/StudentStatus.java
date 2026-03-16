package com.creatip.lms.domain.learning.enums;

public enum StudentStatus {
    ACTIVE(1),
    INACTIVE(0);

    private final int code;

    StudentStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static StudentStatus fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (StudentStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown StudentStatus code: " + code);
    }
}