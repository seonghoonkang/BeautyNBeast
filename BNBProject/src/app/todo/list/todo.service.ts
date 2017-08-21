import { Injectable } from '@angular/core';
import { HEROES } from '../../mock-data/mock-heroes';
import { TodoVO } from './todo';

@Injectable()
export class TodoService {
  constructor() { }
  getTodoList(): Promise<TodoVO[]> {
    return Promise.resolve(HEROES);
  }
}
