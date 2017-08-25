import {LoginComponent} from './login/login.component';
import {TodoDetailComponent} from './todo/detail/todo-detail.component';
import {TodoListComponent} from './todo/list/todo-list.component';
import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
const routes: Routes = [
    {path: '', redirectTo: '/dashboard', pathMatch: 'full'},
    {path: 'login', component: LoginComponent},
    {path: 'todo-list', component: TodoListComponent},
    {path: 'todo-detail/:ctg/:id', component: TodoDetailComponent},
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {}
