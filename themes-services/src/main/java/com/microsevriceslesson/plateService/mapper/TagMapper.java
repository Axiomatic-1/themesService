package com.microsevriceslesson.plateService.mapper;

import com.microsevriceslesson.plateService.controller.dto.TagDto;
import com.microsevriceslesson.plateService.entity.Tag;
import org.mapstruct.Mapper;

@Mapper
public interface TagMapper {
    Tag fromDto(TagDto tagDto);
    TagDto toDto(Tag tag);
}
