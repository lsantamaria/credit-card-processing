package com.codetest.lsantamaria.creditcardprocessing.domain.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;

/**
 * Base class for creating an implementation of a card. Clients must provide a custom implementation
 * of <code>getBalance()</code> and <code>getLimit()</code> methods which return that properties in
 * the provided currency.
 */
@MappedSuperclass
@Data
public abstract class Card {

  @Id
  private String id;

  @Column(name = "cardNumber")
  private String cardNumber;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "currency", nullable = false)
  private String currency;

  @Column(name = "balance")
  private BigDecimal balance;
}
