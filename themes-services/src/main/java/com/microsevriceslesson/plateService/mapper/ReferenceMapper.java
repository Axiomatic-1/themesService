package com.microsevriceslesson.plateService.mapper;

import com.microsevriceslesson.plateService.controller.dto.ReferenceDto;
import com.microsevriceslesson.plateService.entity.Reference;
import org.mapstruct.Mapper;

@Mapper
public interface ReferenceMapper {
    Reference fromDto(ReferenceDto referenceDto);
    ReferenceDto toDto(Reference reference);
}
