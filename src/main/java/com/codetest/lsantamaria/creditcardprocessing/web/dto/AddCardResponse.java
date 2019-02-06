package com.codetest.lsantamaria.creditcardprocessing.web.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO for indicating the status of adding a card. In case that operation has not been successful,
 * one or more errors can be included in the response.
 */

public class AddCardResponse {

  private OperationStatus operationStatus = OperationStatus.SUCCESS;
  private List<AddCardError> errors = new ArrayList<>();

  public void addError(AddCardError addCardError) {
    operationStatus = OperationStatus.ERROR;
    errors.add(addCardError);
  }

  public List<AddCardError> getErrors() {
    return errors;
  }

  public OperationStatus getOperationStatus() {
    return operationStatus;
  }
}
