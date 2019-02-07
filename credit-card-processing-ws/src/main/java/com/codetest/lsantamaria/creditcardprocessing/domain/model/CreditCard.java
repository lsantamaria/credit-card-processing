package com.codetest.lsantamaria.creditcardprocessing.domain.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "CREDIT_CARD")
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard extends Card{

  @Column(name = "creditLimit")
  private BigDecimal creditLimit;
}
