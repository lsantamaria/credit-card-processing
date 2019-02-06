package com.codetest.lsantamaria.creditcardprocessing.domain.model;

import java.math.BigDecimal;
import java.util.Currency;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditCard extends Card {

  @Id
  private String id;

  @Column(name = "number", nullable = false, unique = true)
  @Size(max = 19)
  private String number;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "currency", nullable = false)
  private Currency currency;

  @Column(name = "balance", nullable = false)
  private BigDecimal balance;

  @Column(name = "limit", nullable = false)
  private BigDecimal limit;

  @Override
  public BigDecimal getBalance(Currency currency) {
    if(this.currency.equals(currency)){
      return balance;
    }
    else{
      //do the calculations for converting to another currency
      //and return the converted balance
      return balance;
    }
  }

  @Override
  public BigDecimal getLimit(Currency currency) {
    if(this.currency.equals(currency)){
      return limit;
    }
    else{
      //do the calculations for converting to another currency
      //and return the converted balance
      return limit;
    }
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public void setLimit(BigDecimal limit) {
    this.limit = limit;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }
}
