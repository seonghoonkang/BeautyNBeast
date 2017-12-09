import {TodoVO} from '../list/todo.vo';
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
        // this._route.params: BehaviorSubject
        // 람다식 관련 : https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Functions/%EC%95%A0%EB%A1%9C%EC%9A%B0_%ED%8E%91%EC%85%98
        // 옵저버패턴의 Rx는 비동기 데이터 스트림을 처리하는 API를 제공하는 라이브러리,(http://huns.me/development/2051)
        // switchMap를 사용하려먼 Rx(ReactiveX) - JS를 import 해야한다. "import 'rxjs/add/operator/switchMap'";
        // keyword : 절차형 프로그래밍, 반응형 프로그래밍, 데이터 스트림, BehaviorSubject, Observer
        // ActivatedRoute서비스의 Observable 타입의 params를 제공한다. Angular2는 Rxjs를 적극 도입하여 활용하도록 했다.
        // params에 값이 바인딩되면 해당 결과를 subscribe하여 결과를 수행한다.
        // this._router.snapshot.paramMap.get("id"); //
        this._router.params
            .switchMap((params: Params) => this.todoService.getTodo(+params['id']))// (+) converts string 'id' to a number
            .subscribe(todo => this.todoDetail = todo);
        this.todoService.getFavoKeywords();
    }
}
