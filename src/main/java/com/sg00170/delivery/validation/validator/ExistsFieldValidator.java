package com.sg00170.delivery.validation.validator;

import com.sg00170.delivery.repository.UserRepository;
import com.sg00170.delivery.validation.constraints.ExistsField;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class ExistsFieldValidator implements ConstraintValidator<ExistsField, Object> {

    @Autowired
    private UserRepository userRepository;

    private String table;
    private String field;
    private String message;

    @Override
    public void initialize(ExistsField constraintAnnotation) {
        this.table = constraintAnnotation.table();
        this.field = constraintAnnotation.field();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            Field declaredField = value.getClass().getDeclaredField(field);
            declaredField.setAccessible(true);
            Object fieldValue = declaredField.get(value);

            if (fieldValue == null) return true;

            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(field)
                    .addConstraintViolation();

            String fullKey = table + "." + field;
            return switch (fullKey) {
                case "users.username" -> userRepository.existsByUsername(fieldValue.toString());
                default -> true;
            };

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }
    }
}
