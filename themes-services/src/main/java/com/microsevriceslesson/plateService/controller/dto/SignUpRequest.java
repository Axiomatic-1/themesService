package com.microsevriceslesson.plateService.controller.dto;

import com.microsevriceslesson.plateService.validator.PasswordMatches;
import lombok.Builder;
import lombok.Data;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@PasswordMatches
@Builder
public class SignUpRequest {

    private Long userID;

    private String providerUserId;

    @NotEmpty
    private String displayName;

    @NotEmpty
    private String email;

    private SocialProvider socialProvider;

    @Size(min = 6, message = "{Size.userDto.password}")
    private String password;

    @NotEmpty
    private String matchingPassword;
}