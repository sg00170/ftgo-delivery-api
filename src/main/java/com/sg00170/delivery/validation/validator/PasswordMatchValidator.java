package com.sg00170.delivery.validation.validator;

import com.sg00170.delivery.dto.request.SignUpRequest;
import com.sg00170.delivery.validation.constraints.PasswordMatch;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, SignUpRequest> {

    @Override
    public boolean isValid(SignUpRequest value, ConstraintValidatorContext context) {
        return value.getPassword().equals(value.getConfirmPassword());
    }
}
