package com.creatip.lms.domain.learning.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class LessonContentTypeConverter implements AttributeConverter<LessonContentType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(LessonContentType attribute) {
        return attribute == null ? null : attribute.getCode();
    }

    @Override
    public LessonContentType convertToEntityAttribute(Integer dbData) {
        return LessonContentType.fromCode(dbData);
    }
}
