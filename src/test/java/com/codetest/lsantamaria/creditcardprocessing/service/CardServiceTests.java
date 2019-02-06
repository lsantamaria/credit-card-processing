package com.codetest.lsantamaria.creditcardprocessing.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.codetest.lsantamaria.creditcardprocessing.domain.model.Card;
import com.codetest.lsantamaria.creditcardprocessing.domain.model.CreditCard;
import com.codetest.lsantamaria.creditcardprocessing.domain.repository.CardRepository;
import com.codetest.lsantamaria.creditcardprocessing.domain.service.CardService;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;
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
  private CardRepository cardRepository;

  private CardService cardService;

  @Before
  public void setUp() {
    cardService = new CardService(cardRepository);
  }

  @Test
  public void testSaveCardHappyPath() {
    Card card = CreditCard.builder()
        .name("John Addams")
        .number("47635245364787654298")
        .currency(Currency.getInstance(Locale.UK))
        .balance(new BigDecimal(15553.23))
        .limit(new BigDecimal(25000))
        .build();

    when(cardRepository.save(any(Card.class))).thenReturn(card);

    cardService.saveCard(card);

    verify(cardRepository, times(1)).save(any(Card.class));
  }
}
