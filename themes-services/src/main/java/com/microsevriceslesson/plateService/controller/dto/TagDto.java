package com.microsevriceslesson.plateService.controller.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TagDto {
    private Long id;
    private String tagName;
}
