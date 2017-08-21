import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {RouterModule} from '@angular/router';
import {AlertModule} from 'ngx-bootstrap/alert';

import {AppComponent} from './app.component';
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
    RouterModule.forRoot([
      {
        path: 'login',
        component: LoginComponent,
      },
      {
        path: 'todo-list',
        component: TodoListComponent,
      },
      {
        path: 'todo-detail',
        component: TodoDetailComponent,
      },
      {
        path: '',
        redirectTo: '/todo-list',
        pathMatch: 'full',
      }
    ])
  ],
  providers: [
    TodoService,
  ],
})
export class AppModule {}
