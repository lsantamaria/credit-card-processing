package com.codetest.lsantamaria.creditcardprocessing.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Error related with adding card process.
 */
@Data
@AllArgsConstructor
public class AddCardError {

  public enum AddCardErrorType{
    EXISTING_CARD, CARD_NOT_COMPATIBLE, UNEXPECTED_ERROR, VALIDATION_ERROR
  }

  private AddCardErrorType errorType;
  private String errorDescription;
}
