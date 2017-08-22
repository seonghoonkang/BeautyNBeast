import {Injectable} from '@angular/core';
import {HEROES} from '../../mock-data/mock-heroes';
import {TodoVO} from './todo';

@Injectable()
export class TodoService {
  constructor() {}
  getTodoList(): Promise<TodoVO[]> {
    return Promise.resolve(HEROES);
  }
  getTodo(id: number): Promise<TodoVO> {

    return this.getTodoList()
      .then(todolist => todolist.find(todo => todo.id === id));
  }
}
