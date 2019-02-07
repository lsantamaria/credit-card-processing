package com.codetest.lsantamaria.creditcardprocessing.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.codetest.lsantamaria.creditcardprocessing.domain.model.CreditCard;
import com.codetest.lsantamaria.creditcardprocessing.domain.repository.CreditCardRepository;
import com.codetest.lsantamaria.creditcardprocessing.domain.service.CardService;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Tests for {@link com.codetest.lsantamaria.creditcardprocessing.domain.service.CardService}
 */
@RunWith(MockitoJUnitRunner.class)
public class CardServiceTests {

  @Mock
  private CreditCardRepository creditCardRepository;

  private CardService cardService;

  @Before
  public void setUp() {
    cardService = new CardService(creditCardRepository);
  }

  @Test
  public void testSaveCardHappyPath() {
    CreditCard card = new CreditCard();
    card.setId(UUID.randomUUID().toString());
    card.setName("John Addam");
    card.setCardNumber("4789384727182738498");
    card.setBalance(BigDecimal.valueOf(20000));
    card.setCurrency(Currency.getInstance(Locale.UK).toString());
    card.setCreditLimit(BigDecimal.valueOf(50000));

    when(creditCardRepository.save(any(CreditCard.class))).thenReturn(card);

    cardService.saveNewCard(card);

    verify(creditCardRepository, times(1)).save(any(CreditCard.class));
  }

  //Add test for getting all the cards
}
