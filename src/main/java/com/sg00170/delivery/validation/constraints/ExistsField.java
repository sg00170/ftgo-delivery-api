package com.sg00170.delivery.validation.constraints;

import com.sg00170.delivery.validation.validator.ExistsFieldValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExistsFieldValidator.class)
public @interface ExistsField {

    String table();
    String field();
    String message() default "이미 사용 중인 값입니다.";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
