package com.microsevriceslesson.plateService.mapper;

import com.microsevriceslesson.plateService.controller.dto.PlateDto;
import com.microsevriceslesson.plateService.entity.Plate;
import org.mapstruct.Mapper;

@Mapper
public interface PlateMapper {
    Plate fromDto(PlateDto plateDto);
    PlateDto toDto(Plate plate);
}
