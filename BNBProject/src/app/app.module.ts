import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {AppComponent} from './app.component';
import {BnbLoginComponent} from './bnb-login/bnb-login.component';
import {LoginService} from './login.service';
import { DashBoardComponent } from './dash-board/dash-board/dash-board.component';

@NgModule({
  bootstrap: [AppComponent],
  declarations: [
    AppComponent,
    BnbLoginComponent,
    DashBoardComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
  ],
  providers: [
    LoginService,
  ],
})
export class AppModule {}
