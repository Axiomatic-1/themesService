package com.microsevriceslesson.plateService.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private List<PlateDto> plateDtoList;
}
