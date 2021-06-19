package com.microsevriceslesson.plateService.entity.dto;

import com.microsevriceslesson.plateService.entity.Plate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReferencesDto {
    private Long refId;
    private String refs;
    private String comments;
    private Plate plate;


}
