package com.codetest.lsantamaria.creditcardprocessing.domain.model;

import com.codetest.lsantamaria.creditcardprocessing.web.dto.AddCardRequest;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * Factory for creating cards.
 */
@Component
public class CardFactory {

  //Could be set by properties
  private static Currency defaultCurrency = Currency.getInstance(Locale.UK);

  public static Card newCreditCard(AddCardRequest cardRequest) {
    CardType cardType = CardType.valueOf(cardRequest.getCardType());
    switch (cardType) {
      case CREDIT:
        CreditCard card = new CreditCard();
        card.setId(UUID.randomUUID().toString());
        card.setName(cardRequest.getName());
        card.setCardNumber(cardRequest.getCardNumber());
        card.setBalance(new BigDecimal(0));
        card.setCurrency(defaultCurrency.toString());
        card.setCreditLimit(new BigDecimal(cardRequest.getLimit()));
        return card;
//     Omitted for brevity
//     case DEBIT:
//      return new DebitCard();
      default:
        throw new IllegalArgumentException(
            String.format("Cannot create a card of type %s", cardType));
    }
  }

  //Here we could create different factory methods based on the credit Card type received
  //in cardRequest
}
