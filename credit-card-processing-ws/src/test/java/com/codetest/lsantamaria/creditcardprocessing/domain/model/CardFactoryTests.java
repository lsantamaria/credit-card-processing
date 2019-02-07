package com.codetest.lsantamaria.creditcardprocessing.domain.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.codetest.lsantamaria.creditcardprocessing.web.dto.AddCardRequest;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CardFactoryTests {

  @Test
  public void testCreateCreditCardHappyPath() {
    AddCardRequest addCardRequest =
        AddCardRequest
            .builder()
            .cardNumber("4789384727182738498")
            .name("John Addams")
            .cardType("CREDIT")
            .creditLimit("25000")
            .build();

    CreditCard card = new CreditCard();
    card.setName("John Addams");
    card.setCardNumber("4789384727182738498");
    card.setBalance(BigDecimal.valueOf(20000));
    card.setCurrency(Currency.getInstance(Locale.UK).toString());

    Card obtainedCard = CardFactory.newCreditCard(addCardRequest);

    assertNotNull(obtainedCard.getId());
    assertEquals(card.getName(), obtainedCard.getName());
    assertEquals(card.getCardNumber(), obtainedCard.getCardNumber());
  }
}