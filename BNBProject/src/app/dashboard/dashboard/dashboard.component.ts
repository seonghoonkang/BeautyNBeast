import {TodoVO} from '../../todo/list/todo.vo';
import {TodoService} from '../../todo/list/todo.service';
import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

@Component({
    selector: 'app-dashboard',
    templateUrl: './dashboard.component.html',
    styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
    todoList: TodoVO[];
    constructor(private _router: Router, private todoService: TodoService) {}

    ngOnInit() {
        this.todoService.getTodoList().then(todolist => this.todoList = todolist.slice(1, 5));
    }
    goDetail(selectedTodo: TodoVO): void {
        this._router.navigate(['/todo-detail', 'hero', selectedTodo.id]);
    }
    goList(): void {
        this._router.navigate(['/todo-list']);
    }
}
