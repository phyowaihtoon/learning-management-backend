package com.creatip.lms.domain.learning.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class SessionEnrollmentStatusConverter implements AttributeConverter<SessionEnrollmentStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(SessionEnrollmentStatus attribute) {
        return attribute == null ? null : attribute.getCode();
    }

    @Override
    public SessionEnrollmentStatus convertToEntityAttribute(Integer dbData) {
        return SessionEnrollmentStatus.fromCode(dbData);
    }
}
