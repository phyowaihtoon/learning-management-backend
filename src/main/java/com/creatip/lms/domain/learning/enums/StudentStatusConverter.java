package com.creatip.lms.domain.learning.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class StudentStatusConverter implements AttributeConverter<StudentStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(StudentStatus attribute) {
        return attribute == null ? null : attribute.getCode();
    }

    @Override
    public StudentStatus convertToEntityAttribute(Integer dbData) {
        return StudentStatus.fromCode(dbData);
    }
}
