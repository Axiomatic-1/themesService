package com.microsevriceslesson.plateService.entity.dto;

import com.microsevriceslesson.plateService.entity.References;
import com.microsevriceslesson.plateService.entity.Tags;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlateDto {

    private Long plateId;
    private String plateName;
    private Set<Tags> tag;
    private Set<References> references;

    public PlateDto(Long plateId, String plateName) {
        this.plateId = plateId;
        this.plateName = plateName;
    }
}

