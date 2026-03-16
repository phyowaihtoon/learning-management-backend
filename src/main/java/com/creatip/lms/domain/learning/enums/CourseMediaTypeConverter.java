package com.creatip.lms.domain.learning.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class CourseMediaTypeConverter implements AttributeConverter<CourseMediaType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CourseMediaType attribute) {
        return attribute == null ? null : attribute.getCode();
    }

    @Override
    public CourseMediaType convertToEntityAttribute(Integer dbData) {
        return CourseMediaType.fromCode(dbData);
    }
}
