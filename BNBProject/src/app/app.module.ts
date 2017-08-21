import {AppComponent} from './app.component';
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {LoginComponent} from './login/login.component';
import {LoginService} from './login/login.service';
import {RouterModule} from '@angular/router';
import {TodoDetailComponent} from './todo/detail/todo-detail.component';
import {TodoListComponent} from './todo/list/todo-list.component';

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
    LoginService,
  ],
})
export class AppModule {}
