package com.codetest.lsantamaria.creditcardprocessing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.codetest.lsantamaria.creditcardprocessing.web.controller.CardController;
import com.codetest.lsantamaria.creditcardprocessing.web.dto.AddCardRequest;
import com.codetest.lsantamaria.creditcardprocessing.web.dto.AddCardResponse;
import com.codetest.lsantamaria.creditcardprocessing.web.dto.OperationStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.env.Environment;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@EnableSpringDataWebSupport
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class CardControllerITests {

  @Autowired
  private CardController cardController;

  @Autowired
  Environment environment;

  @Autowired
  private TestRestTemplate testRestTemplate;

  @Test
  public void contextLoads(){
    assertNotNull(cardController);
  }

  @Test
  public void testAddCard(){

    AddCardRequest addCardRequest =
        AddCardRequest
            .builder()
            .cardNumber("4789384727182738498")
            .name("John Addams")
            .cardType("CREDIT")
            .limit("25000")
            .build();

    AddCardResponse addCardResponse =
        testRestTemplate.postForEntity(CardController.CARDS_ENDPOINT, addCardRequest, AddCardResponse.class)
            .getBody();

    assertEquals(OperationStatus.SUCCESS, addCardResponse.getOperationStatus());
  }
}