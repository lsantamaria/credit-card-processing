import {Component, OnInit} from '@angular/core';
import {CreditCardService} from "../../services/credit-card.service";
import {CreditCard} from "../../model/creditcard";

@Component({
  selector: 'app-credit-card-detail',
  templateUrl: './credit-card-detail.component.html',
  styleUrls: ['./credit-card-detail.component.css']
})
export class CreditCardDetailComponent implements OnInit {
  cards: Array<CreditCard> = [{
    name: "Lluis",
    number: "7845784756352413235",
    balance: 45000,
    limit: 20000
  }];

  name: string;
  number: string;
  limit: number;

  constructor(public creditCardService: CreditCardService) {
  }

  ngOnInit() {
  }


  add() {
    let creditCard: CreditCard = new CreditCard();
    creditCard.name = this.name;
    creditCard.limit = this.limit;
    creditCard.number = this.number;

    this.creditCardService.add(creditCard).subscribe(n => {

      this.creditCardService.getAllCards().subscribe((cardList: Array<CreditCard>) => {
        this.cards = cardList;
      }, error1 => {
        alert("Error getting cards " + error1);
      });

    }, error1 => {
      alert("Error adding card " + error1);
    })
  }

  getAllCards() {
    this.creditCardService.getAllCards().subscribe((cardList: Array<CreditCard>) => {
      this.cards = cardList;
    }, error1 => {
      alert("Error getting cards: " + error1);
    });
  }


}
