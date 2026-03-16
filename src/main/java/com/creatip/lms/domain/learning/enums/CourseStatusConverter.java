package com.creatip.lms.domain.learning.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class CourseStatusConverter implements AttributeConverter<CourseStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CourseStatus attribute) {
        return attribute == null ? null : attribute.getCode();
    }

    @Override
    public CourseStatus convertToEntityAttribute(Integer dbData) {
        return CourseStatus.fromCode(dbData);
    }
}
