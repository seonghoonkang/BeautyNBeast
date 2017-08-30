import {TodoVO} from '../list/todo';
import {TodoService} from '../list/todo.service';
import {Component, OnInit, Input} from '@angular/core';
import {Router, ActivatedRoute, Params} from '@angular/router';
import 'rxjs/add/operator/switchMap';

@Component({
    selector: 'app-todo-detail',
    templateUrl: './todo-detail.component.html',
    styleUrls: ['./todo-detail.component.css']
})
export class TodoDetailComponent implements OnInit {
    @Input()
    todoDetail: TodoVO;

    constructor(private _router: ActivatedRoute, private todoService: TodoService) {}

    ngOnInit() {
        // ActivatedRoute서비스의 Observable 타입의 params를 제공한다. Angular2는 Rxjs를 적극 도입하여 활용하도록 했다.
        // params에 값이 바인딩되면 해당 결과를 subscribe하여 결과를 수행한다.
        this._router.params
            .switchMap((params: Params) => this.todoService.getTodo(+params['id']))// (+) converts string 'id' to a number
            .subscribe(todo => this.todoDetail = todo);
    }
}
