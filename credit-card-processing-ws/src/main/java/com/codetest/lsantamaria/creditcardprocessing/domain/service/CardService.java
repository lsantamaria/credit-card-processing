package com.codetest.lsantamaria.creditcardprocessing.domain.service;

import com.codetest.lsantamaria.creditcardprocessing.domain.model.Card;
import com.codetest.lsantamaria.creditcardprocessing.domain.model.CreditCard;
import com.codetest.lsantamaria.creditcardprocessing.domain.model.CardFactory;
import com.codetest.lsantamaria.creditcardprocessing.domain.repository.CardRepository;
import com.codetest.lsantamaria.creditcardprocessing.web.dto.AddCardRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service for operating with {@link CreditCard} instances.
 */
@Service
@RequiredArgsConstructor
public class CardService {
  private final CardRepository cardRepository;

  public void saveNewCard(CreditCard card){
    cardRepository.save(card);
  }

  public Card saveNewCard(AddCardRequest addCardRequest){
    //We could do the transformation from DTO to entity in application layer
    Card card =  CardFactory.newCreditCard(addCardRequest);
    return cardRepository.save(card);
  }

  public List<Card> getCards() {
    return cardRepository.findAll();
  }
}
