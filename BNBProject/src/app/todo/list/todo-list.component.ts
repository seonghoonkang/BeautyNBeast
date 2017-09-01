import {TodoVO} from './todo.vo';
import {TodoService} from './todo.service';
import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

@Component({
    selector: 'app-todo-list',
    templateUrl: './todo-list.component.html',
    styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {

    todoList: TodoVO[];
    selectedTodo: TodoVO;
    constructor(private _router: Router, private todoService: TodoService) {}

    ngOnInit() {
        this.todoService.getTodoList().then(result => this.todoList = result);
    }
    //  Angular 에서는 new 연산자를 사용하지 않도록 권장:
    //  Why?
    //  1.서비스에 파라미터를 받도록 수정한다면 모든 생성자를 수정해야한다.
    //  2.수 만은 객채가 발생한다.

    onSelect(todo: TodoVO): void {
        this.selectedTodo = todo;
    }

    goDetail(): void {
        this._router.navigate(['/todo-detail', 'hero', this.selectedTodo.id]);
    }
}
