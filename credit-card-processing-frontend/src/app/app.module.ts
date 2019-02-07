import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HttpClientModule} from "@angular/common/http";
import { AppComponent } from './app.component';
import { CreditCardDetailComponent } from './components/credit-card-detail/credit-card-detail.component';
import { FormsModule } from '@angular/forms';

const appRoutes: Routes = [
  { path: 'credit-card-detail', component: CreditCardDetailComponent },
  { path: '',
    redirectTo: 'credit-card-detail',
    pathMatch: 'full'
  },
  { path: '**', component: CreditCardDetailComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    CreditCardDetailComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true }
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
