package com.microsevriceslesson.plateService.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlateDto {

    private Long plateId;
    private String plateName;
    private Set<TagDto> tag;
    private Set<ReferenceDto> referenceDtos;
}

