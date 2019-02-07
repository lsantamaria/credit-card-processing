package com.codetest.lsantamaria.creditcardprocessing.application.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR,
    ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LuhnAlgorithmValidator.class)
public @interface ValidCard {

  String message() default "Credit card number is not valid";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
