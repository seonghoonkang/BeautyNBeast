import {TodoVO} from '../list/todo';
import {TodoService} from '../list/todo.service';
import {Component, OnInit, Input} from '@angular/core';
import {ActivatedRoute, Params} from '@angular/router';
import {Location} from '@angular/common';

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
    this._route.params
      .switchMap((params: Params) => this._loginService.getTodo(+params['id']))
      .subscribe(todo => this.todo = todo);
  }
}
