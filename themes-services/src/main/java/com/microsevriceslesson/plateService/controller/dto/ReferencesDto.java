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
public class ReferencesDto {
    private Long refId;
    private String refs;
    private String comments;
    private transient Long plateId;

    public ReferencesDto(String refs, String comments, Long plateId) {
        this.refs = refs;
        this.comments = comments;
        this.plateId = plateId;
    }
}
