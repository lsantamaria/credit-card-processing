package com.codetest.lsantamaria.creditcardprocessing.application.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LuhnAlgorithmValidator implements ConstraintValidator<ValidCard, String> {

   @Override
   public boolean isValid(String cardNumber, ConstraintValidatorContext context) {
      int sum = 0;
      boolean alternate = false;
      for (int i = cardNumber.length() - 1; i >= 0; i--)
      {
         int n = Integer.parseInt(cardNumber.substring(i, i + 1));
         if (alternate)
         {
            n *= 2;
            if (n > 9)
            {
               n = (n % 10) + 1;
            }
         }
         sum += n;
         alternate = !alternate;
      }
      return (sum % 10 == 0);
   }
}
