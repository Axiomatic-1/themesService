package com.microsevriceslesson.plateService.entity.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TagsDto {
    private Long id;
    private String tagName;
}
