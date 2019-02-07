import {Component, OnInit} from '@angular/core';
import {CreditCardService} from "../../services/credit-card.service";
import {CreditCardRequest} from "../../model/creditCardRequest";

@Component({
  selector: 'app-credit-card-detail',
  templateUrl: './credit-card-detail.component.html',
  styleUrls: ['./credit-card-detail.component.css']
})
export class CreditCardDetailComponent implements OnInit {
  cards: any;

  name: string;
  cardNumber: string;
  creditLimit: number;

  constructor(public creditCardService: CreditCardService) {
    this.getAllCards();
  }

  ngOnInit() {
  }


  add() {
    let creditCard: CreditCardRequest = new CreditCardRequest();
    creditCard.name = this.name;
    creditCard.creditLimit = this.creditLimit;
    creditCard.cardNumber = this.cardNumber;
    console.log(name);
    console.log(creditCard);
    this.creditCardService.add(creditCard).subscribe(data => {
      this.getAllCards();
    }, error1 => {
      alert("Error adding card " + error1);
    })
  }

  getAllCards() {
    this.creditCardService.getAllCards().subscribe(cardList => {
      this.cards = cardList;
    }, error1 => {
      //TODO: properly handling error
      alert("Error getting cards: " + error1);
    });
  }


}
