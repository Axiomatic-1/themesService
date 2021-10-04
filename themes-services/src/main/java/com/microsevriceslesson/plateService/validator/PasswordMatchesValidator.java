package com.microsevriceslesson.plateService.validator;

import com.microsevriceslesson.plateService.controller.dto.SignUpRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, SignUpRequest> {

    @Override
    public boolean isValid(SignUpRequest signUpRequest, ConstraintValidatorContext context) {
        return signUpRequest.getPassword().equals(signUpRequest.getMatchingPassword());
    }
}
