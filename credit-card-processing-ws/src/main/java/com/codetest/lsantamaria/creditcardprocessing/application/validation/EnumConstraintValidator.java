package com.codetest.lsantamaria.creditcardprocessing.application.validation;

import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnumConstraintValidator implements ConstraintValidator<ValidEnum, String> {

   private Set<String> enumValues;

   @SuppressWarnings("unchecked")
   @Override
   public void initialize(ValidEnum targetEnum) {
      Class<? extends Enum> enumSelected = targetEnum.target();
      enumValues = (Set<String>) EnumSet.allOf(enumSelected).stream()
          .map(e -> ((Enum<? extends Enum<?>>) e).name()).collect(Collectors
              .toSet());
   }

   @Override
   public boolean isValid(String value, ConstraintValidatorContext context) {
      return value !=null && enumValues.contains(value.toUpperCase());
   }
}
