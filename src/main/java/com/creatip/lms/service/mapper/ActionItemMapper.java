package com.creatip.lms.service.mapper;


import com.creatip.lms.domain.ActionItem;
import com.creatip.lms.service.dto.ActionItemDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActionItemMapper extends EntityMapper<ActionItemDTO, ActionItem> {

}
