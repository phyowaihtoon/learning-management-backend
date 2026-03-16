package com.creatip.lms.domain.learning.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class InstructorStatusConverter implements AttributeConverter<InstructorStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(InstructorStatus attribute) {
        return attribute == null ? null : attribute.getCode();
    }

    @Override
    public InstructorStatus convertToEntityAttribute(Integer dbData) {
        return InstructorStatus.fromCode(dbData);
    }
}
