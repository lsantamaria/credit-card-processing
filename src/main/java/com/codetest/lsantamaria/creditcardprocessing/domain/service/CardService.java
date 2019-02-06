package com.codetest.lsantamaria.creditcardprocessing.domain.service;

import com.codetest.lsantamaria.creditcardprocessing.domain.model.Card;
import com.codetest.lsantamaria.creditcardprocessing.domain.model.CardFactory;
import com.codetest.lsantamaria.creditcardprocessing.domain.repository.CardRepository;
import com.codetest.lsantamaria.creditcardprocessing.web.controller.dto.AddCardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service for operating with {@link Card} instances.
 */
@Service
@RequiredArgsConstructor
public class CardService {
  private final CardRepository cardRepository;

  public void saveCard(Card card){
    cardRepository.save(card);
  }

  public Card saveCard(AddCardRequest addCardRequest){
    //we could create a card using a factory that create a card based on the request type.
    Card card =  CardFactory.newInstance(addCardRequest);
    return cardRepository.save(card);
  }

}
