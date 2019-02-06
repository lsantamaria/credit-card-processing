package com.codetest.lsantamaria.creditcardprocessing.domain.model;

import com.codetest.lsantamaria.creditcardprocessing.web.controller.dto.AddCardRequest;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * Factory for creating cards
 */
@Component
public class CardFactory {
  //Could be setted by properties as well or indic
  private static Currency defaultCurrency = Currency.getInstance(Locale.UK);

  public static Card newInstance(AddCardRequest cardRequest) {
    CardType cardType = CardType.valueOf(cardRequest.getCardType());
    switch (cardType) {
      case CREDIT:
        return CreditCard.builder()
            .id(UUID.randomUUID().toString())
            .name(cardRequest.getName())
            .number(cardRequest.getCardNumber())
            .balance(new BigDecimal(0))
            .currency(defaultCurrency)
            .limit(new BigDecimal(cardRequest.getLimit()))
            .build();
//      Omitted for brevity
//      case DEBIT:
//        return new DebitCard();
      default:
        throw new IllegalArgumentException(
            String.format("Cannot create a card of type %s", cardType));
    }
  }

}
