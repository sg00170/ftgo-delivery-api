package com.sg00170.delivery.validation.validator;

import com.sg00170.delivery.dto.request.auth.SignUpRequest;
import com.sg00170.delivery.validation.constraints.PasswordMatch;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, SignUpRequest> {

    private String message;

    @Override
    public void initialize(PasswordMatch constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(SignUpRequest value, ConstraintValidatorContext context) {
        if (value.getPassword().equals(value.getConfirmPassword())) return true;

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message)
                .addPropertyNode("confirmPassword")
                .addConstraintViolation();
        return false;
    }
}
