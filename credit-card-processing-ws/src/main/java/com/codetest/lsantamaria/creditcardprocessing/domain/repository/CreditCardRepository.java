package com.codetest.lsantamaria.creditcardprocessing.domain.repository;

import com.codetest.lsantamaria.creditcardprocessing.domain.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<Card, Integer> {

}
