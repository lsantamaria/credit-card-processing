import {TestBed} from '@angular/core/testing';

import {CreditCardService} from './credit-card.service';
import {CreditCardDetailComponent} from "../components/credit-card-detail/credit-card-detail.component";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {HttpClientTestingModule, HttpTestingController} from "@angular/common/http/testing";

describe('CreditCardService', () => {
  let httpMock: HttpTestingController;

  beforeEach(() => {

    TestBed.configureTestingModule({
      declarations: [CreditCardDetailComponent],
      imports: [
        HttpClientTestingModule,
        HttpClientModule,
        FormsModule
      ],

    });

    httpMock = TestBed.get(HttpTestingController);
  });

  it('should retrieve all cards', () => {

    let cardsResponse = '[{\n' +
      '  "id": "d186d9b5-11a0-4811-9061-dc4a38466525",\n' +
      '  "cardNumber": "4926221243207342",\n' +
      '  "name": "jorge",\n' +
      '  "currency": "GBP",\n' +
      '  "balance": 0,\n' +
      '  "cardType": "CREDIT",\n' +
      '  "creditLimit": 20000\n' +
      '},\n' +
      '{\n' +
      '  "id": "a9aa865b-a5c8-4e31-8fef-f384b4200d29",\n' +
      '  "cardNumber": "4756756871546912",\n' +
      '  "name": "troy",\n' +
      '  "currency": "GBP",\n' +
      '  "balance": 0,\n' +
      '  "cardType": "CREDIT",\n' +
      '  "creditLimit": 20000\n' +
      '}]';

    const service: CreditCardService = TestBed.get(CreditCardService);

    service.getAllCards().subscribe(response => {
      expect(response).toBe(cardsResponse);
    });

    let getAllCardsRequest = httpMock.expectOne("http://localhost:8080/cards");
    getAllCardsRequest.flush(cardsResponse);

  });
})
;
