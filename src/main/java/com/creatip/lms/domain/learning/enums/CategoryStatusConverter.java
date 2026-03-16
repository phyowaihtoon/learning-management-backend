package com.creatip.lms.domain.learning.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class CategoryStatusConverter implements AttributeConverter<CategoryStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CategoryStatus attribute) {
        return attribute == null ? null : attribute.getCode();
    }

    @Override
    public CategoryStatus convertToEntityAttribute(Integer dbData) {
        return CategoryStatus.fromCode(dbData);
    }
}
