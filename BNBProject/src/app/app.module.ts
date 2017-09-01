import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {RouterModule} from '@angular/router';
import {AlertModule} from 'ngx-bootstrap/alert';

import {AppComponent} from './app.component';
import {AppRoutingModule} from './app.routing.module';
import {DashboardComponent} from './dashboard/dashboard/dashboard.component';
import {LoginComponent} from './login/login.component';
import {InMemoryWebApiModule} from 'angular2-in-memory-web-api';
import {InMemoryDataService} from './mock-data/in-memory-data.service';
import {TodoDetailComponent} from './todo/detail/todo-detail.component';
import {TodoListComponent} from './todo/list/todo-list.component';
import {TodoService} from './todo/list/todo.service';
@NgModule({
  bootstrap: [AppComponent],
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent,
    TodoListComponent,
    TodoDetailComponent,
  ],
  imports: [
    BrowserModule, // Add BrowserModule to imports: [] in @NgModule() if it's the root module, otherwise the CommonModule.
    AlertModule.forRoot(),
    FormsModule,
    HttpModule,
    InMemoryWebApiModule.forRoot(InMemoryDataService),
    AppRoutingModule,
  ],
  providers: [
    TodoService,
  ],
})
export class AppModule {}
