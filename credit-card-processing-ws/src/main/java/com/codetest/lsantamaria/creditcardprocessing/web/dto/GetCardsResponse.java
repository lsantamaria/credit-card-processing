package com.codetest.lsantamaria.creditcardprocessing.web.dto;

import com.codetest.lsantamaria.creditcardprocessing.domain.model.Card;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class GetCardsResponse {
  private List<Card> cards = new ArrayList<>();
  //List of errors could be added as well

}
