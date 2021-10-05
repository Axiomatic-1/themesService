package com.microsevriceslesson.plateService.controller.dto;

import com.microsevriceslesson.plateService.entity.Plate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReferenceDto {
    private Long refId;
    private String refs;
    private String comments;
}
