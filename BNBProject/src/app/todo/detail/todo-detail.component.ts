import {TodoVO} from '../list/todo';
import {TodoService} from '../list/todo.service';
import {Component, OnInit, Input} from '@angular/core';
import {ActivatedRoute, Params} from '@angular/router';
import {Location} from '@angular/common';
import 'rxjs/add/operator/switchMap';

@Component({
  selector: 'app-todo-detail',
  templateUrl: './todo-detail.component.html',
  styleUrls: ['./todo-detail.component.css']
})
export class TodoDetailComponent implements OnInit {
  @Input()
  todo: TodoVO;
  constructor(private _loginService: TodoService, private _route: ActivatedRoute, private _location: Location) {
  }

  ngOnInit() {
    // this._route.params: BehaviorSubject
    //    람다식 관련 : https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Functions/%EC%95%A0%EB%A1%9C%EC%9A%B0_%ED%8E%91%EC%85%98
    //    옵저버패턴의 Rx는 비동기 데이터 스트림을 처리하는 API를 제공하는 라이브러리,(http://huns.me/development/2051)
    //    switchMap를 사용하려먼 Rx(ReactiveX) - JS를 import 해야한다. "import 'rxjs/add/operator/switchMap'";
    //  keyword : 절차형 프로그래밍, 반응형 프로그래밍, 데이터 스트림, BehaviorSubject, Observer
    this._route.params
      .switchMap((params: Params) => this._loginService.getTodo(+params['id']))
      .subscribe(todo => this.todo = todo);
  }
}
