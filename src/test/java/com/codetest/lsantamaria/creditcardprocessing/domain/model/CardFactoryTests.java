package com.codetest.lsantamaria.creditcardprocessing.domain.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.codetest.lsantamaria.creditcardprocessing.web.controller.dto.AddCardRequest;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CardFactoryTests {

  @Test
  public void testCreateCreditCardHappyPath(){
    AddCardRequest addCardRequest = AddCardRequest
        .builder()
        .cardNumber("47635245364787654298")
        .name("John Addams")
        .cardType("CREDIT")
        .limit("25000")
        .build();

    CreditCard card = CreditCard.builder()
        .id(UUID.randomUUID().toString())
        .name("John Addams")
        .number("47635245364787654298")
        .currency(Currency.getInstance(Locale.UK))
        .balance(new BigDecimal(15553.23))
        .limit(new BigDecimal(25000))
        .build();

    Card obtainedCard = CardFactory.newInstance(addCardRequest);

    assertTrue(obtainedCard instanceof CreditCard);
    CreditCard creditCard = (CreditCard)obtainedCard;

    assertNotNull(creditCard.getId());
    assertEquals(((CreditCard) obtainedCard).getName(), card.getName());
    assertEquals(((CreditCard) obtainedCard).getNumber(), card.getNumber());
  }

}
