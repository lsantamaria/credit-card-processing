package com.codetest.lsantamaria.creditcardprocessing.web.controller.dto;

import com.codetest.lsantamaria.creditcardprocessing.application.validation.ValidEnum;
import com.codetest.lsantamaria.creditcardprocessing.domain.model.CardType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddCardRequest {
  @NotBlank
  private String name;
  @NotBlank
  @Size(max = 19)
//  TODO: @LuhnValidation
  private String cardNumber;
  @NotBlank
  private String limit;

  @NotBlank
  @ValidEnum(target = CardType.class)
  private String cardType;
}
