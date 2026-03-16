package com.creatip.lms.domain.learning.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class CourseSessionStatusConverter implements AttributeConverter<CourseSessionStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CourseSessionStatus attribute) {
        return attribute == null ? null : attribute.getCode();
    }

    @Override
    public CourseSessionStatus convertToEntityAttribute(Integer dbData) {
        return CourseSessionStatus.fromCode(dbData);
    }
}
