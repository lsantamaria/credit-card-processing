package com.codetest.lsantamaria.creditcardprocessing.web.controller;

import com.codetest.lsantamaria.creditcardprocessing.domain.model.Card;
import com.codetest.lsantamaria.creditcardprocessing.domain.service.CardService;
import com.codetest.lsantamaria.creditcardprocessing.web.dto.AddCardError;
import com.codetest.lsantamaria.creditcardprocessing.web.dto.AddCardError.AddCardErrorType;
import com.codetest.lsantamaria.creditcardprocessing.web.dto.AddCardRequest;
import com.codetest.lsantamaria.creditcardprocessing.web.dto.AddCardResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@Api(value = "Cards api", description = "Operations related with cards")
public class CardController {

  public static final String CARDS_ENDPOINT = "/cards";

  private final Validator validator;
  private final CardService cardService;

  @PostMapping(value = CARDS_ENDPOINT, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Operation completed. Check the response body for more details"),
      @ApiResponse(code = 400, message = "AddCardRequest does not have the correct params")
  })
  public AddCardResponse addCard(final @RequestBody AddCardRequest addCardRequest) {
    AddCardResponse addCardResponse = new AddCardResponse();

    Set<ConstraintViolation<AddCardRequest>> validationErrors = validator.validate(addCardRequest);

    if (!validationErrors.isEmpty()) {
      validationErrors.forEach(validationError ->
          addCardResponse.addError(
              new AddCardError(AddCardErrorType.VALIDATION_ERROR,
                  validationError.getPropertyPath() + " " + validationError
                      .getMessage()))
      );
      return addCardResponse;
    }

    cardService.saveNewCard(addCardRequest);

    return addCardResponse;
  }

  @GetMapping(value = CARDS_ENDPOINT, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Operation completed. Check the response body for more details"),
  })
  public List<Card> getAllCards() {
    return cardService.getCards();
  }

  //TODO: exception handling
  //  @ExceptionHandler(CustomException.class)
  //  @ResponseStatus(code = HttpStatus.INTERNALSERVERERROR)
  //  private String serverError(Exception e) {
  //    return e.getMessage();
  //  }
}