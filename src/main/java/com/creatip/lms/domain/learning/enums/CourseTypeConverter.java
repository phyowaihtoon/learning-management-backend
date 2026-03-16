package com.creatip.lms.domain.learning.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class CourseTypeConverter implements AttributeConverter<CourseType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CourseType attribute) {
        return attribute == null ? null : attribute.getCode();
    }

    @Override
    public CourseType convertToEntityAttribute(Integer dbData) {
        return CourseType.fromCode(dbData);
    }
}
