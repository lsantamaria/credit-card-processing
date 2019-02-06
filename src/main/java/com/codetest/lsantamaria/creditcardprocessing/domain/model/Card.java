package com.codetest.lsantamaria.creditcardprocessing.domain.model;

import java.math.BigDecimal;
import java.util.Currency;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Base class for creating an implementation of a card. Clients must provide a custom implementation
 * of
 * <code>getBalance()</code> and <code>getLimit()</code> methods which return that properties in the
 * provided currency.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Card {



  /**
   * Get the current card balance.
   *
   * @return the card balance.
   */
  public abstract BigDecimal getBalance(Currency currency);

  /**
   * Gets the current card limit.
   *
   * @return the card limit.
   */
  public abstract BigDecimal getLimit(Currency currency);
}
