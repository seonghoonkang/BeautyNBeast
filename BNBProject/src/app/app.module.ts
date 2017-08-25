import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {RouterModule} from '@angular/router';
import {AlertModule} from 'ngx-bootstrap/alert';

import {AppComponent} from './app.component';
import { AppRoutingModule } from './app.routing.module';
import {LoginComponent} from './login/login.component';
import {TodoDetailComponent} from './todo/detail/todo-detail.component';
import {TodoListComponent} from './todo/list/todo-list.component';
import {TodoService} from './todo/list/todo.service';

@NgModule({
  bootstrap: [AppComponent],
  declarations: [
    AppComponent,
    LoginComponent,
    TodoListComponent,
    TodoDetailComponent,
  ],
  imports: [
    BrowserModule,
    AlertModule.forRoot(),
    FormsModule,
    HttpModule,
    AppRoutingModule,
  ],
  providers: [
    TodoService,
  ],
})
export class AppModule {}
