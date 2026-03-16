package com.creatip.lms.domain.learning.enums;

public enum InstructorStatus {
    ACTIVE(1),
    INACTIVE(0);

    private final int code;

    InstructorStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static InstructorStatus fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (InstructorStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown InstructorStatus code: " + code);
    }
}
