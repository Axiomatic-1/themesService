package com.microsevriceslesson.plateService.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfo {
    private String id;
    private String displayName;
    private String email;
    private String role;
}